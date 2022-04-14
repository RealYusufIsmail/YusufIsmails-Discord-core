package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.callback;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class YMessageEditCallback extends YReplyCallback {
    private final IMessageEditCallback callback;

    public YMessageEditCallback(IReplyCallback callback, IMessageEditCallback callback1) {
        super(callback);
        this.callback = callback1;
    }


    /**
     * No-op acknowledgement of this interaction. <br>
     * This tells discord you intend to update the message that the triggering component is a part
     * of using the {@link #getHook() InteractionHook} instead of sending a reply message. You are
     * not required to actually update the message, this will simply acknowledge that you accepted
     * the interaction.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * Use {@link #editMessage(String)} to edit it directly.
     *
     * @return {@link MessageEditCallbackAction} that can be used to update the message
     * @see #editMessage(String)
     */
    @NotNull
    public MessageEditCallbackAction deferEdit() {
        return callback.deferEdit();
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param message The new message content to use
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided message is null
     */
    @NotNull
    public MessageEditCallbackAction editMessage(@NotNull Message message) {
        return callback.editMessage(message);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param content The new message content to use
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided content is null
     */
    @NotNull
    public MessageEditCallbackAction editMessage(@NotNull String content) {
        return callback.editMessage(content);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param components The new message components, such as {@link ActionRow}
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided components are null
     */
    @NotNull
    public MessageEditCallbackAction editComponents(
            @NotNull Collection<? extends LayoutComponent> components) {
        return callback.editComponents(components);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param components The new message components, such as {@link ActionRow}
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided components are null
     */
    @NotNull
    public MessageEditCallbackAction editComponents(@NotNull LayoutComponent... components) {
        return callback.editComponents(components);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param embeds The new {@link MessageEmbed MessageEmbeds}
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If any of the provided embeds is null
     */
    @NotNull
    public MessageEditCallbackAction editMessageEmbeds(
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return callback.editMessageEmbeds(embeds);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param embeds The new message embeds to include in the message
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If any of the provided embeds is null
     */
    @NotNull
    public MessageEditCallbackAction editMessageEmbeds(@NotNull MessageEmbed... embeds) {
        return callback.editMessageEmbeds(embeds);
    }

    /**
     * Acknowledgement of this interaction with a message update. <br>
     * You can use {@link #getHook()} to edit the message further.
     *
     * <p>
     * <b>You can only use deferEdit() or editMessage() once per interaction!</b> Use
     * {@link #getHook()} for any additional updates.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param format The format string for the new message content
     * @param args The format arguments
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided format is null
     */
    @NotNull
    public MessageEditCallbackAction editMessageFormat(@NotNull String format,
            @NotNull Object... args) {
        return callback.editMessageFormat(format, args);
    }
}
