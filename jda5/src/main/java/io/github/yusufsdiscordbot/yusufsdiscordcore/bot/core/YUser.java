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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public record YUser(@Getter User user) {

    /**
     * @see User#getAsTag()
     */
    public @Nonnull String getUserTag() {
        return this.user.getAsTag();
    }

    /**
     * @see User#getId()
     */
    public @Nonnull String getUserId() {
        return this.user.getId();
    }

    /**
     * @see User#getIdLong()
     */
    public @Nonnull Long getUserIdLong() {
        return this.user.getIdLong();
    }

    /**
     * @see User#getName()
     */
    public @Nonnull String getName() {
        return this.user.getName();
    }

    /**
     * @see User#isBot()
     */
    public @Nonnull Boolean isBot() {
        return this.user.isBot();
    }

    /**
     * @see User#getDiscriminator()
     */
    public @Nonnull String getDiscriminator() {
        return this.user.getDiscriminator();
    }

    /**
     * @see User#getAvatarId()
     */
    public @Nullable String getAvatarId() {
        return this.user.getAvatarId();
    }

    /**
     * @see User#getAvatarUrl()
     */
    public @Nullable String getAvatarUrl() {
        return this.user.getAvatarUrl();
    }

    /**
     * @see User#getDefaultAvatarId()
     */
    public @Nonnull String getDefaultAvatarId() {
        return this.user.getDefaultAvatarId();
    }

    /**
     * The URL for the for the user's default avatar image.
     *
     * @return Never-null String containing the {@link User User} default avatar url.
     * @throws UnsupportedOperationException If this User was created with from id
     */
    @NotNull
    public String getDefaultAvatarUrl() {
        return this.user.getDefaultAvatarUrl();
    }

    /**
     * @see User#getDefaultAvatarUrl()
     */
    public @Nonnull String getEffectiveAvatarUrl() {
        return this.user.getEffectiveAvatarUrl();
    }

    /**
     * Loads the user's {@link User.Profile} data. Returns a completed RestAction if this User has
     * been retrieved using {@link JDA#retrieveUserById(long)}.
     *
     * @return {@link RestAction} - Type: {@link User.Profile}
     * @throws UnsupportedOperationException If this User was created with from id
     * @since 4.3.0
     */
    @NotNull
    public RestAction<User.Profile> retrieveProfile() {
        return this.user.retrieveProfile();
    }

    /**
     * The "tag" for this user
     * <p>
     * This is the equivalent of calling {@link String#format(String, Object...)
     * String.format}("%#s", user)
     *
     * @return Never-null String containing the tag for this user, for example DV8FromTheWorld#6297
     * @throws UnsupportedOperationException If this User was created with fromId(long)
     */
    @NotNull
    public String getAsTag() {
        return this.user.getAsTag();
    }

    /**
     * @see User#hasPrivateChannel()
     */
    public boolean hasPrivateChannel() {
        return this.user.hasPrivateChannel();
    }

    /**
     * @see User#openPrivateChannel()
     */
    public @Nonnull RestAction<PrivateChannel> openPrivateChannel() {
        return this.user.openPrivateChannel();
    }

    /**
     * @see User#getMutualGuilds()
     */
    public @Nonnull List<Guild> getMutualGuilds() {
        return this.user.getMutualGuilds();
    }

    /**
     * @see User#isSystem()
     */
    public boolean isSystem() {
        return this.user.isSystem();
    }

    /**
     * @see User#getJDA()
     */
    public @Nonnull JDA getJDA() {
        return this.user.getJDA();
    }

    /**
     * @see User#getFlags()
     */
    public @Nonnull Set<User.UserFlag> getFlags() {
        return this.user.getFlags();
    }

    /**
     * @see User#getFlagsRaw()
     */
    public int getFlagsRaw() {
        return this.user.getFlagsRaw();
    }

    /**
     * @see User#getAsMention()
     */
    public @Nonnull String getAsMention() {
        return this.user.getAsMention();
    }

    /**
     * @see YBot
     */
    public @Nonnull YBot getBot() {
        return new YBot(this.user.getJDA().getSelfUser());
    }

    public String toString() {
        return this.user.toString();
    }

    @NotNull
    public OffsetDateTime getTimeCreated() {
        return this.user.getTimeCreated();
    }
}
