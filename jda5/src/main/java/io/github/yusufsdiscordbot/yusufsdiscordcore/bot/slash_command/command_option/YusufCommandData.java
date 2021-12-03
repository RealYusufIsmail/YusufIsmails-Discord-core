package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.*;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a subcommand group.
 *
 * Credits to the JDA team for the code for this class. This code was taken from {@link net.dv8tion.jda.api.interactions.commands.build.CommandData}
 */
@SuppressWarnings("unused")
public class YusufCommandData extends YusufBaseCommand<YusufCommandData>
        implements SerializableData {
    private boolean allowSubcommands = true;
    private boolean allowGroups = true;
    private boolean allowedOption = true;
    private boolean allowRequired = true;
    private final CommandData commandData;
    private static final String CAN_NOT_MIX = "You cannot mix options with subcommands/groups.";


    public CommandData getCommandData() {
        return commandData;
    }

    public YusufCommandData(@Nonnull String name, @Nonnull String description) {
        super(name, description);
        this.commandData = new CommandData(name, description);
    }

    @Nonnull
    @Override
    public DataObject toData()
    {
        // whether the command uses default_permissions (blacklist/whitelist)
        boolean defaultPermissions = true;
        return super.toData().put("default_permission", defaultPermissions);
    }


    @Nonnull
    public List<YusufSubcommandData> getSubcommands() {
        return options.stream(DataArray::getObject)
                .filter(obj ->
                {
                    OptionType type = OptionType.fromKey(obj.getInt("type"));
                    return type == OptionType.SUB_COMMAND;
                })
                .map(YusufSubcommandData::fromData)
                .collect(Collectors.toList());
    }

    @Nonnull
    public List<YusufSubcommandGroupData> getSubcommandGroups() {
        return options.stream(DataArray::getObject)
                .filter(obj ->
                {
                    OptionType type = OptionType.fromKey(obj.getInt("type"));
                    return type == OptionType.SUB_COMMAND_GROUP;
                })
                .map(YusufSubcommandGroupData::fromData)
                .collect(Collectors.toList());
    }

    @Nonnull
    public CommandData setDefaultEnabled(boolean enabled) {
        return commandData.setDefaultEnabled(enabled);
    }

    @Nonnull
    public YusufCommandData addOptions(@Nonnull YusufOptionData... options) {
        Checks.noneNull(options, "Option");
        Checks.check(options.length + this.options.length() <= 25, "Cannot have more than 25 options for a command!");
        Checks.check(allowedOption, CAN_NOT_MIX);
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

    @Nonnull
    public YusufCommandData addOptions(@Nonnull Collection<? extends YusufOptionData> options) {
        Checks.noneNull(options, "Option");
        return addOptions(options.toArray(new YusufOptionData[0]));
    }

    @Nonnull
    public YusufCommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description) {
        return addOptions(new YusufOptionData(type, name, description));
    }

    @Nonnull
    public YusufCommandData addOption(@Nonnull OptionType type, @Nonnull String name,
            @Nonnull String description, boolean isRequired) {
        return addOptions(new YusufOptionData(type, name, description, isRequired));
    }

    @Nonnull
    public YusufCommandData addSubcommands(@Nonnull YusufSubcommandData... subcommands) {
        Checks.noneNull(subcommands, "Subcommands");
        if (!allowSubcommands)
            throw new IllegalArgumentException(CAN_NOT_MIX);
        Checks.check(subcommands.length + options.length() <= 25,
                "Cannot have more than 25 subcommands for a command!");
        for (YusufSubcommandData subcommand : subcommands)
            this.options.add(subcommand);
        return this;
    }

    @Nonnull
    public YusufCommandData addSubcommands(@Nonnull Collection<? extends YusufSubcommandData> subcommands) {
        Checks.noneNull(subcommands, "Subcommands");
        return addSubcommands(subcommands.toArray(new YusufSubcommandData[0]));
    }

    @Nonnull
    public YusufCommandData addSubcommandGroups(@Nonnull YusufSubcommandGroupData... groups) {
        Checks.noneNull(groups, "SubcommandGroups");
        if (!allowGroups)
            throw new IllegalArgumentException(CAN_NOT_MIX);
        allowedOption = false;
        Checks.check(groups.length + options.length() <= 25, "Cannot have more than 25 subcommand groups for a command!");
        for (YusufSubcommandGroupData data : groups)
            options.add(data);
        return this;
    }

    @Nonnull
    public YusufCommandData addSubcommandGroups(@Nonnull Collection<? extends YusufSubcommandGroupData> groups) {
        Checks.noneNull(groups, "SubcommandGroups");
        return addSubcommandGroups(groups.toArray(new YusufSubcommandGroupData[0]));
    }

    @Nonnull
    public static @NotNull YusufCommandData fromData(@Nonnull DataObject object) {
        Checks.notNull(object, "DataObject");
        String name = object.getString("name");
        String description = object.getString("description");
        DataArray options = object.optArray("options").orElseGet(DataArray::empty);
        YusufCommandData command = new YusufCommandData(name, description);
        options.stream(DataArray::getObject).forEach(opt ->
        {
            OptionType type = OptionType.fromKey(opt.getInt("type"));
            switch (type) {
                case SUB_COMMAND -> command.addSubcommands(YusufSubcommandData.fromData(opt));
                case SUB_COMMAND_GROUP -> command.addSubcommandGroups(YusufSubcommandGroupData.fromData(opt));
                default -> command.addOptions(YusufOptionData.fromData(opt));
            }
        });
        return command;
    }

    @Nonnull
    public static List<YusufCommandData> fromList(@Nonnull DataArray array) {
        Checks.notNull(array, "DataArray");
        return array.stream(DataArray::getObject).map(YusufCommandData::fromData).collect(Collectors.toList());
    }
    
    @Nonnull
    public static List<CommandData> fromList(@Nonnull Collection<? extends DataObject> collection) {
        return CommandData.fromList(collection);
    }
}
