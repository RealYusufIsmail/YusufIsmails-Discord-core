package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.*;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public class YusufCommandData extends YusufBaseCommand<YusufCommandData>
        implements SerializableData {
    private boolean allowSubcommands = true;
    private boolean allowGroups = true;
    private boolean allowOption = true;
    private boolean defaultPermissions = true; // whether the command uses default_permissions (blacklist/whitelist)
    private boolean allowRequired = true;
    private final CommandData commandData;


    public CommandData getCommandData() {
        return commandData;
    }

    public YusufCommandData(@Nonnull String name, @Nonnull String description) {
        super(name, description);
        this.commandData = new CommandData(name, description);
    }

    public List<SubcommandData> getSubcommands() {
        return commandData.getSubcommands();
    }

    public String getName() {
        return commandData.getName();
    }

    public String getDescription() {
        return commandData.getDescription();
    }

    public List<YusufOptionData> getOptions() {
        return commandData.getOptions()
            .stream()
            .map(YusufOptionData::new)
            .collect(java.util.stream.Collectors.toList());
    }

    public List<YusufSubcommandGroupData> getSubcommandGroups() {
        return commandData.getSubcommandGroups();
    }

    public CommandData setDefaultEnabled(boolean enabled) {
        return commandData.setDefaultEnabled(enabled);
    }

    public YusufCommandData addOptions(@Nonnull YusufOptionData... options) {
        Checks.noneNull(options, "Option");
        Checks.check(options.length + this.options.length() <= 25, "Cannot have more than 25 options for a command!");
        Checks.check(allowOption, "You cannot mix options with subcommands/groups.");
        allowSubcommands = allowGroups = false;
        for (YusufOptionData option : options) {
            Checks.check(option.getOptionType() != OptionType.SUB_COMMAND, "Cannot add a subcommand with addOptions(...). Use addSubcommands(...) instead!");
            Checks.check(option.getOptionType() != OptionType.SUB_COMMAND_GROUP, "Cannot add a subcommand group with addOptions(...). Use addSubcommandGroups(...) instead!");
            Checks.check(allowRequired || !option.getIsRequired(), "Cannot add required options after non-required options!");
            allowRequired = option.getIsRequired(); // prevent adding required options after non-required options
            this.options.add(option);
        }
        return this;
    }

    public YusufCommandData addOptions(@Nonnull Collection<? extends YusufOptionData> options) {
        return addOptions(options.toArray(new YusufOptionData[0]));
    }

    public YusufCommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description) {
        return addOptions(new YusufOptionData(type, name, description));
    }

    public YusufCommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description, boolean isRequired) {
        return addOptions(new YusufOptionData(type, name, description, isRequired));
    }

    public YusufCommandData addSubcommands(@Nonnull YusufSubcommandData... subcommands) {
        Checks.noneNull(subcommands, "Subcommands");
        if (!allowSubcommands)
            throw new IllegalArgumentException("You cannot mix options with subcommands/groups.");
        Checks.check(subcommands.length + options.length() <= 25,
                "Cannot have more than 25 subcommands for a command!");
        for (YusufSubcommandData subcommand : subcommands)
            this.options.add(subcommand);
        return this;
    }

    public YusufCommandData addSubcommands(@Nonnull Collection<? extends YusufSubcommandData> subcommands) {
        return addSubcommands(subcommands.toArray(new YusufSubcommandData[0]));
    }

    public @NotNull DataObject toData() {
        return commandData.toData();
    }

    @Contract("_ -> new")
    public static @NotNull CommandData fromData(@Nonnull DataObject json) {
        return CommandData.fromData(json);
    }
}
