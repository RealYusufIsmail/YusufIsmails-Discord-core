package github.io.yusuf.core.bot;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandBuilder;

public interface Command {
    void onSlashCommand(SlashCommandCreateEvent event);

    String getName();

    String getDescription();

    SlashCommandBuilder getCommandData();
}
