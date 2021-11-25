package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CommandConnector;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufSlashCommandEvent;

class ExampleCommand extends CommandConnector {
    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);
    }

    @Override
    public void onSlashCommand(YusufSlashCommandEvent yusufSlashCommandEvent) {
        yusufSlashCommandEvent.replyMessage("example");
    }
}
