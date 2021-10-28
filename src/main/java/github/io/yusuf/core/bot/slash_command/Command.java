package github.io.yusuf.core.bot.slash_command;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public interface Command {
    void onSlashCommand(SlashCommandEvent event);

    String getName();

    String getDescription();

    Enum SlashCommandVisibility();

    CommandData getCommandData();
}
