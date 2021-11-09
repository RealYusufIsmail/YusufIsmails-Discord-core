package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.cdimascio.dotenv.Dotenv;

class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
}
