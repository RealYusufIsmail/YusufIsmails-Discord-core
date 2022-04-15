package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions.ModelCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YGenericInteractionCreateEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YModalInteraction;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import javax.annotation.Nonnull;
import java.util.List;

public class YModalInteractionEvent extends YGenericInteractionCreateEvent {

    private final ModalInteractionEvent event;
    private final ModelCommand modelCommand;

    private final YModalInteraction interaction;

    public YModalInteractionEvent(ModalInteractionEvent event, ModelCommand modelCommand,
            YModalInteraction interaction) {
        super(event, event, event, event);
        this.event = event;
        this.modelCommand = modelCommand;
        this.interaction = interaction;
    }

    public ModalInteractionEvent getEvent() {
        return event;
    }

    public ModelCommand getModelCommand() {
        return modelCommand;
    }

    @Nonnull
    public YModalInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    public String getModalId() {
        return interaction.getModalId();
    }

    @Nonnull
    public List<ModalMapping> getValues() {
        return interaction.getValues();
    }

    @Nonnull
    @Override
    public ReplyCallbackAction deferReply() {
        return interaction.deferReply();
    }

    @Nonnull
    @Override
    public InteractionHook getHook() {
        return interaction.getHook();
    }

    @Nonnull
    public MessageEditCallbackAction deferEdit() {
        return interaction.deferEdit();
    }
}

