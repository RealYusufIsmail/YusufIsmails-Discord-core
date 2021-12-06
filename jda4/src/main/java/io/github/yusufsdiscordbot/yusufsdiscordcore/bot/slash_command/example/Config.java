package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;

enum Config {
    ;
    private static final Dotenv dotenv = Dotenv.load();

    static String get(@NotNull String key) {
        return dotenv.get(key.toUpperCase());
    }
}
