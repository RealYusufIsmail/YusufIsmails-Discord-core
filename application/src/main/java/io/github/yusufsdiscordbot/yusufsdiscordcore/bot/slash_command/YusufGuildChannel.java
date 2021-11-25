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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public record YusufGuildChannel(GuildChannel guildChannel) {

    public GuildChannel getGuildChannel() {
        return guildChannel;
    }

    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(guildChannel.getGuild());
    }

    public Category getParent() {
        return Objects.requireNonNull(guildChannel.getParent());
    }

    public @NotNull List<Member> getMembers() {
        return guildChannel.getMembers();
    }

    public int getPosition() {
        return guildChannel.getPosition();
    }

    public int getPositionRaw() {
        return guildChannel.getPositionRaw();
    }

    public PermissionOverride getPermissionOverride(@Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.getPermissionOverride(permissionHolder);
    }

    public @NotNull List<PermissionOverride> getPermissionOverrides() {
        return guildChannel.getPermissionOverrides();
    }

    public @NotNull List<PermissionOverride> getRolePermissionOverrides() {
        return guildChannel.getRolePermissionOverrides();
    }

    public boolean isSynced() {
        return guildChannel.isSynced();
    }

    @CheckReturnValue
    public @NotNull ChannelAction<? extends GuildChannel> createCopy(@Nonnull Guild guild) {
        return guildChannel.createCopy(guild);
    }

    @CheckReturnValue
    public @NotNull ChannelAction<? extends GuildChannel> createCopy() {
        return guildChannel.createCopy();
    }

    public @NotNull ChannelManager getManager() {
        return guildChannel.getManager();
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> delete() {
        return guildChannel.delete();
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction createPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.createPermissionOverride(permissionHolder);
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction putPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.putPermissionOverride(permissionHolder);
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction upsertPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.upsertPermissionOverride(permissionHolder);
    }

    @CheckReturnValue
    public @NotNull InviteAction createInvite() {
        return guildChannel.createInvite();
    }

    @CheckReturnValue
    public @NotNull RestAction<List<Invite>> retrieveInvites() {
        return guildChannel.retrieveInvites();
    }
}
