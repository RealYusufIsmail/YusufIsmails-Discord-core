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

package github.io.yusuf.core.bot;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreSlashCommandHandler implements SlashCommandCreateListener {
    private static final Logger logger = LoggerFactory.getLogger(CoreSlashCommandHandler.class);

    private final Map<String, Command> commands = new HashMap<>();
    public @NotNull List<SlashCommandBuilder> dataCommands = new ArrayList<>();

    public void addCommand(@NotNull Command command) {
        commands.put(command.getName(), command);
        dataCommands.add(command.getCommandData());
    }

    private void runSlashCommandEvent(@NotNull SlashCommandCreateEvent slashCommandEvent) {
        var cmd = commands.get(slashCommandEvent.getSlashCommandInteraction().getCommandName());
        if (this.commands.containsKey(cmd)) {
            Command onSlashCommand = this.commands.get(cmd);
            onSlashCommand.onSlashCommand(slashCommandEvent);
        }
    }

    private void runSlashCommandCreate(@NotNull SlashCommandCreateEvent event) {
        var cmd = commands.get(event.getSlashCommandInteraction().getCommandName());
        if (cmd == null) {
            logger.error("Error");
            return;
        }
        cmd.onSlashCommand(event);
    }

    @Override
    public void onSlashCommandCreate(@NotNull SlashCommandCreateEvent event) {
        runSlashCommandCreate(event);
    }
}
