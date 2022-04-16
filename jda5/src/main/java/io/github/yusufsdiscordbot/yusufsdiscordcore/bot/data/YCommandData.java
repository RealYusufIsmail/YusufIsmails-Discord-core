package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.data;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class YCommandData implements CommandData {
    private final CommandData data;
    private boolean isOwnerOnly = false;

    public YCommandData(CommandData data) {
        this.data = data;
    }

    /**
     * Configure the command name.
     *
     * @param name The name, 1-32 characters (lowercase and alphanumeric for
     *        {@link Command.Type#SLASH})
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException If the name is not between 1-32 characters long, or not
     *         lowercase and alphanumeric for slash commands
     */
    @NotNull
    @Override
    public CommandData setName(@NotNull String name) {
        return data.setName(name);
    }

    /**
     * Whether this command is available to everyone by default. <br>
     * If this is disabled, you need to explicitly whitelist users and roles per guild.
     *
     * <p>
     * You can use {@link CommandPrivilege} to enable or disable this command per guild for roles
     * and members of the guild. See {@link Command#updatePrivileges(Guild, CommandPrivilege...)}
     * and {@link Guild#updateCommandPrivileges(Map)}.
     *
     * @param enabled True, if this command is enabled by default for everyone. (Default: true)
     * @return The builder instance, for chaining
     */
    @NotNull
    @Override
    public CommandData setDefaultEnabled(boolean enabled) {
        return data.setDefaultEnabled(enabled);
    }

    /**
     * The current command name
     *
     * @return The command name
     */
    @NotNull
    @Override
    public String getName() {
        return data.getName();
    }

    /**
     * Whether this command is available to everyone by default.
     *
     * @return True, if this command is enabled to everyone by default
     * @see #setDefaultEnabled(boolean)
     * @see CommandPrivilege
     */
    @Override
    public boolean isDefaultEnabled() {
        return data.isDefaultEnabled();
    }

    /**
     * The {@link Command.Type}
     *
     * @return The {@link Command.Type}
     */
    @NotNull
    @Override
    public Command.Type getType() {
        return data.getType();
    }

    /**
     * Serialized {@link DataObject} for this object.
     *
     * @return {@link DataObject}
     */
    @NotNull
    @Override
    public DataObject toData() {
        return data.toData();
    }

    public YCommandData isOwnerOnly() {
        this.isOwnerOnly = true;
        return this;
    }

    public boolean getOwnerOnly() {
        return isOwnerOnly;
    }
}
