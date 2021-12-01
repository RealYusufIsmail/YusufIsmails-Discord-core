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

import net.dv8tion.jda.api.entities.ThreadChannel;
import net.dv8tion.jda.api.entities.ThreadMember;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

public record YusufThreadChannel(ThreadChannel threadChannel) {
    public ThreadChannel getThreadChannel() {
        return threadChannel;
    }

    public @NotNull String getId() {
        return threadChannel.getId();
    }

    public @NotNull String getName() {
        return threadChannel.getName();
    }

    public String getType() {
        return threadChannel.getType().toString();
    }

    public @NotNull List<ThreadMember> getTheMembersInTheThread() {
        return threadChannel.getThreadMembers();
    }

    public RestAction<Void> joinTheThread() {
        return threadChannel.join();
    }

    public RestAction<Void> leaveTheThread() {
        return threadChannel.leave();
    }

    public @NotNull RestAction<Void> deleteTheThread() {
        return threadChannel.delete();
    }

    public @NotNull MessageAction sendMessageToTheThread(@Nonnull CharSequence text) {
        return threadChannel.sendMessage(text);
    }
}
