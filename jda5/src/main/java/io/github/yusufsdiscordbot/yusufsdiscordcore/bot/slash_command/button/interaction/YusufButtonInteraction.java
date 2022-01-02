package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.button.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.button.YusufButton;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.interactions.components.*;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import net.dv8tion.jda.api.requests.restaction.interactions.UpdateInteractionAction;
import net.dv8tion.jda.api.utils.TimeUtil;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Collection;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufButtonInteraction extends YusufComponentInteraction {
    private final ButtonInteraction buttonInteraction;

    public YusufButtonInteraction(ButtonInteraction buttonInteraction) {
        super(buttonInteraction);
        this.buttonInteraction = buttonInteraction;
    }

    public ButtonInteraction getButtonInteraction() {
        return buttonInteraction;
    }

    public YusufComponentInteraction getYusufButtonInteraction() {
        return new YusufComponentInteraction(buttonInteraction);
    }

    @Nullable
    public YusufButton getButton() {
        return new YusufButton(this.buttonInteraction.getButton());
    }

    @NotNull
    public String getComponentId() {
        return buttonInteraction.getComponentId();
    }

    /**
     * The {@link Component} instance. <br>
     * This is null on interactions for ephemeral messages.
     *
     * @return The {@link Component}, or null if this message is ephemeral
     */
    @Nullable
    public YusufComponent getComponent() {
        return getYusufButtonInteraction().getComponent();
    }

    @NotNull
    public Message getMessage() {
        return buttonInteraction.getMessage();
    }

    public long getMessageIdLong() {
        return buttonInteraction.getMessageIdLong();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    @NotNull
    public String getMessageId() {
        return this.buttonInteraction.getMessageId();
    }

    @NotNull
    public Component.Type getComponentType() {
        return buttonInteraction.getComponentType();
    }

    public int getTypeRaw() {
        return buttonInteraction.getTypeRaw();
    }

    /**
     * The {@link InteractionType} for this interaction.
     *
     * @return The {@link InteractionType} or {@link InteractionType#UNKNOWN}
     */
    @NotNull
    public InteractionType getType() {
        return this.buttonInteraction.getType();
    }

    @NotNull
    public String getToken() {
        return buttonInteraction.getToken();
    }

    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(buttonInteraction.getGuild());
    }

    /**
     * Whether this interaction came from a {@link Guild}. <br>
     * This is identical to {@code getGuild() != null}
     *
     * @return True, if this interaction happened in a guild
     */
    public boolean isFromGuild() {
        return this.buttonInteraction.isFromGuild();
    }

    /**
     * The {@link ChannelType} for the channel this interaction came from. <br>
     * If {@link #getChannel()} is null, this returns {@link ChannelType#UNKNOWN}.
     *
     * @return The {@link ChannelType}
     */
    @NotNull
    public ChannelType getChannelType() {
        return this.buttonInteraction.getChannelType();
    }

    @Contract(" -> new")
    @NotNull
    public YusufUser getUser() {
        return new YusufUser(buttonInteraction.getUser());
    }

    @Contract(" -> new")
    @NotNull
    public YusufMember getMember() {
        return new YusufMember(buttonInteraction.getMember());
    }

    @NotNull
    public MessageChannel getChannel() {
        return buttonInteraction.getChannel();
    }

    @NotNull
    public InteractionHook getHook() {
        return buttonInteraction.getHook();
    }

    public boolean isAcknowledged() {
        return buttonInteraction.isAcknowledged();
    }

    @NotNull
    public ReplyAction deferReply() {
        return buttonInteraction.deferReply();
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
     * @return {@link ReplyAction}
     */
    @NotNull
    public ReplyAction deferReply(boolean ephemeral) {
        return this.buttonInteraction.deferReply(ephemeral);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see
     * the message. Replies are non-ephemeral by default.
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
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction reply(@NotNull Message message) {
        return this.buttonInteraction.reply(message);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see
     * the message. Replies are non-ephemeral by default.
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
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided or the content is empty or longer than
     *         {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyAction reply(@NotNull String content) {
        return this.buttonInteraction.reply(content);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see
     * the message. Replies are non-ephemeral by default.
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
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction replyEmbeds(@NotNull Collection<? extends MessageEmbed> embeds) {
        return this.buttonInteraction.replyEmbeds(embeds);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see
     * the message. Replies are non-ephemeral by default.
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
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If null is provided
     */
    @NotNull
    public ReplyAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull MessageEmbed... embeds) {
        return this.buttonInteraction.replyEmbeds(embed, embeds);
    }

    /**
     * Reply to this interaction and acknowledge it. <br>
     * This will send a reply message for this interaction. You can use
     * {@link ReplyAction#setEphemeral(boolean) setEphemeral(true)} to only let the target user see
     * the message. Replies are non-ephemeral by default.
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
     * @return {@link ReplyAction}
     * @throws IllegalArgumentException If the format string is null or the resulting content is
     *         longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @NotNull
    public ReplyAction replyFormat(@NotNull String format, @NotNull Object... args) {
        return this.buttonInteraction.replyFormat(format, args);
    }

    /**
     * The {@link GuildChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not a guild type, this throws {@link IllegalStateException}!
     *
     * @return The {@link GuildChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a guild channel
     */
    @NotNull
    public GuildChannel getGuildChannel() {
        return this.buttonInteraction.getGuildChannel();
    }

    /**
     * The {@link MessageChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not a message channel type, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link MessageChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a message channel
     */
    @NotNull
    public MessageChannel getMessageChannel() {
        return this.buttonInteraction.getMessageChannel();
    }

    /**
     * The {@link TextChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#TEXT}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link TextChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a text channel
     */
    @NotNull
    public TextChannel getTextChannel() {
        return this.buttonInteraction.getTextChannel();
    }

    /**
     * The {@link NewsChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#NEWS}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link NewsChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a news channel
     */
    @NotNull
    public NewsChannel getNewsChannel() {
        return this.buttonInteraction.getNewsChannel();
    }

    /**
     * The {@link VoiceChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#VOICE}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link VoiceChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a voice channel
     */
    @NotNull
    public VoiceChannel getVoiceChannel() {
        return this.buttonInteraction.getVoiceChannel();
    }

    /**
     * The {@link PrivateChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#PRIVATE}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link PrivateChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a private channel
     */
    @NotNull
    public PrivateChannel getPrivateChannel() {
        return this.buttonInteraction.getPrivateChannel();
    }

    @NotNull
    public JDA getJDA() {
        return this.buttonInteraction.getJDA();
    }

    @NotNull
    public UpdateInteractionAction deferEdit() {
        return buttonInteraction.deferEdit();
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided message is null
     */
    @NotNull
    public UpdateInteractionAction editMessage(@NotNull Message message) {
        return this.buttonInteraction.editMessage(message);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided content is null
     */
    @NotNull
    public UpdateInteractionAction editMessage(@NotNull String content) {
        return this.buttonInteraction.editMessage(content);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided components are null
     */
    @NotNull
    public UpdateInteractionAction editComponents(
            @NotNull Collection<? extends ComponentLayout> components) {
        return this.buttonInteraction.editComponents(components);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided components are null
     */
    @NotNull
    public UpdateInteractionAction editComponents(@NotNull ComponentLayout... components) {
        return this.buttonInteraction.editComponents(components);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If any of the provided embeds is null
     */
    @NotNull
    public UpdateInteractionAction editMessageEmbeds(
            @NotNull Collection<? extends MessageEmbed> embeds) {
        return this.buttonInteraction.editMessageEmbeds(embeds);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If any of the provided embeds is null
     */
    @NotNull
    public UpdateInteractionAction editMessageEmbeds(@NotNull MessageEmbed... embeds) {
        return this.buttonInteraction.editMessageEmbeds(embeds);
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
     * @return {@link UpdateInteractionAction} that can be used to further update the message
     * @throws IllegalArgumentException If the provided format is null
     */
    @NotNull
    public UpdateInteractionAction editMessageFormat(@NotNull String format,
            @NotNull Object... args) {
        return this.buttonInteraction.editMessageFormat(format, args);
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getButtonId() {
        return this.buttonInteraction.getId();
    }

    public long getButtonIdLong() {
        return buttonInteraction.getIdLong();
    }

    /**
     * The time this entity was created. Calculated through the Snowflake in
     * {@link #getButtonIdLong}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     * @see TimeUtil#getTimeCreated(long)
     */
    @NotNull
    public OffsetDateTime getTimeCreated() {
        return this.buttonInteraction.getTimeCreated();
    }

    public RestAction<Void> editButton(@Nullable Button newButton) {
        return buttonInteraction.editButton(newButton);
    }
}
