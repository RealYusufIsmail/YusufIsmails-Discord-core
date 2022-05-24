package io.github.yusufsdiscordbot.yusufsdiscordcore.bot;

import net.dv8tion.jda.api.JDAInfo;

@SuppressWarnings("unused")
public class Info {
    private Info() {}

    public static final int JDA_VERSION = Integer.parseInt(JDAInfo.VERSION_MAJOR);
    public static final int YDC_VERSION = 2;
    public static final String JDA_VERSION_MINOR = JDAInfo.VERSION_CLASSIFIER;
    public static final String YDC_VERSION_MINOR = "1.0.0";
    public static final int DISCORD_GATEWAY_VERSION = JDAInfo.DISCORD_GATEWAY_VERSION;
    public static final int DISCORD_REST_VERSION = JDAInfo.DISCORD_REST_VERSION;
    public static final int AUDIO_GATEWAY_VERSION = JDAInfo.AUDIO_GATEWAY_VERSION;
    public static final String GITHUB =
            "https://github.com/YusufsDiscordbot/YusufIsmails-Discord-core";
}
