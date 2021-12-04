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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.entities.SelfUser;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Inspiration from {@link SelfUser}
 * 
 * @author Yusuf Arfan Ismail
 */
public record YusufBot(SelfUser user) {

    /**
     * @return the id of the bot.
     */
    public long getBotIdLong() {
        return user.getApplicationIdLong();
    }

    /**
     * @return the id of the bot.
     */
    public @NotNull String getBotId() {
        return user.getApplicationId();
    }

    /**
     * Check if the bot is verified or not.
     * 
     * @return true if the bot is verified.
     */
    public boolean isBotVerified() {
        return user.isVerified();
    }

    /**
     * If true, this account is protected by Multi-Factor authorization. <br>
     * If this is a Client account, then this describes the MFA status of the Client account. <br>
     * If this is a Bot account, then this describes the MFA status of the Client account that owns
     * this Bot.
     *
     * @return True, if this account has MFA protecting it.
     */
    public boolean isMfaEnabled() {
        return user.isMfaEnabled();
    }

    /**
     * Returns the maximum size for files that can be uploaded with this account. <br>
     * Returns {@value net.dv8tion.jda.api.entities.Message#MAX_FILE_SIZE} for bots.
     *
     * @return The maximum size for files that can be uploaded with this account
     *
     * @see net.dv8tion.jda.api.entities.Message#MAX_FILE_SIZE
     */
    public long getMaxFileSize() {
        return user.getAllowedFileSize();
    }

    /**
     * @return the name of the bot.
     */
    public @NotNull String getBotName() {
        return user.getName();
    }

    /**
     * @return the bots' avatar id.
     */
    public @NotNull String getAvatarId() {
        return Objects.requireNonNull(user.getAvatarId());
    }

    /**
     * @return the bots' avatar url.
     */
    public @NotNull String getAvatarUrl() {
        return Objects.requireNonNull(user.getAvatarUrl());
    }

    /**
     * @return the bots' default avatar id.
     */
    public @NotNull String getDefaultAvatarId() {
        return Objects.requireNonNull(user.getDefaultAvatarId());
    }

    /**
     * @return the bots' default avatar url.
     */
    public @NotNull String getDefaultAvatarUrl() {
        return Objects.requireNonNull(user.getDefaultAvatarUrl());
    }
}