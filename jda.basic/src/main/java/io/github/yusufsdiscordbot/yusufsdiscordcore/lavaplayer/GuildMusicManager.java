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

package io.github.yusufsdiscordbot.yusufsdiscordcore.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import org.jetbrains.annotations.NotNull;

public class GuildMusicManager {
    public final AudioPlayer audioPlayer;

    public final @NotNull TrackScheduler scheduler;

    private final @NotNull AudioPlayerSendHandler sendHandler;

    public GuildMusicManager(@NotNull AudioPlayerManager manager) {
        this.audioPlayer = manager.createPlayer();
        this.scheduler = new TrackScheduler(this.audioPlayer);
        this.audioPlayer.addListener(this.scheduler);
        this.sendHandler = new AudioPlayerSendHandler(this.audioPlayer);
    }

    public @NotNull AudioPlayerSendHandler getSendHandler() {
        return sendHandler;
    }
}
