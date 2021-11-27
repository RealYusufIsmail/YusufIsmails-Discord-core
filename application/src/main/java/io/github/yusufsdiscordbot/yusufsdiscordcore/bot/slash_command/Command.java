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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import io.github.yusufsdiscordbot.annotations.ToBeChanged;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

abstract class Command {

    /**
     * Were the command is created.
     */
    protected abstract void onSlashCommand(YusufSlashCommandEvent yusufSlashCommandEvent);

    /**
     * Provides the user with name of the command
     *
     * @return {@link CommandData#getName()}
     */
    abstract String getName();

    /**
     * Provides the user information on what the command is about.
     *
     * @return {@link CommandData#getDescription()}
     */
    abstract String getDescription();

    /**
     * Used to determine whether the command is Global(can be used on all servers) or whether it is
     * only a Guild command(can only be used in specific servers)
     */
    abstract Boolean isGuildOnly();

    /**
     * Retrieves all the command data such as the name and description of the command. Also used to
     * create options and sub commands.
     *
     * @return {@link CommandData#CommandData(String, String)} and can also return
     *         {@link CommandData#addOption(OptionType, String, String)} <br >
     *         <br >
     *         Choices can also be used which makes it easier for the user. which returns
     *         {@link OptionData#addChoice(String, int)} <br>
     *         <br>
     *         Original from <a href=
     *         "https://github.com/Together-Java/TJ-Bot/blob/95d7f323a998b15abfa2c0723c30636d2f00c4cf/application/src/main/java/org/togetherjava/tjbot/commands/SlashCommand.java#L91">here</a>
     *         and modified by Yusuf
     */
    @ToBeChanged(whenToBeChanged = "1.0.50", willBeChangedSoon = true,
            reasonForTheChange = "To remove the credits")
    abstract CommandData retrieveCommandData();

    /**
     * Used to create buttons for the user to interact with.
     *
     * @see ButtonClickEvent
     */
    abstract void onButtonClick(@NotNull ButtonClickEvent event);

    abstract boolean isOwnerOnly();
}
