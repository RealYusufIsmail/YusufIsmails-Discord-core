/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007 Copyright (C) 2007 Free Software Foundation,
 * Inc. <https://fsf.org/> Everyone is permitted to copy and distribute verbatim copies of this
 * license document, but changing it is not allowed. Yusuf Arfan Ismail The GNU General Public
 * License is a free, copyleft license for software and other kinds of works. The licenses for most
 * software and other practical works are designed to take away your freedom to share and change the
 * works. By contrast, the GNU General Public License is intended to guarantee your freedom to share
 * and change all versions of a program--to make sure it remains free software for all its users.
 * We, the Free Software Foundation, use the GNU General Public License for most of our software; it
 * applies also to any other work released this way by its authors. You can apply it to your
 * programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.CommandType;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YusufSlashCommandInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

import javax.annotation.Nonnull;

/**
 * Used when making a new command. Imports all the need methods into a new class.
 */
public abstract class SlashCommand implements ExtensionCommand {
    private final @Nonnull String name;
    private final @Nonnull String description;
    private final boolean isGuildOnly;
    private final @Nonnull CommandType[] commandType;
    private final SlashCommandData slashCommandData;

    /**
     * Were the command is registered.
     */
    protected SlashCommand(@Nonnull String name, @Nonnull String description, boolean isGuildOnly,
            @Nonnull CommandType... commandType) {
        this.name = name;
        this.description = description;
        this.isGuildOnly = isGuildOnly;
        this.commandType = commandType;

        slashCommandData = Commands.slash(name, description);
    }

    /**
     * Provides the user with name of the command
     *
     * @return {@link CommandDataImpl#getName()}
     */
    public final @Nonnull String getName() {
        return name;
    }

    /**
     * Provides the user information on what the command is about.
     *
     * @return {@link CommandDataImpl#getDescription()}
     */
    public final @Nonnull String getDescription() {
        return description;
    }

    /**
     * Retrieves all the slash command data such as the name and description of the command. Also
     * 
     * @return {@link Commands#slash(String, String)} and can also return <br >
     *         Choices can also be used which makes it easier for the user. which returns
     *         {@link OptionData#addChoice(String, long)} <br>
     *         <br>
     */
    protected final SlashCommandData getSlashCommandData() {
        return slashCommandData;
    }

    /**
     * Used to determine whether the command is Global(can be used on all servers) or whether it is
     * only a Guild command(can only be used in specific servers)
     */
    protected boolean checkIfIsGuildOnly() {
        return isGuildOnly;
    }

    /**
     * Used to determine what type of command it is.
     * 
     * @return Must be one of the following:
     *         <ul>
     *         <li>{@link CommandType#MODERATION}</li>
     *         <li>{@link CommandType#FUN}</li>
     *         <li>{@link CommandType#MUSIC}</li>
     *         <li>{@link CommandType#UTILITY}</li>
     *         <li>{@link CommandType#OWNER_ONLY}</li>
     *         <li>{@link CommandType#DEVELOPMENT}</li>
     *         <li>{@link CommandType#INFO}</li>
     *         <li>{@link CommandType#SETUP}</li>
     *         <li>{@link CommandType#SUPPORT}</li>
     *         <li>{@link CommandType#EXAMPLE}</li>
     *         <li>{@link CommandType#UNKNOWN}</li>
     *         </ul>
     */
    public CommandType getCommandType() {
        return commandType[0];
    }

    /**
     * Used when creating a new slash command.
     * 
     * @param yusufSlashCommandEvent the event that is being used to create the command.
     */
    protected abstract void onSlashCommand(
            @Nonnull YusufSlashCommandInteractionEvent yusufSlashCommandEvent);

    @SuppressWarnings("unused")
    @Override
    public void onButtonInteraction(@Nonnull YusufButtonInteractionEvent event) {}

    @SuppressWarnings("unused")
    @Override
    public void onSelectMenuInteraction(@Nonnull YusufSelectMenuInteractionEvent event) {}
}
