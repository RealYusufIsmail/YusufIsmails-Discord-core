package io.github.yusufsdiscordbot.yusufsdiscordcore.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.components.ComponentLayout;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageUpdateAction;
import net.dv8tion.jda.api.utils.AttachmentOption;
import net.dv8tion.jda.api.interactions.components.ActionRow;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings({"unused"})
public record YusufInteractionHook(InteractionHook interactionHook) {

    public InteractionHook getInteractionHook() {
        return interactionHook;
    }

    @Contract(" -> new")
    public @NotNull YusufInteraction getInteraction() {
        return new YusufInteraction(interactionHook.getInteraction());
    }

    public long getExpirationTimestamp() {
        return interactionHook.getExpirationTimestamp();
    }

    /**
     * Whether this interaction has expired. <br>
     * An interaction hook is only valid for 15 minutes.
     *
     * @return True, if this interaction hook has expired
     * @see #getExpirationTimestamp()
     */
    public boolean isExpired() {
        return interactionHook.isExpired();
    }

    /**
     * Whether messages sent from this interaction hook should be ephemeral by default. <br>
     * This does not affect message updates, including deferred replies sent with
     * {@link #sendMessage(String) sendMessage(...)} methods. <br>
     * When a message is ephemeral, it will only be visible to the user that used the interaction.
     *
     * <p>
     * Ephemeral messages have some limitations and will be removed once the user restarts their
     * client. <br>
     * Limitations:
     * <ul>
     * <li>Cannot be deleted by the bot</li>
     * <li>Cannot contain any files/attachments</li>
     * <li>Cannot be reacted to</li>
     * <li>Cannot be retrieved</li>
     * </ul>
     *
     * @param ephemeral True if messages should be ephemeral
     * @return The same interaction hook instance
     */
    @NotNull
    public YusufInteractionHook setEphemeral(boolean ephemeral) {
        return new YusufInteractionHook(interactionHook.setEphemeral(ephemeral));
    }

    /**
     * The JDA instance for this interaction
     *
     * @return The JDA instance
     */
    @NotNull
    public JDA getJDA() {
        return interactionHook.getJDA();
    }

