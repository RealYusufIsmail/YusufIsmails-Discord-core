package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.command_option.YusufOptionMapping;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.*;
import net.dv8tion.jda.api.utils.TimeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings({"unused", "java:S6206"})
public class YCommandInteractionPayload extends YReplyCallback {
    private final CommandInteractionPayload commandInteractionPayload;


    public YCommandInteractionPayload(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload) {
        super(callback);
        this.commandInteractionPayload = commandInteractionPayload;
    }

    public CommandInteractionPayload getCommandInteractionPayload() {
        return commandInteractionPayload;
    }

    /**
     * The {@link Command.Type Type} of command this interaction is for.
     *
     * @return The command type
     */
    @NotNull
    public Command.Type getCommandType() {
        return commandInteractionPayload.getCommandType();
    }

    /**
     * The command name. <br>
     * This can be useful for abstractions.
     *
     * <p>
     * Note that commands can have these following structures:
     * <ul>
     * <li>{@code /name subcommandGroup subcommandName}</li>
     * <li>{@code /name subcommandName}</li>
     * <li>{@code /name}</li>
     * </ul>
     * <p>
     * You can use {@link #getCommandPath()} to simplify your checks.
     *
     * @return The command name
     */
    @NotNull
    public String getName() {
        return commandInteractionPayload.getName();
    }

    /**
     * The subcommand name. <br>
     * This can be useful for abstractions.
     *
     * <p>
     * Note that commands can have these following structures:
     * <ul>
     * <li>{@code /name subcommandGroup subcommandName}</li>
     * <li>{@code /name subcommandName}</li>
     * <li>{@code /name}</li>
     * </ul>
     * <p>
     * You can use {@link #getCommandPath()} to simplify your checks.
     *
     * @return The subcommand name, or null if this is not a subcommand
     */
    @Nullable
    public String getSubcommandName() {
        return commandInteractionPayload.getSubcommandName();
    }

    /**
     * The subcommand group name. <br>
     * This can be useful for abstractions.
     *
     * <p>
     * Note that commands can have these following structures:
     * <ul>
     * <li>{@code /name subcommandGroup subcommandName}</li>
     * <li>{@code /name subcommandName}</li>
     * <li>{@code /name}</li>
     * </ul>
     * <p>
     * You can use {@link #getCommandPath()} to simplify your checks.
     *
     * @return The subcommand group name, or null if this is not a subcommand group
     */
    @Nullable
    public String getSubcommandGroup() {
        return commandInteractionPayload.getSubcommandGroup();
    }

    /**
     * The command id
     *
     * @return The command id
     */
    public long getCommandIdLong() {
        return commandInteractionPayload.getCommandIdLong();
    }

    /**
     * Finds the first option with the specified name.
     *
     * @param name The option name
     *
     * @throws IllegalArgumentException If the name is null
     *
     * @return The option with the provided name, or null if that option is not provided
     */
    @Nullable
    public YusufOptionMapping getOption(@Nonnull String name) {
        List<YusufOptionMapping> options = getOptionsByName(name);
        return options.isEmpty() ? null : options.get(0);
    }


    /**
     * The options provided by the user when this command was executed. <br>
     * Each option has a name and value.
     *
     * @return The options passed for this command
     */
    @Nonnull
    public List<YusufOptionMapping> getOptions() {
        return commandInteractionPayload.getOptions()
            .stream()
            .map(YusufOptionMapping::new)
            .toList();
    }

    /**
     * Gets all options for the specified name.
     *
     * @param name The option name
     * @return The list of options
     * @throws IllegalArgumentException If the provided name is null
     * @see #getOption(String)
     */
    @Nonnull
    public List<YusufOptionMapping> getOptionsByName(@NotNull String name) {
        return this.commandInteractionPayload.getOptionsByName(name)
            .stream()
            .map(YusufOptionMapping::new)
            .toList();
    }

