package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

import com.sedmelluq.discord.lavaplayer.player.AudioConfiguration;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.remote.RemoteNodeRegistry;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.tools.io.MessageInput;
import com.sedmelluq.discord.lavaplayer.tools.io.MessageOutput;
import com.sedmelluq.discord.lavaplayer.track.AudioReference;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.DecodedTrackHolder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class PlayerManager {
    public AudioPlayerManager getManager() {
        return manager;
    }

    private final AudioPlayerManager manager;

    public PlayerManager(AudioPlayerManager manager) {
        this.manager = manager;
    }

    /**
     * Shut down the manager. All threads will be stopped, the manager cannot be used any further.
     * All players created with this manager will stop and all source managers registered to this
     * manager will also be shut down.
     * <p>
     * Every thread created by the audio manager is a daemon thread, so calling this is not required
     * for an application to be able to gracefully shut down, however it should be called if the
     * application continues without requiring this manager any longer.
     */
    public void shutdown() {
        manager.shutdown();
    }

    /**
     * Configure to use remote nodes for playback. On consecutive calls, the connections with
     * previously used nodes will be severed and all remotely playing tracks will be stopped first.
     *
     * @param nodeAddresses The addresses of the remote nodes
     */
    public void useRemoteNodes(String... nodeAddresses) {
        manager.useRemoteNodes(nodeAddresses);
    }

    /**
     * Enable reporting GC pause length statistics to log (warn level with lengths bad for latency,
     * debug level otherwise)
     */
    public void enableGcMonitoring() {
        manager.enableGcMonitoring();
    }

    /**
     * @param sourceManager The source manager to register, which will be used for subsequent
     *        loadItem calls
     */
    public void registerSourceManager(AudioSourceManager sourceManager) {
        manager.registerSourceManager(sourceManager);
    }

    /**
     * Shortcut for accessing a source manager of a certain class.
     *
     * @param klass The class of the source manager to return.
     * @return The source manager of the specified class, or null if not registered.
     */
    public <T extends AudioSourceManager> T source(Class<T> klass) {
        return manager.source(klass);
    }


    /**
     * Schedules loading a track or playlist with the specified identifier.
     * 
     * @param identifier The identifier that a specific source manager should be able to find the
     *        track with.
     * @param resultHandler A handler to process the result of this operation. It can either end by
     *        finding a track, finding a playlist, finding nothing or terminating with an exception.
     * @return A future for this operation
     * @see #loadItem(AudioReference, AudioLoadResultHandler)
     */
    public Future<Void> loadItem(final String identifier,
            final AudioLoadResultHandler resultHandler) {
        return loadItem(new AudioReference(identifier, null), resultHandler);
    }

    /**
     * Schedules loading a track or playlist with the specified identifier.
     *
     * @param reference The audio reference that holds the identifier that a specific source manager
     *        should be able to find the track with.
     * @param resultHandler A handler to process the result of this operation. It can either end by
     *        finding a track, finding a playlist, finding nothing or terminating with an exception.
     * @return A future for this operation
     */
    public Future<Void> loadItem(AudioReference reference, AudioLoadResultHandler resultHandler) {
        return manager.loadItem(reference, resultHandler);
    }

    /**
     * Schedules loading a track or playlist with the specified identifier with an ordering key so
     * that items with the same ordering key are handled sequentially in the order of calls to this
     * method.
     *
     * @param orderingKey Object to use as the key for the ordering channel
     * @param identifier The identifier that a specific source manager should be able to find the
     *        track with.
     * @param resultHandler A handler to process the result of this operation. It can either end by
     *        finding a track, finding a playlist, finding nothing or terminating with an exception.
     * @return A future for this operation
     * @see #loadItemOrdered(Object, AudioReference, AudioLoadResultHandler)
     */
    public Future<Void> loadItemOrdered(Object orderingKey, final String identifier,
            final AudioLoadResultHandler resultHandler) {
        return loadItemOrdered(orderingKey, new AudioReference(identifier, null), resultHandler);
    }

    /**
     * Schedules loading a track or playlist with the specified identifier with an ordering key so
     * that items with the same ordering key are handled sequentially in the order of calls to this
     * method.
     *
     * @param orderingKey Object to use as the key for the ordering channel
     * @param reference The audio reference that holds the identifier that a specific source manager
     *        should be able to find the track with.
     * @param resultHandler A handler to process the result of this operation. It can either end by
     *        finding a track, finding a playlist, finding nothing or terminating with an exception.
     * @return A future for this operation
     * @see #loadItemOrdered(Object, String, AudioLoadResultHandler)
     */
    public Future<Void> loadItemOrdered(Object orderingKey, AudioReference reference,
            AudioLoadResultHandler resultHandler) {
        return manager.loadItemOrdered(orderingKey, reference, resultHandler);
    }

    /**
     * Encode a track into an output stream. If the decoder is not supposed to know the number of
     * tracks in advance, then the encoder should call MessageOutput#finish() after all the tracks
     * it wanted to write have been written. This will make decodeTrack() return null at that
     * position
     *
     * @param stream The message stream to write it to.
     * @param track The track to encode.
     * @throws IOException On IO error.
     */
    public void encodeTrack(MessageOutput stream, AudioTrack track) throws IOException {
        manager.encodeTrack(stream, track);
    }

    /**
     * Decode a track from an input stream. Null returns value indicates reaching the position where
     * the decoder had called MessageOutput#finish().
     *
     * @param stream The message stream to read it from.
     * @return Holder containing the track if it was successfully decoded.
     * @throws IOException On IO error.
     */
    public DecodedTrackHolder decodeTrack(MessageInput stream) throws IOException {
        return manager.decodeTrack(stream);
    }

    /**
     * @return Audio processing configuration used for tracks executed by this manager.
     */
    public AudioConfiguration getConfiguration() {
        return manager.getConfiguration();
    }

    /**
     * Seek ghosting is the effect where while a seek is in progress, buffered audio from the
     * previous location will be served until seek is ready or the buffer is empty.
     *
     * @return True if seek ghosting is enabled.
     */
    public boolean isUsingSeekGhosting() {
        return manager.isUsingSeekGhosting();
    }

    /**
     * @param useSeekGhosting The new state of seek ghosting
     */
    public void setUseSeekGhosting(boolean useSeekGhosting) {
        manager.setUseSeekGhosting(useSeekGhosting);
    }

    /**
     * @return The length of the internal buffer for audio in milliseconds.
     */
    public int getFrameBufferDuration() {
        return manager.getFrameBufferDuration();
    }

    /**
     * @param frameBufferDuration New length of the internal buffer for audio in milliseconds.
     */
    public void setFrameBufferDuration(int frameBufferDuration) {
        manager.setFrameBufferDuration(frameBufferDuration);
    }

    /**
     * Sets the threshold for how long a track can be stuck until the TrackStuckEvent is sent out. A
     * track is considered to be stuck if the player receives requests for audio samples from the
     * track, but the audio frame provider of that track has been returning no data for the
     * specified time.
     *
     * @param trackStuckThreshold The threshold in milliseconds.
     */
    public void setTrackStuckThreshold(long trackStuckThreshold) {
        manager.setTrackStuckThreshold(trackStuckThreshold);
    }

    /**
     * Sets the threshold for clearing an audio player when it has not been queried for the
     * specified amount of time.
     *
     * @param cleanupThreshold The threshold in milliseconds.
     */
    public void setPlayerCleanupThreshold(long cleanupThreshold) {
        manager.setPlayerCleanupThreshold(cleanupThreshold);
    }

    /**
     * Sets the number of threads used for loading processing item load requests.
     *
     * @param poolSize Maximum number of concurrent threads used for loading items.
     */
    public void setItemLoaderThreadPoolSize(int poolSize) {
        manager.setItemLoaderThreadPoolSize(poolSize);
    }

    /**
     * @return New audio player.
     */
    public @NotNull Player createPlayer() {
        return new Player(manager.createPlayer());
    }

    /**
     * @return Registry of remote nodes currently used.
     */
    public RemoteNodeRegistry getRemoteNodeRegistry() {
        return manager.getRemoteNodeRegistry();
    }

    /**
     * @param configurator Function used to reconfigure the request config of all sources which
     *        perform HTTP requests. Applied to all current and future registered sources. Setting
     *        this while sources are already in use will close all active connections, so this
     *        should be called before the sources have been used.
     */
    public void setHttpRequestConfigurator(UnaryOperator<RequestConfig> configurator) {
        manager.setHttpRequestConfigurator(configurator);
    }

    /**
     * @param configurator Function used to reconfigure the HTTP builder of all sources which
     *        perform HTTP requests. Applied to all current and future registered sources. Setting
     *        this while sources are already in use will close all active connections, so this
     *        should be called before the sources have been used.
     */
    public void setHttpBuilderConfigurator(Consumer<HttpClientBuilder> configurator) {
        manager.setHttpBuilderConfigurator(configurator);
    }
}
