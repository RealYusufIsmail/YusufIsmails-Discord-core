package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.command_option.YOptionMapping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class YGenericCommandInteractionEvent extends YGenericInteractionCreateEvent
        implements YCommandInteraction {

    public YGenericCommandInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YCommandInteraction interaction) {
        super(api, responseNumber, interaction);
    }

    @Nonnull
    @Override
    public YCommandInteraction getInteraction() {
        return (YCommandInteraction) super.getInteraction();
    }

    @Nonnull
    @Override
    public Command.Type getCommandType() {
        return getInteraction().getCommandType();
    }

    @Nonnull
    @Override
    public String getName() {
        return getInteraction().getName();
    }

    @Nullable
    @Override
    public String getSubcommandName() {
        return getInteraction().getSubcommandName();
    }

    @Nullable
    @Override
    public String getSubcommandGroup() {
        return getInteraction().getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return getInteraction().getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return getInteraction().isGuildCommand();
    }

    @Nonnull
    @Override
    public List<YOptionMapping> getOptions() {
        return getInteraction().getOptions();
    }

    @Nonnull
    @Override
    public InteractionHook getHook() {
        return getInteraction().getHook();
    }

    @Nonnull
    @Override
    public ReplyCallbackAction deferReply() {
        return getInteraction().deferReply();
    }

    @Nonnull
    @Override
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        return getInteraction().replyModal(modal);
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
