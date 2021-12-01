package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufSlashCommandEvent;
import org.jetbrains.annotations.NotNull;

class ExampleCommand extends Command {
    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);
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
