package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YModalInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YGenericInteractionCreateEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

public class YModalInteractionEvent extends YGenericInteractionCreateEvent
        implements YModalInteraction {
    private final YModalInteraction interaction;

    public YModalInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YModalInteraction interaction) {
        super(api, responseNumber, (YInteraction) interaction);
        this.interaction = interaction;
    }

    @Nonnull
    @Override
    public YModalInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public String getModalId() {
        return interaction.getModalId();
    }

    @Nonnull
    @Override
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
    @Override
    public MessageEditCallbackAction deferEdit() {
        return interaction.deferEdit();
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
