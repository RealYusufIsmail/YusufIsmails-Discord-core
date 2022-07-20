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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events;

import io.github.yusufsdiscordbot.annotations.Author;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.backend.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.util.Verify;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YSlashCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.Mp3Handler;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.PlayerHandler;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.AudioPlayerSendHandler;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.Player;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.TrackScheduler;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.callbacks.IDeferrableCallback;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

@ToString
@EqualsAndHashCode(callSuper = false)
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YSlashCommandInteractionEvent extends YCommandInteraction {
    @Getter
    private final SlashCommandExtender command;
    @Getter
    private final SlashCommandInteractionEvent event;
    private static final String GUILD = "guild";

    public YSlashCommandInteractionEvent(SlashCommandExtender command,
            SlashCommandInteractionEvent event) {
        super(event, event);
        this.command = command;
        this.event = event;
    }

    @Nonnull
    public YSlashCommandInteraction getInteraction() {
        return new YSlashCommandInteraction(getCallback(), getCommandInteractionPayload(),
                event.getInteraction());
    }

    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return event.getChannel();
    }

    @Nonnull
    public @NotNull Player getPlayer() {
        Checks.notNull(getGuild(), GUILD);
        return PlayerHandler.getInstance().getMusicManager(this.getGuild()).getPlayer();
    }

    @Nonnull
    public @NotNull TrackScheduler getScheduler() {
        Checks.notNull(getGuild(), GUILD);
        return PlayerHandler.getInstance().getMusicManager(this.getGuild()).getScheduler();
    }

    @Nonnull
    public @NotNull AudioPlayerSendHandler getSchedulerHandler() {
        Checks.notNull(getGuild(), GUILD);
        return PlayerHandler.getInstance().getMusicManager(this.getGuild()).getSendHandler();
    }

    public void playUrl(@NotNull YMember member, @NotNull String url) {
        Verify.isInVc(member, this);
        Checks.notNull(getTextChannel(), "Text Channel");
        PlayerHandler.getInstance().loadAndPlay(this.getTextChannel(), url);
    }

    public void playName(@NotNull YMember member, @NotNull String name) {
        Verify.isInVc(member, this);
        Checks.notNull(getTextChannel(), "Text Channel");
        PlayerHandler.getInstance().loadAndPlay(this.getTextChannel(), "ytsearch:" + name);
    }

    public void playMp3Url(@NotNull YMember member, @NotNull String url, int mp3Number,
            @NotNull String author) {
        Verify.isInVc(member, this);
        Checks.notNull(getTextChannel(), "Text Channel");
        Mp3Handler.getInstance().loadAndPlay(this.getTextChannel(), url, mp3Number, author);
    }

    /**
     * Acknowledgement of this interaction with a {@link Modal Modal}.
     *
     * <p>
     * This will open a popup on the target user's Discord client.
     *
     * <p>
     * Interactions can only be acknowledged once.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param modal The Modal to send
     * @return ModalCallbackAction
     * @throws IllegalArgumentException If the provided modal is null
     */
    @NotNull
    @CheckReturnValue
    public ModalCallbackAction replyModal(@NotNull Modal modal) {
        return getInteraction().replyModal(modal);
    }

    /**
     * Acknowledgement of this interaction with a {@link Modal Modal}.
     *
     * <p>
     * This will open a popup on the target user's Discord client.
     *
     * <p>
     * Interactions can only be acknowledged once.
     *
     * <p>
     * <b>You only have 3 seconds to acknowledge an interaction!</b> <br>
     * When the acknowledgement is sent after the interaction expired, you will receive
     * {@link ErrorResponse#UNKNOWN_INTERACTION ErrorResponse.UNKNOWN_INTERACTION}.
     *
     * @param modal The Modal to send
     * @throws IllegalArgumentException If the provided modal is null
     */
    public void replyQueuedModal(@NotNull Modal modal) {
        getInteraction().replyModal(modal).queue();
    }

    public IDeferrableCallback getDeferrableCallback() {
        return this.getInteraction().getDeferrableCallback();
    }
}

