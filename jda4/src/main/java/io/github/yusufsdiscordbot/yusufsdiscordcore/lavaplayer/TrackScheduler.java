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
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
    public static final boolean REPEATING = false;
    public final AudioPlayer player;
    public final @NotNull BlockingQueue<AudioTrack> blockingQueue;

    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.blockingQueue = new LinkedBlockingQueue<>();
    }

    public void queue(@NotNull AudioTrack track) {
        if (!this.player.startTrack(track, true)) {
            this.blockingQueue.offer(track);
        }
    }

    public void nextTrack() {
        this.player.startTrack(this.blockingQueue.poll(), false);
    }

    @Override
    public void onTrackEnd(AudioPlayer player, @NotNull AudioTrack track,
            @NotNull AudioTrackEndReason endReason) {
        if (endReason.mayStartNext) {
            if (REPEATING) {
                this.player.startTrack(track.makeClone(), false);
                return;
            }
            nextTrack();
        }
    }
}
