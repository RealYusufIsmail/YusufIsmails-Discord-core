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
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.example.ExampleCommandHandler;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.ExtensionCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.MessageCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.UserCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YusufMessageContextInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YusufSlashCommandInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YusufUserContextInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.*;

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
 * Commands are register by using a List with an example being
 * 
 * <pre>
 * List<Command> handler = new ArrayList<>(); <br>
 * handler.add(new ExampleCommand()); <br>
 * queueAndRegisterCommands(handler);
 * </pre>
 */
@SuppressWarnings("unused")
@Authors(namesOfTheAuthors = {"Yusuf Arfan Ismail", "Serkwi Bruno Ndzi"},
        namesOfTheAuthorsGithub = {"RealYusufIsmail", "nDZIB"})
public abstract class CoreSlashCommandHandler extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(CoreSlashCommandHandler.class);
    private final Map<String, SlashCommand> slashCommand = new HashMap<>();
    private final Map<String, UserCommand> userCommand = new HashMap<>();
    private final Map<String, MessageCommand> messageCommand = new HashMap<>();
    private final Map<String, ExtensionCommand> extensionCommand = new HashMap<>();
    private static final String COMMAND_ERROR = "The command {} is not registered";

    /**
     * Used to determine whether the commands should be global or guild only.
     */
    private final @NotNull CommandListUpdateAction globalCommandsData;
    private final @NotNull CommandListUpdateAction guildCommandsData;

    /**
     * For an example please see {@link ExampleCommandHandler#ExampleCommandHandler(JDA, Guild)}
     */
    protected CoreSlashCommandHandler(@NotNull JDA jda, @NotNull Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }

    /**
     *
     * @return used to set the bot owner id.
     */
    protected abstract long botOwnerId();

    /**
     * Used to register slash commands. when the developer types slashCommand.add(new
     * ExampleCommand());. The addCommand will retrieve the commandData which includes
     * name,description,options,sub commands, etc
     *
     * @param command <br>
     *        The Command class is an interface class which contains all the need methods for the
     *        making of the command. <br>
     *        <br>
     *        The boolean {@link SlashCommand#checkIfIsGuildOnly()} ()} is used to determine whether
     *        the command should be global or guild only. determines whether the command should be
     *        Global or Guild only.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void addSlashCommand(@NotNull SlashCommand command) {
        slashCommand.put(command.getName(), command);
        if (command.checkIfIsGuildOnly()) {
            guildCommandsData.addCommands(command.getSlashCommandData());
        } else if (!command.checkIfIsGuildOnly()) {
            globalCommandsData.addCommands(command.getSlashCommandData());
        } else {
            logger.error(COMMAND_ERROR, command.getName());
        }
    }

    // TODO add java doc
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void addUserCommand(@NotNull UserCommand command) {
        userCommand.put(command.getName(), command);
        if (command.checkIfIsGuildOnly()) {
            guildCommandsData.addCommands(command.getCommandData());
        } else if (!command.checkIfIsGuildOnly()) {
            globalCommandsData.addCommands(command.getCommandData());
        } else {
            logger.error(COMMAND_ERROR, command.getName());
        }
    }

    // TODO add java doc
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void addMessageCommand(@NotNull MessageCommand command) {
        messageCommand.put(command.getName(), command);
        if (command.checkIfIsGuildOnly()) {
            guildCommandsData.addCommands(command.getCommandData());
        } else if (!command.checkIfIsGuildOnly()) {
            globalCommandsData.addCommands(command.getCommandData());
        } else {
            logger.error(COMMAND_ERROR, command.getName());
        }
    }

    /**
     * Used to register the slash commands.
     *
     * @param commands The slash commands
     */
    public void queueAndRegisterCommands(@NotNull Collection<SlashCommand> commands,
            @NotNull Collection<UserCommand> userCommands,
            @NotNull Collection<MessageCommand> messageCommands) {
        commands.forEach(this::addSlashCommand);
        userCommands.forEach(this::addUserCommand);
        messageCommands.forEach(this::addMessageCommand);
        onFinishedRegistration();
    }

    /**
     * Used to register the user commands.
     *
     * @param userCommands The user commands.
     */
    public void queueAndRegisterUserCommands(@NotNull Collection<UserCommand> userCommands) {
        userCommands.forEach(this::addUserCommand);
        onFinishedRegistration();
    }

    /**
     * Used to register the slash commands.
     * 
     * @param slashCommands the slash commands.
     */
    public void queueAndRegisterSlashCommands(@NotNull Collection<SlashCommand> slashCommands) {
        slashCommands.forEach(this::addSlashCommand);
        onFinishedRegistration();
    }

    /**
     * Used to register the message context commands.
     * 
     * @param messageCommand the message context command.
     */
    public void queueAndRegisterMessageContextCommands(
            @NotNull Collection<MessageCommand> messageCommand) {
        messageCommand.forEach(this::addMessageCommand);
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
    private void runSlashCommandEvent(@NotNull SlashCommandInteractionEvent slashCommandEvent) {
        if (checkIfCommandNameIsNullOrRepeated(slashCommandEvent)
                || isCommandOwnerOnly(slashCommandEvent, botOwnerId())) {
            onSlashCommandEvent(slashCommandEvent);
        }
    }

    private boolean checkIfCommandNameIsNullOrRepeated(
            @NotNull SlashCommandInteractionEvent slashCommandEvent) {
        var cmdName = this.slashCommand.containsKey(slashCommandEvent.getName());
        if (cmdName) {
            return true;
        }
        logger.info(COMMAND_ERROR, slashCommandEvent.getCommandPath());
        return false;
    }

    private boolean isCommandOwnerOnly(@NotNull SlashCommandInteractionEvent slashCommandEvent,
            long botOwnerId) {
        var onSlashCommand = this.slashCommand.get(slashCommandEvent.getName());
        if (onSlashCommand.getCommandType() == CommandType.OWNER_ONLY
                && slashCommandEvent.getMember().getIdLong() == botOwnerId) {
            return true;
        } else {
            slashCommandEvent.reply("This command is only available for the bot owner")
                .setEphemeral(true)
                .queue();
            logger.error("You are not the owner of the bot so you can not run this command '{}'",
                    slashCommandEvent.getCommandPath());
            return false;
        }
    }

    private void onSlashCommandEvent(@NotNull SlashCommandInteractionEvent slashCommandEvent) {
        var onSlashCommand = this.slashCommand.get(slashCommandEvent.getName());
        onSlashCommand.onSlashCommand(
                new YusufSlashCommandInteractionEvent(onSlashCommand, slashCommandEvent));
    }

    /**
     * Handles the slash command event.
     *
     * @param slashCommandEvent The original slash command event,
     */
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent slashCommandEvent) {
        this.runSlashCommandEvent(slashCommandEvent);
    }

    @Override
    public void onUserContextInteraction(@NotNull UserContextInteractionEvent userContextEvent) {
        var onUserCommand = this.userCommand.get(userContextEvent.getName());
        if (onUserCommand != null) {
            onUserCommand.onUserContextInteraction(
                    new YusufUserContextInteractionEvent(onUserCommand, userContextEvent));
        } else {
            logger.info(COMMAND_ERROR, userContextEvent.getCommandPath());
        }
    }

    @Override
    public void onMessageContextInteraction(@Nonnull MessageContextInteractionEvent event) {
        var onMessageCommand = this.messageCommand.get(event.getName());
        if (onMessageCommand != null) {
            onMessageCommand.onMessageContextInteraction(
                    new YusufMessageContextInteractionEvent(onMessageCommand, event));
        } else {
            logger.info(COMMAND_ERROR, event.getCommandPath());
        }
    }

    @Override
    public void onButtonInteraction(@Nonnull ButtonInteractionEvent event) {
        var onButtonCommand = this.extensionCommand.get(event.getComponentId());
        if (onButtonCommand != null) {
            onButtonCommand.onButtonInteraction(new YusufButtonInteractionEvent(event));
        } else {
            logger.info("The command id is null please double check this command '{}",
                    event.getComponentId());
        }
    }

    @Override
    public void onSelectMenuInteraction(@Nonnull SelectMenuInteractionEvent event) {
        var onSelectionMenuCommand = this.extensionCommand.get(event.getComponentId());
        if (onSelectionMenuCommand != null) {
            onSelectionMenuCommand
                .onSelectMenuInteraction(new YusufSelectMenuInteractionEvent(event));
        } else {
            logger.info("The command id is null please double check this command '{}",
                    event.getComponentId());
        }
    }

    /**
     * Gets the commands as a list.
     *
     * @return retrieves the commands as a list.
     */
    @NotNull
    public List<SlashCommand> getCommands() {
        return new ArrayList<>(this.slashCommand.values());
    }
}
