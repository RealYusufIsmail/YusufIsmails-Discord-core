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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.exceptions.ParsingException;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

public class YusufCommandData {
    private final @NotNull CommandData commandData;

    public @NotNull CommandData getCommandData() {
        return commandData;
    }

    public YusufCommandData(@Nonnull String name, @Nonnull String description) {
        this.commandData = new CommandData(name, description);
    }

    @Nonnull
    public String getName() {
        return this.commandData.getName();
    }

    @Nonnull
    public String getDescription() {
        return this.commandData.getDescription();
    }

    @Nonnull
    public DataObject toDataObject() {
        return this.commandData.toData();
    }

    /**
     * The {@link SubcommandData Subcommands} in this command.
     *
     * @return Immutable list of {@link SubcommandData}
     */
    @Nonnull
    public List<SubcommandData> getSubcommands() {
        return this.commandData.getSubcommands();
    }

    /**
     * The {@link SubcommandGroupData Subcommand Groups} in this command.
     *
     * @return Immutable list of {@link SubcommandGroupData}
     */
    @Nonnull
    public List<SubcommandGroupData> getSubcommandGroups() {
        return this.commandData.getSubcommandGroups();
    }

    /**
     * Whether this command is available to everyone by default. <br>
     * If this is disabled, you need to explicitly whitelist users and roles per guild.
     *
     * @param enabled True, if this command is enabled by default for everyone. (Default: true)
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData setDefaultEnabled(boolean enabled) {
        return this.commandData.setDefaultEnabled(enabled);
    }

    /**
     * Adds up to 25 options to this command.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param options The {@link OptionData Options} to add
     *
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If null is provided</li>
     *         </ul>
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addOptionData(@Nonnull OptionData... options) {
        return this.commandData.addOptions(options);
    }

    /**
     * Adds up to 25 options to this command.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param options The {@link OptionData Options} to add
     *
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If null is provided</li>
     *         </ul>
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addOptionData(@Nonnull Collection<? extends OptionData> options) {
        return this.commandData.addOptions(options);
    }

    /**
     * Adds an option to this command.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param type The {@link OptionType}
     * @param name The lowercase option name, 1-32 characters
     * @param description The option description, 1-100 characters
     * @param required Whether this option is required (See {@link OptionData#setRequired(boolean)})
     *
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If null is provided</li>
     *         </ul>
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description, boolean required) {
        return this.commandData.addOption(type, name, description, required);
    }


    /**
     * Adds an option to this command. <br>
     * The option is set to be non-required! You can use
     * {@link #addOption(OptionType, String, String, boolean)} to add a required option instead.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param type The {@link OptionType}
     * @param name The lowercase option name, 1-32 characters
     * @param description The option description, 1-100 characters
     *
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If null is provided</li>
     *         </ul>
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description) {
        return this.commandData.addOption(type, name, description, false);
    }

    /**
     * Add up to 25 {@link SubcommandData Subcommands} to this command.
     *
     * @param subcommands The subcommands to add
     *
     * @throws IllegalArgumentException If null is provided, or more than 25 subcommands are
     *         provided. Also throws if you try to mix subcommands/options/groups in one command.
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addSubcommandData(@Nonnull SubcommandData... subcommands) {
        return this.commandData.addSubcommands(subcommands);
    }

    /**
     * Add up to 25 {@link SubcommandData Subcommands} to this command.
     *
     * @param subcommands The subcommands to add
     *
     * @throws IllegalArgumentException If null is provided, or more than 25 subcommands are
     *         provided. Also throws if you try to mix subcommands/options/groups in one command.
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addSubcommandData(
            @Nonnull Collection<? extends SubcommandData> subcommands) {
        return this.commandData.addSubcommands(subcommands);
    }

    /**
     * Add up to 25 {@link SubcommandGroupData Subcommand-Groups} to this command.
     *
     * @param groups The subcommand groups to add
     *
     * @throws IllegalArgumentException If null is provided, or more than 25 subcommand groups are
     *         provided. Also throws if you try to mix subcommands/options/groups in one command.
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addSubcommandGroupData(@Nonnull SubcommandGroupData... groups) {
        return this.commandData.addSubcommandGroups(groups);
    }

    /**
     * Add up to 25 {@link SubcommandGroupData Subcommand-Groups} to this command.
     *
     * @param groups The subcommand groups to add
     *
     * @throws IllegalArgumentException If null is provided, or more than 25 subcommand groups are
     *         provided. Also throws if you try to mix subcommands/options/groups in one command.
     *
     * @return The CommandData instance, for chaining
     */
    @Nonnull
    public CommandData addSubcommandGroupData(
            @Nonnull Collection<? extends SubcommandGroupData> groups) {
        return this.commandData.addSubcommandGroups(groups);
    }

    /**
     * Parses the provided serialization back into an CommandData instance. <br>
     * This is the reverse function for {@link #toDataObject()}.
     *
     * @param object The serialized {@link DataObject} representing the command
     *
     * @throws ParsingException If the serialized object is missing required fields
     * @throws IllegalArgumentException If any of the values are failing the respective checks such
     *         as length
     *
     * @return The parsed CommandData instance, which can be further configured through setters
     */
    @Nonnull
    public static CommandData fromDataObject(@Nonnull DataObject object) {
        return CommandData.fromData(object);
    }

    /**
     * Parses the provided serialization back into an CommandData instance. <br>
     * This is the reverse function for {@link #toDataObject()}.
     *
     * @param array Array of serialized {@link DataObject} representing the commands
     *
     * @throws ParsingException If the serialized object is missing required fields
     * @throws IllegalArgumentException If any of the values are failing the respective checks such
     *         as length
     *
     * @return The parsed CommandData instances, which can be further configured through setters
     */
    @Nonnull
    public static List<CommandData> fromDataArray(@Nonnull DataArray array) {
        return CommandData.fromList(array);
    }

    /**
     * Parses the provided serialization back into an CommandData instance. <br>
     * This is the reverse function for {@link #toDataObject()}.
     *
     * @param collection Collection of serialized {@link DataObject} representing the commands
     *
     * @throws ParsingException If the serialized object is missing required fields
     * @throws IllegalArgumentException If any of the values are failing the respective checks such
     *         as length
     *
     * @return The parsed CommandData instances, which can be further configured through setters
     */
    @Nonnull
    public static List<CommandData> fromDataObject(
            @Nonnull Collection<? extends DataObject> collection) {
        return CommandData.fromList(collection);
    }
}
