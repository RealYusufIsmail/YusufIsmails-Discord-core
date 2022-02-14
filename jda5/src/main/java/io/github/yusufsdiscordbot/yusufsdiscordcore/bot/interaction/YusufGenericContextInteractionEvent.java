package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

import javax.annotation.Nonnull;

public class YusufGenericContextInteractionEvent<T> extends YusufContextInteraction<T> {
    private final GenericContextInteractionEvent<T> event;

    protected YusufGenericContextInteractionEvent(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            ContextInteraction<T> contextInteraction, GenericContextInteractionEvent<T> event) {
        super(callback, commandInteractionPayload, contextInteraction);
        this.event = event;
    }


    public GenericContextInteractionEvent<T> getEvent() {
        return event;
    }

    @Nonnull
    public ContextInteraction<T> getInteraction() {
        return event.getInteraction();
    }

    @Override
    @Nonnull
    public ContextInteraction.ContextTarget getTargetType() {
        return getInteraction().getTargetType();
    }

    @Override
    @Nonnull
    public Object getTarget() {
        return event.getTarget();
    }
}
