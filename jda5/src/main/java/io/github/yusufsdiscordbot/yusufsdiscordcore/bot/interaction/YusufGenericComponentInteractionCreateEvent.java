package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import javax.annotation.Nonnull;

public class YusufGenericComponentInteractionCreateEvent
        extends YusufGenericInteractionCreateEvent {
    private final GenericComponentInteractionCreateEvent event;

    public YusufGenericComponentInteractionCreateEvent(
            GenericComponentInteractionCreateEvent event) {
        super(event.getJDA(), event.getResponseNumber(), event);
        this.event = event;
    }

    public GenericComponentInteractionCreateEvent getEvent() {
        return event;
    }

    public YusufReplyCallback getReply() {
        return new YusufReplyCallback(event);
    }


    @Nonnull
    public ComponentInteraction getInteraction() {
        return event.getInteraction();
    }

    @Nonnull
    public MessageChannel getChannel() {
        return event.getChannel();
    }

    @Nonnull
    public String getComponentId() {
        return event.getComponentId();
    }

    @Nonnull
    public ActionComponent getComponent() {
        return event.getComponent();
    }

    @Nonnull
    public Message getMessage() {
        return event.getMessage();
    }

    public long getMessageIdLong() {
        return event.getMessageIdLong();
    }

    @Nonnull
    public Component.Type getComponentType() {
        return event.getComponentType();
    }

    @Nonnull
    public MessageEditCallbackAction deferEdit() {
        return event.deferEdit();
    }

    @Nonnull
    public InteractionHook getHook() {
        return event.getHook();
    }

    @Nonnull
    public ReplyCallbackAction deferReply() {
        return event.deferReply();
    }
}
