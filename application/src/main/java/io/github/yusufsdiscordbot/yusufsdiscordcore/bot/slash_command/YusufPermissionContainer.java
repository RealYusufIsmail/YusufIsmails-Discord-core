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
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.PermissionOverrideAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public record YusufPermissionContainer(IPermissionContainer guildChannel) {

    public PermissionOverride getPermissionOverride(@Nonnull IPermissionHolder permissionHolder) {
        return guildChannel.getPermissionOverride(permissionHolder);
    }

    public @NotNull List<PermissionOverride> getPermissionOverrides() {
        return guildChannel.getPermissionOverrides();
    }


    public @NotNull List<PermissionOverride> getRolePermissionOverrides() {
        return guildChannel.getRolePermissionOverrides();
    }

    public @NotNull List<PermissionOverride> getMemberPermissionOverrides() {
        return guildChannel.getMemberPermissionOverrides();
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
}
