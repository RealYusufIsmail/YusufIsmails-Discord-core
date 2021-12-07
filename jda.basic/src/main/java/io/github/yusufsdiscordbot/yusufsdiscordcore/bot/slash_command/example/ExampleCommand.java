package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.Command;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import org.jetbrains.annotations.NotNull;

class ExampleCommand extends Command {
    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent slashCommandEvent) {
        slashCommandEvent.reply("example").queue();
    }
}