    /**
     * Gets all options for the specified type.
     *
     * @param type The option type
     * @return The list of options
     * @throws IllegalArgumentException If the provided type is null
     */
    @Nonnull
    public List<YusufOptionMapping> getOptionsByType(@NotNull OptionType type) {
        return commandInteractionPayload.getOptionsByType(type)
            .stream()
            .map(YusufOptionMapping::new)
            .toList();
    }

    /**
     * Combination of {@link #getName()}, {@link #getSubcommandGroup()}, and
     * {@link #getSubcommandName()}. <br>
     * This will format the command into a path such as {@code mod/mute} where {@code mod} would be
     * the {@link #getName()} and {@code mute} the {@link #getSubcommandName()}.
     *
     * <p>
     * Examples:
     * <ul>
     * <li>{@code /mod ban -> "mod/ban"}</li>
     * <li>{@code /admin config owner -> "admin/config/owner"}</li>
     * <li>{@code /ban -> "ban"}</li>
     * </ul>
     *
     * @return The command path
     */
    @NotNull
    public String getCommandPath() {
        return commandInteractionPayload.getCommandPath();
    }

    /**
     * Gets the display string for this command. <br>
     * This is similar to the string you see when clicking the interaction name in the client. For
     * non-slash command types, this simply returns {@link #getName()} instead.
     *
     * <p>
     * Example return for an echo command: {@code /say echo phrase: Say this}
     *
     * @return The display string for this command
     */
    @NotNull
    public String getCommandString() {
        return commandInteractionPayload.getCommandString();
    }


    /**
     * Finds the first option with the specified name. <br>
     * A resolver is used to get the value if the option is provided. If no option is provided for
     * the given name, this will simply return null instead. You can use
     * {@link #getOption(String, Object, Function)} to provide a fallback for missing options.
     *
     * <p>
     * For {@link CommandAutoCompleteInteraction}, this might be incomplete and unvalidated.
     * Auto-complete interactions happen on incomplete command inputs and are not validated.
     *
     * <p>
     * <b>Example</b> <br>
     * You can understand this as a shortcut for these lines of code:
     * 
     * <pre>
     * {
     *     &#64;code
     *     OptionMapping opt = event.getOption("reason");
     *     String reason = opt == null ? null : opt.getAsString();
     * }
     * </pre>
     * 
     * Which can be written with this resolver as:
     * 
     * <pre>
     * {@code
     * String reason = event.getOption("reason", OptionMapping::getAsString);
     * }
     * </pre>
     *
     * @param name The option name
     * @param resolver The mapping resolver function to use if there is a mapping available, the
     *        provided mapping will never be null!
     * @param <T> The type of the resolved option value
     *
     * @throws IllegalArgumentException If the name or resolver is null
     *
     * @return The resolved option with the provided name, or null if that option is not provided
     *
     * @see #getOption(String, Object, Function)
     * @see #getOption(String, Supplier, Function)
     */
    @javax.annotation.Nullable
    public <T> T getOption(@Nonnull String name,
            @Nonnull Function<? super YusufOptionMapping, ? extends T> resolver) {
        return commandInteractionPayload.getOption(name,
                mapping -> resolver.apply(new YusufOptionMapping(mapping)));
    }


