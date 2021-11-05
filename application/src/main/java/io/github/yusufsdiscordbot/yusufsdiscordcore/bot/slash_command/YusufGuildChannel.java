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

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.ChannelManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import net.dv8tion.jda.api.requests.restaction.InviteAction;
import net.dv8tion.jda.api.requests.restaction.PermissionOverrideAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class YusufGuildChannel {
    private final GuildChannel guildChannel;

    public YusufGuildChannel(GuildChannel guildChannel) {
        this.guildChannel = guildChannel;
    }

    @Nonnull
    public GuildChannel getGuildChannel() {
        return guildChannel;
    }

    @Nonnull
    public YusufGuild getGuild() {
        return new YusufGuild(guildChannel.getGuild());
    }

    @Nonnull
    public Category getParent() {
        return guildChannel.getParent();
    }

    @Nonnull
    public List<Member> getMembers() {
        return guildChannel.getMembers();
    }

    public int getPosition() {
        return guildChannel.getPosition();
    }

    public int getPositionRaw() {
        return guildChannel.getPositionRaw();
    }

    @Nullable
    public PermissionOverride getPermissionOverride(@Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.getPermissionOverride(permissionHolder);
    }

    @Nonnull
    public List<PermissionOverride> getPermissionOverrides() {
        return guildChannel.getPermissionOverrides();
    }

    public List<PermissionOverride> getRolePermissionOverrides() {
        return guildChannel.getRolePermissionOverrides();
    }

    public boolean isSynced() {
        return guildChannel.isSynced();
    }

    @Nonnull
    @CheckReturnValue
    public ChannelAction<? extends GuildChannel> createCopy(@Nonnull Guild guild) {
        return guildChannel.createCopy(guild);
    }

    @Nonnull
    @CheckReturnValue
    public ChannelAction<? extends GuildChannel> createCopy() {
        return guildChannel.createCopy();
    }

    @Nonnull
    public ChannelManager getManager() {
        return guildChannel.getManager();
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> delete() {
        return guildChannel.delete();
    }

    @Nonnull
    @CheckReturnValue
    public PermissionOverrideAction createPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.createPermissionOverride(permissionHolder);
    }

    @Nonnull
    @CheckReturnValue
    public PermissionOverrideAction putPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.putPermissionOverride(permissionHolder);
    }

    @Nonnull
    @CheckReturnValue
    public PermissionOverrideAction upsertPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.upsertPermissionOverride(permissionHolder);
    }

    @Nonnull
    @CheckReturnValue
    public InviteAction createInvite() {
        return guildChannel.createInvite();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<Invite>> retrieveInvites() {
        return guildChannel.retrieveInvites();
    }
}
