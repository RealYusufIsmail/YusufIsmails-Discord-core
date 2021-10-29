package github.io.yusuf.core.bot.slash_command;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

/**
 * Used when making a new command. Imports all the need methods into the new class.
 */
public interface Command {
    void onSlashCommand(SlashCommandEvent event);

    /**
     * Provides the user with name of the command
     * @return {@link CommandData#getName()}
     */
    String getName();

    /**
     * Provides the user information on what the command is about.
     * @return {@link CommandData#getDescription()}
     */
    String getDescription();

    /**
     * Used to determine whether the command is Global(can be used on all servers) or
     * whether it is only a Guild command(can only be used in specific servers)
     * @return {@link SlashCommandVisibility#GLOBAL} and {@link SlashCommandVisibility#GUILD}
     */
    SlashCommandVisibility getVisibility();

    /**
     * Retrieves all the command data such as the name and description of the command.
     * Also used to create options and sub commands.
     * @return {@link CommandData#CommandData(String, String)}
     * and can also return {@link CommandData#addOption(OptionType, String, String)}
     * <br >
     * <br >
     * Choices can also be used which makes it easier for the user.
     * which returns {@link OptionData#addChoice(String, int)}
     */
    CommandData getCommandData();
}
