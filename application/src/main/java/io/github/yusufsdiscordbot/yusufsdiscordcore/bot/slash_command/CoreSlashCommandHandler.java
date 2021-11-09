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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example.ExampleCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.HashMap;
import java.util.Map;

/**
 * For register the commands make sure to set it to awaitReady as seen here
 * 
 * <pre>
 * jda.awaitReady()
 *     .addEventListener(new CommandHandler(jda, jda.getGuildById(872494635757473932L)));
 * </pre>
 * <p>
 * The is class which process the registration of the commands. <br>
 * <br>
 * Commands are register by using addCommand with an example being <br>
 * addCommand(new TestCommand())
 */
public class CoreSlashCommandHandler extends ListenerAdapter {
    private final Map<String, CommandConnector> commands = new HashMap<>();
    /**
     * Used to determine whether the commands should be global or guild only.
     */
    public CommandListUpdateAction globalCommandsData;
    public CommandListUpdateAction guildCommandsData;

    /**
     * For an example please see {@link ExampleCommandHandler#ExampleCommandHandler(JDA, Guild)}
     */
    public CoreSlashCommandHandler(JDA jda, Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }

    /**
     * Used to register the commands. when the developer types addCommand(new TestCommand()). The
     * addCommand will retrieve the commandData which includes name,description,options,sub
     * commands, etc
     *
     * @param command <br>
     *        The Command class is an interface class which contains all the need methods for the
     *        making of the command. <br>
     *        <br>
     *        The enum {@link CommandVisibility#UNIVERSAL} and {@link CommandVisibility#SERVER}
     *        determines whether the command should be Global or Guild only.
     */
    public void addCommand(CommandConnector command) {
        commands.put(command.getName(), command);
        if (command.getVisibility() == CommandVisibility.SERVER) {
            guildCommandsData.addCommands(command.getCommandData());
        } else if (command.getVisibility() == CommandVisibility.UNIVERSAL) {
            globalCommandsData.addCommands(command.getCommandData());
        }
    }

    @Override
    public void onSlashCommand(SlashCommandEvent slashCommandEvent) {
        var cmd = commands.get(slashCommandEvent.getName());
        if (cmd == null) {
            slashCommandEvent.reply("unknown command").queue();
            return;
        }
        Command slashCommand = this.commands.get(cmd.getName());
        cmd.onSlashCommand(new YusufSlashCommandEvent(slashCommand, slashCommandEvent));
    }
}
