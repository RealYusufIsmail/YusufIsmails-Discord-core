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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.utility.PermissionChecker;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YSlashCommandInteractionEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.templates.Template;
import net.dv8tion.jda.api.events.guild.member.GenericGuildMemberEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.managers.GuildManager;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.*;
import net.dv8tion.jda.api.requests.restaction.order.CategoryOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.ChannelOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.OrderAction;
import net.dv8tion.jda.api.requests.restaction.order.RoleOrderAction;
import net.dv8tion.jda.api.requests.restaction.pagination.AuditLogPaginationAction;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.TimeUtil;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.cache.MemberCacheView;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;
import net.dv8tion.jda.api.utils.cache.SortedSnowflakeCacheView;
import net.dv8tion.jda.api.utils.concurrent.Task;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("unused")
@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public record YGuild(Guild guild) {
    private static final Integer REASON_MAX_LENGTH = 512;

    @Contract(value = " -> new", pure = true)
    public @Nonnull PermissionChecker getPermissionChecker() {
        return new PermissionChecker(guild);
    }

    public @Nonnull String getGuildId() {
        return guild.getId();
    }

    public @Nonnull Long getGuildIdLong() {
        return guild.getIdLong();
    }

    public @Nonnull String getGuildName() {
        return guild.getName();
    }

    /**
     * @see Guild#retrieveCommands()
     */
    @CheckReturnValue
    public @Nonnull RestAction<List<Command>> retrieveCommands() {
        return guild.retrieveCommands();
    }

    /**
     * @see Guild#retrieveCommandById(String)
     */
    @CheckReturnValue
    public @Nonnull RestAction<Command> retrieveCommandById(@Nonnull String commandId) {
        return guild.retrieveCommandById(commandId);
    }

    /**
     * @see Guild#retrieveCommandById(long)
     */
    @CheckReturnValue
    public @Nonnull RestAction<Command> retrieveCommandById(long commandId) {
        return guild.retrieveCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Command> upsertCommand(@Nonnull CommandData command) {
        return guild.upsertCommand(command);
    }

    @CheckReturnValue
    public @Nonnull CommandCreateAction upsertCommand(@Nonnull String name,
            @Nonnull String description) {
        return guild.upsertCommand(name, description);
    }

    @CheckReturnValue
    public @Nonnull CommandListUpdateAction updateCommands() {
        return guild.updateCommands();
    }

    @CheckReturnValue
    public @Nonnull CommandEditAction editCommandById(@Nonnull String commandId) {
        return guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull CommandEditAction editCommandById(long commandId) {
        return guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Void> deleteCommandById(@Nonnull String commandId) {
        return guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Void> deleteCommandById(long commandId) {
        return guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            @Nonnull String commandId) {
        return guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            long commandId) {
        return guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Map<String, List<CommandPrivilege>>> retrieveCommandPrivileges() {
        return guild.retrieveCommandPrivileges();
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull CommandPrivilege... privileges) {
        return guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull CommandPrivilege... privileges) {
        return guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Map<String, List<CommandPrivilege>>> updateCommandPrivileges(
            @Nonnull Map<String, ? extends Collection<CommandPrivilege>> privileges) {
        return guild.updateCommandPrivileges(privileges);
    }

    /**
     * Retrieves the available regions for this Guild <br>
     * Shortcut for {@link #retrieveRegions(boolean) retrieveRegions(true)} <br>
     * This will include deprecated voice regions by default.
     *
     * @return {@link RestAction RestAction} - Type {@link EnumSet EnumSet}
     */
    @NotNull
    public RestAction<EnumSet<Region>> retrieveRegions() {
        return guild.retrieveRegions();
    }

    @Nonnull
    public RestAction<EnumSet<Region>> retrieveRegions(boolean includeDeprecated) {
        return guild.retrieveRegions(includeDeprecated);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull String userId) {
        return guild.addMember(accessToken, userId);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull User user) {
        return guild.addMember(accessToken, user);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull YUser user) {
        return guild.addMember(accessToken, user.user());
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, long userId) {
        return guild.addMember(accessToken, userId);
    }

    public boolean isLoaded() {
        return false;
    }

    public void pruneMemberCache() {
        guild.pruneMemberCache();
    }

    public boolean unloadMember(long userId) {
        return guild.unloadMember(userId);
    }

    public int getMemberCount() {
        return guild.getMemberCount();
    }

    public @Nonnull String getName() {
        return guild.getName();
    }

    @Nullable
    public String getIconId() {
        return guild.getIconId();
    }

    @Nullable
    public String getIconUrl() {
        return guild.getIconUrl();
    }

    public @Nonnull Set<String> getFeatures() {
        return guild.getFeatures();
    }

    @Contract(" -> new")
    public @Nonnull YMember getBot() {
        return new YMember(guild.getSelfMember());
    }

    @Contract("_ -> new")
    public @Nonnull YMember getMember(@Nonnull YUser user) {
        return new YMember(guild.getMember(user.user()));
    }

    @Nullable
    String getSplashId() {
        return guild.getSplashId();
    }

    @Nullable
    public String getSplashUrl() {
        return guild.getSplashUrl();
    }

    @Nullable
    public String getVanityCode() {
        return guild.getVanityCode();
    }

    @Nonnull
    public Guild.Timeout getAfkTimeout() {
        return guild.getAfkTimeout();
    }

    public boolean isMember(@Nonnull User user) {
        return guild.isMember(user);
    }

    @Nonnull
    public Member getSelfMember() {
        return guild.getSelfMember();
    }

    @Nonnull
    public Guild.NSFWLevel getNSFWLevel() {
        return guild.getNSFWLevel();
    }

    @Nonnull
    public YMember getMember(@Nonnull User user) {
        return new YMember(guild.getMember(user));
    }

    @Nonnull
    public MemberCacheView getMemberCache() {
        return guild.getMemberCache();
    }

    @Contract("_ -> new")
    public @NotNull YMember getMemberById(long id) {
        return new YMember(guild.getMemberById(id));
    }

    @Contract("_ -> new")
    public @NotNull YMember getMemberById(@NotNull String id) {
        return new YMember(guild.getMemberById(id));
    }

    @Contract("_ -> new")
    public @NotNull YMember getMemberByTag(@NotNull String tag) {
        return new YMember(guild.getMemberByTag(tag));
    }

    @Contract("_, _ -> new")
    public @NotNull YMember getMemberByTag(@NotNull String tag, @NotNull String discriminator) {
        return new YMember(guild.getMemberByTag(tag, discriminator));
    }

    public List<YMember> getMembersByEffectiveName(@NotNull String name, boolean ignoreCase) {
        return guild.getMembersByEffectiveName(name, ignoreCase)
            .stream()
            .map(YMember::new)
            .toList();
    }

    public List<YMember> getMembersByName(@NotNull String name, boolean ignoreCase) {
        return guild.getMembersByName(name, ignoreCase).stream().map(YMember::new).toList();
    }

    public List<YMember> getMembersByNickname(String nickname, boolean ignoreCase) {
        return guild.getMembersByNickname(nickname, ignoreCase).stream().map(YMember::new).toList();
    }

    public List<YMember> getMembersWithRoles(Role... roles) {
        return guild.getMembersWithRoles(roles).stream().map(YMember::new).toList();
    }

    /**
     * Gets a list of {@link Member Members} that have all provided {@link Role Roles}. <br>
     * If there are no {@link Member Members} with all provided roles, then this returns an empty
     * list.
     *
     * <p>
     * This will only check cached members! <br>
     * See {@link MemberCachePolicy MemberCachePolicy}
     *
     * @param roles The {@link Role Roles} that a {@link Member Member} must have to be included in
     *        the returned list.
     * @return Possibly-empty immutable list of Members with all provided Roles.
     * @throws IllegalArgumentException If a provided {@link Role Role} is from a different guild or
     *         null.
     * @see #findMembersWithRoles(Collection)
     */
    @NotNull
    public List<Member> getMembersWithRoles(@NotNull Collection<Role> roles) {
        return guild.getMembersWithRoles(roles);
    }

    public List<YMember> getMembers() {
        return guild.getMembers().stream().map(YMember::new).toList();
    }

    @Nullable
    public String getVanityUrl() {
        return guild.getVanityUrl();
    }

    @CheckReturnValue
    public @Nonnull RestAction<VanityInvite> retrieveVanityInvite() {
        return guild.retrieveVanityInvite();
    }

    @Nullable
    public String getDescription() {
        return guild.getDescription();
    }

    @Nonnull
    public Locale getLocale() {
        return guild.getLocale();
    }

    @Nullable
    public String getBannerId() {
        return guild.getBannerId();
    }

    /**
     * The guild banner url. <br>
     * This is shown in guilds below the guild name.
     *
     * <p>
     * The banner can be modified using {@link GuildManager#setBanner(Icon)}.
     *
     * @return The guild banner url or null
     * @since 4.0.0
     */
    @org.jetbrains.annotations.Nullable
    public String getBannerUrl() {
        return guild.getBannerUrl();
    }

    @Nonnull
    public Guild.BoostTier getBoostTier() {
        return guild.getBoostTier();
    }

    public int getBoostCount() {
        return guild.getBoostCount();
    }

    public @Nonnull AuditableRestAction<Void> changeUserNickname(@Nonnull Member member,
            String nickname) {
        return guild.modifyNickname(member, nickname);
    }

    public @Nonnull AuditableRestAction<Void> changeUserNickname(@Nonnull YMember member,
            String nickname) {
        return guild.modifyNickname(member.member(), nickname);
    }

    // start of moderation commands
    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull User user, String reason) {
        return guild.unban(user).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull User user) {
        return guild.unban(user);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull String userId) {
        return guild.unban(userId);
    }

    @Nonnull
    public AuditableRestAction<Void> unBan(@Nonnull Long userId) {
        return guild.unban(User.fromId(userId));
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull YUser user, String reason) {
        return guild.unban(user.user()).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull YUser user) {
        return guild.unban(user.user());
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YMember member) {
        return guild.ban(member.member(), 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YMember member, String reason) {
        return guild.ban(member.member(), 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YMember member, int days,
            String reason) {
        return guild.ban(member.member(), days, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member) {
        return guild.ban(member, 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member, String reason) {
        return guild.ban(member, 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member, int days, String reason) {
        return guild.ban(member, days, reason);
    }

    /**
     * Bans the {@link Member Member} and deletes messages sent by the user based on the amount of
     * delDays. <br>
     * If you wish to ban a member without deleting any messages, provide delDays with a value of 0.
     *
     * <p>
     * You can unban a user with {@link Guild#unban(User) Guild.unban(User)}.
     *
     * <p>
     * <b>Note:</b> {@link Guild#getMembers()} will still contain the {@link Member Member} until
     * Discord sends the {@link GuildMemberRemoveEvent GuildMemberRemoveEvent}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be banned due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param member The {@link Member Member} to ban.
     * @param delDays The history of messages, in days, that will be deleted.
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot ban the other user due to
     *         permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the provided amount of days (delDays) is less than 0.</li>
     *         <li>If the provided amount of days (delDays) is bigger than 7.</li>
     *         <li>If the provided member is {@code null}</li>
     *         </ul>
     */
    @NotNull
    public AuditableRestAction<Void> ban(@NotNull Member member, int delDays) {
        return guild.ban(member, delDays);
    }

    /**
     * Bans the {@link Member Member} and deletes messages sent by the user based on the amount of
     * delDays. <br>
     * If you wish to ban a member without deleting any messages, provide delDays with a value of 0.
     *
     * <p>
     * You can unban a user with {@link Guild#unban(User) Guild.unban(User)}.
     *
     * <p>
     * <b>Note:</b> {@link Guild#getMembers()} will still contain the {@link Member Member} until
     * Discord sends the {@link GuildMemberRemoveEvent GuildMemberRemoveEvent}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be banned due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param user The {@link User User} to ban.
     * @param delDays The history of messages, in days, that will be deleted.
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot ban the other user due to
     *         permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the provided amount of days (delDays) is less than 0.</li>
     *         <li>If the provided amount of days (delDays) is bigger than 7.</li>
     *         <li>If the provided user is {@code null}</li>
     *         </ul>
     */
    @NotNull
    public AuditableRestAction<Void> ban(@NotNull User user, int delDays) {
        return guild.ban(user, delDays);
    }

    /**
     * Bans the user specified by the userId and deletes messages sent by the user based on the
     * amount of delDays. <br>
     * If you wish to ban a user without deleting any messages, provide delDays with a value of 0.
     *
     * <p>
     * You can unban a user with {@link Guild#unban(User) Guild.unban(User)}.
     *
     * <p>
     * <b>Note:</b> {@link Guild#getMembers()} will still contain the {@link User User's}
     * {@link Member Member} object (if the User was in the Guild) until Discord sends the
     * {@link GuildMemberRemoveEvent GuildMemberRemoveEvent}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be banned due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param userId The id of the {@link User User} to ban.
     * @param delDays The history of messages, in days, that will be deleted.
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot ban the other user due to
     *         permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the provided amount of days (delDays) is less than 0.</li>
     *         <li>If the provided amount of days (delDays) is bigger than 7.</li>
     *         <li>If the provided userId is {@code null}</li>
     *         </ul>
     */
    @NotNull
    public AuditableRestAction<Void> ban(@NotNull String userId, int delDays) {
        return guild.ban(userId, delDays);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user) {
        return guild.ban(user, 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user, String reason) {
        return guild.ban(user, 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user, int days, String reason) {
        return guild.ban(user, days, reason);
    }

    @Nonnull
    public AuditableRestAction<Void> ban(@Nonnull String userId, int delDays,
            @Nullable String reason) {
        return guild.ban(userId, delDays, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YUser user) {
        return guild.ban(user.user(), 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YUser user, String reason) {
        return guild.ban(user.user(), 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YUser user, int days, String reason) {
        return guild.ban(user.user(), days, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull YMember member) {
        return guild.kick(member.member(), null);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull YMember member, String reason) {
        return guild.kick(member.member(), reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull Member user) {
        return guild.kick(user, null);
    }

    /**
     * Kicks the {@link Member Member} specified by the userId from the {@link Guild Guild}.
     *
     * <p>
     * <b>Note:</b> {@link Guild#getMembers()} will still contain the {@link User User} until
     * Discord sends the {@link GuildMemberRemoveEvent GuildMemberRemoveEvent}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be kicked due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param userId The id of the {@link User User} to kick from the {@link Guild Guild}.
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#KICK_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot kick the other member due to
     *         permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     * @throws IllegalArgumentException If the userId provided does not correspond to a Member in
     *         this Guild or the provided {@code userId} is blank/null.
     */
    @NotNull
    public AuditableRestAction<Void> kick(@NotNull String userId) {
        return guild.kick(userId);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull Member member, String reason) {
        return guild.kick(member, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull String userId, String reason) {
        return guild.kick(userId, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(@Nonnull Member member, Boolean mute,
            String reason) {
        return guild.mute(member, mute).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(@Nonnull YMember member, Boolean mute,
            String reason) {
        return guild.mute(member.member(), mute).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull Member member,
            @Nonnull Role role) {
        return guild.addRoleToMember(member, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull YMember member,
            @Nonnull Role role) {
        return guild.addRoleToMember(member.member(), role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(long userId, @Nonnull Role role) {
        return guild.addRoleToMember(userId, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull String userId,
            @Nonnull Role role) {
        return guild.addRoleToMember(userId, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull Member member,
            @Nonnull Role role) {
        return guild.removeRoleFromMember(member, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull YMember member,
            @Nonnull Role role) {
        return guild.removeRoleFromMember(member.member(), role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull String userId,
            @Nonnull Role role) {
        return guild.removeRoleFromMember(userId, role);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyMemberRoles(@Nonnull Member member,
            @Nullable Collection<Role> rolesToAdd, @Nullable Collection<Role> rolesToRemove) {
        return guild.modifyMemberRoles(member, rolesToAdd, rolesToRemove);
    }

    /**
     * Modifies the complete {@link Role Role} set of the specified {@link Member Member} <br>
     * The provided roles will replace all current Roles of the specified Member.
     *
     * <h1>Warning</h1> <b>This may <u>not</u> be used together with any other role
     * add/remove/modify methods for the same Member within one event listener cycle! The changes
     * made by this require cache updates which are triggered by lifecycle events which are received
     * later. This may only be called again once the specific Member has been updated by a
     * {@link GenericGuildMemberEvent GenericGuildMemberEvent} targeting the same Member.</b>
     *
     * <p>
     * <b>The new roles <u>must not</u> contain the Public Role of the Guild</b>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The Members Roles could not be modified due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The target Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * <h2>Example</h2>
     * 
     * <pre>
     * {@code
     * public static void removeRoles(Member member) {
     *     Guild guild = member.getGuild();
     *     // pass no role, this means we set the roles of the member to an empty array.
     *     guild.modifyMemberRoles(member).queue();
     * }
     * }
     * </pre>
     *
     * @param member A {@link Member Member} of which to override the Roles of
     * @param roles New collection of {@link Role Roles} for the specified Member
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the currently logged in account does not have
     *         {@link Permission#MANAGE_ROLES Permission.MANAGE_ROLES}
     * @throws HierarchyException If the provided roles are higher in the Guild's hierarchy and thus
     *         cannot be modified by the currently logged in account
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If any of the provided arguments is {@code null}</li>
     *         <li>If any of the provided arguments is not from this Guild</li>
     *         <li>If any of the specified {@link Role Roles} is managed</li>
     *         <li>If any of the specified {@link Role Roles} is the {@code Public Role} of this
     *         Guild</li>
     *         </ul>
     * @see #modifyMemberRoles(Member, Collection)
     */
    @NotNull
    public AuditableRestAction<Void> modifyMemberRoles(@NotNull Member member,
            @NotNull Role... roles) {
        return guild.modifyMemberRoles(member, roles);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyMemberRoles(@Nonnull Member member,
            @Nonnull Collection<Role> roles) {
        return guild.modifyMemberRoles(member, roles);
    }

    @Nonnull
    public AuditableRestAction<Void> transferOwnership(@Nonnull Member newOwner) {
        return guild.transferOwnership(newOwner);
    }

    @Nonnull
    public AuditableRestAction<Void> transferOwnership(@Nonnull YMember newOwner) {
        return guild.transferOwnership(newOwner.member());
    }


    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(long userId,
            @Nonnull Role role) {
        return guild.removeRoleFromMember(userId, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Integer> prune(@Nonnull Integer days,
            @Nonnull Role... roles) {
        return guild.prune(days, roles);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Integer> prune(int days, boolean wait, @Nonnull Role... roles) {
        return guild.prune(days, wait, roles);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull YMember member, long amount,
            @Nonnull TimeUnit unit) {
        return guild.timeoutFor(member.member(), amount, unit);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull YMember member,
            @Nonnull Duration duration) {
        return guild.timeoutFor(member.member(), duration);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull YMember member,
            @Nonnull TemporalAccessor temporal) {
        return guild.timeoutUntil(member.member(), temporal);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull Member member, long amount,
            @Nonnull TimeUnit unit) {
        return guild.timeoutFor(member, amount, unit);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull Member member,
            @Nonnull Duration duration) {
        return guild.timeoutFor(member, duration);
    }

    /**
     * Puts the specified Member in time out in this {@link Guild Guild} until the specified date.
     * <br>
     * While a Member is in time out, all permissions except {@link Permission#VIEW_CHANNEL
     * VIEW_CHANNEL} and {@link Permission#MESSAGE_HISTORY MESSAGE_HISTORY} are removed from them.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be put into time out due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param member The member to put in time out
     * @param temporal The time the specified Member will be released from time out or null to
     *        remove the time-out
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MODERATE_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot put a timeout on the other Member
     *         due to permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     * @throws IllegalArgumentException If any of the following are true
     *         <ul>
     *         <li>The provided {@code member} is null</li>
     *         <li>The provided {@code temporal} is in the past</li>
     *         <li>The provided {@code temporal} is more than {@value Member#MAX_TIME_OUT_LENGTH}
     *         days in the future</li>
     *         </ul>
     */
    @NotNull
    public AuditableRestAction<Void> timeoutUntil(@NotNull Member member,
            @NotNull TemporalAccessor temporal) {
        return guild.timeoutUntil(member, temporal);
    }

    @CheckReturnValue
    @Nonnull
    public AuditableRestAction<Void> timeoutFor(@Nonnull Member member,
            @Nonnull TemporalAccessor temporal) {
        return guild.timeoutUntil(member, temporal);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutForById(long userId, long amount,
            @Nonnull TimeUnit unit) {
        return guild.timeoutForById(userId, amount, unit);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutForById(@Nonnull String userId, long amount,
            @Nonnull TimeUnit unit) {
        return guild.timeoutForById(userId, amount, unit);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutForById(long userId,
            @Nonnull Duration duration) {
        return guild.timeoutForById(userId, duration);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutForById(@Nonnull String userId,
            @Nonnull Duration duration) {
        return guild.timeoutForById(userId, duration);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutUntilById(long userId,
            @Nonnull TemporalAccessor temporal) {
        return guild.timeoutUntilById(userId, temporal);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> timeoutUntilById(@Nonnull String userId,
            @Nonnull TemporalAccessor temporal) {
        return guild.timeoutUntilById(userId, temporal);
    }

    /**
     * Removes a time-out from the specified Member in this {@link Guild Guild}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The time out cannot be removed due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     * </ul>
     *
     * @param member The Member to remove a time-out from
     * @return {@link AuditableRestAction AuditableRestAction}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MODERATE_MEMBERS} permission.
     * @throws HierarchyException If the logged in account cannot remove the timeout from the other
     *         Member due to permission hierarchy position. <br>
     *         See {@link Member#canInteract(Member)}
     */
    @NotNull
    public AuditableRestAction<Void> removeTimeout(@NotNull Member member) {
        return guild.removeTimeout(member);
    }

    public @NotNull AuditableRestAction<Void> removeTimeout(@Nonnull YMember member) {
        return guild.removeTimeout(member.member());
    }

    public @NotNull AuditableRestAction<Void> removeTimeoutById(long userId) {
        return guild.removeTimeoutById(userId);
    }

    public @NotNull AuditableRestAction<Void> removeTimeoutById(@Nonnull String userId) {
        return guild.removeTimeoutById(userId);
    }

    // end of moderation commands

    /**
     * Get a channel of the specified type by id.
     *
     * <p>
     * This will automatically check for all channel types and cast to the specified class. If a
     * channel with the specified id does not exist, or exists but is not an instance of the
     * provided class, this returns null.
     *
     * @param type {@link Class} of a channel type
     * @param id The snowflake id of the channel
     * @return The casted channel, if it exists and is assignable to the provided class, or null
     * @throws IllegalArgumentException If null is provided, or the id is not a valid snowflake
     */
    @org.jetbrains.annotations.Nullable
    public <T extends Channel> T getChannelById(@NotNull Class<T> type, @NotNull String id) {
        return guild.getChannelById(type, id);
    }

    /**
     * Get a channel of the specified type by id.
     *
     * <p>
     * This will automatically check for all channel types and cast to the specified class. If a
     * channel with the specified id does not exist, or exists but is not an instance of the
     * provided class, this returns null.
     *
     * @param type {@link Class} of a channel type
     * @param id The snowflake id of the channel
     * @return The casted channel, if it exists and is assignable to the provided class, or null
     * @throws IllegalArgumentException If null is provided
     */
    @org.jetbrains.annotations.Nullable
    public <T extends Channel> T getChannelById(@NotNull Class<T> type, long id) {
        return guild.getChannelById(type, id);
    }

    @Nullable
    public GuildChannel getGuildChannelById(@Nonnull String id) {
        return guild.getGuildChannelById(id);
    }

    @Nullable
    public GuildChannel getGuildChannelById(long id) {
        return guild.getGuildChannelById(id);
    }

    /**
     * Get {@link GuildChannel GuildChannel} for the provided ID.
     *
     * <br>
     * This is meant for systems that use a dynamic {@link ChannelType} and can profit from a simple
     * function to get the channel instance. To get more specific channel types you can use one of
     * the following:
     * <ul>
     * <li>{@link #getTextChannelById(String)}</li>
     * <li>{@link #getVoiceChannelById(String)}</li>
     * <li>{@link #getStoreChannelById(String)}</li>
     * <li>{@link #getCategoryById(String)}</li>
     * </ul>
     *
     * @param type The {@link ChannelType}
     * @param id The ID of the channel
     * @return The GuildChannel or null
     * @throws IllegalArgumentException If the provided ID is null
     * @throws NumberFormatException If the provided ID is not a snowflake
     */
    @org.jetbrains.annotations.Nullable
    public GuildChannel getGuildChannelById(@NotNull ChannelType type, @NotNull String id) {
        return guild.getGuildChannelById(type, id);
    }

    @Nullable
    public GuildChannel getGuildChannelById(@Nonnull ChannelType type, long id) {
        return guild.getGuildChannelById(type, id);
    }

    @Nonnull
    public SortedSnowflakeCacheView<StageChannel> getStageChannelCache() {
        return guild.getStageChannelCache();
    }

    /**
     * Gets a list of all {@link StageChannel StageChannel} in this Guild that have the same name as
     * the one provided. <br>
     * If there are no {@link StageChannel StageChannels} with the provided name, then this returns
     * an empty list.
     *
     * @param name The name used to filter the returned {@link StageChannel StageChannels}.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all StageChannel names that match the provided name.
     */
    @NotNull
    public List<StageChannel> getStageChannelsByName(@NotNull String name, boolean ignoreCase) {
        return guild.getStageChannelsByName(name, ignoreCase);
    }

    /**
     * Gets a {@link StageChannel StageChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getStageChannelById(String)}, but it only
     * checks this specific Guild for a StageChannel. <br>
     * If there is no {@link StageChannel StageChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link StageChannel StageChannel}.
     * @return Possibly-null {@link StageChannel StageChannel} with matching id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     */
    @org.jetbrains.annotations.Nullable
    public StageChannel getStageChannelById(@NotNull String id) {
        return guild.getStageChannelById(id);
    }

    /**
     * Gets a {@link StageChannel StageChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getStageChannelById(long)}, but it only checks
     * this specific Guild for a StageChannel. <br>
     * If there is no {@link StageChannel StageChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link StageChannel StageChannel}.
     * @return Possibly-null {@link StageChannel StageChannel} with matching id.
     */
    @org.jetbrains.annotations.Nullable
    public StageChannel getStageChannelById(long id) {
        return guild.getStageChannelById(id);
    }

    /**
     * Gets all {@link StageChannel StageChannel} in this {@link Guild Guild}. <br>
     * The channels returned will be sorted according to their position.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getStageChannelCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable List of {@link StageChannel StageChannels}.
     */
    @NotNull
    public List<StageChannel> getStageChannels() {
        return guild.getStageChannels();
    }

    @Nonnull
    public SortedSnowflakeCacheView<ThreadChannel> getThreadChannelCache() {
        return guild.getThreadChannelCache();
    }

    /**
     * Gets a list of all {@link ThreadChannel ThreadChannel} in this Guild that have the same name
     * as the one provided. <br>
     * If there are no {@link ThreadChannel ThreadChannels} with the provided name, then this
     * returns an empty list.
     *
     * @param name The name used to filter the returned {@link ThreadChannel ThreadChannels}.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all ThreadChannel names that match the provided
     *         name.
     */
    @NotNull
    public List<ThreadChannel> getThreadChannelsByName(@NotNull String name, boolean ignoreCase) {
        return guild.getThreadChannelsByName(name, ignoreCase);
    }

    /**
     * Gets a {@link ThreadChannel ThreadChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getThreadChannelById(String)}, but it only
     * checks this specific Guild for a ThreadChannel. <br>
     * If there is no {@link ThreadChannel ThreadChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link ThreadChannel ThreadChannel}.
     * @return Possibly-null {@link ThreadChannel ThreadChannel} with matching id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     */
    @org.jetbrains.annotations.Nullable
    public ThreadChannel getThreadChannelById(@NotNull String id) {
        return guild.getThreadChannelById(id);
    }

    /**
     * Gets a {@link ThreadChannel ThreadChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getThreadChannelById(long)}, but it only
     * checks this specific Guild for a ThreadChannel. <br>
     * If there is no {@link ThreadChannel ThreadChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link ThreadChannel ThreadChannel}.
     * @return Possibly-null {@link ThreadChannel ThreadChannel} with matching id.
     */
    @org.jetbrains.annotations.Nullable
    public ThreadChannel getThreadChannelById(long id) {
        return guild.getThreadChannelById(id);
    }

    /**
     * Gets all {@link ThreadChannel ThreadChannel} in this {@link Guild Guild}.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getThreadChannelCache()} and use its more efficient versions of handling these
     * values.
     *
     * @return An immutable List of {@link ThreadChannel ThreadChannels}.
     */
    @NotNull
    public List<ThreadChannel> getThreadChannels() {
        return guild.getThreadChannels();
    }

    /**
     * Gets the {@link Category Category} from this guild that matches the provided id. This method
     * is similar to {@link JDA#getCategoryById(String)}, but it only checks in this specific Guild.
     * <br>
     * If there is no matching {@link Category Category} this returns {@code null}.
     *
     * @param id The snowflake ID of the wanted Category
     * @return Possibly-null {@link Category Category} for the provided ID.
     * @throws IllegalArgumentException If the provided ID is not a valid {@code long}
     */
    @org.jetbrains.annotations.Nullable
    public Category getCategoryById(@NotNull String id) {
        return guild.getCategoryById(id);
    }

    /**
     * Gets the {@link Category Category} from this guild that matches the provided id. This method
     * is similar to {@link JDA#getCategoryById(String)}, but it only checks in this specific Guild.
     * <br>
     * If there is no matching {@link Category Category} this returns {@code null}.
     *
     * @param id The snowflake ID of the wanted Category
     * @return Possibly-null {@link Category Category} for the provided ID.
     */
    @org.jetbrains.annotations.Nullable
    public Category getCategoryById(long id) {
        return guild.getCategoryById(id);
    }

    /**
     * Gets all {@link Category Categories} in this {@link Guild Guild}. <br>
     * The returned categories will be sorted according to their position.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getCategoryCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable list of all {@link Category Categories} in this Guild.
     */
    @NotNull
    public List<Category> getCategories() {
        return guild.getCategories();
    }

    /**
     * Gets a list of all {@link Category Categories} in this Guild that have the same name as the
     * one provided. <br>
     * If there are no matching categories this will return an empty list.
     *
     * @param name The name to check
     * @param ignoreCase Whether to ignore case on name checking
     * @return Immutable list of all categories matching the provided name
     * @throws IllegalArgumentException If the provided name is {@code null}
     */
    @NotNull
    public List<Category> getCategoriesByName(@NotNull String name, boolean ignoreCase) {
        return guild.getCategoriesByName(name, ignoreCase);
    }

    @Nonnull
    public SortedSnowflakeCacheView<Category> getCategoryCache() {
        return guild.getCategoryCache();
    }


    @Nonnull
    public SortedSnowflakeCacheView<TextChannel> getTextChannelCache() {
        return guild.getTextChannelCache();
    }

    /**
     * Gets a {@link NewsChannel NewsChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getNewsChannelById(String)}, but it only
     * checks this specific Guild for a NewsChannel. <br>
     * If there is no {@link NewsChannel NewsChannel} with an id that matches the provided one, then
     * this returns {@code null}.
     *
     * @param id The id of the {@link NewsChannel NewsChannel}.
     * @return Possibly-null {@link NewsChannel NewsChannel} with matching id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     */
    @org.jetbrains.annotations.Nullable
    public NewsChannel getNewsChannelById(@NotNull String id) {
        return guild.getNewsChannelById(id);
    }

    /**
     * Gets a {@link NewsChannel NewsChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getNewsChannelById(long)}, but it only checks
     * this specific Guild for a NewsChannel. <br>
     * If there is no {@link NewsChannel NewsChannel} with an id that matches the provided one, then
     * this returns {@code null}.
     *
     * @param id The id of the {@link NewsChannel NewsChannel}.
     * @return Possibly-null {@link NewsChannel NewsChannel} with matching id.
     */
    @org.jetbrains.annotations.Nullable
    public NewsChannel getNewsChannelById(long id) {
        return guild.getNewsChannelById(id);
    }

    /**
     * Gets all {@link NewsChannel NewsChannels} in this {@link Guild Guild}. <br>
     * The channels returned will be sorted according to their position.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getNewsChannelCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable List of all {@link NewsChannel NewsChannels} in this Guild.
     */
    @NotNull
    public List<NewsChannel> getNewsChannels() {
        return guild.getNewsChannels();
    }

    /**
     * Gets a list of all {@link NewsChannel NewsChannels} in this Guild that have the same name as
     * the one provided. <br>
     * If there are no {@link NewsChannel NewsChannels} with the provided name, then this returns an
     * empty list.
     *
     * @param name The name used to filter the returned {@link NewsChannel NewsChannels}.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all NewsChannels names that match the provided name.
     */
    @NotNull
    public List<NewsChannel> getNewsChannelsByName(@NotNull String name, boolean ignoreCase) {
        return guild.getNewsChannelsByName(name, ignoreCase);
    }

    @Nonnull
    public SortedSnowflakeCacheView<NewsChannel> getNewsChannelCache() {
        return guild.getNewsChannelCache();
    }

    /**
     * Gets a {@link VoiceChannel VoiceChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getVoiceChannelById(String)}, but it only
     * checks this specific Guild for a VoiceChannel. <br>
     * If there is no {@link VoiceChannel VoiceChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link VoiceChannel VoiceChannel}.
     * @return Possibly-null {@link VoiceChannel VoiceChannel} with matching id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     */
    @org.jetbrains.annotations.Nullable
    public VoiceChannel getVoiceChannelById(@NotNull String id) {
        return guild.getVoiceChannelById(id);
    }

    /**
     * Gets a {@link VoiceChannel VoiceChannel} from this guild that has the same id as the one
     * provided. This method is similar to {@link JDA#getVoiceChannelById(long)}, but it only checks
     * this specific Guild for a VoiceChannel. <br>
     * If there is no {@link VoiceChannel VoiceChannel} with an id that matches the provided one,
     * then this returns {@code null}.
     *
     * @param id The id of the {@link VoiceChannel VoiceChannel}.
     * @return Possibly-null {@link VoiceChannel VoiceChannel} with matching id.
     */
    @org.jetbrains.annotations.Nullable
    public VoiceChannel getVoiceChannelById(long id) {
        return guild.getVoiceChannelById(id);
    }

    /**
     * Gets all {@link VoiceChannel VoiceChannels} in this {@link Guild Guild}. <br>
     * The channels returned will be sorted according to their position.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getVoiceChannelCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable List of {@link VoiceChannel VoiceChannels}.
     */
    @NotNull
    public List<VoiceChannel> getVoiceChannels() {
        return guild.getVoiceChannels();
    }

    /**
     * Gets a list of all {@link VoiceChannel VoiceChannels} in this Guild that have the same name
     * as the one provided. <br>
     * If there are no {@link VoiceChannel VoiceChannels} with the provided name, then this returns
     * an empty list.
     *
     * @param name The name used to filter the returned {@link VoiceChannel VoiceChannels}.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all VoiceChannel names that match the provided name.
     */
    @NotNull
    public List<VoiceChannel> getVoiceChannelsByName(@NotNull String name, boolean ignoreCase) {
        return guild.getVoiceChannelsByName(name, ignoreCase);
    }

    @Nonnull
    public SortedSnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
        return guild.getVoiceChannelCache();
    }

    /**
     * Populated list of {@link GuildChannel channels} for this guild. This includes all types of
     * channels, such as category/voice/text. <br>
     * This includes hidden channels by default.
     *
     * <p>
     * The returned list is ordered in the same fashion as it would be by the official discord
     * client.
     * <ol>
     * <li>TextChannel and StoreChannel without parent</li>
     * <li>VoiceChannel without parent</li>
     * <li>StageChannel without parent</li>
     * <li>Categories
     * <ol>
     * <li>TextChannel and StoreChannel with category as parent</li>
     * <li>VoiceChannel with category as parent</li>
     * <li>StageChannel with category as parent</li>
     * </ol>
     * </li>
     * </ol>
     *
     * @return Immutable list of channels for this guild
     * @see #getChannels(boolean)
     */
    @NotNull
    public List<GuildChannel> getChannels() {
        return guild.getChannels();
    }

    @Nonnull
    public List<GuildChannel> getChannels(boolean includeHidden) {
        return guild.getChannels(includeHidden);
    }

    /**
     * Gets a {@link Role Role} from this guild that has the same id as the one provided. <br>
     * If there is no {@link Role Role} with an id that matches the provided one, then this returns
     * {@code null}.
     *
     * @param id The id of the {@link Role Role}.
     * @return Possibly-null {@link Role Role} with matching id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     */
    @org.jetbrains.annotations.Nullable
    public Role getRoleById(@NotNull String id) {
        return guild.getRoleById(id);
    }

    /**
     * Gets a {@link Role Role} from this guild that has the same id as the one provided. <br>
     * If there is no {@link Role Role} with an id that matches the provided one, then this returns
     * {@code null}.
     *
     * @param id The id of the {@link Role Role}.
     * @return Possibly-null {@link Role Role} with matching id.
     */
    @org.jetbrains.annotations.Nullable
    public Role getRoleById(long id) {
        return guild.getRoleById(id);
    }

    /**
     * Gets all {@link Role Roles} in this {@link Guild Guild}. <br>
     * The roles returned will be sorted according to their position. The highest role being at
     * index 0 and the lowest at the last index.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getRoleCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable List of {@link Role Roles}.
     */
    @NotNull
    public List<Role> getRoles() {
        return guild.getRoles();
    }

    /**
     * Gets a list of all {@link Role Roles} in this Guild that have the same name as the one
     * provided. <br>
     * If there are no {@link Role Roles} with the provided name, then this returns an empty list.
     *
     * @param name The name used to filter the returned {@link Role Roles}.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all Role names that match the provided name.
     */
    @NotNull
    public List<Role> getRolesByName(@NotNull String name, boolean ignoreCase) {
        return guild.getRolesByName(name, ignoreCase);
    }

    /**
     * Looks up a role which is the integration role for a bot. <br>
     * These roles are created when the bot requested a list of permission in the authorization URL.
     *
     * <p>
     * To check whether a role is a bot role you can use {@code role.getTags().isBot()} and you can
     * use {@link Role.RoleTags#getBotIdLong()} to check which bot it applies to.
     *
     * <p>
     * This requires {@link CacheFlag#ROLE_TAGS CacheFlag.ROLE_TAGS} to be enabled. See
     * {@link JDABuilder#enableCache(CacheFlag, CacheFlag...) JDABuilder.enableCache(...)}.
     *
     * @param userId The user id of the bot
     * @return The bot role, or null if no role matches
     */
    @org.jetbrains.annotations.Nullable
    public Role getRoleByBot(long userId) {
        return guild.getRoleByBot(userId);
    }

    /**
     * Looks up a role which is the integration role for a bot. <br>
     * These roles are created when the bot requested a list of permission in the authorization URL.
     *
     * <p>
     * To check whether a role is a bot role you can use {@code role.getTags().isBot()} and you can
     * use {@link Role.RoleTags#getBotIdLong()} to check which bot it applies to.
     *
     * <p>
     * This requires {@link CacheFlag#ROLE_TAGS CacheFlag.ROLE_TAGS} to be enabled. See
     * {@link JDABuilder#enableCache(CacheFlag, CacheFlag...) JDABuilder.enableCache(...)}.
     *
     * @param userId The user id of the bot
     * @return The bot role, or null if no role matches
     * @throws IllegalArgumentException If the userId is null or not a valid snowflake
     */
    @org.jetbrains.annotations.Nullable
    public Role getRoleByBot(@NotNull String userId) {
        return guild.getRoleByBot(userId);
    }

    /**
     * Looks up a role which is the integration role for a bot. <br>
     * These roles are created when the bot requested a list of permission in the authorization URL.
     *
     * <p>
     * To check whether a role is a bot role you can use {@code role.getTags().isBot()} and you can
     * use {@link Role.RoleTags#getBotIdLong()} to check which bot it applies to.
     *
     * <p>
     * This requires {@link CacheFlag#ROLE_TAGS CacheFlag.ROLE_TAGS} to be enabled. See
     * {@link JDABuilder#enableCache(CacheFlag, CacheFlag...) JDABuilder.enableCache(...)}.
     *
     * @param user The bot user
     * @return The bot role, or null if no role matches
     * @throws IllegalArgumentException If null is provided
     */
    @org.jetbrains.annotations.Nullable
    public Role getRoleByBot(@NotNull User user) {
        return guild.getRoleByBot(user);
    }

    /**
     * Looks up the role which is the integration role for the currently connected bot (self-user).
     * <br>
     * These roles are created when the bot requested a list of permission in the authorization URL.
     *
     * <p>
     * To check whether a role is a bot role you can use {@code role.getTags().isBot()} and you can
     * use {@link Role.RoleTags#getBotIdLong()} to check which bot it applies to.
     *
     * <p>
     * This requires {@link CacheFlag#ROLE_TAGS CacheFlag.ROLE_TAGS} to be enabled. See
     * {@link JDABuilder#enableCache(CacheFlag, CacheFlag...) JDABuilder.enableCache(...)}.
     *
     * @return The bot role, or null if no role matches
     */
    @org.jetbrains.annotations.Nullable
    public Role getBotRole() {
        return guild.getBotRole();
    }

    /**
     * Looks up the role which is the booster role of this guild. <br>
     * These roles are created when the first user boosts this guild.
     *
     * <p>
     * To check whether a role is a booster role you can use {@code role.getTags().isBoost()}.
     *
     * <p>
     * This requires {@link CacheFlag#ROLE_TAGS CacheFlag.ROLE_TAGS} to be enabled. See
     * {@link JDABuilder#enableCache(CacheFlag, CacheFlag...) JDABuilder.enableCache(...)}.
     *
     * @return The boost role, or null if no role matches
     */
    @org.jetbrains.annotations.Nullable
    public Role getBoostRole() {
        return guild.getBoostRole();
    }

    @Nonnull
    public SortedSnowflakeCacheView<Role> getRoleCache() {
        return guild.getRoleCache();
    }

    /**
     * Gets an {@link Emote Emote} from this guild that has the same id as the one provided. <br>
     * If there is no {@link Emote Emote} with an id that matches the provided one, then this
     * returns {@code null}.
     *
     * <p>
     * <b>Unicode emojis are not included as {@link Emote Emote}!</b>
     *
     * <p>
     * This requires the {@link CacheFlag#EMOTE CacheFlag.EMOTE} to be enabled!
     *
     * @param id the emote id
     * @return An Emote matching the specified Id.
     * @throws NumberFormatException If the provided {@code id} cannot be parsed by
     *         {@link Long#parseLong(String)}
     * @see #retrieveEmoteById(String)
     */
    @org.jetbrains.annotations.Nullable
    public Emote getEmoteById(@NotNull String id) {
        return guild.getEmoteById(id);
    }

    /**
     * Gets an {@link Emote Emote} from this guild that has the same id as the one provided. <br>
     * If there is no {@link Emote Emote} with an id that matches the provided one, then this
     * returns {@code null}.
     *
     * <p>
     * <b>Unicode emojis are not included as {@link Emote Emote}!</b>
     *
     * <p>
     * This requires the {@link CacheFlag#EMOTE CacheFlag.EMOTE} to be enabled!
     *
     * @param id the emote id
     * @return An Emote matching the specified Id.
     * @see #retrieveEmoteById(long)
     */
    @org.jetbrains.annotations.Nullable
    public Emote getEmoteById(long id) {
        return guild.getEmoteById(id);
    }

    /**
     * Gets all custom {@link Emote Emotes} belonging to this {@link Guild Guild}. <br>
     * Emotes are not ordered in any specific way in the returned list.
     *
     * <p>
     * <b>Unicode emojis are not included as {@link Emote Emote}!</b>
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getEmoteCache()} and use its more efficient versions of handling these values.
     *
     * <p>
     * This requires the {@link CacheFlag#EMOTE CacheFlag.EMOTE} to be enabled!
     *
     * @return An immutable List of {@link Emote Emotes}.
     * @see #retrieveEmotes()
     */
    @NotNull
    public List<Emote> getEmotes() {
        return guild.getEmotes();
    }

    /**
     * Gets a list of all {@link Emote Emotes} in this Guild that have the same name as the one
     * provided. <br>
     * If there are no {@link Emote Emotes} with the provided name, then this returns an empty list.
     *
     * <p>
     * <b>Unicode emojis are not included as {@link Emote Emote}!</b>
     *
     * <p>
     * This requires the {@link CacheFlag#EMOTE CacheFlag.EMOTE} to be enabled!
     *
     * @param name The name used to filter the returned {@link Emote Emotes}. Without colons.
     * @param ignoreCase Determines if the comparison ignores case when comparing. True -
     *        case-insensitive.
     * @return Possibly-empty immutable list of all Emotes that match the provided name.
     */
    @NotNull
    public List<Emote> getEmotesByName(@NotNull String name, boolean ignoreCase) {
        return guild.getEmotesByName(name, ignoreCase);
    }

    @Nonnull
    public SnowflakeCacheView<Emote> getEmoteCache() {
        return guild.getEmoteCache();
    }

    @Nonnull
    public RestAction<List<ListedEmote>> retrieveEmotes() {
        return guild.retrieveEmotes();
    }

    @Nonnull
    public RestAction<ListedEmote> retrieveEmoteById(@Nonnull String id) {
        return guild.retrieveEmoteById(id);
    }

    @NotNull
    public RestAction<ListedEmote> retrieveEmoteById(long id) {
        return guild.retrieveEmoteById(id);
    }

    @NotNull
    public RestAction<ListedEmote> retrieveEmote(@NotNull Emote emote) {
        return guild.retrieveEmote(emote);
    }

    @Nonnull
    public RestAction<List<Guild.Ban>> retrieveBanList() {
        return guild.retrieveBanList();
    }

    /**
     * Retrieves a {@link Guild.Ban Ban} of the provided ID <br>
     * If you wish to ban or unban a user, use either {@link #ban(String, int) ban(id, int)} or
     * {@link #unBan(String) unban(id)}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The ban list cannot be fetched due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_BAN UNKNOWN_BAN} <br>
     * Either the ban was removed before finishing the task or it did not exist in the first
     * place</li>
     * </ul>
     *
     * @param userId the id of the banned user
     * @return {@link RestAction RestAction} - Type: {@link Guild.Ban Ban} <br>
     *         An unmodifiable ban object for the user banned from this guild
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     */
    @NotNull
    public RestAction<Guild.Ban> retrieveBanById(long userId) {
        return guild.retrieveBanById(userId);
    }

    @Nonnull
    public RestAction<Guild.Ban> retrieveBanById(@Nonnull String userId) {
        return guild.retrieveBanById(userId);
    }

    /**
     * Retrieves a {@link Guild.Ban Ban} of the provided {@link User User} <br>
     * If you wish to ban or unban a user, use either {@link #ban(User, int) ban(User, int)} or
     * {@link #unBan(User) unban(User)}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The ban list cannot be fetched due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_BAN UNKNOWN_BAN} <br>
     * Either the ban was removed before finishing the task or it did not exist in the first
     * place</li>
     * </ul>
     *
     * @param bannedUser the banned user
     * @return {@link RestAction RestAction} - Type: {@link Guild.Ban Ban} <br>
     *         An unmodifiable ban object for the user banned from this guild
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     */
    @NotNull
    public RestAction<Guild.Ban> retrieveBan(@NotNull User bannedUser) {
        return guild.retrieveBan(bannedUser);
    }

    /**
     * Retrieves a {@link Guild.Ban Ban} of the provided {@link YUser User} <br>
     * If you wish to ban or unban a user, use either {@link #ban(User, int) or {@link #unBan(YUser)
     * unban(User)}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The ban list cannot be fetched due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_BAN UNKNOWN_BAN} <br>
     * Either the ban was removed before finishing the task or it did not exist in the first
     * place</li>
     * </ul>
     *
     * @param bannedUser the banned user
     * @return {@link RestAction RestAction} - Type: {@link Guild.Ban Ban} <br>
     *         An unmodifiable ban object for the user banned from this guild
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#BAN_MEMBERS} permission.
     */
    @NotNull
    public RestAction<Guild.Ban> retrieveBan(@NotNull YUser bannedUser) {
        return guild.retrieveBan(bannedUser.user());
    }

    @Nonnull
    public RestAction<Integer> retrievePrunableMemberCount(int days) {
        return guild.retrievePrunableMemberCount(days);
    }

    @Nonnull
    public Role getPublicRole() {
        return guild.getPublicRole();
    }

    @Nullable
    public BaseGuildMessageChannel getDefaultChannel() {
        return guild.getDefaultChannel();
    }

    @Nonnull
    public GuildManager getManager() {
        return guild.getManager();
    }

    public boolean isBoostProgressBarEnabled() {
        return guild.isBoostProgressBarEnabled();
    }

    @Nonnull
    public AuditLogPaginationAction retrieveAuditLogs() {
        return guild.retrieveAuditLogs();
    }

    @Nonnull
    public RestAction<Void> leave() {
        return guild.leave();
    }

    @Nonnull
    public RestAction<Void> delete() {
        return guild.delete();
    }

    @Nonnull
    public RestAction<Void> delete(@Nullable String mfaCode) {
        return guild.delete(mfaCode);
    }

    @Nonnull
    public AudioManager getAudioManager() {
        return guild.getAudioManager();
    }

    @Nonnull
    public Task<Void> requestToSpeak() {
        return guild.requestToSpeak();
    }

    @Nonnull
    public Task<Void> cancelRequestToSpeak() {
        return guild.cancelRequestToSpeak();
    }

    @Nonnull
    public JDA getJDA() {
        return guild.getJDA();
    }

    @Nonnull
    public RestAction<List<Invite>> retrieveInvites() {
        return guild.retrieveInvites();
    }

    @Nonnull
    public RestAction<List<Template>> retrieveTemplates() {
        return guild.retrieveTemplates();
    }

    @Nonnull
    public RestAction<Template> createTemplate(@Nonnull String name, @Nullable String description) {
        return guild.createTemplate(name, description);
    }

    @Nonnull
    public RestAction<List<Webhook>> retrieveWebhooks() {
        return guild.retrieveWebhooks();
    }

    @Nonnull
    public List<GuildVoiceState> getVoiceStates() {
        return guild.getVoiceStates();
    }

    @Nonnull
    public Guild.VerificationLevel getVerificationLevel() {
        return guild.getVerificationLevel();
    }

    @Nonnull
    public Guild.NotificationLevel getDefaultNotificationLevel() {
        return guild.getDefaultNotificationLevel();
    }

    @Nonnull
    public Guild.MFALevel getRequiredMFALevel() {
        return guild.getRequiredMFALevel();
    }

    @Nonnull
    public Guild.ExplicitContentLevel getExplicitContentLevel() {
        return guild.getExplicitContentLevel();
    }

    /**
     * Retrieves and collects members of this guild into a list. <br>
     * This will use the configured {@link MemberCachePolicy MemberCachePolicy} to decide which
     * members to retain in cache.
     *
     * <p>
     * You can use {@link #findMembers(Predicate)} to filter specific members.
     *
     * <p>
     * <b>This requires the privileged GatewayIntent.GUILD_MEMBERS to be enabled!</b>
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @return {@link Task} - Type: {@link List} of {@link Member}
     * @throws IllegalStateException If the {@link GatewayIntent#GUILD_MEMBERS
     *         GatewayIntent.GUILD_MEMBERS} is not enabled
     */
    @NotNull
    public Task<List<Member>> loadMembers() {
        return guild.loadMembers();
    }

    /**
     * Retrieves and collects members of this guild into a list. <br>
     * This will use the configured {@link MemberCachePolicy MemberCachePolicy} to decide which
     * members to retain in cache.
     *
     * <p>
     * <b>This requires the privileged GatewayIntent.GUILD_MEMBERS to be enabled!</b>
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param filter Filter to decide which members to include
     * @return {@link Task} - Type: {@link List} of {@link Member}
     * @throws IllegalArgumentException If the provided filter is null
     * @throws IllegalStateException If the {@link GatewayIntent#GUILD_MEMBERS
     *         GatewayIntent.GUILD_MEMBERS} is not enabled
     */
    @NotNull
    public Task<List<Member>> findMembers(@NotNull Predicate<? super Member> filter) {
        return guild.findMembers(filter);
    }

    /**
     * Retrieves and collects members of this guild into a list. <br>
     * This will use the configured {@link MemberCachePolicy MemberCachePolicy} to decide which
     * members to retain in cache.
     *
     * <p>
     * <b>This requires the privileged GatewayIntent.GUILD_MEMBERS to be enabled!</b>
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param roles Collection of all roles the members must have
     * @return {@link Task} - Type: {@link List} of {@link Member}
     * @throws IllegalArgumentException If null is provided
     * @throws IllegalStateException If the {@link GatewayIntent#GUILD_MEMBERS
     *         GatewayIntent.GUILD_MEMBERS} is not enabled
     * @since 4.2.1
     */
    @NotNull
    public Task<List<Member>> findMembersWithRoles(@NotNull Collection<Role> roles) {
        return guild.findMembersWithRoles(roles);
    }

    /**
     * Retrieves and collects members of this guild into a list. <br>
     * This will use the configured {@link MemberCachePolicy MemberCachePolicy} to decide which
     * members to retain in cache.
     *
     * <p>
     * <b>This requires the privileged GatewayIntent.GUILD_MEMBERS to be enabled!</b>
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param roles All roles the members must have
     * @return {@link Task} - Type: {@link List} of {@link Member}
     * @throws IllegalArgumentException If null is provided
     * @throws IllegalStateException If the {@link GatewayIntent#GUILD_MEMBERS
     *         GatewayIntent.GUILD_MEMBERS} is not enabled
     * @since 4.2.1
     */
    @NotNull
    public Task<List<Member>> findMembersWithRoles(@NotNull Role... roles) {
        return guild.findMembersWithRoles(roles);
    }

    @Nonnull
    public Task<Void> loadMembers(@Nonnull Consumer<Member> callback) {
        return guild.loadMembers(callback);
    }


    /**
     * Load the member for the specified user. <br>
     * If the member is already loaded it will be retrieved from {@link #getMemberById(long)} and
     * immediately provided if the member information is consistent. The cache consistency directly
     * relies on the enabled {@link GatewayIntent GatewayIntents} as
     * {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is required to keep the cache
     * updated with the latest information. You can pass {@code update = false} to always return
     * immediately if the member is cached regardless of cache consistency.
     *
     * <p>
     * When the intent {@link GatewayIntent#GUILD_MEMBERS GUILD_MEMBERS} is disabled this will
     * always make a request even if the member is cached. You can use
     * {@link #retrieveMember(User, boolean)} to disable this behavior.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param user The user to load the member from
     * @return {@link RestAction} - Type: {@link Member}
     * @throws IllegalArgumentException If provided with null
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     */
    @NotNull
    public RestAction<Member> retrieveMember(@NotNull User user) {
        return guild.retrieveMember(user);
    }

    @NotNull
    public RestAction<Member> retrieveMember(@NotNull YUser user) {
        return guild.retrieveMember(user.user());
    }

    /**
     * Load the member for the specified user. <br>
     * If the member is already loaded it will be retrieved from {@link #getMemberById(long)} and
     * immediately provided if the member information is consistent. The cache consistency directly
     * relies on the enabled {@link GatewayIntent GatewayIntents} as
     * {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is required to keep the cache
     * updated with the latest information. You can pass {@code update = false} to always return
     * immediately if the member is cached regardless of cache consistency.
     *
     * <p>
     * When the intent {@link GatewayIntent#GUILD_MEMBERS GUILD_MEMBERS} is disabled this will
     * always make a request even if the member is cached. You can use
     * {@link #retrieveMemberById(String, boolean)} to disable this behavior.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param id The user id to load the member from
     * @return {@link RestAction} - Type: {@link Member}
     * @throws IllegalArgumentException If the provided id is empty or null
     * @throws NumberFormatException If the provided id is not a snowflake
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     */
    @NotNull
    public RestAction<Member> retrieveMemberById(@NotNull String id) {
        return guild.retrieveMemberById(id);
    }

    /**
     * Load the member for the specified user. <br>
     * If the member is already loaded it will be retrieved from {@link #getMemberById(long)} and
     * immediately provided if the member information is consistent. The cache consistency directly
     * relies on the enabled {@link GatewayIntent GatewayIntents} as
     * {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is required to keep the cache
     * updated with the latest information. You can pass {@code update = false} to always return
     * immediately if the member is cached regardless of cache consistency.
     *
     * <p>
     * When {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is disabled this will
     * always make a request even if the member is cached. You can use
     * {@link #retrieveMemberById(long, boolean)} to disable this behavior.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param id The user id to load the member from
     * @return {@link RestAction} - Type: {@link Member}
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     */
    @NotNull
    public RestAction<Member> retrieveMemberById(long id) {
        return guild.retrieveMemberById(id);
    }

    /**
     * Shortcut for {@code guild.retrieveMemberById(guild.getOwnerIdLong())}. <br>
     * This will retrieve the current owner of the guild. It is possible that the owner of a guild
     * is no longer a registered discord user in which case this will fail.
     *
     * <p>
     * When {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is disabled this will
     * always make a request even if the member is cached. You can use
     * {@link #retrieveOwner(boolean)} to disable this behavior.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @return {@link RestAction} - Type: {@link Member}
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     * @see #getOwner()
     * @see #getOwnerIdLong()
     * @see #retrieveMemberById(long)
     */
    @NotNull
    public RestAction<Member> retrieveOwner() {
        return guild.retrieveOwner();
    }

    /**
     * Load the member for the specified user. <br>
     * If the member is already loaded it will be retrieved from {@link #getMemberById(long)} and
     * immediately provided if the member information is consistent. The cache consistency directly
     * relies on the enabled {@link GatewayIntent GatewayIntents} as
     * {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is required to keep the cache
     * updated with the latest information. You can pass {@code update = false} to always return
     * immediately if the member is cached regardless of cache consistency.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param user The user to load the member from
     * @param update Whether JDA should perform a request even if the member is already cached to
     *        update properties such as the name
     * @return {@link RestAction} - Type: {@link Member}
     * @throws IllegalArgumentException If provided with null
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     */
    @NotNull
    public RestAction<Member> retrieveMember(@NotNull User user, boolean update) {
        return guild.retrieveMember(user, update);
    }

    /**
     * Load the member for the specified user. <br>
     * If the member is already loaded it will be retrieved from {@link #getMemberById(long)} and
     * immediately provided if the member information is consistent. The cache consistency directly
     * relies on the enabled {@link GatewayIntent GatewayIntents} as
     * {@link GatewayIntent#GUILD_MEMBERS GatewayIntent.GUILD_MEMBERS} is required to keep the cache
     * updated with the latest information. You can pass {@code update = false} to always return
     * immediately if the member is cached regardless of cache consistency.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param id The user id to load the member from
     * @param update Whether JDA should perform a request even if the member is already cached to
     *        update properties such as the name
     * @return {@link RestAction} - Type: {@link Member}
     * @throws IllegalArgumentException If the provided id is empty or null
     * @throws NumberFormatException If the provided id is not a snowflake
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     */
    @NotNull
    public RestAction<Member> retrieveMemberById(@NotNull String id, boolean update) {
        return guild.retrieveMemberById(id, update);
    }

    @Nonnull
    public RestAction<Member> retrieveMemberById(long id, boolean update) {
        return guild.retrieveMemberById(id, update);
    }

    /**
     * Shortcut for {@code guild.retrieveMemberById(guild.getOwnerIdLong())}. <br>
     * This will retrieve the current owner of the guild. It is possible that the owner of a guild
     * is no longer a registered discord user in which case this will fail.
     *
     * <p>
     * Possible {@link ErrorResponseException ErrorResponseExceptions} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER} <br>
     * The specified user is not a member of this guild</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_USER} <br>
     * The specified user does not exist</li>
     * </ul>
     *
     * @param update Whether JDA should perform a request even if the member is already cached to
     *        update properties such as the name
     * @return {@link RestAction} - Type: {@link Member}
     * @see #pruneMemberCache()
     * @see #unloadMember(long)
     * @see #getOwner()
     * @see #getOwnerIdLong()
     * @see #retrieveMemberById(long)
     */
    @NotNull
    public RestAction<Member> retrieveOwner(boolean update) {
        return guild.retrieveOwner(update);
    }

    /**
     * Retrieves a list of members. <br>
     * If the user does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the users resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * If the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES} intent is enabled, this will
     * load the {@link OnlineStatus OnlineStatus} and {@link Activity Activities} of the members.
     * You can use {@link #retrieveMembers(boolean, Collection)} to disable presences.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param users The users of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembers(@NotNull Collection<User> users) {
        return guild.retrieveMembers(users);
    }

    /**
     * Retrieves a list of members by their user id. <br>
     * If the id does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the IDs resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * If the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES} intent is enabled, this will
     * load the {@link OnlineStatus OnlineStatus} and {@link Activity Activities} of the members.
     * You can use {@link #retrieveMembersByIds(boolean, Collection)} to disable presences.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param ids The ids of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembersByIds(@NotNull Collection<Long> ids) {
        return guild.retrieveMembersByIds(ids);
    }

    /**
     * Retrieves a list of members by their user id. <br>
     * If the id does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the IDs resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * If the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES} intent is enabled, this will
     * load the {@link OnlineStatus OnlineStatus} and {@link Activity Activities} of the members.
     * You can use {@link #retrieveMembersByIds(boolean, String...)} to disable presences.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param ids The ids of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembersByIds(@NotNull String... ids) {
        return guild.retrieveMembersByIds(ids);
    }

    /**
     * Retrieves a list of members by their user id. <br>
     * If the id does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the IDs resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * If the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES} intent is enabled, this will
     * load the {@link OnlineStatus OnlineStatus} and {@link Activity Activities} of the members.
     * You can use {@link #retrieveMembersByIds(boolean, long...)} to disable presences.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param ids The ids of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembersByIds(long... ids) {
        return guild.retrieveMembersByIds(ids);
    }

    /**
     * Retrieves a list of members. <br>
     * If the user does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the users resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * You can only load presences with the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES}
     * intent enabled.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param includePresence Whether to load presences of the members (online status/activity)
     * @param users The users of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If includePresence is {@code true} and the GUILD_PRESENCES intent is
     *         disabled</li>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 users</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembers(boolean includePresence,
            @NotNull Collection<User> users) {
        return guild.retrieveMembers(includePresence, users);
    }

    /**
     * Retrieves a list of members by their user id. <br>
     * If the id does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the IDs resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * You can only load presences with the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES}
     * intent enabled.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param includePresence Whether to load presences of the members (online status/activity)
     * @param ids The ids of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If includePresence is {@code true} and the GUILD_PRESENCES intent is
     *         disabled</li>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembersByIds(boolean includePresence,
            @NotNull Collection<Long> ids) {
        return guild.retrieveMembersByIds(includePresence, ids);
    }

    /**
     * Retrieves a list of members by their user id. <br>
     * If the id does not resolve to a member of this guild, then it will not appear in the
     * resulting list. It is possible that none of the IDs resolve to a member, in which case an
     * empty list will be the result.
     *
     * <p>
     * You can only load presences with the {@link GatewayIntent#GUILD_PRESENCES GUILD_PRESENCES}
     * intent enabled.
     *
     * <p>
     * The requests automatically timeout after {@code 10} seconds. When the timeout occurs a
     * {@link TimeoutException TimeoutException} will be used to complete exceptionally.
     *
     * <p>
     * <b>You MUST NOT use blocking operations such as {@link Task#get()}!</b> The response handling
     * happens on the event thread by default.
     *
     * @param includePresence Whether to load presences of the members (online status/activity)
     * @param ids The ids of the members (max 100)
     * @return {@link Task} handle for the request
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If includePresence is {@code true} and the GUILD_PRESENCES intent is
     *         disabled</li>
     *         <li>If the input contains null</li>
     *         <li>If the input is more than 100 IDs</li>
     *         </ul>
     */
    @NotNull
    public Task<List<Member>> retrieveMembersByIds(boolean includePresence,
            @NotNull String... ids) {
        return guild.retrieveMembersByIds(includePresence, ids);
    }

    @Nonnull
    public Task<List<Member>> retrieveMembersByIds(boolean includePresence, long... ids) {
        return guild.retrieveMembersByIds(includePresence, ids);
    }

    @Nonnull
    public Task<List<Member>> retrieveMembersByPrefix(@Nonnull String prefix, int limit) {
        return guild.retrieveMembersByPrefix(prefix, limit);
    }

    @Nonnull
    public RestAction<List<ThreadChannel>> retrieveActiveThreads() {
        return guild.retrieveActiveThreads();
    }

    @Nonnull
    public RestAction<Void> moveVoiceMember(@Nonnull Member member,
            @Nullable AudioChannel audioChannel) {
        return guild.moveVoiceMember(member, audioChannel);
    }

    /**
     * Used to kick a {@link Member Member} from a {@link AudioChannel AudioChannel}. <br>
     * As a note, you cannot kick a Member that isn't already in a AudioChannel. Also they must be
     * in a AudioChannel in the same Guild.
     *
     * <p>
     * Equivalent to {@code moveVoiceMember(member, null)}.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The target Member cannot be moved due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_MEMBER UNKNOWN_MEMBER} <br>
     * The specified Member was removed from the Guild before finishing the task</li>
     *
     * <li>{@link ErrorResponse#UNKNOWN_CHANNEL UNKNOWN_CHANNEL} <br>
     * The specified channel was deleted before finishing the task</li>
     * </ul>
     *
     * @param member The {@link Member Member} that you are moving.
     * @return {@link RestAction RestAction}
     * @throws IllegalStateException If the Member isn't currently in a AudioChannel in this Guild,
     *         or {@link CacheFlag#VOICE_STATE} is disabled.
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If any of the provided arguments is {@code null}</li>
     *         <li>If the provided Member isn't part of this {@link Guild Guild}</li>
     *         <li>If the provided AudioChannel isn't part of this {@link Guild Guild}</li>
     *         </ul>
     * @throws InsufficientPermissionException If this account doesn't have
     *         {@link Permission#VOICE_MOVE_OTHERS} in the AudioChannel that the Member is currently
     *         in.
     */
    @NotNull
    public RestAction<Void> kickVoiceMember(@NotNull Member member) {
        return guild.kickVoiceMember(member);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyNickname(@Nonnull Member member,
            @Nullable String nickname) {
        return guild.modifyNickname(member, nickname);
    }

    /**
     * This method will prune (kick) all members who were offline for at least <i>days</i> days.
     * <br>
     * The RestAction returned from this method will return the amount of Members that were pruned.
     * <br>
     * You can use {@link Guild#retrievePrunableMemberCount(int)} to determine how many Members
     * would be pruned if you were to call this method.
     *
     * <p>
     * This might timeout when pruning many members. You can use {@code prune(days, false)} to
     * ignore the prune count and avoid a timeout.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The prune cannot finished due to a permission discrepancy</li>
     * </ul>
     *
     * @param days Minimum number of days since a member has been offline to get affected.
     * @param roles Optional roles to include in prune filter
     * @return {@link AuditableRestAction AuditableRestAction} - Type: Integer <br>
     *         The amount of Members that were pruned from the Guild.
     * @throws InsufficientPermissionException If the account doesn't have
     *         {@link Permission#KICK_MEMBERS KICK_MEMBER} Permission.
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the provided days are not in the range from 1 to 30 (inclusive)</li>
     *         <li>If null is provided</li>
     *         <li>If any of the provided roles is not from this guild</li>
     *         </ul>
     */
    @NotNull
    public AuditableRestAction<Integer> prune(int days, @NotNull Role... roles) {
        return guild.prune(days, roles);
    }

    @CheckReturnValue
    public @Nonnull RoleOrderAction modifyRolePositions(boolean useAscendingOrder) {
        return guild.modifyRolePositions(useAscendingOrder);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> mute(@Nonnull Member member, boolean mute) {
        return guild.mute(member, mute);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> mute(@Nonnull YMember member, boolean mute) {
        return guild.mute(member.member(), mute);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> deafen(@Nonnull Member member, boolean deafen) {
        return guild.deafen(member, deafen);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> deafen(@Nonnull YMember member, boolean deafen) {
        return guild.deafen(member.member(), deafen);
    }

    /**
     * @see Guild#getBoosters()
     */
    public @Nonnull List<Member> getBoosters() {
        return guild.getBoosters();
    }

    /**
     * @see Guild#getMaxBitrate()
     */
    public int getMaxBitrate() {
        return guild.getMaxBitrate();
    }

    /**
     * @see Guild#getMaxFileSize()
     */
    public long getMaxFileSize() {
        return guild.getMaxFileSize();
    }

    /**
     * @see Guild#getMaxEmotes()
     */
    public int getMaxEmotes() {
        return guild.getMaxEmotes();
    }

    public int getMaxMembers() {
        return guild.getMaxMembers();
    }

    public int getMaxPresences() {
        return guild.getMaxPresences();
    }

    @Nonnull
    public RestAction<Guild.MetaData> retrieveMetaData() {
        return guild.retrieveMetaData();
    }

    @Nullable
    public VoiceChannel getAfkChannel() {
        return guild.getAfkChannel();
    }

    @Nullable
    public TextChannel getSystemChannel() {
        return guild.getSystemChannel();
    }

    @Nullable
    public TextChannel getRulesChannel() {
        return guild.getRulesChannel();
    }

    @Nullable
    public TextChannel getCommunityUpdatesChannel() {
        return guild.getCommunityUpdatesChannel();
    }

    public boolean isMember(@Nonnull YUser user) {
        return guild.isMember(user.user());
    }

    public @Nonnull ChannelAction<TextChannel> createTextChannel(@Nonnull String name) {
        return guild.createTextChannel(name);
    }

    public @Nonnull ChannelAction<TextChannel> createTextChannel(@Nonnull String name,
            @Nonnull Category parent) {
        return guild.createTextChannel(name, parent);
    }

    /**
     * Creates a new {@link NewsChannel NewsChannel} in this Guild. For this to be successful, the
     * logged in account has to have the {@link Permission#MANAGE_CHANNEL MANAGE_CHANNEL} Permission
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The channel could not be created due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#MAX_CHANNELS MAX_CHANNELS} <br>
     * The maximum number of channels were exceeded</li>
     * </ul>
     *
     * @param name The name of the NewsChannel to create
     * @return A specific {@link ChannelAction ChannelAction} <br>
     *         This action allows to set fields for the new NewsChannel before creating it
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MANAGE_CHANNEL} permission
     * @throws IllegalArgumentException If the provided name is {@code null} or empty or greater
     *         than 100 characters in length
     */
    @NotNull
    public ChannelAction<NewsChannel> createNewsChannel(@NotNull String name) {
        return guild.createNewsChannel(name);
    }

    @Nonnull
    public ChannelAction<NewsChannel> createNewsChannel(@Nonnull String name,
            @Nullable Category parent) {
        return guild.createNewsChannel(name, parent);
    }

    /**
     * Creates a new {@link VoiceChannel VoiceChannel} in this Guild. For this to be successful, the
     * logged in account has to have the {@link Permission#MANAGE_CHANNEL MANAGE_CHANNEL}
     * Permission.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The channel could not be created due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#MAX_CHANNELS MAX_CHANNELS} <br>
     * The maximum number of channels were exceeded</li>
     * </ul>
     *
     * @param name The name of the VoiceChannel to create
     * @return A specific {@link ChannelAction ChannelAction} <br>
     *         This action allows to set fields for the new VoiceChannel before creating it
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MANAGE_CHANNEL} permission
     * @throws IllegalArgumentException If the provided name is {@code null} or empty or greater
     *         than 100 characters in length
     */
    @NotNull
    public ChannelAction<VoiceChannel> createVoiceChannel(@NotNull String name) {
        return guild.createVoiceChannel(name);
    }

    @Nonnull
    public ChannelAction<VoiceChannel> createVoiceChannel(@Nonnull String name,
            @Nullable Category parent) {
        return guild.createVoiceChannel(name, parent);
    }

    /**
     * Creates a new {@link StageChannel StageChannel} in this Guild. For this to be successful, the
     * logged in account has to have the {@link Permission#MANAGE_CHANNEL MANAGE_CHANNEL}
     * Permission.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The channel could not be created due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#MAX_CHANNELS MAX_CHANNELS} <br>
     * The maximum number of channels were exceeded</li>
     * </ul>
     *
     * @param name The name of the StageChannel to create
     * @return A specific {@link ChannelAction ChannelAction} <br>
     *         This action allows to set fields for the new StageChannel before creating it
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MANAGE_CHANNEL} permission
     * @throws IllegalArgumentException If the provided name is {@code null} or empty or greater
     *         than 100 characters in length
     */
    @NotNull
    public ChannelAction<StageChannel> createStageChannel(@NotNull String name) {
        return guild.createStageChannel(name);
    }

    @Nonnull
    public ChannelAction<StageChannel> createStageChannel(@Nonnull String name,
            @Nullable Category parent) {
        return guild.createStageChannel(name, parent);
    }

    @Nonnull
    public ChannelAction<Category> createCategory(@Nonnull String name) {
        return guild.createCategory(name);
    }

    /**
     * Creates a copy of the specified {@link GuildChannel GuildChannel} in this {@link Guild
     * Guild}. <br>
     * The provided channel need not be in the same Guild for this to work!
     *
     * <p>
     * This copies the following elements:
     * <ol>
     * <li>Name</li>
     * <li>Parent Category (if present)</li>
     * <li>Voice Elements (Bitrate, Userlimit)</li>
     * <li>Text Elements (Topic, NSFW)</li>
     * <li>All permission overrides for Members/Roles</li>
     * </ol>
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The channel could not be created due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#MAX_CHANNELS MAX_CHANNELS} <br>
     * The maximum number of channels were exceeded</li>
     * </ul>
     *
     * @param channel The {@link GuildChannel GuildChannel} to use for the copy template
     * @return A specific {@link ChannelAction ChannelAction} <br>
     *         This action allows setting fields for the new GuildChannel before creating it!
     * @throws IllegalArgumentException If the provided channel is {@code null}
     * @throws InsufficientPermissionException If the currently logged in account does not have the
     *         {@link Permission#MANAGE_CHANNEL MANAGE_CHANNEL} Permission
     * @see #createTextChannel(String)
     * @see #createVoiceChannel(String)
     * @see ChannelAction ChannelAction
     * @since 3.1
     */
    @NotNull
    public <T extends ICopyableChannel> ChannelAction<T> createCopyOfChannel(@NotNull T channel) {
        return guild.createCopyOfChannel(channel);
    }

    public @Nonnull RoleAction createRole() {
        return guild.createRole();
    }

    /**
     * Creates a new {@link Role Role} in this {@link Guild Guild} with the same settings as the
     * given {@link Role Role}. <br>
     * The position of the specified Role does not matter in this case!
     *
     * <p>
     * It will be placed at the bottom (just over the Public Role) to avoid permission hierarchy
     * conflicts. <br>
     * For this to be successful, the logged in account has to have the
     * {@link Permission#MANAGE_ROLES MANAGE_ROLES} Permission and all {@link Permission
     * Permissions} the given {@link Role Role} has.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} caused by the returned {@link RestAction
     * RestAction} include the following:
     * <ul>
     * <li>{@link ErrorResponse#MISSING_PERMISSIONS MISSING_PERMISSIONS} <br>
     * The role could not be created due to a permission discrepancy</li>
     *
     * <li>{@link ErrorResponse#MAX_ROLES_PER_GUILD MAX_ROLES_PER_GUILD} <br>
     * There are too many roles in this Guild</li>
     * </ul>
     *
     * @param role The {@link Role Role} that should be copied
     * @return {@link RoleAction RoleAction} <br>
     *         RoleAction with already copied values from the specified {@link Role Role}
     * @throws InsufficientPermissionException If the logged in account does not have the
     *         {@link Permission#MANAGE_ROLES} Permission and every Permission the provided Role has
     * @throws IllegalArgumentException If the specified role is {@code null}
     */
    @NotNull
    public RoleAction createCopyOfRole(@NotNull Role role) {
        return guild.createCopyOfRole(role);
    }

    @Nonnull
    public AuditableRestAction<Emote> createEmote(@Nonnull String name, @Nonnull Icon icon,
            @Nonnull Role... roles) {
        return guild.createEmote(name, icon, roles);
    }

    @Nonnull
    public ChannelOrderAction modifyCategoryPositions() {
        return guild.modifyCategoryPositions();
    }

    public @Nonnull ChannelOrderAction modifyTextChannelPositions() {
        return guild.modifyTextChannelPositions();
    }

    @Nonnull
    public ChannelOrderAction modifyVoiceChannelPositions() {
        return guild.modifyVoiceChannelPositions();
    }

    public @Nonnull CategoryOrderAction modifyTextChannelPositions(@Nonnull Category category) {
        return guild.modifyTextChannelPositions(category);
    }

    @Nonnull
    public CategoryOrderAction modifyVoiceChannelPositions(@Nonnull Category category) {
        return guild.modifyVoiceChannelPositions(category);
    }

    /**
     * Modifies the positional order of {@link Guild#getRoles() Guild.getRoles()} using a specific
     * {@link RestAction RestAction} extension to allow moving Roles {@link OrderAction#moveUp(int)
     * up}/{@link OrderAction#moveDown(int) down} or {@link OrderAction#moveTo(int) to} a specific
     * position.
     *
     * <p>
     * This uses <b>ascending</b> ordering which means the lowest role is first! <br>
     * This means the highest role appears at index {@code n - 1} and the lower role at index
     * {@code 0}. <br>
     * Providing {@code true} to {@link #modifyRolePositions(boolean)} will result in the ordering
     * being in ascending order, with the lower role at index {@code n - 1} and the highest at index
     * {@code 0}. <br>
     * As a note: {@link Member#getRoles() Member.getRoles()} and {@link Guild#getRoles()
     * Guild.getRoles()} are both in descending order.
     *
     * <p>
     * Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     * <li>{@link ErrorResponse#UNKNOWN_ROLE UNKNOWN_ROLE} <br>
     * One of the roles was deleted before the completion of the task</li>
     *
     * <li>{@link ErrorResponse#MISSING_ACCESS MISSING_ACCESS} <br>
     * The currently logged in account was removed from the Guild</li>
     * </ul>
     *
     * @return {@link RoleOrderAction RoleOrderAction}
     */
    @NotNull
    public RoleOrderAction modifyRolePositions() {
        return guild.modifyRolePositions();
    }

    @Nullable
    public TextChannel getTextChannelById(@NotNull String id) {
        return guild.getTextChannelById(id);
    }

    @Nullable
    public TextChannel getTextChannelById(long id) {
        return guild.getTextChannelById(id);
    }

    /**
     * Gets all {@link TextChannel TextChannels} in this {@link Guild Guild}. <br>
     * The channels returned will be sorted according to their position.
     *
     * <p>
     * This copies the backing store into a list. This means every call creates a new list with O(n)
     * complexity. It is recommended to store this into a local variable or use
     * {@link #getTextChannelCache()} and use its more efficient versions of handling these values.
     *
     * @return An immutable List of all {@link TextChannel TextChannels} in this Guild.
     */
    @NotNull
    public List<TextChannel> getTextChannels() {
        return guild.getTextChannels();
    }

    @Nonnull
    public List<TextChannel> getTextChannelsByName(@Nonnull String name, boolean ignoreCase) {
        return guild.getTextChannelsByName(name, ignoreCase);
    }

    /**
     * @see Guild#getOwner()
     */
    @Contract(" -> new")
    public @Nonnull YMember getOwner() {
        return new YMember(guild.getOwner());
    }

    public @Nonnull String getOwnerId() {
        return guild.getOwnerId();
    }

    public long getOwnerIdLong() {
        return guild.getOwnerIdLong();
    }

    public boolean checkReasonLength(@Nonnull String reason,
            @Nonnull YSlashCommandInteractionEvent event) {
        if (reason.length() > REASON_MAX_LENGTH) {
            event.replyQueuedEphemeral("You have gone over the reason character limit which is "
                    + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }

    /**
     * The time this entity was created. Calculated through the Snowflake in
     * {@link #getGuildIdLong}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     * @see TimeUtil#getTimeCreated(long)
     */
    @NotNull
    public OffsetDateTime getTimeCreated() {
        return guild.getTimeCreated();
    }
}
