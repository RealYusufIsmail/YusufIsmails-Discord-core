package github.io.yusuf.core.bot;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import java.util.HashMap;
import java.util.Map;

public class SlashCommandHandler implements SlashCommandCreateListener {
    private final Map<String, Command> commands = new HashMap<>();

    public void addCommand(Command command){
        commands.put(command.getName(), command);
    }

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommandInteraction slashCommandInteraction;
        var cmd = commands.get(event.getSlashCommandInteraction().getCommandName());
        if(cmd == null) {
            System.out.println("Error");
            return;
        }
        cmd.onSlashCommand(event);
    }
}
