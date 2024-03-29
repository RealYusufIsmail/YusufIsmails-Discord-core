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

// Originally from
// https://github.com/Together-Java/TJ-Bot/blob/95d7f323a998b15abfa2c0723c30636d2f00c4cf/application/src/main/java/org/togetherjava/tjbot/commands/SlashCommandAdapter.java,
// then modified by Yusuf
package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handler.extension;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

/**
 * Used when making a new command. Imports all the need methods into the new class.
 */
public abstract class SlashCommand extends BaseCommand {
    private final @NotNull String name;
    private final @NotNull String description;
    private final boolean isGuildOnly;
    private final @NotNull CommandData commandData;

    /**
     * Were the command is registered.
     */
    protected SlashCommand(@NotNull String name, @NotNull String description, boolean isGuildOnly) {
        this.name = name;
        this.description = description;
        this.isGuildOnly = isGuildOnly;

        commandData = new CommandData(name, description);
    }

    /**
     * Were the command is created.
     */
    @Override
    public abstract void onSlashCommand(@NotNull SlashCommandEvent slashCommandEvent);

    /**
     * Provides the user with name of the command
     *
     * @return {@link CommandData#getName()}
     */
    public final @NotNull String getName() {
        return name;
    }

    /**
     * Provides the user information on what the command is about.
     *
     * @return {@link CommandData#getDescription()}
     */
    public final @NotNull String getDescription() {
        return description;
    }

    /**
     * Retrieves all the command data such as the name and description of the command. Also used to
     * create options and sub commands.
     *
     * @return {@link CommandData#CommandData(String, String)} and can also return
     *         {@link CommandData#addOption(OptionType, String, String)}<br >
     *         <br >
     *         Choices can also be used which makes it easier for the user. which returns
     *         {@link net.dv8tion.jda.api.interactions.commands.build.OptionData#addChoice(String, int)}
     */
    public final @NotNull CommandData getCommandData() {
        return commandData;
    }

    /**
     * Used to determine whether the command is Global(can be used on all servers) or whether it is
     * only a Guild command(can only be used in specific servers)
     */
    public boolean checkIfIsGuildOnly() {
        return isGuildOnly;
    }

    /**
     * Used to determine whether the command is Global(can be used on all servers) or whether it is
     * only a Guild command(can only be used in specific servers)
     */
    public boolean isOwnerOnlyCommand() {
        return false;
    }
}
