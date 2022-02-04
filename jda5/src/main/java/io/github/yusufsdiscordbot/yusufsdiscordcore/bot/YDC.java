package io.github.yusufsdiscordbot.yusufsdiscordcore.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

@SuppressWarnings("unused")
public class YDC {
    private YDC() {}

    public static @NotNull JDABuilder setUp(String token) {
        return JDABuilder.createDefault(token);
    }

    public static @NotNull JDABuilder setUp(@Nullable String token, @Nonnull GatewayIntent intent) {
        return JDABuilder.createDefault(token, intent);
    }

    public static @NotNull JDABuilder setUp(@Nullable String token, @Nonnull GatewayIntent intent, @Nonnull GatewayIntent... intents) {
        return JDABuilder.createDefault(token, intent, intents);
    }

    public static @NotNull JDABuilder setUpLight(@Nullable String token) {
        return JDABuilder.createLight(token);
    }

    public static @NotNull JDABuilder setUpLight(@Nullable String token, @Nonnull GatewayIntent intent) {
        return JDABuilder.createLight(token, intent);
    }

    public static @NotNull JDABuilder setUpLight(@Nullable String token, @Nonnull GatewayIntent intent, @Nonnull GatewayIntent... intents) {
        return JDABuilder.createLight(token, intent, intents);
    }

    public static @NotNull JDABuilder setUpLight(@Nullable String token, @Nonnull Collection<GatewayIntent> intents) {
        return JDABuilder.createLight(token, intents);
    }
}
