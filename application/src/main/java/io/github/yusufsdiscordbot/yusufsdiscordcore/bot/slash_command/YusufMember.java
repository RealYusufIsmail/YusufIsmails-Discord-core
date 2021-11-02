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

import net.dv8tion.jda.annotations.Incubating;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

public class YusufMember {
    private final Member member;

    public YusufMember(Member member) {
        this.member = member;
    }

    public User getUser() {
        return this.member.getUser();
    }

    @Nonnull
    public YusufGuild getGuild() {
        return new YusufGuild(this.member.getGuild());
    }

    @Nonnull
    public OffsetDateTime getTimeJoined() {
        return this.member.getTimeJoined();
    }

    public boolean hasTimeJoined() {
        return this.member.hasTimeJoined();
    }

    @Nullable
    public OffsetDateTime getTimeBoosted() {
        return this.member.getTimeBoosted();
    }

    @Nullable
    public GuildVoiceState getVoiceState() {
        return this.member.getVoiceState();
    }

    @Nullable
    public List<Activity> getActivities() {
        return this.member.getActivities();
    }

    @Nullable
    public OnlineStatus getOnlineStatus() {
        return this.member.getOnlineStatus();
    }

    @Nullable
    public OnlineStatus getOnlineStatus(@Nonnull ClientType type) {
        return this.member.getOnlineStatus(type);
    }

    @Nullable
    public EnumSet<ClientType> getActiveClients() {
        return this.member.getActiveClients();
    }

    @Nullable
    public String getNickname() {
        return this.member.getNickname();
    }

    @Nullable
    public String getAvatarId() {
        return this.member.getAvatarId();
    }

    @Nullable
    public String getAvatarUrl() {
        return this.member.getAvatarUrl();
    }

    @Nullable
    public String getEffectiveAvatarUrl() {
        return this.member.getEffectiveAvatarUrl();
    }

    @Nullable
    public List<Role> getRoles() {
        return this.member.getRoles();
    }

    @Nullable
    public Color getColor() {
        return this.member.getColor();
    }

    public int getColorRaw() {
        return this.member.getColorRaw();
    }

    public boolean canInteract(@Nonnull Member member) {
        return this.member.canInteract(member);
    }

    public boolean canInteract(@Nonnull Emote emote) {
        return this.member.canInteract(emote);
    }

    public boolean isOwner() {
        return this.member.isOwner();
    }

    @Incubating
    public boolean isPending() {
        return this.member.isPending();
    }

    @Nullable
    public TextChannel getDefaultChannel() {
        return this.member.getDefaultChannel();
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> ban(int delDays) {
        return this.member.ban(delDays);
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> ban(int delDays, @Nullable String reason) {
        return this.member.ban(delDays, reason);
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> kick() {
        return this.member.kick();
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> kick(String reason) {
        return this.member.kick(reason);
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> mute(boolean mute) {
        return this.member.mute(mute);
    }

    @Nullable
    @CheckReturnValue
    public AuditableRestAction<Void> deafen(boolean deafen) {
        return this.member.deafen(deafen);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> modifyNickname(@Nullable String nickname) {
        return this.member.modifyNickname(nickname);
    }

    @Nonnull
    public String getName() {
        return this.member.getEffectiveName();
    }

    @Nonnull
    public Member getAuthor() {
        return this.member;
    }

    @Nonnull
    public String getUserId() {
        return this.getUser().getId();
    }

    @Nullable
    public EnumSet<Permission> getPermissions() {
        return this.member.getPermissions();
    }

    @Nullable
    public EnumSet<Permission> getPermissions(@Nonnull GuildChannel channel) {
        return this.member.getPermissions(channel);
    }

    @Nullable
    public EnumSet<Permission> getPermissionsExplicit() {
        return this.member.getPermissionsExplicit();
    }

    @Nullable
    public EnumSet<Permission> getPermissionsExplicit(@Nonnull GuildChannel channel) {
        return this.member.getPermissionsExplicit(channel);
    }

    public boolean hasPermission(@Nonnull Permission... permissions) {
        return this.member.hasPermission(permissions);
    }

    public boolean hasPermission(@Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(permissions);
    }

    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Permission... permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    public boolean hasAccess(@Nonnull GuildChannel channel) {
        return this.member.hasAccess(channel);
    }

    public boolean canSync(@Nonnull GuildChannel targetChannel, @Nonnull GuildChannel syncSource) {
        return this.member.canSync(targetChannel, syncSource);
    }

    public boolean canSync(@Nonnull GuildChannel channel) {
        return this.member.canSync(channel);
    }
}
