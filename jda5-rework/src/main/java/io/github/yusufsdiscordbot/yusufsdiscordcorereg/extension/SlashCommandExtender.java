package io.github.yusufsdiscordbot.yusufsdiscordcorereg.extension;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YSlashCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommandFinalizer;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YSlashCommandInteractionEvent;

public interface SlashCommandExtender {
    void onSlashCommand(YSlashCommandInteractionEvent slash);

    SlashCommandFinalizer build();
}
