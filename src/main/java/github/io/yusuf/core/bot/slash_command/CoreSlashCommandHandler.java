package github.io.yusuf.core.bot.slash_command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.HashMap;
import java.util.Map;

public class CoreSlashCommandHandler extends ListenerAdapter {
    private final Map<String, Command> commands = new HashMap<>();
    public CommandListUpdateAction globalCommandsData;
    public CommandListUpdateAction guildCommandsData;

    public CoreSlashCommandHandler(JDA jda, Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }

    public void addCommand(Command command){
        commands.put(command.getName(), command);
        if(command.getVisibility() == SlashCommandVisibility.GUILD) {
            guildCommandsData.addCommands(command.getCommandData());
        } else if(command.getVisibility() == SlashCommandVisibility.GLOBAL) {
            globalCommandsData.addCommands(command.getCommandData());
        }
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
