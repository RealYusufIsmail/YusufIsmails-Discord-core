/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007 Copyright (C) 2007 Free Software Foundation,
 * Inc. <https://fsf.org/> Everyone is permitted to copy and distribute verbatim copies of this
 * license document, but changing it is not allowed. Yusuf Arfan Ismail The GNU General Public
 * License is a free, copyleft license for software and other kinds of works. The licenses for most
 * software and other practical works are designed to take away your freedom to share and change the
 * works. By contrast, the GNU General Public License is intended to guarantee your freedom to share
 * and change all versions of a program--to make sure it remains free software for all its users.
 * We, the Free Software Foundation, use the GNU General Public License for most of our software; it
 * applies also to any other work released this way by its authors. You can apply it to your
 * programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions;

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
