package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.CoreSlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

public class ExampleCommandHandler extends CoreSlashCommandHandler {
    /**
     * For an example please see <a href=
     * "https://github.com/YusufsDiscordbot/Yusuf-s-Moderation-Bot/blob/JDA-Development/application/src/main/java/net/yusuf/bot/CommandHandler.java">example</a>
     */
    public ExampleCommandHandler(JDA jda, Guild guild) {
        super(jda, guild);
        addCommand(new ExampleCommand());

        globalCommandsData.queue();
        guildCommandsData.queue();
    }
}
