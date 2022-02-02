package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.MessageCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YusufGenericContextInteractionEvent;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;

public class YusufMessageContextInteractionEvent extends YusufGenericContextInteractionEvent<Message>{
    private final MessageCommand messageCommand;
    private final MessageContextInteractionEvent event;

    public YusufMessageContextInteractionEvent(MessageCommand messageCommand, MessageContextInteractionEvent event) {
        super(event, event, event, event);
        this.messageCommand = messageCommand;
        this.event = event;
    }

    public MessageContextInteractionEvent getEvent() {
        return event;
    }

    public MessageCommand getMessageCommand() {
        return messageCommand;
    }
}
