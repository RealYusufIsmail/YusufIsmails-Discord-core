package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public class YusufCommandData {
    private final CommandData commandData;

    public CommandData getCommandData() {
        return commandData;
    }

    @Contract(pure = true)
    public YusufCommandData(@NotNull YusufCommandData commandData) {
        this.commandData = commandData.commandData;
    }

    public YusufCommandData(String name, String description) {
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

    public CommandData addOptions(@Nonnull YusufOptionData... options) {
        for (YusufOptionData option : options) {
            commandData.addOptions(option.optionData);
        }
        return commandData;
    }
}
