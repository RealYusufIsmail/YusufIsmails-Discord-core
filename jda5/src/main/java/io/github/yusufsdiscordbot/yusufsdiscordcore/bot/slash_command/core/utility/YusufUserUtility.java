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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.utility;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class YusufUserUtility {
    private final User user;

    public YusufUserUtility(User user) {
        this.user = user;
    }

    /**
     * @see YusufBot
     */
    public @NotNull YusufBot getBot() {
        return new YusufBot(this.user.getJDA().getSelfUser());
    }

    /**
     * @see YusufBot#getBotTag()
     */
    @Contract(pure = true)
    public @NotNull String getBotTag() {
        return this.getBot().getBotTag();
    }

    /**
     * @see YusufBot#getBotId()
     */
    @Contract(pure = true)
    public @NotNull String getBotId() {
        return this.getBot().getBotId();
    }

    /**
     * @see YusufBot#getBotIdLong()
     */
    @Contract(pure = true)
    public @NotNull Long getBotIdLong() {
        return this.getBot().getBotIdLong();
    }

    /**
     * @see YusufBot#getName()
     */
    @Contract(pure = true)
    public @NotNull String getBotName() {
        return this.getBot().getName();
    }

    /**
     * @see YusufBot#getDiscriminator()
     */
    @Contract(pure = true)
    public @NotNull String getBotDiscriminator() {
        return this.getBot().getDiscriminator();
    }

    /**
     * @see YusufBot#getAvatarId()
     */
    @Contract(pure = true)
    public @NotNull String getBotAvatarId() {
        return this.getBot().getAvatarId();
    }

    /**
     * @see YusufBot#getAvatarUrl()
     */
    @Contract(pure = true)
    public @NotNull String getBotAvatarUrl() {
        return this.getBot().getAvatarUrl();
    }

    /**
     * @see YusufBot#getDefaultAvatarId()
     */
    @Contract(pure = true)
    public @NotNull String getBotDefaultAvatarId() {
        return this.getBot().getDefaultAvatarId();
    }

    /**
     * @see YusufBot#getBotEffectiveAvatarUrl()
     */
    @Contract(pure = true)
    public @NotNull String getBotEffectiveAvatarUrl() {
        return this.getBot().getBotEffectiveAvatarUrl();
    }

    /**
     * @param user the user who you want to check is null
     * @param event the slash command event.
     * @return not null
     */
    @Contract("null,_->false;!null,_->true")
    public boolean userIsNotNull(YusufUser user, YusufSlashCommandEvent event) {
        boolean result = user == null;
        if (result) {
            event.replyEphemeral("The given user is null");
            return false;
        }
        return true;
    }
}
