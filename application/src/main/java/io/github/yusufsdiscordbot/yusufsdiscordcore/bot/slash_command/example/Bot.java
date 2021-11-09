package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

class Bot {
    public static void main(String[] args) throws InterruptedException, LoginException {
        JDA jda = JDABuilder
                .createDefault(Config.get("TOKEN"))
                .setActivity(Activity.watching("/example"))
                .setStatus(OnlineStatus.ONLINE)
                .build();

        jda.awaitReady()
                .addEventListener(new ExampleCommandHandler(jda, jda.getGuildById(Config.get("GUILDID"))));
    }
}
