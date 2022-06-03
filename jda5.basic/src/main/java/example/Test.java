package example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handler.SlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Test {
    public static void main(String[] args) throws LoginException {
        JDA builder = JDABuilder.createDefault("").build();

        SlashCommandHandler handler = new SlashCommandHandler(builder, builder.getGuildById(""), 0L);
        builder.addEventListener(handler);
        handler.addSlashCommand();
        handler.queueSlashCommand();
    }
}
