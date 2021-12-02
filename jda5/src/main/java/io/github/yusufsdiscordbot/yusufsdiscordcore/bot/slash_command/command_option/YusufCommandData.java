package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.build.*;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public class YusufCommandData extends YusufBaseCommand<YusufCommandData>
        implements SerializableData {
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

    public List<SubcommandGroupData> getSubcommandGroups() {
        return commandData.getSubcommandGroups();
    }

    public CommandData setDefaultEnabled(boolean enabled) {
        return commandData.setDefaultEnabled(enabled);
    }

    public YusufCommandData addOptions(@Nonnull YusufOptionData... options) {
        for (YusufOptionData option : options) {
            commandData.addOptions(option.getOptionData());
        }
        return this;
    }

    public YusufCommandData addOptions(@Nonnull Collection<? extends YusufOptionData> options) {
        for (YusufOptionData option : options) {
            commandData.addOptions(option.getOptionData());
        }
        return this;
    }

    public DataObject toData() {
        return commandData.toData();
    }

    @Contract("_ -> new")
    public static @NotNull CommandData fromData(@Nonnull DataObject json) {
        return CommandData.fromData(json);
    }
}
