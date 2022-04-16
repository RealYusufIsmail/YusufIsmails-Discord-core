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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers;

import io.github.yusufsdiscordbot.annotations.Authors;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interactions.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interactions.YusufSlashCommandEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.example.ExampleCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
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
@Authors(namesOfTheAuthors = {"Yusuf Arfan Ismail", "Serkwi Bruno Ndzi"},
        namesOfTheAuthorsGithub = {"RealYusufIsmail", "nDZIB"})
public abstract class CoreSlashCommandHandler extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(CoreSlashCommandHandler.class);
    private final Map<String, Command> commandConnector = new HashMap<>();
    protected JDA jda;


    /**
     * Used to determine whether the commands should be global or guild only.
     */
    private final @NotNull CommandListUpdateAction globalCommandsData;
    private final @NotNull CommandListUpdateAction guildCommandsData;

    /**
     * For an example please see {@link ExampleCommandHandler#ExampleCommandHandler(JDA, Guild)}
     */
    protected CoreSlashCommandHandler(@NotNull JDA jda, @NotNull Guild guild) {
        this.jda = jda;
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }

    /**
     *
     * @return used to set the bot owner id.
     */
    protected abstract long botOwnerId();

    /**
     * Used to register the commands. when the developer types addCommand(new TestCommand()). The
     * addCommand will retrieve the commandData which includes name,description,options,sub
     * commands, etc
     *
     * @param command <br>
     *        The Command class is an interface class which contains all the need methods for the
     *        making of the command. <br>
     *        <br>
     *        The boolean {@link Command#checkIfIsGuildOnly()} ()} is used to determine whether the
     *        command should be global or guild only. determines whether the command should be
     *        Global or Guild only.
     */
    private void addCommand(@NotNull Command command) {
        commandConnector.put(command.getName(), command); // Add the command to the commandConnector
        // add the command to the global or guild command list
        this.jda.addEventListener(command);
        if (command.checkIfIsGuildOnly()) {
            guildCommandsData.addCommands(command.getCommandData());
        } else if (!command.checkIfIsGuildOnly()) {
            globalCommandsData.addCommands(command.getCommandData());
        }
    }

    public void queueAndRegisterCommands(@NotNull Collection<Command> commands) {
        commands.forEach(this::addCommand);
        onFinishedRegistration();
    }

    /**
     * Queues the command after the command has been registered.
     */
    private void onFinishedRegistration() {
        globalCommandsData.queue();
        guildCommandsData.queue();
    }


    /**
     * This method is called when the slash command is triggered.
     *
     * @param slashCommandEvent the event that triggered the slash command.
     */
    private void runSlashCommandEvent(@NotNull SlashCommandEvent slashCommandEvent) {
        if (this.commandConnector.containsKey(slashCommandEvent.getName())) {
            Command onSlashCommand = this.commandConnector.get(slashCommandEvent.getName());
            if (onSlashCommand.isOwnerOnly()) {
                if (slashCommandEvent.getUser().getIdLong() == botOwnerId()) {
                    onSlashCommand.onSlashCommand(
                            new YusufSlashCommandEvent(onSlashCommand, slashCommandEvent));
                } else {
                    logger
                        .error("You are not the owner of the bot so you can not run this command");
                }
            }
            onSlashCommand
                .onSlashCommand(new YusufSlashCommandEvent(onSlashCommand, slashCommandEvent));
        } else {
            logger.error("The command you are trying to run does not exist");
        }
    }

    /**
     * Handles the slash command event.
     *
     * @param slashCommandEvent The original slash command event,
     */
    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent slashCommandEvent) {
        this.runSlashCommandEvent(slashCommandEvent);
    }
}
