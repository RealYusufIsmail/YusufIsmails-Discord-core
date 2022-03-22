package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.MusicManager;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.PlayerManager;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend.YAudioSourceManagers;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp3Handler {
    private static final Logger logger = LoggerFactory.getLogger(Mp3Handler.class);
    private static Mp3Handler instance;
    private final @NotNull Map<Long, MusicManager> musicManagers;
    private final @NotNull PlayerManager audioPlayerManager;

    public Mp3Handler() {
        this.musicManagers = new HashMap<>();
        this.audioPlayerManager = new PlayerManager(new DefaultAudioPlayerManager());

        YAudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
        YAudioSourceManagers.registerLocalSource(this.audioPlayerManager);
    }

    public static Mp3Handler getInstance() {
        if (instance == null) {
            instance = new Mp3Handler();
        }
        return instance;
    }

    public MusicManager getMusicManager(@NotNull YGuild guild) {
        return this.musicManagers.computeIfAbsent(guild.getGuildIdLong(), guildId -> {
            final MusicManager guildMusicManager = new MusicManager(this.audioPlayerManager);

            guild.getAudioManager().setSendingHandler(guildMusicManager.getSendHandler());

            return guildMusicManager;
        });
    }

    public void loadAndPlay(@NotNull TextChannel channel, String mp3Url, int mp3Number,
            @NotNull String author) {
        final MusicManager musicManager = this.getMusicManager(new YGuild(channel.getGuild()));

        this.audioPlayerManager.loadItemOrdered(musicManager, mp3Url, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(@NotNull AudioTrack track) {
                musicManager.getScheduler().queue(track);

                channel
                    .sendMessage(
                            "Playing the surah number " + mp3Number + " recited by" + author + ".")
                    .queue();
            }

            @Override
            public void playlistLoaded(@NotNull AudioPlaylist playlist) {
                final List<AudioTrack> tracks = playlist.getTracks();

                channel.sendMessage("Adding to queue: `")
                    .append(String.valueOf(tracks.size()))
                    .append("` tracks from playlist `")
                    .append("Surah number ")
                    .append(String.valueOf(mp3Number))
                    .append(" recited by ")
                    .append(author)
                    .append("`")
                    .append('`')
                    .queue();

                for (final AudioTrack track : tracks) {
                    musicManager.getScheduler().queue(track);
                }
            }

            @Override
            public void noMatches() {
                channel.sendMessage("No matches has been found").queue();

                logger.info("No matches have been found.");
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                channel
                    .sendMessage("The bot could not load the music. Please type /support for help.")
                    .queue();
                logger.error("The bot has failed while trying to load the music.");
            }
        });
    }
}
