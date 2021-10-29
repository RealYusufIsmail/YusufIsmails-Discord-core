package github.io.yusuf.core.bot.slash_command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.HashMap;
import java.util.Map;

/**
 * The is class which process the registration of the commands.
 * <br>
 * <br>
 * Commands are register by using addCommand with an example being
 * <br>
 * addCommand(new TestCommand())
 */
public class CoreSlashCommandHandler extends ListenerAdapter {
    private final Map<String, Command> commands = new HashMap<>();
    /**
     * Used to determine whether the commands should be global or guild only.
     **/
    public CommandListUpdateAction globalCommandsData;
    public CommandListUpdateAction guildCommandsData;

    public CoreSlashCommandHandler(JDA jda, Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
    }

    /**
     * Used to register the commands. when the developer types addCommand(new TestCommand()).
     * The addCommand will retrieve the commandData which includes name,description,options,sub commands, etc
     * @param command
     * <br>
     * The Command class is an interface class which contains all the need methods for the making of the command.
     *  <br>
     *  <br>
     * The enum {@link SlashCommandVisibility#GLOBAL} and {@link SlashCommandVisibility#GUILD} determines whether
     * the command should be Global or Guild only.
     */
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
