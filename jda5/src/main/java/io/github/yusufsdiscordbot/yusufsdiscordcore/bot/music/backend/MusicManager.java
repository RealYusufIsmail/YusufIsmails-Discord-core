package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

import org.jetbrains.annotations.NotNull;

public class MusicManager {

    /**
     * The audio player manager for handling audio.
     */
    private final @NotNull Player player;

    /**
     * The audio event handler for handling events.
     */
    private final @NotNull AudioPlayerSendHandler sendHandler;

    /**
     * Retrieve the track scheduler.
     */
    private final @NotNull TrackScheduler scheduler;

    public MusicManager(@NotNull PlayerManager manager) {
        this.player = manager.createPlayer();
        this.scheduler = new TrackScheduler(player);
        this.sendHandler = new AudioPlayerSendHandler(player);
    }

    public @NotNull AudioPlayerSendHandler getSendHandler() {
        return sendHandler;
    }

    public @NotNull Player getPlayer() {
        return player;
    }

    public @NotNull TrackScheduler getScheduler() {
        return scheduler;
    }
}
