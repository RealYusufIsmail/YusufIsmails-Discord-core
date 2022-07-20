package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/**
 * Interactions which allow sending modals as a response.
 *
 * <p>
 * Sending a modal using {@link #replyModal(Modal)} will automatically acknowledge this interaction.
 */
public interface YModalCallback extends YInteraction {

    /**
     * Acknowledgement of this interaction with a
     * {@link net.dv8tion.jda.api.interactions.components.Modal Modal}.
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
     * {@link net.dv8tion.jda.api.requests.ErrorResponse#UNKNOWN_INTERACTION
     * ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param modal The Modal to send
     *
     * @throws IllegalArgumentException If the provided modal is null
     *
     * @return ModalCallbackAction
     */
    @Nonnull
    @CheckReturnValue
    ModalCallbackAction replyModal(@Nonnull Modal modal);
}
