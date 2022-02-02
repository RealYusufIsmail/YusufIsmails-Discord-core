package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandInteraction;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class YusufContextInteraction extends YusufCommandInteraction {
    private final ContextInteraction contextInteraction;

    protected YusufContextInteraction(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            ContextInteraction contextInteraction) {
        super(callback, commandInteractionPayload);
        this.contextInteraction = contextInteraction;
    }


    public ContextInteraction getContextInteraction() {
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
