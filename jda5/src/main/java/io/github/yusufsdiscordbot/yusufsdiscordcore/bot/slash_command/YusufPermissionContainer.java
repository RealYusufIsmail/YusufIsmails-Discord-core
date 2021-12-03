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

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.channel.ChannelManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.PermissionOverrideAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public record YusufPermissionContainer(IPermissionContainer iPermissionContainer) implements GuildChannel{

    public PermissionOverride getPermissionOverride(@Nonnull IPermissionHolder permissionHolder) {
        return iPermissionContainer.getPermissionOverride(permissionHolder);
    }

    public @NotNull List<PermissionOverride> getPermissionOverrides() {
        return iPermissionContainer.getPermissionOverrides();
    }


    public @NotNull List<PermissionOverride> getRolePermissionOverrides() {
        return iPermissionContainer.getRolePermissionOverrides();
    }

    public @NotNull List<PermissionOverride> getMemberPermissionOverrides() {
        return iPermissionContainer.getMemberPermissionOverrides();
    }

    @NotNull
    @Override
    public Guild getGuild() {
        return this.iPermissionContainer.getGuild();
    }

    @NotNull
    @Override
    public ChannelManager<?, ?> getManager() {
        return this.iPermissionContainer.getManager();
    }

    @NotNull
    @Override
    public String getName() {
        return this.iPermissionContainer.getName();
    }

    @NotNull
    @Override
    public ChannelType getType() {
        return iPermissionContainer.getType();
    }

    @NotNull
    @Override
    public JDA getJDA() {
        return iPermissionContainer.getJDA();
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> delete() {
        return iPermissionContainer.delete();
    }

    @Override
    public IPermissionContainer getPermissionContainer() {
        return iPermissionContainer;
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction createPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return iPermissionContainer.createPermissionOverride(permissionHolder);
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction putPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return iPermissionContainer.putPermissionOverride(permissionHolder);
    }

    @CheckReturnValue
    public @NotNull PermissionOverrideAction upsertPermissionOverride(
            @Nonnull IPermissionHolder permissionHolder) {
        return iPermissionContainer.upsertPermissionOverride(permissionHolder);
    }

    @Override
    public int compareTo(@NotNull GuildChannel o) {
        return iPermissionContainer.compareTo(o);
    }

    @Override
    public long getIdLong() {
        return iPermissionContainer.getIdLong();
    }
}
