package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YComponentInteraction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class YGenericComponentInteractionCreateEvent extends YGenericInteractionCreateEvent
        implements YComponentInteraction {
    private final YComponentInteraction interaction;

    public YGenericComponentInteractionCreateEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YComponentInteraction interaction) {
        super(api, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Nonnull
    @Override
    public YComponentInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return interaction.getChannel();
    }

    @Nonnull
    @Override
    public String getComponentId() {
        return interaction.getComponentId();
    }

    @Nonnull
    @Override
    public ActionComponent getComponent() {
        return interaction.getComponent();
    }

    @Nonnull
    @Override
    public Message getMessage() {
        return interaction.getMessage();
    }

    @Override
    public long getMessageIdLong() {
        return interaction.getMessageIdLong();
    }

    @Nonnull
    @Override
    public Component.Type getComponentType() {
        return interaction.getComponentType();
    }

    @Nonnull
    @Override
    public MessageEditCallbackAction deferEdit() {
        return interaction.deferEdit();
    }

    @Nonnull
    @Override
    public InteractionHook getHook() {
        return interaction.getHook();
    }

    @Nonnull
    @Override
    public ReplyCallbackAction deferReply() {
        return interaction.deferReply();
    }

    @Nonnull
    @Override
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        return interaction.replyModal(modal);
    }

    @Override
    public void replyQueuedMessage(@NotNull String message) {
        getInteraction().reply(message).queue();
    }

    @Override
    public void replyQueuedEphemeral(@NotNull String message) {
        getInteraction().reply(message).setEphemeral(true).queue();
    }

    @Override
    public void replyQueuedEmbed(@NotNull MessageEmbed messageEmbed) {
        getInteraction().replyEmbeds(messageEmbed).queue();
    }

    @Override
    public void replyQueuedEphemeralEmbed(@NotNull MessageEmbed messageEmbed) {
        getInteraction().replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
