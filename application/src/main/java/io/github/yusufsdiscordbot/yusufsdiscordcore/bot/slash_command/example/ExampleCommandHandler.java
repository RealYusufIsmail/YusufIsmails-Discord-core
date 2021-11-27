package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CoreSlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

public class ExampleCommandHandler extends CoreSlashCommandHandler {
    /**
     * Handles and registers the commands
     *
     * @param jda used to register global command
     * @param guild used to register guild commands
     */
    public ExampleCommandHandler(JDA jda, Guild guild) {
        super(jda, guild);
        addCommand(new ExampleCommand());
    }
}
