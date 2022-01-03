package io.github.yusufsdiscordbot.yusufsdiscordcore.bot;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteractionHook;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.components.ComponentLayout;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import net.dv8tion.jda.api.requests.restaction.interactions.UpdateInteractionAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

@SuppressWarnings({"unused"})
public class YusufComponentInteraction {
    private final ComponentInteraction componentInteraction;

    public YusufComponentInteraction(ComponentInteraction componentInteraction) {
        this.componentInteraction = componentInteraction;
    }

    public YusufInteractionHook getInteractionHook() {
        return new YusufInteractionHook(componentInteraction.getHook());
    }

    public YusufInteraction getInteraction() {
        return getInteractionHook().getInteraction();
    }

    /**
     * The custom component Id provided to the component when it was originally created. <br>
     * This value should be used to determine what action to take in regards to this interaction.
     *
     * <br>
     * This id does not have to be numerical.
     *
     * @return The component ID
     */
    @NotNull
    public String getComponentId() {
        return componentInteraction.getComponentId();
    }

    /**
     * The {@link Component} instance. <br>
     * This is null on interactions for ephemeral messages.
     *
     * @return The {@link Component}, or null if this message is ephemeral
     */
    @Nullable
    public YusufComponent getComponent() {
        return new YusufComponent(componentInteraction.getComponent());
    }

    /**
     * The {@link Message} instance.
     *
     * @return The {@link Message}
     */
    @NotNull
    public Message getMessage() {
        return componentInteraction.getMessage();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    public long getMessageIdLong() {
        return componentInteraction.getMessageIdLong();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    @NotNull
    public String getMessageId() {
        return componentInteraction.getMessageId();
    }

    /**
     * The {@link Component.Type}
     *
     * @return The {@link Component.Type}
     */
    @NotNull
    public Component.Type getComponentType() {
        return componentInteraction.getComponentType();
    }

    /**
     * The raw interaction type. <br>
     * It is recommended to use {@link #getType()} instead.
     *
     * @return The raw interaction type
     */
    public int getTypeRaw() {
        return getInteraction().getTypeRaw();
    }

    /**
     * The {@link InteractionType} for this interaction.
     *
     * @return The {@link InteractionType} or {@link InteractionType#UNKNOWN}
     */
    @NotNull
    public InteractionType getType() {
        return componentInteraction.getType();
    }

    /**
     * The interaction token used for responding to an interaction.
     *
     * @return The interaction token
     */
    @NotNull
    public String getToken() {
        return getInteraction().getToken();
    }

    /**
     * The {@link Guild} this interaction happened in. <br>
     * This is null in direct messages.
     *
     * @return The {@link Guild} or null
     */
    @Nullable
    public YusufGuild getGuild() {
        return getInteraction().getGuild();
    }

    /**
     * Whether this interaction came from a {@link Guild}. <br>
     * This is identical to {@code getGuild() != null}
     *
     * @return True, if this interaction happened in a guild
     */
    public boolean isFromGuild() {
        return getInteraction().isFromGuild();
    }

    /**
     * The {@link ChannelType} for the channel this interaction came from. <br>
     * If {@link #getChannel()} is null, this returns {@link ChannelType#UNKNOWN}.
     *
     * @return The {@link ChannelType}
     */
    @NotNull
    public ChannelType getChannelType() {
        return getInteraction().getChannelType();
    }

    /**
     * The {@link User} who caused this interaction.
     *
     * @return The {@link User}
     */
    @NotNull
    public YusufUser getUser() {
        return getInteraction().getUser();
    }

    /**
     * The {@link Member} who caused this interaction. <br>
     * This is null if the interaction is not from a guild.
     *
     * @return The {@link Member}
     */
    @Nullable
    public YusufMember getMember() {
        return getInteraction().getMember();
    }

    /**
     * The respective {@link MessageChannel} for this interaction.
     *
     * @return The {@link MessageChannel}
     */
    @NotNull
    public MessageChannel getChannel() {
        return getInteraction().getMessageChannel();
    }

    /**
     * The {@link InteractionHook} which can be used to send deferred replies or followup messages.
     *
     * @return The interaction hook
     * @throws UnsupportedOperationException If this interaction does not support deferred replies
     *         and followup messages
     */
    @NotNull
    public YusufInteractionHook getHook() {
        return getInteraction().getHook();
    }

    /**
     * Whether this interaction has already been acknowledged. <br>
     * Both {@link #deferReply()} and {@link #reply(String)} acknowledge an interaction. Each
     * interaction can only be acknowledged once.
     *
     * @return True, if this interaction has already been acknowledged
     */
    public boolean isAcknowledged() {
        return getInteraction().isAcknowledged();
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
     * @return {@link ReplyAction}
     */
    @NotNull
    public ReplyAction deferReply() {
        return getInteraction().deferReply();
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
        return componentInteraction.deferReply(ephemeral);
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
        return componentInteraction.reply(message);
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
        return componentInteraction.reply(content);
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
        return componentInteraction.replyEmbeds(embeds);
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
        return componentInteraction.replyEmbeds(embed, embeds);
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
        return componentInteraction.replyFormat(format, args);
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
        return componentInteraction.getGuildChannel();
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
        return componentInteraction.getMessageChannel();
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
        return componentInteraction.getTextChannel();
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
        return componentInteraction.getNewsChannel();
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
        return componentInteraction.getVoiceChannel();
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
        return componentInteraction.getPrivateChannel();
    }

    /**
     * Returns the {@link JDA JDA} instance of this interaction
     *
     * @return the corresponding JDA instance
     */
    @NotNull
    public JDA getJDA() {
        return getInteraction().getJDA();
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
     * @return {@link UpdateInteractionAction} that can be used to update the message
     * @see #editMessage(String)
     */
    @NotNull
    public UpdateInteractionAction deferEdit() {
        return componentInteraction.deferEdit();
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
        return componentInteraction.editMessage(message);
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
        return componentInteraction.editMessage(content);
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
        return componentInteraction.editComponents(components);
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
        return componentInteraction.editComponents(components);
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
        return componentInteraction.editMessageEmbeds(embeds);
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
        return componentInteraction.editMessageEmbeds(embeds);
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
        return componentInteraction.editMessageFormat(format, args);
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getId() {
        return componentInteraction.getId();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    public long getIdLong() {
        return componentInteraction.getIdLong();
    }
}
