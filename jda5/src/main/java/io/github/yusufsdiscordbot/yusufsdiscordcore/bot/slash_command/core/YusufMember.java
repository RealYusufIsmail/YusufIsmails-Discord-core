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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core;

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
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Represents a Guild-specific User.
 *
 * <p>
 * Contains all guild-specific information about a User. (Roles, Nickname, VoiceStatus etc.)
 *
 * @since 3.0
 *
 * @see YusufGuild#getMember(User)
 * @see YusufGuild#getMemberCache()
 * @see YusufGuild#getMemberById(long)
 * @see YusufGuild#getMemberByTag(String)
 * @see YusufGuild#getMemberByTag(String, String)
 * @see YusufGuild#getMembersByEffectiveName(String, boolean)
 * @see YusufGuild#getMembersByName(String, boolean)
 * @see YusufGuild#getMembersByNickname(String, boolean)
 * @see YusufGuild#getMembersWithRoles(Role...)
 * @see YusufGuild#getMembers()
 */
@SuppressWarnings("unused")
public record YusufMember(Member member) implements IMentionable, IPermissionHolder {
    /**
     * Maximum number of days a Member can be timed out for
     */
    private static final int MAX_TIME_OUT_LENGTH = 28;

    @Contract(" -> new")
    public @Nonnull YusufUser getYusufUser() {
        return new YusufUser(this.member.getUser());
    }

    /**
     * @see Member#canInteract(Role)
     */
    public boolean canInteract(@Nonnull Role role) {
        return this.member.canInteract(role);
    }

    /**
     * @see Member#getGuild()
     */
    public @Nonnull YusufGuild getYusufGuild() {
        return new YusufGuild(this.member.getGuild());
    }

    /**
     * @see Member#getGuild()
     */
    public @Nonnull Guild getGuild() {
        return this.member.getGuild();
    }

