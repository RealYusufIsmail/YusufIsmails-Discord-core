package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

import com.sedmelluq.discord.lavaplayer.filter.PcmFilterFactory;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventListener;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * An audio player that is capable of playing audio tracks and provides audio frames from the
 * currently playing track.
 */
public record Player(AudioPlayer player) {

    /**
     * @return Currently playing track
     */
    public AudioTrack getPlayingTrack() {
        return player.getPlayingTrack();
    }

    /**
     * @param track The track to start playing
     */
    public void playTrack(AudioTrack track) {
        player.playTrack(track);
    }

    /**
     * @param track The track to start playing, passing null will stop the current track and return
     *        false
     * @param noInterrupt Whether to only start if nothing else is playing
     * @return True if the track was started
     */
    public boolean startTrack(AudioTrack track, boolean noInterrupt) {
        return player.startTrack(track, noInterrupt);
    }

    /**
     * Stop currently playing track.
     */
    public void stopTrack() {
        player.stopTrack();
    }

    public int getVolume() {
        return player.getVolume();
    }

    public void setVolume(@NotNull Volume volume) {
        player.setVolume(volume.getVolume());
    }

    public void setFilterFactory(PcmFilterFactory factory) {
        player.setFilterFactory(factory);
    }

    public void setFrameBufferDuration(Integer duration) {

    }

    /**
     * @return Whether the player is paused
     */
    public boolean isPaused() {
        return player.isPaused();
    }

    /**
     * @return Whether the player is resumed.
     */
    public boolean isResumed() {
        return !player.isPaused();
    }

    /**
     * Used to pause the player.
     */
    public void pause() {
        player.setPaused(true);
    }

    /**
     * Used to resume the player.
     */
    public void resume() {
        player.setPaused(false);
    }

    /**
     * Used to terminate the player.
     */
    public void stop() {
        player.destroy();
    }

    /**
     * Add a listener to events from this player.
     *
     * @param listener New listener
     */
    public void addListener(AudioEventListener listener) {
        player.addListener(listener);
    }

    /**
     * Remove an attached listener using identity comparison.
     *
     * @param listener The listener to remove
     */
    public void removeListener(AudioEventListener listener) {
        player.removeListener(listener);
    }

    /**
     * Check if the player should be "cleaned up" - stopped due to nothing using it, with the given
     * threshold.
     *
     * @param threshold Threshold in milliseconds to use
     */
    public void checkCleanup(long threshold) {
        player.checkCleanup(threshold);
    }

    /**
     * @return Provided frame, or null if none available
     */
    public AudioFrame provide() {
        return player.provide();
    }

    /**
     * @param timeout Specifies the maximum time to wait for data. Pass 0 for non-blocking mode.
     * @param unit Specifies the time unit of the maximum wait time.
     * @return Provided frame. In case wait time is above zero, null indicates that no data is not
     *         available at the current moment, otherwise null means the end of the track.
     * @throws TimeoutException When wait time is above zero, but no track info is found in that
     *         time.
     * @throws InterruptedException When interrupted externally (or for seek/stop).
     */
    public AudioFrame provide(long timeout, TimeUnit unit)
            throws TimeoutException, InterruptedException {
        return player.provide(timeout, unit);
    }

    /**
     * @param targetFrame Frame to update with the details and data of the provided frame.
     * @return <code>true</code> if a frame was provided.
     */
    public boolean provide(MutableAudioFrame targetFrame) {
        return player.provide(targetFrame);
    }

    /**
     * @param targetFrame Frame to update with the details and data of the provided frame.
     * @param timeout Timeout.
     * @param unit Time unit for the timeout value.
     * @return <code>true</code> if a frame was provided.
     * @throws TimeoutException If no frame became available within the timeout.
     * @throws InterruptedException When interrupted externally (or for seek/stop).
     */
    public boolean provide(MutableAudioFrame targetFrame, long timeout, TimeUnit unit)
            throws TimeoutException, InterruptedException {
        return player.provide(targetFrame, timeout, unit);
    }
}
