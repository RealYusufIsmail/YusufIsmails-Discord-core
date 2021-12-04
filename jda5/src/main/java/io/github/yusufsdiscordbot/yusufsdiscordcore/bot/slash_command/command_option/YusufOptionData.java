package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.DataType;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a subcommand group.
 *
 * Credits to the JDA team for the code for this class. This code was taken from
 * {@link net.dv8tion.jda.api.interactions.commands.build.OptionData}
 */
@SuppressWarnings("unused")
public class YusufOptionData implements SerializableData {
    private final OptionType type;
    private String name;
    private String description;
    private boolean isRequired;
    private final EnumSet<ChannelType> channelTypes = EnumSet.noneOf(ChannelType.class);
    private Number minValue;
    private Number maxValue;
    private Map<String, Object> choices;


    /**
     * @param type The slash command option type
     * @param name The slash command option name
     * @param description The slash command option description
     */
    public YusufOptionData(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description) {
        this(type, name, description, false);
    }

    /**
     *
     * @param type The slash command option type
     * @param name The slash command option name
     * @param description The slash command option description
     * @param isRequired if the user has to reply to the slash command event
     */
    public YusufOptionData(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description, boolean isRequired) {
        Checks.notNull(type, "Type");
        this.type = type;

        setName(name);
        setDescription(description);
        setRequired(isRequired);
        if (type.canSupportChoices())
            choices = new LinkedHashMap<>();
    }

    public @NotNull OptionType getOptionType() {
        return type;
    }

    public @NotNull String getOptionName() {
        return name;
    }

