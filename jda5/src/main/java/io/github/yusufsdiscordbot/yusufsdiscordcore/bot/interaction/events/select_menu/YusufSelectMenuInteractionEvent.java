package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YusufCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YusufGenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;

import javax.annotation.Nonnull;
import java.util.List;

public class YusufSelectMenuInteractionEvent extends YusufGenericComponentInteractionCreateEvent {
    private final SelectMenuInteractionEvent event;

    public YusufSelectMenuInteractionEvent(SelectMenuInteractionEvent event) {
        super(event);
        this.event = event;
    }

    @Nonnull
    @Override
    public SelectMenuInteraction getInteraction() {
        return event;
    }

    @Nonnull
    @Override
    public SelectMenu getComponent() {
        return event.getComponent();
    }

    @Nonnull
    public List<String> getValues() {
        return event.getValues();
    }
}
