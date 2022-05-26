package io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder;

import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class SlashCommandFinalizer {
    private final SlashCommandData commandData;

    SlashCommandFinalizer(final SlashCommandData commandData) {
        this.commandData = commandData;
    }

    public SlashCommandData getSlashCommandData() {
        return commandData;
    }
}
