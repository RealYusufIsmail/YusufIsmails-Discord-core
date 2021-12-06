package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class YusufSlashCommandUtility {
    private final SlashCommandEvent event;

    public YusufSlashCommandUtility(SlashCommandEvent event) {
        this.event = event;
    }

    /**
     * replays as a normal message.
     */
    @CheckReturnValue
    public ReplyAction reply(String message) {
        return this.event.reply(message);
    }

    @CheckReturnValue
    public ReplyAction reply(String message, Boolean setEphemeral) {
        return this.event.reply(message).setEphemeral(setEphemeral);
    }

    @CheckReturnValue
    public ReplyAction reply(String message, Boolean setEphemeral, Boolean setTTS) {
        return this.event.reply(message).setEphemeral(setEphemeral).setTTS(setTTS);
    }

    public void replyMessage(String message) {
        this.event.reply(message).queue();
    }

    public void replyMessage(String message, Boolean setEphemeral) {
        this.event.reply(message).setEphemeral(setEphemeral).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyEphemeral(String message) {
        this.event.reply(message).setEphemeral(true).queue();
    }

    @CheckReturnValue
    public ReplyAction replyEphemeralMessage(String message) {
        return this.event.reply(message).setEphemeral(true);
    }

    /**
     * replays as an embed message.
     */
    public void replyEmbed(MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).queue();
    }

    public void replyEphemeralEmbed(MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }

    @CheckReturnValue
    public ReplyAction replyEmbeds(MessageEmbed messageEmbed) {
        return this.event.replyEmbeds(messageEmbed);
    }

    @CheckReturnValue
    public ReplyAction replyEphemeralEmbeds(MessageEmbed messageEmbed) {
        return this.event.replyEmbeds(messageEmbed).setEphemeral(true);
    }

    @CheckReturnValue
    public ReplyAction replyFormat(@Nonnull String format, @Nonnull Object... args) {
        return this.event.replyFormat(format, args);
    }

    public ReplyAction deferReply() {
        return this.event.deferReply();
    }

    public @NotNull String getToken() {
        return this.event.getToken();
    }

    public int getTypeRaw() {
        return this.event.getTypeRaw();
    }

    public @NotNull InteractionHook getHook() {
        return this.event.getHook();
    }

    public long getIdLong() {
        return this.event.getIdLong();
    }

    public boolean isAcknowledged() {
        return this.event.isAcknowledged();
    }
}
