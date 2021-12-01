package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public class YusufOptionData {
    final OptionData optionData;

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

    // TODO add the rest of the optionData

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

    public YusufOptionData addChoices(@Nonnull String name, double value) {
        this.optionData.addChoice(name, value);
        return this;
    }

    public YusufOptionData addChoices(@Nonnull String name, long value) {
        this.optionData.addChoice(name, value);
        return this;
    }

    public YusufOptionData addChoices(@Nonnull String name, String value) {
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

}
