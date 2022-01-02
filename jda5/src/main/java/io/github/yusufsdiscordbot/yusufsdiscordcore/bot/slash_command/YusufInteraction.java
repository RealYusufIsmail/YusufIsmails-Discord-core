package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import net.dv8tion.jda.api.utils.TimeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Objects;

//TODO: not finished.
public record YusufInteraction(Interaction interaction) {

    public Interaction getInteraction() {
        return interaction;
    }

    /**
     * Indicates whether some other object is "equal to" this one.  In addition
     * to the general contract of {@link Object#equals(Object) Object.equals},
     * record classes must further obey the invariant that when
     * a record instance is "copied" by passing the result of the record component
     * accessor methods to the canonical constructor, as follows:
     * <pre>
     *     R copy = new R(r.c1(), r.c2(), ..., r.cn());
     * </pre>
     * then it must be the case that {@code r.equals(copy)}.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this record is equal to the
     * argument; {@code false} otherwise.
     * @implSpec The implicitly provided implementation returns {@code true} if
     * and only if the argument is an instance of the same record class
     * as this record, and each component of this record is equal to
     * the corresponding component of the argument; otherwise, {@code
     * false} is returned. Equality of a component {@code c} is
     * determined as follows:
     * <ul>
     *
     * <li> If the component is of a reference type, the component is
     * considered equal if and only if {@link
     * Objects#equals(Object, Object)
     * Objects.equals(this.c, r.c} would return {@code true}.
     *
     * <li> If the component is of a primitive type, using the
     * corresponding primitive wrapper class {@code PW} (the
     * corresponding wrapper class for {@code int} is {@code
     * java.lang.Integer}, and so on), the component is considered
     * equal if and only if {@code
     * PW.compare(this.c, r.c)} would return {@code 0}.
     *
     * </ul>
     * <p>
     * Apart from the semantics described above, the precise algorithm
     * used in the implicitly provided implementation is unspecified
     * and is subject to change. The implementation may or may not use
     * calls to the particular methods listed, and may or may not
     * perform comparisons in the order of component declaration.
     * @see Objects#equals(Object, Object)
     */
    public boolean equals(Object obj) {
        return interaction.equals(obj);
    }

    /**
     * Returns a hash code value for the record.
     * Obeys the general contract of {@link Object#hashCode Object.hashCode}.
     * For records, hashing behavior is constrained by the refined contract
     * of {@link Record#equals Record.equals}, so that any two records
     * created from the same components must have the same hash code.
     *
     * @return a hash code value for this record.
     * @implSpec The implicitly provided implementation returns a hash code value derived
     * by combining appropriate hashes from each component.
     * The precise algorithm used in the implicitly provided implementation
     * is unspecified and is subject to change within the above limits.
     * The resulting integer need not remain consistent from one
     * execution of an application to another execution of the same
     * application, even if the hashes of the component values were to
     * remain consistent in this way.  Also, a component of primitive
     * type may contribute its bits to the hash code differently than
     * the {@code hashCode} of its primitive wrapper class.
     * @see Object#hashCode()
     */
    public int hashCode() {
        return interaction.hashCode();
    }

    /**
     * Returns a string representation of the record.
     * In accordance with the general contract of {@link Object#toString()},
     * the {@code toString} method returns a string that
     * "textually represents" this record. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * <p>
     * In addition to this general contract, record classes must further
     * participate in the invariant that any two records which are
     * {@linkplain Record#equals(Object) equal} must produce equal
     * strings.  This invariant is necessarily relaxed in the rare
     * case where corresponding equal component values might fail
     * to produce equal strings for themselves.
     *
     * @return a string representation of the object.
     * @implSpec The implicitly provided implementation returns a string which
     * contains the name of the record class, the names of components
     * of the record, and string representations of component values,
     * so as to fulfill the contract of this method.
     * The precise format produced by this implicitly provided implementation
     * is subject to change, so the present syntax should not be parsed
     * by applications to recover record component values.
     * @see Object#toString()
     */
    public String toString() {
        return interaction.toString();
    }

    /**
     * The raw interaction type.
     * <br>It is recommended to use {@link #getType()} instead.
     *
     * @return The raw interaction type
     */
    public int getTypeRaw() {
        return interaction.getTypeRaw();
    }

    /**
     * The {@link InteractionType} for this interaction.
     *
     * @return The {@link InteractionType} or {@link InteractionType#UNKNOWN}
     */
    @NotNull
    public InteractionType getType() {
        return interaction.getType();
    }

    /**
     * The interaction token used for responding to an interaction.
     *
     * @return The interaction token
     */
    @NotNull
    public String getToken() {
        return interaction.getToken();
    }

