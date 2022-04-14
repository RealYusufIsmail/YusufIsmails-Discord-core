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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.util.Verify;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.callback.YReplyCallback;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.dv8tion.jda.annotations.Incubating;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Represents a Guild-specific User.
 *
 * <p>
 * Contains all guild-specific information about a User. (Roles, Nickname, VoiceStatus etc.)
 *
 * @since 3.0
 *
 * @see YGuild#getMember(User)
 * @see YGuild#getMemberCache()
 * @see YGuild#getMemberById(long)
 * @see YGuild#getMemberByTag(String)
 * @see YGuild#getMemberByTag(String, String)
 * @see YGuild#getMembersByEffectiveName(String, boolean)
 * @see YGuild#getMembersByName(String, boolean)
 * @see YGuild#getMembersByNickname(String, boolean)
 * @see YGuild#getMembersWithRoles(Role...)
 * @see YGuild#getMembers()
 */
@SuppressWarnings("unused")
@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public record YMember(Member member) {
    /**
     * Maximum number of days a Member can be timed out for
     */
    private static final int MAX_TIME_OUT_LENGTH = 28;

    public static @NotNull YMember from(Member member) {
        Checks.notNull(member, "Member");
        return new YMember(member);
    }

    @Contract(" -> new")
    public @Nonnull YUser getUser() {
        return new YUser(member.getUser());
    }

    /**
     * @see Member#canInteract(Role)
     */
    public boolean canInteract(@Nonnull Role role) {
        return member.canInteract(role);
    }

    /**
     * @see Member#getGuild()
     */
    public @Nonnull YGuild getGuild() {
        return new YGuild(member.getGuild());
    }

    /**
     * The JDA instance.
     *
     * @return The current JDA instance.
     */
    @NotNull
    public JDA getJDA() {
        return member.getJDA();
    }

    /**
     * @see Member#getTimeJoined()
     */
    public @Nonnull OffsetDateTime getTimeJoined() {
        return member.getTimeJoined();
    }

    /**
     * @see Member#hasTimeJoined
     */
    public boolean hasTimeJoined() {
        return member.hasTimeJoined();
    }

    /**
     * @see Member#getTimeBoosted()
     */
    @Nullable
    public OffsetDateTime getTimeBoosted() {
        return member.getTimeBoosted();
    }

    /**
     * Returns whether a member is boosting the guild or not.
     *
     * @return True, if it is boosting
     */

    public boolean isBoosting() {
        return false;
    }

    /**
     * @see Member#getVoiceState()
     */
    @Nullable
    public GuildVoiceState getVoiceState() {
        return member.getVoiceState();
    }

    /**
     * @see Member#getActivities()
     */
    public @Nonnull List<Activity> getActivities() {
        return member.getActivities();
    }

    /**
     * @see Member#getOnlineStatus()
     */
    public @Nonnull OnlineStatus getOnlineStatus() {
        return member.getOnlineStatus();
    }

    /**
     * @see Member#getOnlineStatus(ClientType)
     */
    public @Nonnull OnlineStatus getOnlineStatus(@Nonnull ClientType type) {
        return member.getOnlineStatus(type);
    }

    /**
     * @see Member#getActiveClients()
     */
    public @Nonnull Set<ClientType> getActiveClients() {
        return member.getActiveClients();
    }

    /**
     * @see Member#getNickname()
     */
    @Nullable
    public String getNickname() {
        return member.getNickname();
    }

    /**
     * @see Member#getAvatarId()
     */
    public @org.jetbrains.annotations.Nullable String getAvatarId() {
        return member.getAvatarId();
    }

    /**
     * @see Member#getAvatarUrl()
     */
    @Nullable
    public String getAvatarUrl() {
        return member.getAvatarUrl();
    }

    /**
     * @see Member#getEffectiveAvatarUrl()
     */
    public @Nonnull String getEffectiveAvatarUrl() {
        return member.getEffectiveAvatarUrl();
    }

    /**
     * @see Member#getRoles()
     */
    public @Nonnull List<Role> getRoles() {
        return member.getRoles();
    }

    /**
     * @see Member#getColor()
     */
    @Nullable
    public Color getColor() {
        return member.getColor();
    }

    /**
     * @see Member#getColorRaw()
     */
    public int getColorRaw() {
        return member.getColorRaw();
    }

    /**
     * @see Member#canInteract(Member)
     */
    public boolean canInteract(@Nonnull Member member) {
        return member.canInteract(member);
    }

    /**
     * @see Member#canInteract(Member)
     */
    public boolean canInteract(@Nonnull YMember member) {
        return member.canInteract(member.member());
    }

    /**
     * @see Member#canInteract(Emote)
     */
    public boolean canInteract(@Nonnull Emote emote) {
        return member.canInteract(emote);
    }

    /**
     * @see Member#isOwner()
     */
    public boolean isOwner() {
        return member.isOwner();
    }

    /**
     * @see Member#isPending()
     */
    @Incubating
    public boolean isPending() {
        return member.isPending();
    }

    /**
     * @see Member#getDefaultChannel()
     */
    @Nullable
    public BaseGuildMessageChannel getDefaultChannel() {
        return member.getDefaultChannel();
    }

    /**
     * @see Member#ban(int)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(int delDays) {
        return member.ban(delDays);
    }

    /**
     * @see Member#ban(int, String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(int delDays, @Nullable String reason) {
        return member.ban(delDays, reason);
    }

    /**
     * @see Member#kick()
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick() {
        return member.kick();
    }

    /**
     * @see Member#kick(String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(String reason) {
        return member.kick(reason);
    }

    /**
     * @see Member#mute(boolean)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(boolean mute) {
        return member.mute(mute);
    }

    /**
     * @see Member#deafen(boolean)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> deafen(boolean deafen) {
        return member.deafen(deafen);
    }

    /**
     * @see Member#modifyNickname(String)
     */
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> modifyNickname(@Nullable String nickname) {
        return member.modifyNickname(nickname);
    }

    /**
     * @see Member#getEffectiveName() ()
     */
    public @Nonnull String getName() {
        return member.getEffectiveName();
    }

    /**
     * @see Member
     */
    public Member getAuthor() {
        return member;
    }

    /**
     * @see Member#getId()
     */
    public @Nonnull String getMemberId() {
        return member.getId();
    }

    /**
     * @see Member#getIdLong()
     */
    public @Nonnull Long getMemberIdLong() {
        return member.getIdLong();
    }

    /**
     * @see Member#getPermissions()
     */
    public @Nonnull Set<Permission> getPermissions() {
        return member.getPermissions();
    }

    /**
     * @see Member#getPermissions(GuildChannel)
     */
    public @Nonnull Set<Permission> getPermissions(@Nonnull GuildChannel channel) {
        return member.getPermissions(channel);
    }


    public @Nonnull Set<Permission> getPermissions(@Nonnull IPermissionContainer channel) {
        return member.getPermissions(channel);
    }

    /**
     * @see Member#getPermissionsExplicit()
     */
    public @Nonnull Set<Permission> getPermissionsExplicit() {
        return member.getPermissionsExplicit();
    }

    /**
     * @see Member#getPermissionsExplicit(GuildChannel)
     */
    public @Nonnull Set<Permission> getPermissionsExplicit(@Nonnull GuildChannel channel) {
        return member.getPermissionsExplicit(channel);
    }

    public @Nonnull Set<Permission> getPermissionsExplicit(@Nonnull IPermissionContainer channel) {
        return member.getPermissionsExplicit(channel);
    }

    /**
     * @see Member#hasPermission(Permission...)
     */
    public boolean hasPermission(@Nonnull Permission... permissions) {
        return member.hasPermission(permissions);
    }

    /**
     * @see Member#hasPermission(Collection)
     */
    public boolean hasPermission(@Nonnull Collection<Permission> permissions) {
        return member.hasPermission(permissions);
    }

    /**
     * @see Member#hasPermission(GuildChannel, Permission...)
     */
    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Permission... permissions) {
        return member.hasPermission(channel, permissions);
    }

    /**
     * @see Member#hasPermission(GuildChannel, Collection)
     */
    public boolean hasPermission(@Nonnull GuildChannel channel,
            @Nonnull Collection<Permission> permissions) {
        return member.hasPermission(channel, permissions);
    }

    public boolean hasPermission(@Nonnull IPermissionContainer channel,
            @Nonnull Permission... permissions) {
        return member.hasPermission(channel, permissions);
    }

    public boolean hasPermission(@Nonnull IPermissionContainer channel,
            @Nonnull Collection<Permission> permissions) {
        return member.hasPermission(channel, permissions);
    }

    /**
     * @see Member#hasAccess(GuildChannel)
     */
    public boolean hasAccess(@Nonnull GuildChannel channel) {
        return member.hasAccess(channel);
    }

    public boolean canSync(@Nonnull IPermissionContainer targetChannel,
            @Nonnull IPermissionContainer syncSource) {
        return member.canSync(targetChannel, syncSource);
    }

    public boolean canSync(@Nonnull IPermissionContainer channel) {
        return member.canSync(channel);
    }

    public boolean hasAccess(@Nonnull IPermissionContainer channel) {
        return member.hasAccess(channel);
    }

    /**
     * @see Member#hasPermission(Permission...)
     */
    public boolean hasPermission(@Nonnull Permission permission) {
        return member.hasPermission(permission);
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
        return member.getTimeOutEnd();
    }

    /**
     * Whether this Member is in time out. <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * @return True, if this Member is in time out
     */
    public boolean isTimedOut() {
        return member.isTimedOut();
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
        return member.timeoutFor(amount, unit);
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
        return member.timeoutFor(duration);
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
        return member.timeoutUntil(temporal);
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
        return getGuild().removeTimeout(member());
    }

    @Nonnull
    public String getAsMention() {
        return member.getAsMention();
    }


    public long getIdLong() {
        return member.getIdLong();
    }

    public boolean isDeafened() {
        return Objects.requireNonNull(member.getVoiceState()).isDeafened();
    }

    @NotNull
    public OffsetDateTime getTimeCreated() {
        return member.getTimeCreated();
    }

    public @NotNull AudioManager getAudioManager() {
        return member.getGuild().getAudioManager();
    }

    public boolean isInVc() {
        return Objects.requireNonNull(member.getVoiceState()).inAudioChannel();
    }

    public void joinVc(@NotNull YReplyCallback callback) {
        Verify.isInVc(this, callback);
        getAudioManager()
            .openAudioConnection(Objects.requireNonNull(this.getVoiceState()).getChannel());
    }

    public void leaveVc(@NotNull YReplyCallback callback) {
        Verify.isInVc(this, callback);
        getAudioManager().closeAudioConnection();
    }

    public void joinVc(@NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager()
            .openAudioConnection(Objects.requireNonNull(this.getVoiceState()).getChannel());
    }

    public void leaveVc(@NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().closeAudioConnection();
    }

    public void joinVc(@NotNull YMember member, @NotNull YReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().openAudioConnection(member.getVoiceState().getChannel());
    }

    public void leaveVc(@NotNull YMember member, @NotNull YReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().closeAudioConnection();
    }

    public void joinVc(@NotNull Member member, @NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().openAudioConnection(member.getVoiceState().getChannel());
    }

    public void leaveVc(@NotNull Member member, @NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().closeAudioConnection();
    }

    public void deafen(@NotNull YReplyCallback callback) {
        Verify.isInVc(this, callback);
        getAudioManager().setSelfDeafened(true);
    }

    public void deafen(@NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().setSelfDeafened(true);
    }

    public void mute(@NotNull YReplyCallback callback) {
        Verify.isInVc(this, callback);
        getAudioManager().setSelfMuted(true);
    }

    public void mute(@NotNull IReplyCallback callback) {
        Verify.isInVc(member, callback);
        getAudioManager().setSelfMuted(true);
    }
}