    public @NotNull String getOptionDescription() {
        return description;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public @NotNull Set<ChannelType> getChannelTypes() {
        return channelTypes;
    }

    public Number getLowestValue() {
        return minValue;
    }

    public Number getHighestValue() {
        return maxValue;
    }

    public List<YusufCommand.YusufChoices> getChoices() {
        return choices.entrySet().stream().map(entry -> {
            if (entry.getValue() instanceof String)
                return new YusufCommand.YusufChoices(entry.getKey(), entry.getValue().toString());
            else if (entry.getValue() instanceof Double)
                return new YusufCommand.YusufChoices(entry.getKey(),
                        ((Number) entry.getValue()).doubleValue());
            return new YusufCommand.YusufChoices(entry.getKey(),
                    ((Number) entry.getValue()).longValue());
        }).toList();
    }

    public YusufOptionData setName(@Nonnull String name) {
        Checks.notEmpty(name, "Name");
        Checks.notLonger(name, OptionData.MAX_NAME_LENGTH, "Name");
        Checks.isLowercase(name, "Name");
        Checks.matches(name, Checks.ALPHANUMERIC_WITH_DASH, "Name");
        this.name = name;
        return this;
    }

    public YusufOptionData setDescription(@Nonnull String description) {
        Checks.notEmpty(description, "Description");
        Checks.notLonger(description, OptionData.MAX_DESCRIPTION_LENGTH, "Description");
        this.description = description;
        return this;
    }

    public YusufOptionData setRequired(boolean required) {
        this.isRequired = required;
        return this;
    }

    @Nonnull
    public YusufOptionData setChannelTypes(@Nonnull ChannelType... channelTypes) {
        Checks.notNull(channelTypes, "Channel types");
        this.channelTypes.clear();
        Collections.addAll(this.channelTypes, channelTypes);
        return this;
    }

    @Nonnull
    public YusufOptionData setChannelTypes(@Nonnull Set<ChannelType> channelTypes) {
        if (type != OptionType.CHANNEL)
            throw new IllegalArgumentException(
                    "Can only apply channel type restriction to options of type CHANNEL");
        Checks.notNull(channelTypes, "ChannelType collection");
        Checks.noneNull(channelTypes, "ChannelType");

        for (ChannelType channelType : channelTypes) {
            if (!channelType.isGuild())
                throw new IllegalArgumentException(
                        "Provided channel type is not a guild channel type. Provided: "
                                + channelType);
        }
        this.channelTypes.clear();
        this.channelTypes.addAll(channelTypes);
        return this;
    }

    public YusufOptionData setLowestValue(long lowestValue) {
        if (type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min double value for options of type NUMBER");
        Checks.check(lowestValue >= OptionData.MIN_NEGATIVE_NUMBER,
                "Double value may not be lower than %f", OptionData.MIN_NEGATIVE_NUMBER);
        this.minValue = lowestValue;
        return this;
    }

    public YusufOptionData setLowestValue(double lowestValue) {
        if (type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min double value for options of type NUMBER");
        Checks.check(lowestValue >= OptionData.MIN_NEGATIVE_NUMBER,
                "Double value may not be lower than %f", OptionData.MIN_NEGATIVE_NUMBER);
        this.minValue = lowestValue;
        return this;
    }

    public YusufOptionData setHighestValue(long highestValue) {
        if (type != OptionType.INTEGER && type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min and max long value for options of type INTEGER or NUMBER");
        Checks.check(highestValue <= OptionData.MAX_POSITIVE_NUMBER,
                "Long value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        this.maxValue = highestValue;
        return this;
    }

    public YusufOptionData setHighestValue(double highestValue) {
        if (type != OptionType.INTEGER && type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min and max long value for options of type INTEGER or NUMBER");
        Checks.check(highestValue <= OptionData.MAX_POSITIVE_NUMBER,
                "Long value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        this.maxValue = highestValue;
        return this;
    }

    public YusufOptionData setLowestAndHighestValues(long lowestValue, long highestValue) {
        if (type != OptionType.INTEGER && type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min and max long value for options of type INTEGER or NUMBER");
        Checks.check(lowestValue >= OptionData.MIN_NEGATIVE_NUMBER,
                "Double value may not be lower than %f", OptionData.MIN_NEGATIVE_NUMBER);
        Checks.check(highestValue <= OptionData.MAX_POSITIVE_NUMBER,
                "Long value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        this.minValue = lowestValue;
        this.maxValue = highestValue;
        return this;
    }

    public YusufOptionData setLowestAndHighestValues(double lowestValue, double highestValue) {
        if (type != OptionType.INTEGER && type != OptionType.NUMBER)
            throw new IllegalArgumentException(
                    "Can only set min and max long value for options of type INTEGER or NUMBER");
        Checks.check(lowestValue >= OptionData.MIN_NEGATIVE_NUMBER,
                "Double value may not be lower than %f", OptionData.MIN_NEGATIVE_NUMBER);
        Checks.check(highestValue <= OptionData.MAX_POSITIVE_NUMBER,
                "Long value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        this.minValue = lowestValue;
        this.maxValue = highestValue;
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, double value) {
        Checks.notEmpty(name, "Name");
        Checks.notLonger(name, OptionData.MAX_CHOICE_NAME_LENGTH, "Name");
        Checks.check(value >= OptionData.MIN_NEGATIVE_NUMBER,
                "Double value may not be lower than %f", OptionData.MIN_NEGATIVE_NUMBER);
        Checks.check(value <= OptionData.MAX_POSITIVE_NUMBER,
                "Double value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        Checks.check(choices.size() < OptionData.MAX_CHOICES,
                "Cannot have more than 25 choices for an option!");
        if (type != OptionType.NUMBER)
            throw new IllegalArgumentException("Cannot add double choice for OptionType." + type);
        choices.put(name, value);
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, long value) {
        Checks.notEmpty(name, "Name");
        Checks.notLonger(name, OptionData.MAX_CHOICE_NAME_LENGTH, "Name");
        Checks.check(value >= OptionData.MIN_NEGATIVE_NUMBER, "Long value may not be lower than %f",
                OptionData.MIN_NEGATIVE_NUMBER);
        Checks.check(value <= OptionData.MAX_POSITIVE_NUMBER,
                "Long value may not be larger than %f", OptionData.MAX_POSITIVE_NUMBER);
        Checks.check(choices.size() < OptionData.MAX_CHOICES,
                "Cannot have more than 25 choices for an option!");
        if (type != OptionType.INTEGER)
            throw new IllegalArgumentException("Cannot add long choice for OptionType." + type);
        choices.put(name, value);
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, String value) {
        Checks.notEmpty(name, "Name");
        Checks.notEmpty(value, "Value");
        Checks.notLonger(name, OptionData.MAX_CHOICE_NAME_LENGTH, "Name");
        Checks.notLonger(value, OptionData.MAX_CHOICE_VALUE_LENGTH, "Value");
        Checks.check(choices.size() < OptionData.MAX_CHOICES,
                "Cannot have more than 25 choices for an option!");
        if (type != OptionType.STRING)
            throw new IllegalArgumentException("Cannot add string choice for OptionType." + type);
        choices.put(name, value);
        return this;
    }

    public YusufOptionData addChoices(@Nonnull YusufCommand.YusufChoices... choices) {
        if (this.choices == null)
            throw new IllegalStateException("Cannot add choices for an option of type " + type);
        Checks.noneNull(choices, "Choices");
        Checks.check(choices.length + this.choices.size() <= OptionData.MAX_CHOICES,
                "Cannot have more than 25 choices for one option!");
        for (YusufCommand.YusufChoices choice : choices) {
            if (type == OptionType.INTEGER)
                addChoice(choice.getName(), choice.getAsLong());
            else if (type == OptionType.STRING)
                addChoice(choice.getName(), choice.getAsString());
            else if (type == OptionType.NUMBER)
                addChoice(choice.getName(), choice.getAsDouble());
            else
                throw new IllegalArgumentException("Cannot add choice for type " + type);
        }
        return this;
    }

    public YusufOptionData addChoices(
            @Nonnull Collection<? extends YusufCommand.YusufChoices> choices) {
        Checks.noneNull(choices, "Choices");
        return addChoices(choices.toArray(new YusufCommand.YusufChoices[0]));
    }

    public @NotNull DataObject toData() {
        DataObject json = DataObject.empty()
            .put("type", type.getKey())
            .put("name", name)
            .put("description", description);
        if (type != OptionType.SUB_COMMAND && type != OptionType.SUB_COMMAND_GROUP)
            json.put("required", isRequired);
        if (choices != null && !choices.isEmpty()) {
            json.put("choices",
                    DataArray.fromCollection(choices.entrySet()
                        .stream()
                        .map(entry -> DataObject.empty()
                            .put("name", entry.getKey())
                            .put("value", entry.getValue()))
                        .toList()));
        }
        if (type == OptionType.CHANNEL && !channelTypes.isEmpty())
            json.put("channel_types", channelTypes.stream().map(ChannelType::getId).toList());
        if (type == OptionType.INTEGER || type == OptionType.NUMBER) {
            if (minValue != null)
                json.put("min_value", minValue);
            if (maxValue != null)
                json.put("max_value", maxValue);
        }
        return json;
    }

    @Contract("_ -> new")
    public static @NotNull YusufOptionData fromData(@Nonnull DataObject json) {
        var maxValue = "maxValue";
        var minValue = "minValue";
        var value = "value";
        var name = json.getString("name");
        var description = json.getString("description");
        var type = OptionType.fromKey(json.getInt("type"));
        var option = new YusufOptionData(type, name, description);
        option.setRequired(json.getBoolean("required"));
        if (type == OptionType.INTEGER || type == OptionType.NUMBER) {
            if (!json.isNull(minValue)) {
                if (json.isType(minValue, DataType.INT))
                    option.setLowestValue(json.getLong(minValue));
                else if (json.isType(minValue, DataType.FLOAT))
                    option.setHighestValue(json.getDouble(minValue));
            }
            if (!json.isNull(maxValue)) {
                if (json.isType(maxValue, DataType.INT))
                    option.setHighestValue(json.getLong(maxValue));
                else if (json.isType(maxValue, DataType.FLOAT))
                    option.setHighestValue(json.getDouble(maxValue));
            }
        }
        if (type == OptionType.CHANNEL) {
            option.setChannelTypes(json.optArray("channel_types")
                .map(it -> it.stream(DataArray::getInt)
                    .map(ChannelType::fromId)
                    .collect(Collectors.toSet()))
                .orElse(Collections.emptySet()));
        }
        json.optArray("choices")
            .ifPresent(choices1 -> choices1.stream(DataArray::getObject).forEach(o -> {
                if (o.isType(value, DataType.FLOAT))
                    option.addChoice(o.getString("name"), o.getDouble(value));
                else if (o.isType(value, DataType.INT))
                    option.addChoice(o.getString("name"), o.getLong(value));
                else
                    option.addChoice(o.getString("name"), o.get(value).toString());
            }));
        return option;
    }
}
