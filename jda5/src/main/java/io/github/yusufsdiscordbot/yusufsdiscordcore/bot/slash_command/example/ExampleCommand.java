package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufSlashCommandEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufCommandData;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionData;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.NotNull;

class ExampleCommand extends Command {
    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);

        getCommandData()
                .addOptions(new YusufOptionData(OptionType.BOOLEAN, "example_option", "This is an example option"));
    }

    YusufCommand getChoices() {
        return new YusufCommand(
                new YusufCommand.YusufChoices("Example Choice 1", "Example Choice 1"));
    }

    @Override
    public void onSlashCommand(@NotNull YusufSlashCommandEvent yusufSlashCommandEvent) {
        yusufSlashCommandEvent.replyMessage("example");
    }
}
