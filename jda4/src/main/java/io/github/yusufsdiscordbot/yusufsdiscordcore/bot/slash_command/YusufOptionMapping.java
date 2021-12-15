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

import io.github.yusufsdiscordbot.annotations.ToBeChanged;
import io.github.yusufsdiscordbot.annotations.ToBeRemoved;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public record YusufOptionMapping(OptionMapping optionMapping) {

    public OptionMapping getOptionMapping() {
        return optionMapping;
    }

    @Contract(" -> new")
    public @NotNull YusufMember getAsMember() {
        return new YusufMember(optionMapping.getAsMember());
    }

    @Contract(" -> new")
    public @NotNull YusufUser getAsUser() {
        return new YusufUser(optionMapping.getAsUser());
    }

    @Contract(" -> new")
    @ToBeRemoved(
            reasonForRemoval = "This was added to make it easier to use the OptionMapping class. It is not recommended to use this method anymore since it was broken down in JDA 5.,"
                    + "It will be removed in the next major version of the library.",
            willBeRemovedSoon = true, versionOfRemoval = "2.0.0")
    public @NotNull YusufGuildChannel getAsGuildChannel() {
        return new YusufGuildChannel(optionMapping.getAsGuildChannel());
    }
}
