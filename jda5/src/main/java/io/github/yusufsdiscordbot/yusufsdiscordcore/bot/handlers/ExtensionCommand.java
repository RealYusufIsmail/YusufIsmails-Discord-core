package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;

import javax.annotation.Nonnull;

interface ExtensionCommand  {
    void onButtonInteraction(@Nonnull YusufButtonInteractionEvent event);

    void onSelectMenuInteraction(@Nonnull YusufSelectMenuInteractionEvent event);
}
// End of file ExtensionCommand.java
