package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.UserCommand;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

public class YusufUserContextInteractionEvent extends YusufGenericContextInteractionEvent {
    private final UserCommand command;
    private final UserContextInteractionEvent event;

    public YusufUserContextInteractionEvent(UserCommand command,
            UserContextInteractionEvent event) {
        super(event, event, event, event);
        this.command = command;
        this.event = event;
    }

    public UserCommand getCommand() {
        return command;
    }

    public UserContextInteractionEvent getEvent() {
        return event;
    }
}
