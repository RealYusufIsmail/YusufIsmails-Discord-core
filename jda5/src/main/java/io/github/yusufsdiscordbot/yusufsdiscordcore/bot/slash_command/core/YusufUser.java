/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/> Everyone is permitted to
 * copy and distribute verbatim copies of this license document, but changing it is not allowed.
 * Yusuf Arfan Ismail
 * The GNU General Public License is a free, copyleft license for software and other kinds of works.
 * The licenses for most software and other practical works are designed to take away your freedom
 * to share and change the works. By contrast, the GNU General Public License is intended to
 * guarantee your freedom to share and change all versions of a program--to make sure it remains
 * free software for all its users. We, the Free Software Foundation, use the GNU General Public
 * License for most of our software; it applies also to any other work released this way by its
 * authors. You can apply it to your programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.utility.YusufUserUtility;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class YusufUser extends YusufUserUtility implements IMentionable {
    private final User user;

    public YusufUser(User user) {
        super(user);
        this.user = user;
    }

    /**
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**
     * @see User#getAsTag()
     */
    public @NotNull String getUserTag() {
        return this.user.getAsTag();
    }

    /**
     * @see User#getId()
     */
    public @NotNull String getUserId() {
        return this.user.getId();
    }

    /**
     * @see User#getIdLong()
     */
    public @NotNull Long getUserIdLong() {
        return this.user.getIdLong();
    }

    /**
     * @see User#getName()
     */
    public @NotNull String getName() {
        return this.user.getName();
    }

    /**
     * @see User#isBot()
     */
    public @NotNull Boolean isBot() {
        return this.user.isBot();
    }

    /**
     * @see User#getDiscriminator()
     */
    public @NotNull String getDiscriminator() {
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
    public @NotNull String getDefaultAvatarId() {
        return this.user.getDefaultAvatarId();
    }

    /**
     * @see User#getDefaultAvatarUrl()
     */
    public @NotNull String getEffectiveAvatarUrl() {
        return this.user.getEffectiveAvatarUrl();
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
    public @NotNull RestAction<PrivateChannel> openPrivateChannel() {
        return this.user.openPrivateChannel();
    }

    /**
     * @see User#getMutualGuilds()
     */
    public @NotNull List<Guild> getMutualGuilds() {
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
    public @NotNull JDA getJDA() {
        return this.user.getJDA();
    }

    /**
     * @see User#getFlags()
     */
    public @NotNull Set<User.UserFlag> getFlags() {
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
    public @NotNull String getAsMention() {
        return this.user.getAsMention();
    }

    @Override
    public long getIdLong() {
        return this.user.getIdLong();
    }
}
