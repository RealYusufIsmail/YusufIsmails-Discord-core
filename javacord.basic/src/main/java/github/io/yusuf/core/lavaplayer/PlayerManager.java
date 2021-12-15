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

package github.io.yusuf.core.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {
    private static PlayerManager INSTANCE;
    private final @NotNull Map<Long, ApiMusicManager> musicManagers;
    private final @NotNull AudioPlayerManager audioPlayerManager;


    public PlayerManager() {
        this.musicManagers = new HashMap<>();
        this.audioPlayerManager = new DefaultAudioPlayerManager();

        AudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
        AudioSourceManagers.registerLocalSource(this.audioPlayerManager);
    }



    public ApiMusicManager getMusicManager(@NotNull Server server, @NotNull DiscordApi api) {
        return this.musicManagers.computeIfAbsent(server.getId(), (guildId) -> {
            final ApiMusicManager apiMusicManager =
                    new ApiMusicManager(this.audioPlayerManager, api);

            // server.getAudioConnection().flatMap(AudioConnection::getAudioSource);

            server.getAudioConnection().get().setAudioSource(apiMusicManager.getSendHandler());

            return apiMusicManager;
        });
    }

    public void loadAndPlay(@NotNull MessageBuilder channel, String trackUrl,
            @NotNull SlashCommandInteraction interaction) throws Exception {
        final ApiMusicManager musicManager =
                this.getMusicManager(interaction.getServer().get(), interaction.getApi());


        this.audioPlayerManager.loadItemOrdered(musicManager, trackUrl,
                new AudioLoadResultHandler() {
                    @Override
                    public void trackLoaded(@NotNull AudioTrack track) {
                        musicManager.scheduler.queue(track);

                        channel.setContent("Adding to queue: `")
                            .append(track.getInfo().title)
                            .append("` by `")
                            .append(track.getInfo().author)
                            .append('`');
                    }

                    @Override
                    public void playlistLoaded(@NotNull AudioPlaylist playlist) {
                        final List<AudioTrack> tracks = playlist.getTracks();

                        channel.setContent("Adding to queue: `")
                            .append(String.valueOf(tracks.size()))
                            .append("` tracks from playlist `")
                            .append(playlist.getName())
                            .append('`');

                        for (final AudioTrack track : tracks) {
                            musicManager.scheduler.queue(track);
                        }
                    }

                    @Override
                    public void noMatches() {
                        interaction.createImmediateResponder()
                            .setContent("Failed 406 error")
                            .respond();
                        System.out.println("Failed at noMatches");
                    }

                    @Override
                    public void loadFailed(FriendlyException exception) {
                        interaction.createImmediateResponder()
                            .setContent("Failed 405 error")
                            .respond();
                        System.out.println("Failed at loadFailed");
                    }
                });
    }


    public static PlayerManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerManager();
        }

        return INSTANCE;
    }
}
