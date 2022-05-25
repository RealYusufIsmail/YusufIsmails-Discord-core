package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YInteraction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.Interaction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;

public class YGenericInteractionCreateEvent extends Event implements YInteraction {
    private final YInteraction interaction;

    public YGenericInteractionCreateEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YInteraction interaction) {
        super(api, responseNumber);
        this.interaction = interaction;
    }

    /**
     * The {@link Interaction} instance. <br>
     * Note that this event is a delegate which implements the same interface.
     *
     * @return The {@link Interaction}
     */
    @Nonnull
    public Interaction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public String getToken() {
        return interaction.getToken();
    }

    @Override
    public int getTypeRaw() {
        return interaction.getTypeRaw();
    }

    @Nullable
    @Override
    public Guild getGuild() {
        return interaction.getGuild();
    }

    @Override
    public @NotNull Channel getChannel() {
        return interaction.getChannel();
    }

    @Nonnull
    @Override
    public Locale getUserLocale() {
        return interaction.getUserLocale();
    }

    @Nonnull
    @Override
    public Locale getGuildLocale() {
        return interaction.getGuildLocale();
    }

    @Nullable
    @Override
    public YMember getMember() {
        return interaction.getMember();
    }

    @Nonnull
    @Override
    public YUser getUser() {
        return interaction.getUser();
    }

    @Override
    public long getIdLong() {
        return interaction.getIdLong();
    }

    @Override
    public boolean isAcknowledged() {
        return interaction.isAcknowledged();
    }
}