    /**
     * Retrieves the original reply to this interaction. <br>
     * This doesn't work for ephemeral messages and will always cause an unknown message error
     * response.
     *
     * @return {@link RestAction} - Type: {@link Message}
     */
    @NotNull
    public RestAction<Message> retrieveOriginal() {
        return interactionHook.retrieveOriginal();
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param content The new message content to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided content is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(@NotNull String content) {
        return interactionHook.editOriginal(content);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginalComponents(
            @NotNull Collection<? extends ComponentLayout> components) {
        return interactionHook.editOriginalComponents(components);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginalComponents(
            @NotNull ComponentLayout... components) {
        return interactionHook.editOriginalComponents(components);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to 10 in total)
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginalEmbeds(
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return interactionHook.editOriginalEmbeds(embeds);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param embeds The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginalEmbeds(@NotNull MessageEmbed... embeds) {
        return interactionHook.editOriginalEmbeds(embeds);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param message The new message to replace the existing message with
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message is null
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(@NotNull Message message) {
        return interactionHook.editOriginal(message);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param format Format string for the message content
     * @param args Format arguments for the content
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the formatted string is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginalFormat(@NotNull String format,
            @NotNull Object... args) {
        return interactionHook.editOriginalFormat(format, args);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editOriginal(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided data, or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(@NotNull InputStream data,
            @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editOriginal(data, name, options);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * This is a shortcut to {@link #editOriginal(File, String, AttachmentOption...)} by way of
     * using {@link File#getName()}.
     * 
     * <pre>
     * editOriginal(file, file.getName())
     * </pre>
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editOriginal(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param file The {@link File} data to upload to the webhook.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided file is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(@NotNull File file,
            @NotNull AttachmentOption... options) {
        return interactionHook.editOriginal(file, options);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editOriginal(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param file The {@link File} data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(@NotNull File file,
            @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editOriginal(file, name, options);
    }

    /**
     * Edit the source message sent by this interaction. <br>
     * For {@link ComponentInteraction#editComponents(Collection)} and
     * {@link ComponentInteraction#deferEdit()} this will be the message the components are attached
     * to. For {@link YusufInteraction#deferReply()} and {@link YusufInteraction#reply(String)} this
     * will be the reply message instead. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * This method will be delayed until the interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editOriginal(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided data or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editOriginal(byte[] data, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return interactionHook.editOriginal(data, name, options);
    }

    /**
     * Delete the original reply. <br>
     * This doesn't work for ephemeral messages.
     *
     * @return {@link RestAction}
     */
    @NotNull
    public RestAction<Void> deleteOriginal() {
        return interactionHook.deleteOriginal();
    }


    /**
     * Indicates whether some other object is "equal to" this one. In addition to the general
     * contract of {@link Object#equals(Object) Object.equals}, record classes must further obey the
     * invariant that when a record instance is "copied" by passing the result of the record
     * component accessor methods to the canonical constructor, as follows:
     * 
     * <pre>
     *     R copy = new R(r.c1(), r.c2(), ..., r.cn());
     * </pre>
     * 
     * then it must be the case that {@code r.equals(copy)}.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this record is equal to the argument; {@code false} otherwise.
     * @implSpec The implicitly provided implementation returns {@code true} if and only if the
     *           argument is an instance of the same record class as this record, and each component
     *           of this record is equal to the corresponding component of the argument; otherwise,
     *           {@code
     * false} is returned. Equality of a component {@code c} is determined as follows:
     *           <ul>
     *
     *           <li>If the component is of a reference type, the component is considered equal if
     *           and only if {@link Objects#equals(Object, Object) Objects.equals(this.c, r.c} would
     *           return {@code true}.
     *
     *           <li>If the component is of a primitive type, using the corresponding primitive
     *           wrapper class {@code PW} (the corresponding wrapper class for {@code int} is {@code
     * java.lang.Integer}, and so on), the component is considered equal if and only if {@code
     * PW.compare(this.c, r.c)} would return {@code 0}.
     *
     *           </ul>
     *           <p>
     *           Apart from the semantics described above, the precise algorithm used in the
     *           implicitly provided implementation is unspecified and is subject to change. The
     *           implementation may or may not use calls to the particular methods listed, and may
     *           or may not perform comparisons in the order of component declaration.
     * @see Objects#equals(Object, Object)
     */
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object obj) {
        return interactionHook.equals(obj);
    }

    /**
     * Returns a hash code value for the record. Obeys the general contract of
     * {@link Object#hashCode Object.hashCode}. For records, hashing behavior is constrained by the
     * refined contract of {@link Record#equals Record.equals}, so that any two records created from
     * the same components must have the same hash code.
     *
     * @return a hash code value for this record.
     * @implSpec The implicitly provided implementation returns a hash code value derived by
     *           combining appropriate hashes from each component. The precise algorithm used in the
     *           implicitly provided implementation is unspecified and is subject to change within
     *           the above limits. The resulting integer need not remain consistent from one
     *           execution of an application to another execution of the same application, even if
     *           the hashes of the component values were to remain consistent in this way. Also, a
     *           component of primitive type may contribute its bits to the hash code differently
     *           than the {@code hashCode} of its primitive wrapper class.
     * @see Object#hashCode()
     */
    public int hashCode() {
        return interactionHook.hashCode();
    }

    /**
     * Returns a string representation of the record. In accordance with the general contract of
     * {@link Object#toString()}, the {@code toString} method returns a string that "textually
     * represents" this record. The result should be a concise but informative representation that
     * is easy for a person to read.
     * <p>
     * In addition to this general contract, record classes must further participate in the
     * invariant that any two records which are {@linkplain Record#equals(Object) equal} must
     * produce equal strings. This invariant is necessarily relaxed in the rare case where
     * corresponding equal component values might fail to produce equal strings for themselves.
     *
     * @return a string representation of the object.
     * @implSpec The implicitly provided implementation returns a string which contains the name of
     *           the record class, the names of components of the record, and string representations
     *           of component values, so as to fulfill the contract of this method. The precise
     *           format produced by this implicitly provided implementation is subject to change, so
     *           the present syntax should not be parsed by applications to recover record component
     *           values.
     * @see Object#toString()
     */
    public String toString() {
        return interactionHook.toString();
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * </ul>
     *
     * @param content The message content
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the content is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageAction<Message> sendMessage(@NotNull String content) {
        return interactionHook.sendMessage(content);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * </ul>
     *
     * @param message The message to send
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the message is null
     */
    @NotNull
    public WebhookMessageAction<Message> sendMessage(@NotNull Message message) {
        return interactionHook.sendMessage(message);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * </ul>
     *
     * @param format Format string for the message content
     * @param args Format arguments for the content
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the format string is null or the resulting content is
     *         longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageAction<Message> sendMessageFormat(@NotNull String format,
            @NotNull Object... args) {
        return interactionHook.sendMessageFormat(format, args);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * </ul>
     *
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to 10 in total)
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If any of the embeds are null, more than 10, or longer than
     *         {@link MessageEmbed#EMBED_MAX_LENGTH_BOT}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendMessageEmbeds(
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return interactionHook.sendMessageEmbeds(embeds);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * </ul>
     *
     * @param embed {@link MessageEmbed} to use
     * @param embeds Additional {@link MessageEmbed MessageEmbeds} to use (up to 10 in total)
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If any of the embeds are null, more than 10, or longer than
     *         {@link MessageEmbed#EMBED_MAX_LENGTH_BOT}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendMessageEmbeds(@NotNull MessageEmbed embed,
            @NotNull MessageEmbed... embeds) {
        return interactionHook.sendMessageEmbeds(embed, embeds);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.sendFile(file, "cat.png").addEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendFile(@NotNull InputStream data, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return interactionHook.sendFile(data, name, options);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * This is a shortcut to {@link #sendFile(File, String, AttachmentOption...)} by way of using
     * {@link File#getName()}.
     * 
     * <pre>
     * sendFile(file, file.getName())
     * </pre>
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File data = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.sendFile(file, "cat.png").addEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param file The {@link File} data to upload to the webhook.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the provided file is {@code null}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendFile(@NotNull File file,
            @NotNull AttachmentOption... options) {
        return interactionHook.sendFile(file, options);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
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
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * byte[] data = IOUtils.readAllBytes(new FileInputStream("image.png")); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.sendFile(file, "cat.png").addEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param file The {@link File} data to upload to the webhook.
     * @param name The file name that should be sent to discord
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendFile(@NotNull File file, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return interactionHook.sendFile(file, name, options);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * byte[] data = IOUtils.readAllBytes(new FileInputStream("image.png")); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.sendFile(file, "cat.png").addEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#REQUEST_ENTITY_TOO_LARGE REQUEST_ENTITY_TOO_LARGE} <br>
     * The file exceeds the maximum upload size of {@link Message#MAX_FILE_SIZE}</li>
     * </ul>
     *
     * @param data The {@code byte[]} data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null} or
     *         {@code empty}.
     */
    @NotNull
    public WebhookMessageAction<Message> sendFile(byte[] data, @NotNull String name,
            @NotNull AttachmentOption... options) {
        return interactionHook.sendFile(data, name, options);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param content The new message content to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided content is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            @NotNull String content) {
        return interactionHook.editMessageById(messageId, content);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param content The new message content to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided content is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId,
            @NotNull String content) {
        return interactionHook.editMessageById(messageId, content);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param message The new message to replace the existing message with
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message is null
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            @NotNull Message message) {
        return interactionHook.editMessageById(messageId, message);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param message The new message to replace the existing message with
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message is null
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId, Message message) {
        return interactionHook.editMessageById(messageId, message);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param format Format string for the message content
     * @param args Format arguments for the content
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the formatted string is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageFormatById(@NotNull String messageId,
            @NotNull String format, @NotNull Object... args) {
        return interactionHook.editMessageFormatById(messageId, format, args);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param format Format string for the message content
     * @param args Format arguments for the content
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the formatted string is null, empty, or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageFormatById(long messageId,
            @NotNull String format, @NotNull Object... args) {
        return interactionHook.editMessageFormatById(messageId, format, args);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to 10 in total)
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageEmbedsById(@NotNull String messageId,
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return interactionHook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to 10 in total)
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageEmbedsById(long messageId,
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return interactionHook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param embeds The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageEmbedsById(@NotNull String messageId,
            @NotNull MessageEmbed... embeds) {
        return interactionHook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param embeds The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageEmbedsById(long messageId,
            @NotNull MessageEmbed... embeds) {
        return interactionHook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageComponentsById(@NotNull String messageId,
            @NotNull Collection<? extends ComponentLayout> components) {
        return interactionHook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageComponentsById(long messageId,
            @NotNull Collection<? extends ComponentLayout> components) {
        return interactionHook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageComponentsById(@NotNull String messageId,
            @NotNull ComponentLayout... components) {
        return interactionHook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow
     *        ActionRows}
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts
     *         are provided
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageComponentsById(long messageId,
            @NotNull ComponentLayout... components) {
        return interactionHook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message id, data, or filename is
     *         {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            @NotNull InputStream data, @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, data, name, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * This is a shortcut to {@link #editMessageById(String, File, String, AttachmentOption...)} by
     * way of using {@link File#getName()}.
     * 
     * <pre>
     * editMessageById(messageId, file, file.getName())
     * </pre>
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param file The {@link File} data to upload to the webhook.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message id or file is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            @NotNull File file, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, file, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param file The {@link File} data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided file, message id, or filename is
     *         {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            @NotNull File file, @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, file, name, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided message id, data, or filename is
     *         {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(@NotNull String messageId,
            byte[] data, @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, data, name, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided data or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId,
            @NotNull InputStream data, @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, data, name, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * This is a shortcut to {@link #sendFile(File, String, AttachmentOption...)} by way of using
     * {@link File#getName()}.
     * 
     * <pre>
     * sendFile(file, file.getName())
     * </pre>
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param file The {@link File} data to upload to the webhook.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided file is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId, @NotNull File file,
            @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, file, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * File file = new File("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param file The {@link File} data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided file or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId, @NotNull File file,
            @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, file, name, options);
    }

    /**
     * Edit an existing message sent by this webhook. <br>
     * The provided file will be appended to the message. You cannot delete or edit existing files
     * on a message.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * <b>Uploading images with Embeds</b> <br>
     * When uploading an <u>image</u> you can reference said image using the specified filename as
     * URI {@code attachment://filename.ext}.
     *
     * <p>
     * <u>Example</u>
     * 
     * <pre>
     * <code>
     * WebhookClient hook; // = reference of a WebhookClient such as interaction.getHook()
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new FileInputStream("image.png"); // the name in your file system can be different from the name used in discord
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * hook.editMessageById(messageId, file, "cat.png").setEmbeds(embed.build()).queue();
     * </code>
     * </pre>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit
     *        the source message of the interaction.
     * @param data The InputStream data to upload to the webhook.
     * @param name The file name that should be sent to discord <br>
     *        Refer to the documentation for {@link #sendFile(File, String, AttachmentOption...)}
     *        for information about this parameter.
     * @param options Possible options to apply to this attachment, such as marking it as spoiler
     *        image
     * @return {@link WebhookMessageUpdateAction}
     * @throws IllegalArgumentException If the provided data or filename is {@code null}.
     */
    @NotNull
    public WebhookMessageUpdateAction<Message> editMessageById(long messageId, byte[] data,
            @NotNull String name, @NotNull AttachmentOption... options) {
        return interactionHook.editMessageById(messageId, data, name, options);
    }

    /**
     * Delete a message from this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The id for the message to delete
     * @return {@link RestAction}
     * @throws IllegalArgumentException If the provided message id is null or not a valid snowflake
     */
    @NotNull
    public RestAction<Void> deleteMessageById(@NotNull String messageId) {
        return interactionHook.deleteMessageById(messageId);
    }

    /**
     * Delete a message from this webhook.
     *
     * <p>
     * If this is an {@link InteractionHook InteractionHook} this method will be delayed until the
     * interaction is acknowledged.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK} <br>
     * The webhook is no longer available, either it was deleted or in case of interactions it
     * expired.</li>
     * <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE} <br>
     * The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The id for the message to delete
     * @return {@link RestAction}
     */
    @NotNull
    public RestAction<Void> deleteMessageById(long messageId) {
        return interactionHook.deleteMessageById(messageId);
    }
}
