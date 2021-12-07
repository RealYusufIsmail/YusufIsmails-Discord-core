package github.io.yusuf.core.bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreSlashCommandHandler implements SlashCommandCreateListener {
    private final Map<String, Command> commands = new HashMap<>();
    public List<SlashCommandBuilder> dataCommands = new ArrayList<>();

    public void addCommand(Command command){
        commands.put(command.getName(), command);
        dataCommands.add(command.getCommandData());
    }

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        var cmd = commands.get(event.getSlashCommandInteraction().getCommandName());
        if(cmd == null) {
            System.out.println("Error");
            return;
        }
        cmd.onSlashCommand(event);
    }
}
