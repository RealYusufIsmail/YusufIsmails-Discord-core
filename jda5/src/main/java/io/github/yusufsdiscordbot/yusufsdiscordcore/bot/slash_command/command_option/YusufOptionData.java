package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.DataType;
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
public class YusufOptionData {
    private final OptionData optionData;
    private Map<String, Object> choices;


    public OptionData getOptionData() {
        return optionData;
    }

    /**
     *
     * @param optionType The slash command option type
     * @param optionName The slash command option name
     * @param optionDescription The slash command option description
     */
    public YusufOptionData(@Nonnull OptionType optionType, @Nonnull String optionName,
            @Nonnull String optionDescription) {
        this.optionData = new OptionData(optionType, optionName, optionDescription, false);
    }

    /**
     *
     * @param optionType The slash command option type
     * @param optionName The slash command option name
     * @param optionDescription The slash command option description
     * @param isRequired if the user has to reply to the slash command event
     */
    public YusufOptionData(@Nonnull OptionType optionType, @Nonnull String optionName,
            @Nonnull String optionDescription, boolean isRequired) {
        this.optionData = new OptionData(optionType, optionName, optionDescription, isRequired);
    }

    public YusufOptionData(OptionData optionData) {
        this.optionData = optionData;
    }

    public @NotNull OptionType getOptionType() {
        return this.optionData.getType();
    }

    public @NotNull String getOptionName() {
        return this.optionData.getName();
    }


    public @NotNull String getOptionDescription() {
        return this.optionData.getDescription();
    }

    public boolean getIsRequired() {
        return this.optionData.isRequired();
    }

    public @NotNull Set<ChannelType> getChannelTypes() {
        return this.optionData.getChannelTypes();
    }

    public Number getLowestValue() {
        return this.optionData.getMinValue();
    }

    public Number getHighestValue() {
        return this.optionData.getMaxValue();
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
        }).collect(Collectors.toList());
    }

    public YusufOptionData setName(@Nonnull String name) {
        this.optionData.setName(name);
        return this;
    }

    public YusufOptionData setDescription(@Nonnull String description) {
        this.optionData.setDescription(description);
        return this;
    }

    public YusufOptionData setRequired(boolean required) {
        this.optionData.setRequired(required);
        return this;
    }

    public YusufOptionData setChannelTypes(@Nonnull Set<ChannelType> channelTypes) {
        this.optionData.setChannelTypes(channelTypes);
        return this;
    }

    public YusufOptionData setChannelTypes(@Nonnull ChannelType... channelTypes) {
        this.optionData.setChannelTypes(channelTypes);
        return this;
    }

    public YusufOptionData setLowestValue(long lowestValue) {
        this.optionData.setMinValue(lowestValue);
        return this;
    }

    public YusufOptionData setLowestValue(double lowestValue) {
        this.optionData.setMinValue(lowestValue);
        return this;
    }

    public YusufOptionData setHighestValue(long highestValue) {
        this.optionData.setMaxValue(highestValue);
        return this;
    }

    public YusufOptionData setHighestValue(double highestValue) {
        this.optionData.setMaxValue(highestValue);
        return this;
    }

    public YusufOptionData setLowestAndHighestValues(long lowestValue, long highestValue) {
        this.optionData.setMinValue(lowestValue);
        this.optionData.setMaxValue(highestValue);
        return this;
    }

    public YusufOptionData setLowestAndHighestValues(double lowestValue, double highestValue) {
        this.optionData.setMinValue(lowestValue);
        this.optionData.setMaxValue(highestValue);
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, double value) {
        this.optionData.addChoice(name, value);
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, long value) {
        this.optionData.addChoice(name, value);
        return this;
    }

    public YusufOptionData addChoice(@Nonnull String name, String value) {
        this.optionData.addChoice(name, value);
        return this;
    }

    public YusufOptionData addChoices(@Nonnull YusufCommand.YusufChoices... choices) {
        for (YusufCommand.YusufChoices choice : choices) {
            this.optionData.addChoice(choice.getName(), choice.getAsLong())
                .addChoice(choice.getName(), choice.getAsDouble())
                .addChoice(choice.getName(), choice.getAsString());
        }
        return this;
    }

    public YusufOptionData addChoices(
            @Nonnull Collection<? extends YusufCommand.YusufChoices> choices) {
        Checks.noneNull(choices, "Choices");
        return addChoices(choices.toArray(new YusufCommand.YusufChoices[0]));
    }

    public DataObject toData() {
        return this.optionData.toData();
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
