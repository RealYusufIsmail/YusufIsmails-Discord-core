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

import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class YusufOptionMapping {
    private final OptionMapping optionMapping;

    public YusufOptionMapping(OptionMapping optionMapping) {
        this.optionMapping = optionMapping;
    }

    public OptionMapping getOptionMapping() {
        return optionMapping;
    }

    @Nullable
    public YusufMember getAsMember() {
        return new YusufMember(optionMapping.getAsMember());
    }

    @Nonnull
    public YusufUser getAsUser() {
        return new YusufUser(optionMapping.getAsUser());
    }

    @Nonnull
    public YusufGuildChannel getAsGuildChannel() {
        return new YusufGuildChannel(optionMapping.getAsGuildChannel());
    }
}
