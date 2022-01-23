/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007 Copyright (C) 2007 Free Software Foundation,
 * Inc. <https://fsf.org/> Everyone is permitted to copy and distribute verbatim copies of this
 * license document, but changing it is not allowed. Yusuf Arfan Ismail The GNU General Public
 * License is a free, copyleft license for software and other kinds of works. The licenses for most
 * software and other practical works are designed to take away your freedom to share and change the
 * works. By contrast, the GNU General Public License is intended to guarantee your freedom to share
 * and change all versions of a program--to make sure it remains free software for all its users.
 * We, the Free Software Foundation, use the GNU General Public License for most of our software; it
 * applies also to any other work released this way by its authors. You can apply it to your
 * programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionMapping;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufCommandInteraction extends YusufInteraction {
    private final CommandInteraction interaction;

    public YusufCommandInteraction(CommandInteraction interaction) {
        super(interaction);
        this.interaction = interaction;
    }

    @Override
    @Contract(" -> new")
    public @NotNull YusufBot getBot() {
        return new YusufBot(this.getJDA().getSelfUser());
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
        return interaction.getName();
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
        return interaction.getSubcommandName();
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
        return interaction.getSubcommandGroup();
    }

    /**
     * The command id
     *
     * @return The command id
     */
    public long getCommandIdLong() {
        return interaction.getCommandIdLong();
    }

    /**
     * The command id
     *
     * @return The command id
     */
    @NotNull
    public String getCommandId() {
        return interaction.getCommandId();
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
        return interaction.getOptions().stream().map(YusufOptionMapping::new).toList();
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
        return this.interaction.getOptionsByName(name)
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
        return interaction.getOptionsByType(type).stream().map(YusufOptionMapping::new).toList();
    }

    /**
     * Gets the slash command String for this slash command. <br>
     * This is similar to the String you see when clicking the interaction name in the client.
     *
     * <p>
     * Example return for an echo command: {@code /say echo phrase: Say this}
     *
     * @return The command String for this slash command
     */
    @Nonnull
    public String getCommandString() {
        return this.interaction.getCommandString();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    public long getIdLong() {
        return interaction.getIdLong();
    }

    public String getCommandPath() {
        return interaction.getCommandPath();
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