    /**
     * Finds the first option with the specified name. <br>
     * A resolver is used to get the value if the option is provided. If no option is provided for
     * the given name, this will simply return your provided fallback instead. You can use
     * {@link #getOption(String, Function)} to fall back to {@code null}.
     *
     * <p>
     * For {@link CommandAutoCompleteInteraction}, this might be incomplete and unvalidated.
     * Auto-complete interactions happen on incomplete command inputs and are not validated.
     *
     * <p>
     * <b>Example</b> <br>
     * You can understand this as a shortcut for these lines of code:
     * 
     * <pre>
     * {
     *     &#64;code
     *     OptionMapping opt = event.getOption("reason");
     *     String reason = opt == null ? "ban by mod" : opt.getAsString();
     * }
     * </pre>
     * 
     * Which can be written with this resolver as:
     * 
     * <pre>
     * {@code
     * String reason = event.getOption("reason", "ban by mod", OptionMapping::getAsString);
     * }
     * </pre>
     *
     * @param name The option name
     * @param fallback The fallback to use if the option is not provided, meaning
     *        {@link #getOption(String)} returns null
     * @param resolver The mapping resolver function to use if there is a mapping available, the
     *        provided mapping will never be null!
     * @param <T> The type of the resolved option value
     *
     * @throws IllegalArgumentException If the name or resolver is null
     *
     * @return The resolved option with the provided name, or {@code fallback} if that option is not
     *         provided
     *
     * @see #getOption(String, Function)
     * @see #getOption(String, Supplier, Function)
     */
    public <T> T getOption(@Nonnull String name, @javax.annotation.Nullable T fallback,
            @Nonnull Function<? super YusufOptionMapping, ? extends T> resolver) {
        return commandInteractionPayload.getOption(name, fallback,
                mapping -> resolver.apply(new YusufOptionMapping(mapping)));
    }

    /**
     * Finds the first option with the specified name. <br>
     * A resolver is used to get the value if the option is provided. If no option is provided for
     * the given name, this will simply return your provided fallback instead. You can use
     * {@link #getOption(String, Function)} to fall back to {@code null}.
     *
     * <p>
     * For {@link CommandAutoCompleteInteraction}, this might be incomplete and unvalidated.
     * Auto-complete interactions happen on incomplete command inputs and are not validated.
     *
     * <p>
     * <b>Example</b> <br>
     * You can understand this as a shortcut for these lines of code:
     * 
     * <pre>
     * {
     *     &#64;code
     *     OptionMapping opt = event.getOption("reason");
     *     String reason = opt == null ? context.getFallbackReason() : opt.getAsString();
     * }
     * </pre>
     * 
     * Which can be written with this resolver as:
     * 
     * <pre>
     * {@code
     * String reason = event.getOption("reason", context::getFallbackReason , OptionMapping::getAsString);
     * }
     * </pre>
     *
     * @param name The option name
     * @param fallback The fallback supplier to use if the option is not provided, meaning
     *        {@link #getOption(String)} returns null
     * @param resolver The mapping resolver function to use if there is a mapping available, the
     *        provided mapping will never be null!
     * @param <T> The type of the resolved option value
     *
     * @throws IllegalArgumentException If the name or resolver is null
     *
     * @return The resolved option with the provided name, or {@code fallback} if that option is not
     *         provided
     *
     * @see #getOption(String, Function)
     * @see #getOption(String, Object, Function)
     */
    public <T> T getOption(@Nonnull String name,
            @javax.annotation.Nullable Supplier<? extends T> fallback,
            @Nonnull Function<? super YusufOptionMapping, ? extends T> resolver) {
        return commandInteractionPayload.getOption(name, fallback,
                mapping -> resolver.apply(new YusufOptionMapping(mapping)));
    }


    /**
     * The command id <br>
     * This is the id generated when a command is created via {@link Guild#updateCommands()} or
     * similar.
     *
     * <p>
     * It is usually preferred to discriminate commands by the {@link #getName() command names}
     * instead.
     *
     * @return The command id
     */
    @NotNull
    public String getCommandId() {
        return commandInteractionPayload.getCommandId();
    }

    /**
     * The raw interaction type. <br>
     * It is recommended to use {@link #getType()} instead.
     *
     * @return The raw interaction type
     */
    public int getTypeRaw() {
        return commandInteractionPayload.getTypeRaw();
    }

    /**
     * The {@link InteractionType} for this interaction.
     *
     * @return The {@link InteractionType} or {@link InteractionType#UNKNOWN}
     */
    @NotNull
    public InteractionType getType() {
        return commandInteractionPayload.getType();
    }

