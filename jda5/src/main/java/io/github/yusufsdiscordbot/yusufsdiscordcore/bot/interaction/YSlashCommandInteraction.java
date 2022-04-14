package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.dv8tion.jda.api.entities.GuildMessageChannel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.interactions.callbacks.IDeferrableCallback;
import net.dv8tion.jda.api.interactions.callbacks.IModalCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

@EqualsAndHashCode(callSuper = false)
public class YSlashCommandInteraction extends YCommandInteraction {
    @Getter
    private final SlashCommandInteraction slashCommandInteraction;
    private final IModalCallback modalCallback;
    private final IDeferrableCallback deferrableCallback;

    public YSlashCommandInteraction(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            SlashCommandInteraction slashCommandInteraction) {
        super(callback, commandInteractionPayload);
        this.slashCommandInteraction = slashCommandInteraction;
        this.modalCallback = slashCommandInteraction;
        this.deferrableCallback = slashCommandInteraction;
    }


    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return slashCommandInteraction.getChannel();
    }

    @Nonnull
    @Override
    public GuildMessageChannel getGuildChannel() {
        return slashCommandInteraction.getGuildChannel();
    }

    @NotNull
    public YSlashCommandInteraction getInteraction() {
        return this;
    }

    public IDeferrableCallback getDeferrableCallback() {
        return this.deferrableCallback;
    }

    /**
     * Acknowledgement of this interaction with a {@link Modal Modal}.
     *
     * <p>
     * This will open a popup on the target user's Discord client.
     *
     * <p>
     * Interactions can only be acknowledged once.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param modal The Modal to send
     * @return ModalCallbackAction
     * @throws IllegalArgumentException If the provided modal is null
     */
    @NotNull
    @CheckReturnValue
    public ModalCallbackAction replyModal(@NotNull Modal modal) {
        return modalCallback.replyModal(modal);
    }

    /**
     * Acknowledgement of this interaction with a {@link Modal Modal}.
     *
     * <p>
     * This will open a popup on the target user's Discord client.
     *
     * <p>
     * Interactions can only be acknowledged once.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param modal The Modal to send
     * @throws IllegalArgumentException If the provided modal is null
     */
    public void replyQueuedModal(@NotNull Modal modal) {
        modalCallback.replyModal(modal).queue();
    }
}
