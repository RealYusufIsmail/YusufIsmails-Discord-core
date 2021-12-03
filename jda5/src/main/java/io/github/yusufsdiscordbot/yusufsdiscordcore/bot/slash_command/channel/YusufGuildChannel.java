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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.channel;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufPermissionContainer;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record YusufGuildChannel(GuildChannel channel) implements Channel, Comparable<GuildChannel>{
    public GuildChannel getChannel() {
        return channel;
    }

    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(channel.getGuild());
    }

    public @NotNull String getName() {
        return channel.getName();
    }

    @Override
    public @NotNull String getId() {
        return channel.getId();
    }

    @Override
    public long getIdLong() {
        return this.channel.getIdLong();
    }

    public @NotNull ChannelType getType() {
        return channel.getType();
    }

    @NotNull
    @Override
    public JDA getJDA() {
        return this.channel.getJDA();
    }

    public @NotNull AuditableRestAction<Void> delete() {
        return channel.delete();
    }

    @Contract(" -> new")
    public @NotNull YusufPermissionContainer getPermissionContainer() {
        return new YusufPermissionContainer(channel.getPermissionContainer());
    }

    public @NotNull ChannelManager<?, ?> getManager() {
        return channel.getManager();
    }

    @Override
    public int compareTo(@NotNull GuildChannel o) {
        return this.channel.compareTo(o);
    }
}
