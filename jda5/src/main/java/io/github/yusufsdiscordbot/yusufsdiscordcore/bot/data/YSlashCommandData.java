package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.data;

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class YSlashCommandData implements SlashCommandData {
    private final SlashCommandData data;
    private boolean isOwnerOnly = false;

    public YSlashCommandData(SlashCommandData data) {
        this.data = data;
    }

    @NotNull
    @Override
    public YSlashCommandData setName(@NotNull String name) {
        return new YSlashCommandData(data.setName(name));
    }

    @NotNull
    @Override
    public YSlashCommandData setDefaultEnabled(boolean enabled) {
        return new YSlashCommandData(data.setDefaultEnabled(enabled));
    }

    /**
     * Configure the description
     *
     * @param description The description, 1-100 characters
     * @return The builder, for chaining
     * @throws IllegalArgumentException If the name is null or not between 1-100 characters
     */
    @NotNull
    @Override
    public YSlashCommandData setDescription(@NotNull String description) {
        return new YSlashCommandData(data.setDescription(description));
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
     * The configured description
     *
     * @return The description
     */
    @NotNull
    @Override
    public String getDescription() {
        return data.getDescription();
    }

    /**
     * The {@link SubcommandData Subcommands} in this command. <br>
     * These subcommand instances are <b>reconstructed</b>, which means that any modifications will
     * not be reflected in the backing state.
     *
     * @return Immutable list of {@link SubcommandData}
     */
    @NotNull
    @Override
    public List<SubcommandData> getSubcommands() {
        return data.getSubcommands();
    }

    /**
     * The {@link SubcommandGroupData Subcommand Groups} in this command. <br>
     * These subcommand group instances are <b>reconstructed</b>, which means that any modifications
     * will not be reflected in the backing state.
     *
     * @return Immutable list of {@link SubcommandGroupData}
     */
    @NotNull
    @Override
    public List<SubcommandGroupData> getSubcommandGroups() {
        return data.getSubcommandGroups();
    }

    /**
     * The options for this command.
     *
     * @return Immutable list of {@link OptionData}
     */
    @NotNull
    @Override
    public List<OptionData> getOptions() {
        return data.getOptions();
    }

    /**
     * Adds up to 25 options to this command.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param options The {@link OptionData Options} to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If the option name is not unique</li>
     *         <li>If null is provided</li>
     *         </ul>
     */
    @NotNull
    @Override
    public YSlashCommandData addOptions(@NotNull OptionData... options) {
        return new YSlashCommandData(data.addOptions(options));
    }

    /**
     * Adds up to 25 options to this command.
     *
     * <p>
     * Required options must be added before non-required options!
     *
     * @param options The {@link OptionData Options} to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If the option name is not unique</li>
     *         <li>If null is provided</li>
     *         </ul>
     */
    @NotNull
    @Override
    public YSlashCommandData addOptions(@NotNull Collection<? extends OptionData> options) {
        return new YSlashCommandData(data.addOptions(options));
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
     * @param autoComplete Whether this option supports auto-complete via
     *        {@link CommandAutoCompleteInteractionEvent}, only supported for option types which
     *        {@link OptionType#canSupportChoices() support choices}
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If the provided option type does not support auto-complete</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If the option name is not unique</li>
     *         <li>If null is provided</li>
     *         </ul>
     */
    @NotNull
    @Override
    public YSlashCommandData addOption(@NotNull OptionType type, @NotNull String name,
            @NotNull String description, boolean required, boolean autoComplete) {
        return new YSlashCommandData(
                data.addOption(type, name, description, required, autoComplete));
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
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If the option name is not unique</li>
     *         <li>If null is provided</li>
     *         </ul>
     */
    @NotNull
    @Override
    public YSlashCommandData addOption(@NotNull OptionType type, @NotNull String name,
            @NotNull String description, boolean required) {
        return new YSlashCommandData(data.addOption(type, name, description, required));
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
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If you try to mix subcommands/options/groups in one command.</li>
     *         <li>If the option type is {@link OptionType#SUB_COMMAND} or
     *         {@link OptionType#SUB_COMMAND_GROUP}.</li>
     *         <li>If this option is required and you already added a non-required option.</li>
     *         <li>If more than 25 options are provided.</li>
     *         <li>If the option name is not unique</li>
     *         <li>If null is provided</li>
     *         </ul>
     */
    @NotNull
    @Override
    public YSlashCommandData addOption(@NotNull OptionType type, @NotNull String name,
            @NotNull String description) {
        return new YSlashCommandData(data.addOption(type, name, description));
    }

    /**
     * Add up to 25 {@link SubcommandData Subcommands} to this command.
     *
     * @param subcommands The subcommands to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException If null, more than 25 subcommands, or duplicate subcommand
     *         names are provided. Also throws if you try to mix subcommands/options/groups in one
     *         command.
     */
    @NotNull
    @Override
    public YSlashCommandData addSubcommands(@NotNull SubcommandData... subcommands) {
        return new YSlashCommandData(data.addSubcommands(subcommands));
    }

    /**
     * Add up to 25 {@link SubcommandData Subcommands} to this command.
     *
     * @param subcommands The subcommands to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException If null, more than 25 subcommands, or duplicate subcommand
     *         names are provided. Also throws if you try to mix subcommands/options/groups in one
     *         command.
     */
    @NotNull
    @Override
    public YSlashCommandData addSubcommands(
            @NotNull Collection<? extends SubcommandData> subcommands) {
        return new YSlashCommandData(data.addSubcommands(subcommands));
    }

    /**
     * Add up to 25 {@link SubcommandGroupData Subcommand-Groups} to this command.
     *
     * @param groups The subcommand groups to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException If null, more than 25 subcommand groups, or duplicate group
     *         names are provided. Also throws if you try to mix subcommands/options/groups in one
     *         command.
     */
    @NotNull
    @Override
    public YSlashCommandData addSubcommandGroups(@NotNull SubcommandGroupData... groups) {
        return new YSlashCommandData(data.addSubcommandGroups(groups));
    }

    /**
     * Add up to 25 {@link SubcommandGroupData Subcommand-Groups} to this command.
     *
     * @param groups The subcommand groups to add
     * @return The builder instance, for chaining
     * @throws IllegalArgumentException If null, more than 25 subcommand groups, or duplicate group
     *         names are provided. Also throws if you try to mix subcommands/options/groups in one
     *         command.
     */
    @NotNull
    @Override
    public YSlashCommandData addSubcommandGroups(
            @NotNull Collection<? extends SubcommandGroupData> groups) {
        return new YSlashCommandData(data.addSubcommandGroups(groups));
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

    public YSlashCommandData isOwnerOnly() {
        this.isOwnerOnly = true;
        return this;
    }

    public boolean getOwnerOnly() {
        return isOwnerOnly;
    }
}
