package io.github.yusufsdiscordbot.yusufsdiscordcore.extension;

import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YModalInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YSlashCommandInteractionEvent;

public interface SlashCommandExtender {
    void onSlashCommand(YSlashCommandInteractionEvent slash);

    default void onButtonClick(YButtonInteractionEvent button) {

    }

    default void onModalInteraction(YModalInteractionEvent modal) {

    }

    SlashCommand build();
}
