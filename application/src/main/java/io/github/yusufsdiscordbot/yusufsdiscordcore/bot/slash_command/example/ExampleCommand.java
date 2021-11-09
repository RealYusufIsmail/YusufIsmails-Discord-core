package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CommandConnector;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CommandVisibility;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufSlashCommandEvent;

public class ExampleCommand extends CommandConnector {
    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("test", "This is a test", CommandVisibility.SERVER);
    }

    @Override
    public void onSlashCommand(YusufSlashCommandEvent yusufSlashCommandEvent) {
        yusufSlashCommandEvent.reply("test");
    }
}
