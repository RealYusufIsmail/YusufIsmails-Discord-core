package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.exception;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public class DuplicateNameException extends Exception {
    private final SlashCommandInteraction event;

    public DuplicateNameException(SlashCommandInteraction event) {
        this(event, "This command " + event.getCommandPath() + " has a duplicate name");
    }

    public DuplicateNameException(SlashCommandInteraction event, String message) {
        super(message);
        this.event = event;
    }

    public SlashCommandInteraction getEvent() {
        return event;
    }

    public static class MessageContextInteractionDuplicateNameException extends Exception {
        private final MessageContextInteractionEvent event;

        public MessageContextInteractionDuplicateNameException(
                MessageContextInteractionEvent event) {
            this(event, "This command " + event.getCommandPath() + " has a duplicate name");
        }

        public MessageContextInteractionDuplicateNameException(MessageContextInteractionEvent event,
                String message) {
            super(message);
            this.event = event;
        }

        public MessageContextInteractionEvent getEvent() {
            return event;
        }
    }

    public static class UserContextInteractionDuplicateNameException extends Exception {
        private final UserContextInteractionEvent event;

        public UserContextInteractionDuplicateNameException(UserContextInteractionEvent event) {
            this(event, "This command " + event.getCommandPath() + " has a duplicate name");
        }

        public UserContextInteractionDuplicateNameException(UserContextInteractionEvent event,
                String message) {
            super(message);
            this.event = event;
        }

        public UserContextInteractionEvent getEvent() {
            return event;
        }
    }
}
