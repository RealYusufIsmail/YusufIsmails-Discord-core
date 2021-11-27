// Originally from
// https://github.com/Together-Java/TJ-Bot/blob/95d7f323a998b15abfa2c0723c30636d2f00c4cf/application/src/main/java/org/togetherjava/tjbot/commands/SlashCommandAdapter.java,
// then modified by Yusuf
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

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

/**
 * Used when making a new command. Imports all the need methods into the new class.
 */
public abstract class CommandConnector extends Command {
    private final String name;
    private final String description;
    private final Boolean isGuildOnly;
    private final CommandData retrieveCommandData;


    /**
     * Were the command is registered.
     */
    protected CommandConnector(String name, String description, boolean isGuildOnly) {
        this.name = name;
        this.description = description;
        this.isGuildOnly = isGuildOnly;

        retrieveCommandData = new CommandData(name, description);
    }

    @Override
    public final @NotNull String getName() {
        return name;
    }

    @Override
    public final @NotNull String getDescription() {
        return description;
    }

    @Override
    public final CommandData retrieveCommandData() {
        return retrieveCommandData;
    }

    @Override
    public Boolean isGuildOnly() {
        return isGuildOnly;
    }

    @Override
    @SuppressWarnings("NoopMethodInAbstractClass")
    public void onButtonClick(@NotNull ButtonClickEvent event) {}

    @Override
    public boolean isOwnerOnly() {
        return false;
    }
}
