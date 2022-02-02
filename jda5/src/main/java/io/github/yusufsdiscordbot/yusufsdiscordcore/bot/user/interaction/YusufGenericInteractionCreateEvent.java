package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.utils.TimeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Locale;

@SuppressWarnings("unused")
public class YusufGenericInteractionCreateEvent extends Event {
    private final GenericInteractionCreateEvent event;

    /**
     * Creates a new Event from the given JDA instance
     *
     * @param api Current JDA instance
     * @param responseNumber The sequence number for this event
     * @param event The event
     */
    public YusufGenericInteractionCreateEvent(@NotNull JDA api, long responseNumber,
            GenericInteractionCreateEvent event) {
        super(api, responseNumber);
        this.event = event;
    }

    /**
     * Creates a new Event from the given JDA instance <br>
     * Uses the current {@link JDA#getResponseTotal()} as sequence
     *
     * @param api Current JDA instance
     * @param event The event
     */
    public YusufGenericInteractionCreateEvent(@NotNull JDA api,
            GenericInteractionCreateEvent event) {
        super(api);
        this.event = event;
    }


    public GenericInteractionCreateEvent getEvent() {
        return event;
    }

    /**
     * The raw interaction type. <br>
     * It is recommended to use {@link #getType()} instead.
     *
     * @return The raw interaction type
     */
    public int getTypeRaw() {
        return event.getTypeRaw();
    }

    /**
     * The {@link InteractionType} for this interaction.
     *
     * @return The {@link InteractionType} or {@link InteractionType#UNKNOWN}
     */
    @NotNull
    public InteractionType getType() {
        return event.getType();
    }

    /**
     * The interaction token used for responding to an interaction.
     *
     * @return The interaction token
     */
    @NotNull
    public String getToken() {
        return event.getToken();
    }

    /**
     * The {@link YusufGuild} this interaction happened in. <br>
     * This is null in direct messages.
     *
     * @return The {@link YusufGuild} or null
     */
    @Nullable
    public YusufGuild getGuild() {
        return new YusufGuild(event.getGuild());
    }

    /**
     * Whether this interaction came from a {@link Guild}. <br>
     * This is identical to {@code getGuild() != null}
     *
     * @return True, if this interaction happened in a guild
     */
    public boolean isFromGuild() {
        return event.isFromGuild();
    }

    /**
     * The {@link ChannelType} for the channel this interaction came from. <br>
     * If {@link #getChannel()} is null, this returns {@link ChannelType#UNKNOWN}.
     *
     * @return The {@link ChannelType}
     */
    @NotNull
    public ChannelType getChannelType() {
        return event.getChannelType();
    }

    /**
     * The {@link YusufUser} who caused this interaction.
     *
     * @return The {@link YusufUser}
     */
    @NotNull
    public YusufUser getUser() {
        return new YusufUser(event.getUser());
    }

    /**
     * The {@link YusufMember} who caused this interaction. <br>
     * This is null if the interaction is not from a guild.
     *
     * @return The {@link YusufMember}
     */
    @Nullable
    public YusufMember getMember() {
        return new YusufMember(event.getMember());
    }

    /**
     * The channel this interaction happened in. <br>
     * This is currently never null, but might be nullable in the future.
     *
     * @return The channel or null if this interaction is not from a channel context
     */
    @Nullable
    public Channel getChannel() {
        return event.getChannel();
    }

    /**
     * Whether this interaction has already been acknowledged. <br>
     * <b>Each interaction can only be acknowledged once.</b>
     *
     * @return True, if this interaction has already been acknowledged
     */
    public boolean isAcknowledged() {
        return event.isAcknowledged();
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
        return event.getGuildChannel();
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
        return event.getMessageChannel();
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
        return event.getTextChannel();
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
        return event.getNewsChannel();
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
        return event.getVoiceChannel();
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
        return event.getPrivateChannel();
    }

    /**
     * The {@link ThreadChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#isThread()}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link ThreadChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not a thread channel
     */
    @NotNull
    public ThreadChannel getThreadChannel() {
        return event.getThreadChannel();
    }

    /**
     * Returns the selected language of the invoking user.
     *
     * @return The language of the invoking user
     */
    @NotNull
    public Locale getUserLocale() {
        return event.getUserLocale();
    }

    /**
     * Returns the preferred language of the Guild. <br>
     * This is identical to {@code getGuild().getLocale()}.
     *
     * @return The preferred language of the Guild
     * @throws IllegalStateException If this interaction is not from a guild. (See
     *         {@link #isFromGuild()})
     */
    @NotNull
    public Locale getGuildLocale() {
        return event.getGuildLocale();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getId() {
        return event.getId();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    public long getIdLong() {
        return event.getIdLong();
    }

    /**
     * The time this entity was created. Calculated through the Snowflake in {@link #getIdLong}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     * @see TimeUtil#getTimeCreated(long)
     */
    @NotNull
    public OffsetDateTime getTimeCreated() {
        return event.getTimeCreated();
    }
}
