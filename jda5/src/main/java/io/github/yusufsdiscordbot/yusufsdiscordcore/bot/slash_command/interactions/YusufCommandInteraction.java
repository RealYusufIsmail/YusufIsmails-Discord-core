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
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * The options provided by the user when this command was executed. <br>
     * Each option has a name and value.
     *
     * @return The options passed for this command
     */
    @NotNull
    public List<OptionMapping> getOptions() {
        return interaction.getOptions();
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
    public boolean equals(Object obj) {
        return this.interaction.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.interaction.hashCode();
    }
}
