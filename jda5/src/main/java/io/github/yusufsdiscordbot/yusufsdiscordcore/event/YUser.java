package io.github.yusufsdiscordbot.yusufsdiscordcore.event;

import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;

public interface YUser extends User {
    /**
     * The username of the {@link net.dv8tion.jda.api.entities.User User}. Length is between 2 and
     * 32 characters (inclusive).
     *
     * @throws UnsupportedOperationException If this User was created with {@link #fromId(long)}
     *
     * @return Never-null String containing the {@link net.dv8tion.jda.api.entities.User User}'s
     *         username.
     */
    @Nonnull
    String getUserName();

    /**
     * The "tag" for this user
     * <p>
     * This is the equivalent of calling {@link java.lang.String#format(String, Object...)
     * String.format}("%#s", user)
     *
     * @throws UnsupportedOperationException If this User was created with {@link #fromId(long)}
     *
     * @return Never-null String containing the tag for this user, for example DV8FromTheWorld#6297
     */
    @Nonnull
    String getUserTag();
}
