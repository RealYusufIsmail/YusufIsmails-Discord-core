package github.io.yusuf.core.bot;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreSlashCommandHandler implements SlashCommandCreateListener {
    private final Map<String, Command> commands = new HashMap<>();
    public List<SlashCommandBuilder> dataCommands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.put(command.getName(), command);
        dataCommands.add(command.getCommandData());
    }

    private void runSlashCommandEvent(@NotNull SlashCommandCreateEvent slashCommandEvent) {
        var cmd = commands.get(slashCommandEvent.getSlashCommandInteraction().getCommandName());
        if (this.commands.containsKey(cmd)) {
            Command onSlashCommand = this.commands.get(cmd);
            onSlashCommand.onSlashCommand(slashCommandEvent);
        }
    }

    private void runSlashCommandCreate(@NotNull SlashCommandCreateEvent event) {
        var cmd = commands.get(event.getSlashCommandInteraction().getCommandName());
        if (cmd == null) {
            System.out.println("Error");
            return;
        }
        cmd.onSlashCommand(event);
    }

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        runSlashCommandCreate(event);
    }
}
