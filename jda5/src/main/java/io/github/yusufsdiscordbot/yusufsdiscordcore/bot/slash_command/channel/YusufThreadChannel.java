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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.channel;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public record YusufThreadChannel(
        ThreadChannel threadChannel) implements GuildMessageChannel, IMemberContainer {
    public ThreadChannel getThreadChannel() {
        return threadChannel;
    }

    @Override
    public @NotNull String getId() {
        return threadChannel.getId();
    }

    @Override
    public long getIdLong() {
        return this.threadChannel.getIdLong();
    }

    public @NotNull String getName() {
        return threadChannel.getName();
    }

    public @NotNull ChannelType getType() {
        return threadChannel.getType();
    }

    @NotNull
    @Override
    public JDA getJDA() {
        return this.threadChannel.getJDA();
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

    @Override
    public boolean canTalk(@NotNull Member member) {
        return false;
    }

    @NotNull
    @Override
    public RestAction<Void> removeReactionById(@NotNull String messageId, @NotNull String unicode,
            @NotNull User user) {
        return this.threadChannel.removeReactionById(messageId, unicode, user);
    }

    @NotNull
    @Override
    public RestAction<Void> deleteMessagesByIds(@NotNull Collection<String> messageIds) {
        return this.threadChannel.deleteMessagesByIds(messageIds);
    }

    @NotNull
    @Override
    public RestAction<Void> clearReactionsById(@NotNull String messageId) {
        return this.threadChannel.clearReactionsById(messageId);
    }

    @NotNull
    @Override
    public RestAction<Void> clearReactionsById(@NotNull String messageId, @NotNull String unicode) {
        return this.threadChannel.clearReactionsById(messageId, unicode);
    }

    @NotNull
    @Override
    public List<Member> getMembers() {
        return this.threadChannel.getMembers();
    }

    @NotNull
    @Override
    public Guild getGuild() {
        return this.threadChannel.getGuild();
    }

    @NotNull
    @Override
    public ChannelManager<?, ?> getManager() {
        return this.threadChannel.getManager();
    }

    @NotNull
    @Override
    public AuditableRestAction<Void> delete() {
        return this.threadChannel.delete();
    }

    @Override
    public IPermissionContainer getPermissionContainer() {
        return this.threadChannel.getPermissionContainer();
    }

    @Override
    public int compareTo(@NotNull GuildChannel o) {
        return this.threadChannel.compareTo(o);
    }

    @Override
    public long getLatestMessageIdLong() {
        return this.threadChannel.getLatestMessageIdLong();
    }
}