    /**
     * The {@link YusufGuild} this interaction happened in.
     * <br>This is null in direct messages.
     *
     * @return The {@link YusufGuild} or null
     */
    public @Nullable
    YusufGuild getGuild() {
        return new YusufGuild(interaction.getGuild());
    }

    /**
     * Whether this interaction came from a {@link Guild}.
     * <br>This is identical to {@code getGuild() != null}
     *
     * @return True, if this interaction happened in a guild
     */
    public boolean isFromGuild() {
        return getGuild() != null;
    }

    /**
     * The {@link ChannelType} for the channel this interaction came from.
     * <br>If {@link #getChannel()} is null, this returns {@link ChannelType#UNKNOWN}.
     *
     * @return The {@link ChannelType}
     */
    @NotNull
    public ChannelType getChannelType() {
        return interaction.getChannelType();
    }

    /**
     * The {@link YusufUser} who caused this interaction.
     *
     * @return The {@link YusufUser}
     */
    @NotNull
    public YusufUser getUser() {
        return new YusufUser(interaction.getUser());
    }

    /**
     * The {@link YusufMember} who caused this interaction.
     * <br>This is null if the interaction is not from a guild.
     *
     * @return The {@link YusufMember}
     */
    public @NotNull
    YusufMember getMember() {
        return new YusufMember(interaction.getMember());
    }

    /**
     * The channel this interaction happened in.
     * <br>This is currently never null, but might be nullable in the future.
     *
     * @return The channel or null if this interaction is not from a channel context
     */
    @Nullable
    public Channel getChannel() {
        return interaction.getChannel();
    }

    /**
     * The {@link InteractionHook} which can be used to send deferred replies or followup messages.
     *
     * @return The interaction hook
     * @throws UnsupportedOperationException If this interaction does not support deferred replies and followup messages
     */
    @NotNull
    public InteractionHook getHook() {
        return interaction.getHook();
    }

    /**
     * Whether this interaction has already been acknowledged.
     * <br>Both {@link #deferReply()} and {@link #reply(String)} acknowledge an interaction.
     * Each interaction can only be acknowledged once.
     *
     * @return True, if this interaction has already been acknowledged
     */
    public boolean isAcknowledged() {
        return interaction.isAcknowledged();
    }

    /**
     * Acknowledge this interaction and defer the reply to a later time.
     * <br>This will send a {@code <Bot> is thinking...} message in chat that will be updated later through either {@link InteractionHook#editOriginal(String)} or {@link InteractionHook#sendMessage(String)}.
     *
     * <p>You can use {@link #deferReply(boolean) deferReply(true)} to send a deferred ephemeral reply. If your initial deferred message is not ephemeral it cannot be made ephemeral later.
     * Your first message to the {@link InteractionHook} will inherit whether the message is ephemeral or not from this deferred reply.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>Use {@link #reply(String)} to reply directly.
     *
     * @return {@link ReplyAction}
     */
    @NotNull
    public ReplyAction deferReply() {
        return interaction.deferReply();
    }

    /**
     * Acknowledge this interaction and defer the reply to a later time.
     * <br>This will send a {@code <Bot> is thinking...} message in chat that will be updated later through either {@link InteractionHook#editOriginal(String)} or {@link InteractionHook#sendMessage(String)}.
     *
     * <p>You can use {@code deferReply()} or {@code deferReply(false)} to send a non-ephemeral deferred reply. If your initial deferred message is ephemeral it cannot be made non-ephemeral later.
     * Your first message to the {@link InteractionHook} will inherit whether the message is ephemeral or not from this deferred reply.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>Use {@link #reply(String)} to reply directly.
     *
     * <p>Ephemeral messages have some limitations and will be removed once the user restarts their client.
     * <br>When a message is ephemeral, it will only be visible to the user that used the interaction.
     * <br>Limitations:
     * <ul>
     *     <li>Cannot be deleted by the bot</li>
     *     <li>Cannot contain any files/attachments</li>
     *     <li>Cannot be reacted to</li>
     *     <li>Cannot be retrieved</li>
     * </ul>
     *
     * @param ephemeral True, if this message should only be visible to the interaction user
     * @return {@link ReplyAction}
     */
    @NotNull
    public ReplyAction deferReply(boolean ephemeral) {
        return interaction.deferReply(ephemeral);
    }

