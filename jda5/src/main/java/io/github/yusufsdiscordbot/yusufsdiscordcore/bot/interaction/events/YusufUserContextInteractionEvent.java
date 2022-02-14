package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.UserCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YusufGenericContextInteractionEvent;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

public class YusufUserContextInteractionEvent extends YusufGenericContextInteractionEvent<User> {
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

    @Override
    public UserContextInteractionEvent getEvent() {
        return event;
    }
}
