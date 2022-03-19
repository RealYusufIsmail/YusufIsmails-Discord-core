package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

import com.sedmelluq.discord.lavaplayer.container.MediaContainerRegistry;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.source.bandcamp.BandcampAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.beam.BeamAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.getyarn.GetyarnAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.http.HttpAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.local.LocalAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.soundcloud.SoundCloudAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.twitch.TwitchStreamAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.vimeo.VimeoAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import org.jetbrains.annotations.NotNull;

public record YAudioSourceManagers(AudioSourceManagers audioSourceManagers) {

    /**
     * See {@link #registerRemoteSources(PlayerManager, MediaContainerRegistry)}, but with default
     * containers.
     */
    public static void registerRemoteSources(@NotNull PlayerManager playerManager) {
        registerRemoteSources(playerManager, MediaContainerRegistry.DEFAULT_REGISTRY);
    }


    /**
     * Registers all built-in remote audio sources to the specified player manager. Local file audio
     * source must be registered separately.
     *
     * @param playerManager Player manager to register the source managers to
     * @param containerRegistry Media container registry to be used by any probing sources.
     */
    public static void registerRemoteSources(@NotNull PlayerManager playerManager,
            MediaContainerRegistry containerRegistry) {
        playerManager.registerSourceManager(new YoutubeAudioSourceManager(true));
        playerManager.registerSourceManager(SoundCloudAudioSourceManager.createDefault());
        playerManager.registerSourceManager(new BandcampAudioSourceManager());
        playerManager.registerSourceManager(new VimeoAudioSourceManager());
        playerManager.registerSourceManager(new TwitchStreamAudioSourceManager());
        playerManager.registerSourceManager(new BeamAudioSourceManager());
        playerManager.registerSourceManager(new GetyarnAudioSourceManager());
        playerManager.registerSourceManager(new HttpAudioSourceManager(containerRegistry));
    }

    /**
     * Registers the local file source manager to the specified player manager.
     *
     * @param playerManager Player manager to register the source manager to
     */
    public static void registerLocalSource(@NotNull PlayerManager playerManager) {
        registerLocalSource(playerManager, MediaContainerRegistry.DEFAULT_REGISTRY);
    }

    /**
     * Registers the local file source manager to the specified player manager.
     *
     * @param playerManager Player manager to register the source manager to
     * @param containerRegistry Media container registry to be used by the local source.
     */
    public static void registerLocalSource(@NotNull PlayerManager playerManager,
            MediaContainerRegistry containerRegistry) {
        playerManager.registerSourceManager(new LocalAudioSourceManager(containerRegistry));
    }
}
