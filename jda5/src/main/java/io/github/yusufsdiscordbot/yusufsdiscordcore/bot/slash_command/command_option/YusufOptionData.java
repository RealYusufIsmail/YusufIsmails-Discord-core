package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public record YusufOptionData(OptionData optionData) {
    /**
     *
     * @param optionType The slash command option type
     * @param optionName The slash command option name
     * @param optionDescription  The slash command option description
     * @return Creates a new option
     */
    @Contract("_, _, _ -> new")
    public @NotNull OptionData YusufOptionData(@Nonnull OptionType optionType, @Nonnull String optionName, @Nonnull String optionDescription) {
        return new OptionData(optionType, optionName, optionDescription);
    }

    /**
     *
     * @param optionType The slash command option type
     * @param optionName The slash command option name
     * @param optionDescription  The slash command option description
     * @param hasToAnswer if the user has to reply to the slash command event
     * @return Creates a new option
     */
    @Contract("_, _, _, _ -> new")
    public @NotNull OptionData YusufOptionData(@Nonnull OptionType optionType, @Nonnull String optionName, @Nonnull String optionDescription, boolean hasToAnswer) {
        return new OptionData(optionType, optionName, optionDescription, hasToAnswer);
    }

    //TODO add the rest of the optionData

    public @NotNull OptionType getOptionType() {
        return this.optionData.getType();
    }

    public @NotNull String getOptionName() {
        return this.optionData.getName();
    }


}
