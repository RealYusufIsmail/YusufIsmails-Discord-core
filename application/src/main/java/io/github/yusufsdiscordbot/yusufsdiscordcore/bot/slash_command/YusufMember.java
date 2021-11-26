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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public record YusufMember(Member member) {

    @Contract(" -> new")
    public @NotNull YusufUser getYusufUser() {
        return new YusufUser(this.member.getUser());
    }

    /**
     * @see Member
     */
    public Member getMember() {
        return this.member;
    }

    /**
     * @see Member#canInteract(Role)
     */
    public boolean canInteract(Role role) {
        return this.member.canInteract(role);
    }

    /**
     * @see Member#getGuild()
     */
    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(this.member.getGuild());
    }

    /**
     * @see Member#getTimeJoined()
     */
    public @NotNull OffsetDateTime getTimeJoined() {
        return this.member.getTimeJoined();
    }

    /**
     * @see Member#hasTimeJoined
     */
    public boolean hasTimeJoined() {
        return this.member.hasTimeJoined();
    }

    /**
     * @see Member#getTimeBoosted()
     */
    @Nullable
    public OffsetDateTime getTimeBoosted() {
        return this.member.getTimeBoosted();
    }

    /**
     * @see Member#getVoiceState()
     */
    @Nullable
    public GuildVoiceState getVoiceState() {
        return this.member.getVoiceState();
    }

    /**
     * @see Member#getActivities()
     */
    public @NotNull List<Activity> getActivities() {
        return this.member.getActivities();
    }

    /**
     * @see Member#getOnlineStatus()
     */
    public @NotNull OnlineStatus getOnlineStatus() {
        return this.member.getOnlineStatus();
    }

    /**
     * @see Member#getOnlineStatus(ClientType)
     */
    public @NotNull OnlineStatus getOnlineStatus(@Nonnull ClientType type) {
        return this.member.getOnlineStatus(type);
    }

    /**
     * @see Member#getActiveClients()
     */
    public @NotNull Set<ClientType> getActiveClients() {
        return this.member.getActiveClients();
    }

    /**
     * @see Member#getNickname()
     */
    @Nullable
    public String getNickname() {
        return this.member.getNickname();
    }

    /**
     * @see Member#getAvatarId()
     */
    public String getAvatarId() {
        return this.member.getAvatarId();
    }

    /**
     * @see Member#getAvatarUrl()
     */
    @Nullable
    public String getAvatarUrl() {
        return this.member.getAvatarUrl();
    }

    /**
     * @see Member#getEffectiveAvatarUrl()
     */
    public @NotNull String getEffectiveAvatarUrl() {
        return this.member.getEffectiveAvatarUrl();
    }

    /**
     * @see Member#getRoles()
     */
    public @NotNull List<Role> getRoles() {
        return this.member.getRoles();
    }

    /**
     * @see Member#getColor()
     */
    @Nullable
    public Color getColor() {
        return this.member.getColor();
    }

    /**
     * @see Member#getColorRaw()
     */
    public int getColorRaw() {
        return this.member.getColorRaw();
    }

    /**
     * @see Member#canInteract(Member)
     */
    public boolean canInteract(@Nonnull Member member) {
        return this.member.canInteract(member);
    }

    /**
     * @see Member#canInteract(Member)
     */
    public boolean canInteract(@Nonnull YusufMember member) {
        return this.member.canInteract(member.getMember());
    }

    /**
     * @see Member#canInteract(Emote)
     */
    public boolean canInteract(@Nonnull Emote emote) {
        return this.member.canInteract(emote);
    }

    /**
     * @see Member#isOwner()
     */
    public boolean isOwner() {
        return this.member.isOwner();
    }

    /**
     * @see Member#isPending()
     */
    @Incubating
    public boolean isPending() {
        return this.member.isPending();
    }

    /**
     * @see Member#getDefaultChannel()
     */
    @Nullable
    public TextChannel getDefaultChannel() {
        return this.member.getDefaultChannel();
    }

    /**
     * @see Member#ban(int)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(int delDays) {
        return this.member.ban(delDays);
    }

    /**
     * @see Member#ban(int, String)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(int delDays, @Nullable String reason) {
        return this.member.ban(delDays, reason);
    }

    /**
     * @see Member#kick()
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick() {
        return this.member.kick();
    }

    /**
     * @see Member#kick(String)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(String reason) {
        return this.member.kick(reason);
    }

    /**
     * @see Member#mute(boolean)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> mute(boolean mute) {
        return this.member.mute(mute);
    }

    /**
     * @see Member#deafen(boolean)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> deafen(boolean deafen) {
        return this.member.deafen(deafen);
    }

    /**
     * @see Member#modifyNickname(String)
     */
    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> modifyNickname(@Nullable String nickname) {
        return this.member.modifyNickname(nickname);
    }

    /**
     * @see Member#getEffectiveName() ()
     */
    public @NotNull String getName() {
        return this.member.getEffectiveName();
    }

    /**
     * @see Member
     */
    public Member getAuthor() {
        return this.member;
    }


    public @NotNull String getUserId() {
        return this.getYusufUser().getUserId();
    }

    public @NotNull Long getUserIdLong() {
        return this.getYusufUser().getUserIdLong();
    }

    /**
     * @see Member#getId()
     */
    public @NotNull String getMemberId() {
        return this.member.getId();
    }

    /**
     * @see Member#getIdLong()
     */
    public @NotNull Long getMemberIdLong() {
        return this.member.getIdLong();
    }

    /**
     * @see Member#getPermissions()
     */
    public @NotNull Set<Permission> getPermissions() {
        return this.member.getPermissions();
    }

    /**
     * @see Member#getPermissions(GuildChannel)
     */
    public @NotNull Set<Permission> getPermissions(@Nonnull GuildChannel channel) {
        return this.member.getPermissions(channel);
    }


    public @NotNull Set<Permission> getPermissions(@Nonnull YusufGuildChannel channel) {
        return this.member.getPermissions(channel.getGuildChannel());
    }

    /**
     * @see Member#getPermissionsExplicit()
     */
    public @NotNull Set<Permission> getPermissionsExplicit() {
        return this.member.getPermissionsExplicit();
    }

    /**
     * @see Member#getPermissionsExplicit(GuildChannel)
     */
    public @NotNull Set<Permission> getPermissionsExplicit(@Nonnull GuildChannel channel) {
        return this.member.getPermissionsExplicit(channel);
    }

    public @NotNull Set<Permission> getPermissionsExplicit(@Nonnull YusufGuildChannel channel) {
        return this.member.getPermissionsExplicit(channel.getGuildChannel());
    }

    /**
     * @see Member#hasPermission(Permission...)
     */
    public boolean hasPermission(@Nonnull Permission... permissions) {
        return this.member.hasPermission(permissions);
    }

    /**
     * @see Member#hasPermission(Collection)
     */
    public boolean hasPermission(@Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(permissions);
    }

    /**
     * @see Member#hasPermission(GuildChannel, Permission...)
     */
    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Permission... permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    /**
     * @see Member#hasPermission(GuildChannel, Collection)
     */
    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    public boolean hasPermission(@Nonnull YusufGuildChannel channel,
            @Nonnull Permission... permissions) {
        return this.member.hasPermission(channel.getGuildChannel(), permissions);
    }

    public boolean hasPermission(@Nonnull YusufGuildChannel channel,
            @Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(channel.getGuildChannel(), permissions);
    }

    /**
     * @see Member#hasAccess(GuildChannel)
     */
    public boolean hasAccess(@Nonnull GuildChannel channel) {
        return this.member.hasAccess(channel);
    }

    /**
     * @see Member#canSync(GuildChannel, GuildChannel)
     */
    public boolean canSync(@Nonnull GuildChannel targetChannel, @Nonnull GuildChannel syncSource) {
        return this.member.canSync(targetChannel, syncSource);
    }

    /**
     * @see Member#canSync(GuildChannel)
     */
    public boolean canSync(@Nonnull GuildChannel channel) {
        return this.member.canSync(channel);
    }

    public boolean hasAccess(@Nonnull YusufGuildChannel channel) {
        return this.member.hasAccess(channel.getGuildChannel());
    }

    public boolean canSync(@Nonnull YusufGuildChannel targetChannel,
            @Nonnull YusufGuildChannel syncSource) {
        return this.member.canSync(targetChannel.getGuildChannel(), syncSource.getGuildChannel());
    }

    public boolean canSync(@Nonnull YusufGuildChannel channel) {
        return this.member.canSync(channel.getGuildChannel());
    }

    /**
     *
     * @param member the member who you want to check is null
     * @param event the slash command event.
     * @return not null
     */
    @Contract("!null,_->false;null,_->true")
    public boolean memberIsNotNull(YusufMember member, YusufSlashCommandEvent event) {
        boolean result = member == null;
        if (result) {
            event.replyEphemeral("The member is null");
        }
        return result;
    }
}
