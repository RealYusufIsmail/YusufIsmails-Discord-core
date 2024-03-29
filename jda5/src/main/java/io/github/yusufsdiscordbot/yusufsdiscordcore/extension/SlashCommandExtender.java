package io.github.yusufsdiscordbot.yusufsdiscordcore.extension;

import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.slash.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YSlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public interface SlashCommandExtender {

    // This method is called when the command is executed.
    void onSlashCommandInteraction(@NotNull YSlashCommandInteractionEvent event);

    default void onButtonClick(ButtonInteractionEvent event) {

    }

    default void onModalInteraction(ModalInteractionEvent event) {

    }

    default void onCommandAutoComplete(@Nonnull CommandAutoCompleteInteractionEvent event) {

    }

    default void onSelectMenu(@Nonnull SelectMenuInteractionEvent event) {

    }

    SlashCommand build();
}
