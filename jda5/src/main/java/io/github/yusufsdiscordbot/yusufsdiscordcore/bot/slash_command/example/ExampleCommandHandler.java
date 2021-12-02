package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.handlers.CoreSlashCommandHandler;
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

        List<Command> handler = new ArrayList<>();

        handler.add(new ExampleCommand());
        queueAndRegisterCommands(handler);
    }

    @Override
    protected long botOwnerId() {
        return 801168918039232582L;
    }
}