    /**
     * The interaction token used for responding to an interaction.
     *
     * @return The interaction token
     */
    @NotNull
    public String getToken() {
        return commandInteractionPayload.getToken();
    }

    /**
     * The {@link YGuild} this interaction happened in. <br>
     * This is null in direct messages.
     *
     * @return The {@link YGuild} or null
     */
    @Nullable
    public YGuild getGuild() {
        return new YGuild(commandInteractionPayload.getGuild());
    }

    /**
     * Whether this interaction came from a {@link YGuild}. <br>
     * This is identical to {@code getGuild() != null}
     *
     * @return True, if this interaction happened in a guild
     */
    public boolean isFromGuild() {
        return commandInteractionPayload.isFromGuild();
    }

    /**
     * The {@link ChannelType} for the channel this interaction came from. <br>
     * If {@link #getChannel()} is null, this returns {@link ChannelType#UNKNOWN}.
     *
     * @return The {@link ChannelType}
     */
    @NotNull
    public ChannelType getChannelType() {
        return commandInteractionPayload.getChannelType();
    }

    /**
     * The {@link YUser} who caused this interaction.
     *
     * @return The {@link YUser}
     */
    @NotNull
    public YUser getUser() {
        return new YUser(commandInteractionPayload.getUser());
    }

    /**
     * The {@link YMember} who caused this interaction. <br>
     * This is null if the interaction is not from a guild.
     *
     * @return The {@link YMember}
     */
    @Nullable
    public YMember getMember() {
        return new YMember(commandInteractionPayload.getMember());
    }

    /**
     * The channel this interaction happened in. <br>
     * This is currently never null, but might be nullable in the future.
     *
     * @return The channel or null if this interaction is not from a channel context
     */
    @Nullable
    public Channel getChannel() {
        return commandInteractionPayload.getChannel();
    }

    /**
     * Whether this interaction has already been acknowledged. <br>
     * <b>Each interaction can only be acknowledged once.</b>
     *
     * @return True, if this interaction has already been acknowledged
     */
    public boolean isAcknowledged() {
        return commandInteractionPayload.isAcknowledged();
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
        return commandInteractionPayload.getGuildChannel();
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
        return commandInteractionPayload.getMessageChannel();
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
        return commandInteractionPayload.getTextChannel();
    }

    /**
     * The {@link NewsChannel} this interaction happened in. <br>
     * If {@link #getChannelType()} is not {@link ChannelType#NEWS}, this throws
     * {@link IllegalStateException}!
     *
     * @return The {@link NewsChannel}
     * @throws IllegalStateException If {@link #getChannel()} is not news channel
     */
    @NotNull
    public NewsChannel getNewsChannel() {
        return commandInteractionPayload.getNewsChannel();
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
        return commandInteractionPayload.getVoiceChannel();
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
        return commandInteractionPayload.getPrivateChannel();
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
        return commandInteractionPayload.getThreadChannel();
    }

    /**
     * Returns the selected language of the invoking user.
     *
     * @return The language of the invoking user
     */
    @NotNull
    public Locale getUserLocale() {
        return commandInteractionPayload.getUserLocale();
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
        return commandInteractionPayload.getGuildLocale();
    }

    /**
     * Returns the {@link JDA JDA} instance of this interaction
     *
     * @return the corresponding JDA instance
     */
    @NotNull
    public JDA getJDA() {
        return commandInteractionPayload.getJDA();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getId() {
        return commandInteractionPayload.getId();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    public long getIdLong() {
        return commandInteractionPayload.getIdLong();
    }

    /**
     * The time this entity was created. Calculated through the Snowflake in {@link #getIdLong}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     * @see TimeUtil#getTimeCreated(long)
     */
    @NotNull
    public OffsetDateTime getTimeCreated() {
        return commandInteractionPayload.getTimeCreated();
    }
}
