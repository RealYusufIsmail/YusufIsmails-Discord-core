package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;

import javax.annotation.Nonnull;

abstract class ExtensionCommand {
    protected abstract void onButtonInteraction(@Nonnull YusufButtonInteractionEvent event);

    protected abstract void onSelectMenuInteraction(@Nonnull YusufSelectMenuInteractionEvent event);
}
// End of file ExtensionCommand.java