    /**
     * Reply to this interaction and acknowledge it.
     * <br>This will send a reply message for this interaction.
     * You can use {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see the message.
     * Replies are non-ephemeral by default.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>If your handling can take longer than 3 seconds, due to various rate limits or other conditions, you should use {@link #deferReply()} instead.
     *
     * @param message The message to send
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction reply(@NotNull Message message) {
        return interaction.reply(message);
    }

    /**
     * Reply to this interaction and acknowledge it.
     * <br>This will send a reply message for this interaction.
     * You can use {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see the message.
     * Replies are non-ephemeral by default.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>If your handling can take longer than 3 seconds, due to various rate limits or other conditions, you should use {@link #deferReply()} instead.
     *
     * @param content The message content to send
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided or the content is empty or longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyAction reply(@NotNull String content) {
        return interaction.reply(content);
    }

    /**
     * Reply to this interaction and acknowledge it.
     * <br>This will send a reply message for this interaction.
     * You can use {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see the message.
     * Replies are non-ephemeral by default.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>If your handling can take longer than 3 seconds, due to various rate limits or other conditions, you should use {@link #deferReply()} instead.
     *
     * @param embeds The {@link MessageEmbed MessageEmbeds} to send
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction replyEmbeds(@NotNull Collection<? extends MessageEmbed> embeds) {
        return interaction.replyEmbeds(embeds);
    }

    /**
     * Reply to this interaction and acknowledge it.
     * <br>This will send a reply message for this interaction.
     * You can use {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see the message.
     * Replies are non-ephemeral by default.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>If your handling can take longer than 3 seconds, due to various rate limits or other conditions, you should use {@link #deferReply()} instead.
     *
     * @param embed  The message embed to send
     * @param embeds Any additional embeds to send
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull MessageEmbed... embeds) {
        return interaction.replyEmbeds(embed, embeds);
    }

    /**
     * Reply to this interaction and acknowledge it.
     * <br>This will send a reply message for this interaction.
     * You can use {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see the message.
     * Replies are non-ephemeral by default.
     *
     * <p><b>You only have 3 seconds to acknowledge an interaction!</b>
     * <br>When the acknowledgement is sent after the interaction expired, you will receive {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     * <p>If your handling can take longer than 3 seconds, due to various rate limits or other conditions, you should use {@link #deferReply()} instead.
     *
     * @param format Format string for the message content
     * @param args   Format arguments for the content
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If the format string is null or the resulting content is longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyAction replyFormat(@NotNull String format, @NotNull Object... args) {
        return interaction.replyFormat(format, args);
    }

    /**
     * The {@link GuildChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not a guild type, this throws {@link IllegalStateException}!
     *
     * @return The {@link GuildChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a guild channel
     */
    @NotNull
    public GuildChannel getGuildChannel() {
        return interaction.getGuildChannel();
    }

    /**
     * The {@link MessageChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not a message channel type, this throws {@link IllegalStateException}!
     *
     * @return The {@link MessageChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a message channel
     */
    @NotNull
    public MessageChannel getMessageChannel() {
        return interaction.getMessageChannel();
    }

    /**
     * The {@link TextChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not {@link ChannelType#TEXT}, this throws {@link IllegalStateException}!
     *
     * @return The {@link TextChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a text channel
     */
    @NotNull
    public TextChannel getTextChannel() {
        return interaction.getTextChannel();
    }

    /**
     * The {@link NewsChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not {@link ChannelType#NEWS}, this throws {@link IllegalStateException}!
     *
     * @return The {@link NewsChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a news channel
     */
    @NotNull
    public NewsChannel getNewsChannel() {
        return interaction.getNewsChannel();
    }

    /**
     * The {@link VoiceChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not {@link ChannelType#VOICE}, this throws {@link IllegalStateException}!
     *
     * @return The {@link VoiceChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a voice channel
     */
    @NotNull
    public VoiceChannel getVoiceChannel() {
        return interaction.getVoiceChannel();
    }

    /**
     * The {@link PrivateChannel} this interaction happened in.
     * <br>If {@link #getChannelType()} is not {@link ChannelType#PRIVATE}, this throws {@link IllegalStateException}!
     *
     * @return The {@link PrivateChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a private channel
     */
    @NotNull
    public PrivateChannel getPrivateChannel() {
        return interaction.getPrivateChannel();
    }

    /**
     * Returns the {@link JDA JDA} instance of this interaction
     *
     * @return the corresponding JDA instance
     */
    @NotNull
    public JDA getJDA() {
        return interaction.getJDA();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getInteractionId() {
        return interaction.getId();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    public long getInteractionIdLong() {
        return interaction.getIdLong();
    }

    /**
     * The time this entity was created. Calculated through the Snowflake in {@link #getInteractionIdLong}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     * @see TimeUtil#getTimeCreated(long)
     */
    @NotNull
    public OffsetDateTime getTimeCreated() {
        return interaction.getTimeCreated();
    }

    public void replyQueuedMessage(@Nonnull String message) {
        this.interaction.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        this.interaction.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.interaction.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.interaction.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
