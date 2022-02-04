package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;

import javax.annotation.Nonnull;

public interface ExtensionCommand  {
    void onButtonInteraction(@Nonnull YusufButtonInteractionEvent event);

    void onSelectMenuInteraction(@Nonnull YusufSelectMenuInteractionEvent event);
}
// End of file ExtensionCommand.java
