package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

import javax.annotation.Nonnull;

public class YusufContextInteraction<T> extends YusufCommandInteraction {
    private final ContextInteraction<T> contextInteraction;

    protected YusufContextInteraction(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            ContextInteraction<T> contextInteraction) {
        super(callback, commandInteractionPayload);
        this.contextInteraction = contextInteraction;
    }


    public ContextInteraction<T> getContextInteraction() {
        return contextInteraction;
    }

    @Nonnull
    public ContextInteraction.ContextTarget getTargetType() {
        return contextInteraction.getTargetType();
    }

    @Nonnull
    public Object getTarget() {
        return contextInteraction.getTarget();
    }

    /**
     * The target type, of a context interaction.
     */
    enum ContextTarget {
        USER,
        MESSAGE
    }
}
