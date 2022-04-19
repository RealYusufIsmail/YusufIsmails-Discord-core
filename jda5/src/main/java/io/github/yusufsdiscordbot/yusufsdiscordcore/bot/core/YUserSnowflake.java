package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.UserSnowflake;
import org.jetbrains.annotations.NotNull;

public record YUserSnowflake(UserSnowflake user) implements UserSnowflake {
    /**
     * Retrieve a Mention for this Entity.
     * For the public {@link Role Role} (@everyone), this will return the literal string {@code "@everyone"}.
     *
     * @return A resolvable mention.
     */
    @NotNull
    @Override
    public String getAsMention() {
        return user.getAsMention();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Long containing the Id.
     */
    @Override
    public long getIdLong() {
        return user.getIdLong();
    }
}
