package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YButtonInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YGenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import javax.annotation.Nonnull;

public class YButtonInteractionEvent extends YGenericComponentInteractionCreateEvent
        implements YButtonInteraction {
    private final YButtonInteraction interaction;

    public YButtonInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YButtonInteraction interaction) {
        super(api, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Nonnull
    @Override
    public YButtonInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public Button getComponent() {
        return interaction.getComponent();
    }

    @Nonnull
    @Override
    public Button getButton() {
        return interaction.getButton();
    }
}