    /**
     * @see Member#getTimeJoined()
     */
    public @Nonnull OffsetDateTime getTimeJoined() {
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
    public @Nonnull List<Activity> getActivities() {
        return this.member.getActivities();
    }

    /**
     * @see Member#getOnlineStatus()
     */
    public @Nonnull OnlineStatus getOnlineStatus() {
        return this.member.getOnlineStatus();
    }

    /**
     * @see Member#getOnlineStatus(ClientType)
     */
    public @Nonnull OnlineStatus getOnlineStatus(@Nonnull ClientType type) {
        return this.member.getOnlineStatus(type);
    }

    /**
     * @see Member#getActiveClients()
     */
    public @Nonnull Set<ClientType> getActiveClients() {
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
    public @org.jetbrains.annotations.Nullable String getAvatarId() {
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
    public @Nonnull String getEffectiveAvatarUrl() {
        return this.member.getEffectiveAvatarUrl();
    }

    /**
     * @see Member#getRoles()
     */
    public @Nonnull List<Role> getRoles() {
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
        return this.member.canInteract(member.member());
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
    public @Nonnull AuditableRestAction<Void> ban(int delDays) {
        return this.member.ban(delDays);
    }

    /**
     * @see Member#ban(int, String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(int delDays, @Nullable String reason) {
        return this.member.ban(delDays, reason);
    }

    /**
     * @see Member#kick()
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick() {
        return this.member.kick();
    }

    /**
     * @see Member#kick(String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(String reason) {
        return this.member.kick(reason);
    }

    /**
     * @see Member#mute(boolean)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(boolean mute) {
        return this.member.mute(mute);
    }

    /**
     * @see Member#deafen(boolean)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> deafen(boolean deafen) {
        return this.member.deafen(deafen);
    }

    /**
     * @see Member#modifyNickname(String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> modifyNickname(@Nullable String nickname) {
        return this.member.modifyNickname(nickname);
    }

    /**
     * @see Member#getEffectiveName() ()
     */
    public @Nonnull String getName() {
        return this.member.getEffectiveName();
    }

    /**
     * @see Member
     */
    public Member getAuthor() {
        return this.member;
    }

    /**
     * @see Member#getId()
     */
    public @Nonnull String getMemberId() {
        return this.member.getId();
    }

    /**
     * @see Member#getIdLong()
     */
    public @Nonnull Long getMemberIdLong() {
        return this.member.getIdLong();
    }

    /**
     * @see Member#getPermissions()
     */
    public @Nonnull EnumSet<Permission> getPermissions() {
        return this.member.getPermissions();
    }

    /**
     * @see Member#getPermissions(GuildChannel)
     */
    public @Nonnull EnumSet<Permission> getPermissions(@Nonnull GuildChannel channel) {
        return this.member.getPermissions(channel);
    }


    public @Nonnull Set<Permission> getPermissions(@Nonnull IPermissionContainer channel) {
        return this.member.getPermissions(channel);
    }

    /**
     * @see Member#getPermissionsExplicit()
     */
    public @Nonnull EnumSet<Permission> getPermissionsExplicit() {
        return this.member.getPermissionsExplicit();
    }

    /**
     * @see Member#getPermissionsExplicit(GuildChannel)
     */
    public @Nonnull EnumSet<Permission> getPermissionsExplicit(@Nonnull GuildChannel channel) {
        return this.member.getPermissionsExplicit(channel);
    }

    public @Nonnull Set<Permission> getPermissionsExplicit(@Nonnull IPermissionContainer channel) {
        return this.member.getPermissionsExplicit(channel);
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

    public boolean hasPermission(@Nonnull IPermissionContainer channel,
            @Nonnull Permission... permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    public boolean hasPermission(@Nonnull IPermissionContainer channel,
            @Nonnull Collection<Permission> permissions) {
        return this.member.hasPermission(channel, permissions);
    }

    /**
     * @see Member#hasAccess(GuildChannel)
     */
    @Override
    public boolean hasAccess(@Nonnull GuildChannel channel) {
        return this.member.hasAccess(channel);
    }

    @Override
    public boolean canSync(@Nonnull IPermissionContainer targetChannel,
            @Nonnull IPermissionContainer syncSource) {
        return false;
    }

    @Override
    public boolean canSync(@Nonnull IPermissionContainer channel) {
        return false;
    }

    public boolean hasAccess(@Nonnull IPermissionContainer channel) {
        return this.member.hasAccess(channel);
    }

    /**
     * @see Member#hasPermission(Permission...)
     */
    public boolean hasPermission(@Nonnull Permission permission) {
        return this.member.hasPermission(permission);
    }

    /**
     * The time this Member will be released from time out. <br>
     * If this Member is not in time out, this returns {@code null}. This may also return dates in
     * the past, in which case the time out has expired.
     *
     * @return The time this Member will be released from time out or {@code null} if not in time
     *         out
     */
    @Nullable
    public OffsetDateTime getTimeOutEnd() {
        return this.member.getTimeOutEnd();
    }

    /**
     * Whether this Member is in time out. <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * @return True, if this Member is in time out
     */
    public boolean isTimedOut() {
        return this.member.isTimedOut();
    }

    /**
     * Puts this Member in time out in this {@link Guild Guild} for a specific amount of time. <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * <p>
     * Possible {@link net.dv8tion.jda.api.requests.ErrorResponse ErrorResponses} caused by the
     * returned {@link net.dv8tion.jda.api.requests.RestAction RestAction} include the following:
     * <ul>
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#MISSING_PERMISSIONS
     * MISSING_PERMISSIONS} <br>
     * The target Member cannot be put into time out due to a permission discrepancy</li>
     *
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param amount The amount of the provided {@link TimeUnit unit} to put this Member in time out
     *        for
     * @param unit The {@link TimeUnit Unit} type of {@code amount}
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws net.dv8tion.jda.api.exceptions.InsufficientPermissionException If the logged in
     *         account does not have the {@link Permission#MODERATE_MEMBERS} permission.
     * @throws IllegalArgumentException If any of the following checks are true
     *         <ul>
     *         <li>The provided {@code amount} is lower than or equal to {@code 0}</li>
     *         <li>The provided {@code unit} is null</li>
     *         <li>The provided {@code amount} with the {@code unit} results in a date that is more
     *         than {@value MAX_TIME_OUT_LENGTH} days in the future</li>
     *         </ul>
     */
    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> timeoutFor(long amount, @Nonnull TimeUnit unit) {
        return this.member.timeoutFor(amount, unit);
    }

    /**
     * Puts this Member in time out in this {@link Guild Guild} for a specific amount of time. <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * <p>
     * Possible {@link net.dv8tion.jda.api.requests.ErrorResponse ErrorResponses} caused by the
     * returned {@link net.dv8tion.jda.api.requests.RestAction RestAction} include the following:
     * <ul>
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#MISSING_PERMISSIONS
     * MISSING_PERMISSIONS} <br>
     * The target Member cannot be put into time out due to a permission discrepancy</li>
     *
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param duration The duration to put this Member in time out for
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws net.dv8tion.jda.api.exceptions.InsufficientPermissionException If the logged in
     *         account does not have the {@link Permission#MODERATE_MEMBERS} permission.
     * @throws IllegalArgumentException If any of the following checks are true
     *         <ul>
     *         <li>The provided {@code duration} is null</li>
     *         <li>The provided {@code duration} is not positive</li>
     *         <li>The provided {@code duration} results in a date that is more than
     *         {@value MAX_TIME_OUT_LENGTH} days in the future</li>
     *         </ul>
     */
    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> timeoutFor(@Nonnull Duration duration) {
        return this.member.timeoutFor(duration);
    }

    /**
     * Puts this Member in time out in this {@link Guild Guild} until the specified date. <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * <p>
     * Possible {@link net.dv8tion.jda.api.requests.ErrorResponse ErrorResponses} caused by the
     * returned {@link net.dv8tion.jda.api.requests.RestAction RestAction} include the following:
     * <ul>
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#MISSING_PERMISSIONS
     * MISSING_PERMISSIONS} <br>
     * The target Member cannot be put into time out due to a permission discrepancy</li>
     *
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param temporal The time this Member will be released from time out, or null to remove the
     *        time out
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws net.dv8tion.jda.api.exceptions.InsufficientPermissionException If the logged in
     *         account does not have the {@link Permission#MODERATE_MEMBERS} permission.
     * @throws IllegalArgumentException If any of the following checks are true
     *         <ul>
     *         <li>The provided {@code temporal} is in the past</li>
     *         <li>The provided {@code temporal} is more than {@value MAX_TIME_OUT_LENGTH} days in
     *         the future</li>
     *         </ul>
     */
    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> timeoutUntil(@Nullable TemporalAccessor temporal) {
        return this.member.timeoutUntil(temporal);
    }

    /**
     * Removes a time out from this Member in this {@link Guild Guild}.
     *
     * <p>
     * Possible {@link net.dv8tion.jda.api.requests.ErrorResponse ErrorResponses} caused by the
     * returned {@link net.dv8tion.jda.api.requests.RestAction RestAction} include the following:
     * <ul>
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#MISSING_PERMISSIONS
     * MISSING_PERMISSIONS} <br>
     * The time out cannot be removed due to a permission discrepancy</li>
     *
     * <li>{@link net.dv8tion.jda.api.requests.ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws net.dv8tion.jda.api.exceptions.InsufficientPermissionException If the logged in
     *         account does not have the {@link Permission#MODERATE_MEMBERS} permission.
     */
    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> removeTimeout() {
        return getGuild().removeTimeout(this.member());
    }

    @Nonnull
    @Override
    public String getAsMention() {
        return this.member.getAsMention();
    }


    @Override
    public long getIdLong() {
        return this.member.getIdLong();
    }

    public boolean isDeafened() {
        return Objects.requireNonNull(this.member.getVoiceState()).isDeafened();
    }

    @NotNull
    @Override
    public OffsetDateTime getTimeCreated() {
        return this.member.getTimeCreated();
    }

    public String toString() {
        return this.member.toString();
    }
}
