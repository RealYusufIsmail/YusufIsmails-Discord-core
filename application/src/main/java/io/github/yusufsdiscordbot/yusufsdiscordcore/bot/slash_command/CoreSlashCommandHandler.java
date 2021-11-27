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
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

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
@SuppressWarnings("unused")
public class CoreSlashCommandHandler extends ListenerAdapter {
    private final Map<String, CommandConnector> commandConnector = new HashMap<>();

    /**
     * Used to determine whether the commands should be global or guild only.
     */
    private final CommandListUpdateAction globalCommandsData;
    private final CommandListUpdateAction guildCommandsData;

    /**
     * For an example please see {@link ExampleCommandHandler#ExampleCommandHandler(JDA, Guild)}
     */
    public CoreSlashCommandHandler(@NotNull JDA jda, @NotNull Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }



    long botOwnerId = 422708001976221697L;

    private long botOwnerId() {
        return botOwnerId;
    }

    /**
     * Used to register only owner commands.
     * 
     * @param command the command connector.
     * @param ownerId the owner id.
     */
    public void addCommand(@NotNull CommandConnector command, long ownerId) {
        if (command.isOwnerOnly() && ownerId == botOwnerId()) {
            commandConnector.put(command.getName(), command);
            if (command.isGuildOnly()) {
                guildCommandsData.addCommands(command.retrieveCommandData()).queue();
            } else if (!command.isGuildOnly()) {
                globalCommandsData.addCommands(command.retrieveCommandData()).queue();
            }
        }
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
     *        The boolean {@link Command#isGuildOnly()} is used to determine whether the command
     *        should be global or guild only. determines whether the command should be Global or
     *        Guild only.
     */
    public void addCommand(CommandConnector command) {
        commandConnector.put(command.getName(), command);
        if (command.isGuildOnly()) {
            guildCommandsData.addCommands(command.retrieveCommandData()).queue();
        } else if (!command.isGuildOnly()) {
            globalCommandsData.addCommands(command.retrieveCommandData()).queue();
        }
    }

    /**
     * Register the slash command field
     * 
     * @param slashCommandEvent The slash command event
     */
    public void addCommand(@NotNull SlashCommandEvent slashCommandEvent) {
        if (this.commandConnector.containsKey(slashCommandEvent.getName())) {
            CommandConnector onSlashCommand =
                    this.commandConnector.get(slashCommandEvent.getName());
            onSlashCommand
                .onSlashCommand(new YusufSlashCommandEvent(onSlashCommand, slashCommandEvent));
        }
    }

    /**
     * Register the onButtonClick field
     * 
     * @param buttonClickEvent The button click event
     */
    public void addCommand(@NotNull ButtonClickEvent buttonClickEvent) {
        if (this.commandConnector.containsKey(buttonClickEvent.getId())) {
            CommandConnector onButtonClick = this.commandConnector.get(buttonClickEvent.getId());
            onButtonClick.onButtonClick(buttonClickEvent);
        }
    }

    /**
     * Handles the slash command event.
     *
     * @param slashCommandEvent The original slash command event,
     */
    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent slashCommandEvent) {
        this.addCommand(slashCommandEvent);
    }

    /**
     * Handles the button click event.
     *
     * @param buttonClickEvent The original button click event,
     */
    @Override
    public void onButtonClick(@NotNull ButtonClickEvent buttonClickEvent) {
        this.addCommand(buttonClickEvent);
    }
}
