package io.github.yusufsdiscordbot.yusufsdiscordcore.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class YDC {
    private YDC() {}

    public static @NotNull JDABuilder setUp(String token) {
        return JDABuilder.createDefault(token);
    }

    public static @NotNull JDABuilder setUp(@Nullable String token, @Nonnull GatewayIntent intent, @Nonnull GatewayIntent... intents) {
        return JDABuilder.createDefault(token, intent, intents);
    }
}
