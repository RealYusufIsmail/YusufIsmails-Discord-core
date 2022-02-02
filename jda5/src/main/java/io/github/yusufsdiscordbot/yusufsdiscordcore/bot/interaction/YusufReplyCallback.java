package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.AttachmentOption;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufReplyCallback {
    private final IReplyCallback callback;

    public YusufReplyCallback(IReplyCallback callback) {
        this.callback = callback;
    }

    public IReplyCallback getCallback() {
        return callback;
    }


    /**
     * Acknowledge this interaction and defer the reply to a later time. <br>
     * This will send a {@code <Bot> is thinking...} message in chat that will be updated later
     * through either {@link InteractionHook#editOriginal(String)} or
     * {@link InteractionHook#sendMessage(String)}.
     *
     * <p>
     * You can use {@link #deferReply(boolean) deferReply(true)} to send a deferred ephemeral reply.
     * If your initial deferred message is not ephemeral it cannot be made ephemeral later. Your
     * first message to the {@link InteractionHook} will inherit whether the message is ephemeral or
     * not from this deferred reply.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * Use {@link #reply(String)} to reply directly.
     *
     * @return {@link ReplyCallbackAction}
     */
    @NotNull
    public ReplyCallbackAction deferReply() {
        return callback.deferReply();
    }

    /**
     * Acknowledge this interaction and defer the reply to a later time. <br>
     * This will send a {@code <Bot> is thinking...} message in chat that will be updated later
     * through either {@link InteractionHook#editOriginal(String)} or
     * {@link InteractionHook#sendMessage(String)}.
     *
     * <p>
     * You can use {@code deferReply()} or {@code deferReply(false)} to send a non-ephemeral
     * deferred reply. If your initial deferred message is ephemeral it cannot be made non-ephemeral
     * later. Your first message to the {@link InteractionHook} will inherit whether the message is
     * ephemeral or not from this deferred reply.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * Use {@link #reply(String)} to reply directly.
     *
     * <p>
     * Ephemeral messages have some limitations and will be removed once the user restarts their
     * client. <br>
     * When a message is ephemeral, it will only be visible to the user that used the interaction.
     * <br>
     * Limitations:
     * <ul>
     * <li>Cannot be deleted by the bot</li>
     * <li>Cannot contain any files/attachments</li>
     * <li>Cannot be reacted to</li>
     * <li>Cannot be retrieved</li>
     * </ul>
     *
     * @param ephemeral True, if this message should only be visible to the interaction user
     * @return {@link ReplyCallbackAction}
     */
    @NotNull
    public ReplyCallbackAction deferReply(boolean ephemeral) {
        return callback.deferReply(ephemeral);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * @param message The message to send
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyCallbackAction reply(@NotNull Message message) {
        return callback.reply(message);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * @param content The message content to send
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If null is provided or the content is empty or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyCallbackAction reply(@NotNull String content) {
        return callback.reply(content);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * @param embeds The {@link MessageEmbed MessageEmbeds} to send
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyCallbackAction replyEmbeds(@NotNull Collection<? extends MessageEmbed> embeds) {
        return callback.replyEmbeds(embeds);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * @param embed The message embed to send
     * @param embeds Any additional embeds to send
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyCallbackAction replyEmbeds(@NotNull MessageEmbed embed,
            @NotNull MessageEmbed... embeds) {
        return callback.replyEmbeds(embed, embeds);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * @param format Format string for the message content
     * @param args Format arguments for the content
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If the format string is null or the resulting content is
     *         longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyCallbackAction replyFormat(@NotNull String format, @NotNull Object... args) {
        return callback.replyFormat(format, args);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param data The InputStream data to upload
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #replyFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public ReplyCallbackAction replyFile(@NotNull InputStream data, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return callback.replyFile(data, name, options);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * <p>
     * This is a shortcut to {@link #replyFile(File, String, AttachmentOption...)} by way of using
     * {@link File#getName()}.
     * 
     * <pre>
     * sendFile(file, file.getName())
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param file The {@link File} data to upload
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If the provided file is {@code null}.
     */
    @NotNull
    public ReplyCallbackAction replyFile(@NotNull File file, @NotNull AttachmentOption... options) {
        return callback.replyFile(file, options);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * <p>
     * The {@code name} parameter is used to inform Discord about what the file should be called.
     * This is 2 fold:
     * <ol>
     * <li>The file name provided is the name that is found in
     * {@link Message.Attachment#getFileName()} after upload and it is the name that will show up in
     * the client when the upload is displayed. <br>
     * Note: The fileName does not show up on the Desktop client for images. It does on mobile
     * however.</li>
     * <li>The extension of the provided fileName also determines how Discord will treat the file.
     * Discord currently only has special handling for image file types, but the fileName's
     * extension must indicate that it is an image file. This means it has to end in something like
     * .png, .jpg, .jpeg, .gif, etc. As a note, you can also not provide a full name for the file
     * and instead ONLY provide the extension like "png" or "gif" and Discord will generate a name
     * for the upload and append the fileName as the extension.</li>
     * </ol>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param file The {@link File} data to upload
     * @param name The file name that should be sent to discord
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public ReplyCallbackAction replyFile(@NotNull File file, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return callback.replyFile(file, name, options);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyCallbackAction#setEphemeral(boolean) setEphemeral(true)} to only let the target
     * user see the message. Replies are non-ephemeral by default.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>
     * If your handling can take longer than 3 seconds, due to various rate limits or other
     * conditions, you should use {@link #deferReply()} instead.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param data The {@code byte[]} data to upload
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #replyFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link ReplyCallbackAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public ReplyCallbackAction replyFile(@NotNull byte[] data, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return callback.replyFile(data, name, options);
    }

    public void replyQueuedMessage(@Nonnull String message) {
        callback.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        callback.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        callback.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        callback.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }

    @NotNull
    public InteractionHook getHook() {
        return callback.getHook();
    }
}
