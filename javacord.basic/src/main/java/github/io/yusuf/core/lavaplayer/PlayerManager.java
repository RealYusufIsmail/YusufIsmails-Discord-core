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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {
    private static PlayerManager INSTANCE;
    private final Map<Long, ApiMusicManager> musicManagers;
    private final AudioPlayerManager audioPlayerManager;


    public PlayerManager() {
        this.musicManagers = new HashMap<>();
        this.audioPlayerManager = new DefaultAudioPlayerManager();

        AudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
        AudioSourceManagers.registerLocalSource(this.audioPlayerManager);
    }



    public ApiMusicManager getMusicManager(Server server, DiscordApi api) {
        return this.musicManagers.computeIfAbsent(server.getId(), (guildId) -> {
            final ApiMusicManager apiMusicManager =
                    new ApiMusicManager(this.audioPlayerManager, api);

            // server.getAudioConnection().flatMap(AudioConnection::getAudioSource);

            server.getAudioConnection().get().setAudioSource(apiMusicManager.getSendHandler());

            return apiMusicManager;
        });
    }

    public void loadAndPlay(MessageBuilder channel, String trackUrl,
            SlashCommandInteraction interaction) throws Exception {
        final ApiMusicManager musicManager =
                this.getMusicManager(interaction.getServer().get(), interaction.getApi());


        this.audioPlayerManager.loadItemOrdered(musicManager, trackUrl,
                new AudioLoadResultHandler() {
                    @Override
                    public void trackLoaded(AudioTrack track) {
                        musicManager.scheduler.queue(track);

                        channel.setContent("Adding to queue: `")
                            .append(track.getInfo().title)
                            .append("` by `")
                            .append(track.getInfo().author)
                            .append('`');
                    }

                    @Override
                    public void playlistLoaded(AudioPlaylist playlist) {
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
