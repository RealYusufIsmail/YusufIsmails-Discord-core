package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
    private final Player player;

    private final @NotNull BlockingQueue<AudioTrack> blockingQueue;


    private static final boolean LOOP = false;

    /**
     * @param player The audio player this scheduler uses
     */
    public TrackScheduler(Player player) {
        this.player = player;
        this.blockingQueue = new LinkedBlockingQueue<>();
    }

    /**
     * Add the next track to queue or play right away if nothing is in the queue.
     *
     * @param track The track to play or add to queue.
     */
    public void queue(@NotNull AudioTrack track) {
        // Calling startTrack with the noInterrupt set to true will start the track only if nothing
        // is currently playing. If
        // something is playing, it returns false and does nothing. In that case the player was
        // already playing so this
        // track goes to the queue instead.
        if (!player.startTrack(track, true)) {
            blockingQueue.offer(track);
        } else {
            // The player was able to play the track, so we remove it from the queue.
            blockingQueue.remove(track);
        }
    }

    /**
     * Start the next track, stopping the current one if it is playing.
     */
    public void nextTrack() {
        // Start the next track, regardless of if something is already playing or not. In case queue
        // was empty, we are
        // giving null to startTrack, which is a valid argument and will simply stop the player.
        player.startTrack(blockingQueue.poll(), false);
    }

    @Override
    public void onTrackEnd(@NotNull AudioPlayer player, @NotNull AudioTrack track,
            @NotNull AudioTrackEndReason endReason) {
        // Only start the next track if the end reason is suitable for it (FINISHED or LOAD_FAILED)
        if (endReason.mayStartNext) {
            if (LOOP) {
                player.startTrack(track.makeClone(), false);
                return;
            }
            nextTrack();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public @NotNull BlockingQueue<AudioTrack> getBlockingQueue() {
        return blockingQueue;
    }

    /**
     * Used to loop the current track.
     * 
     * @param setLoop True to loop, false to not loop.
     * @return True if the loop was set, false if the loop was already set.
     */
    public boolean setLoop(boolean setLoop) {
        return LOOP == setLoop;
    }

    public boolean getLoop() {
        return LOOP;
    }

    public boolean isEmpty() {
        return blockingQueue.isEmpty();
    }

    public void setAuthor(String author) {
        player.setAuthor(author);
    }

    public void setMp3Number(int mp3Number) {
        player.setMp3Number(mp3Number);
    }
}
