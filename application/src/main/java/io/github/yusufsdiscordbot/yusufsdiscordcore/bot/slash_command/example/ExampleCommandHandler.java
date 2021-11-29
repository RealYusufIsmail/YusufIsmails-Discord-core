package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CoreSlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommandHandler extends CoreSlashCommandHandler {
    /**
     * Handles and registers the commands
     *
     * @param jda used to register global command
     * @param guild used to register guild commands
     */
    public ExampleCommandHandler(JDA jda, Guild guild) {
        super(jda, guild);

        List<Command> commands = new ArrayList<>();
        registerCommands(commands);
    }

    @Override
    protected long botOwnerId() {
        return 801168918039232582L;
    }
}
