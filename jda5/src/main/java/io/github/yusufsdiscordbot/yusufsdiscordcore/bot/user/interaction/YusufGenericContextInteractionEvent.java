package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

import javax.annotation.Nonnull;

@SuppressWarnings(value = "rawtypes")
public class YusufGenericContextInteractionEvent extends YusufContextInteraction {
    private final GenericContextInteractionEvent event;

    protected YusufGenericContextInteractionEvent(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            ContextInteraction contextInteraction, GenericContextInteractionEvent event) {
        super(callback, commandInteractionPayload, contextInteraction);
        this.event = event;
    }


    public GenericContextInteractionEvent getEvent() {
        return event;
    }

    @Nonnull
    public ContextInteraction getInteraction() {
        return event.getInteraction();
    }

    @Nonnull
    public ContextInteraction.ContextTarget getTargetType() {
        return getInteraction().getTargetType();
    }

    @Nonnull
    public Object getTarget() {
        return event.getTarget();
    }
}
