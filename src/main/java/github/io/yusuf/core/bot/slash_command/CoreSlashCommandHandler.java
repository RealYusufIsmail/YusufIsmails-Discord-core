package github.io.yusuf.core.bot.slash_command;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.HashMap;
import java.util.Map;

public class CoreSlashCommandHandler extends ListenerAdapter {
    SlashCommandEvent event;
    private final Map<String, Command> commands = new HashMap<>();
    CommandListUpdateAction commandsData = event.getJDA().updateCommands();


    public void addCommand(Command command){
        commands.put(command.getName(), command);
        commandsData.addCommands(command.getCommandData());
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        var cmd = commands.get(event.getName());
        if(cmd == null) {
            event.reply("unknown command").queue();
            return;
        }
        cmd.onSlashCommand(event);
    }
}
