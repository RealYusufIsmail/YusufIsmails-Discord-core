package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public interface SlashCommandExtender {
    void onSlashCommand(SlashCommandInteractionEvent slash);

    default void onButtonClick(ButtonInteractionEvent button) {

    }

    default void onModalInteraction(ModalInteractionEvent modal) {

    }

    SlashCommand build();
}
