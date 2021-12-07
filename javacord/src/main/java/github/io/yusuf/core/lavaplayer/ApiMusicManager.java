package github.io.yusuf.core.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import org.javacord.api.DiscordApi;

public class ApiMusicManager {
    public final AudioPlayer audioPlayer;

    public final TrackScheduler scheduler;

    private final LavaPlayerAudioSource sendHandler;


    public ApiMusicManager(AudioPlayerManager manager, DiscordApi api) {
        this.audioPlayer = manager.createPlayer();
        this.sendHandler = new LavaPlayerAudioSource(api, this.audioPlayer);
        this.scheduler = new TrackScheduler(this.audioPlayer);
        this.audioPlayer.addListener(this.scheduler);
    }

    public LavaPlayerAudioSource getSendHandler() {
        return sendHandler;
    }
}
