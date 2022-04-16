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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.annotations.ForRemoval;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.templates.Template;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.managers.GuildManager;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.*;
import net.dv8tion.jda.api.requests.restaction.order.CategoryOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.ChannelOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.RoleOrderAction;
import net.dv8tion.jda.api.requests.restaction.pagination.AuditLogPaginationAction;
import net.dv8tion.jda.api.utils.cache.MemberCacheView;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;
import net.dv8tion.jda.api.utils.cache.SortedSnowflakeCacheView;
import net.dv8tion.jda.api.utils.concurrent.Task;
import org.jetbrains.annotations.Contract;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public record YusufGuild(Guild guild) {
    private static final String USER_AND_BOT_MANAGER_ROLE_PERMISSION =
            "You or the bot do not have the permission MANAGE_ROLES";
    private static final Integer REASON_MAX_LENGTH = 512;

    /**
     * @see Guild
     */
    public Guild getGuild() {
        return this.guild;
    }

    /**
     * @see Guild#retrieveCommands()
     */
    @CheckReturnValue
    public @Nonnull RestAction<List<Command>> retrieveCommands() {
        return this.guild.retrieveCommands();
    }

    /**
     * @see Guild#retrieveCommandById(String)
     */
    @CheckReturnValue
    public @Nonnull RestAction<Command> retrieveCommandById(@Nonnull String commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    /**
     * @see Guild#retrieveCommandById(long)
     */
    @CheckReturnValue
    public @Nonnull RestAction<Command> retrieveCommandById(long commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull CommandCreateAction upsertCommand(@Nonnull CommandData command) {
        return this.guild.upsertCommand(command);
    }

    @CheckReturnValue
    public @Nonnull CommandCreateAction upsertCommand(@Nonnull String name,
            @Nonnull String description) {
        return this.guild.upsertCommand(name, description);
    }

    @CheckReturnValue
    public @Nonnull CommandListUpdateAction updateCommands() {
        return this.guild.updateCommands();
    }

    @CheckReturnValue
    public @Nonnull CommandEditAction editCommandById(@Nonnull String commandId) {
        return this.guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull CommandEditAction editCommandById(long commandId) {
        return this.guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Void> deleteCommandById(@Nonnull String commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Void> deleteCommandById(long commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            @Nonnull String commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            long commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Map<String, List<CommandPrivilege>>> retrieveCommandPrivileges() {
        return this.guild.retrieveCommandPrivileges();
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @Nonnull RestAction<Map<String, List<CommandPrivilege>>> updateCommandPrivileges(
            @Nonnull Map<String, Collection<? extends CommandPrivilege>> privileges) {
        return this.guild.updateCommandPrivileges(privileges);
    }

    @Nonnull
    public RestAction<EnumSet<Region>> retrieveRegions(boolean includeDeprecated) {
        return this.guild.retrieveRegions(includeDeprecated);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull String userId) {
        return this.guild.addMember(accessToken, userId);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull User user) {
        return this.guild.addMember(accessToken, user);
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, @Nonnull YusufUser user) {
        return this.guild.addMember(accessToken, user.getUser());
    }

    @CheckReturnValue
    public @Nonnull MemberAction addMember(@Nonnull String accessToken, long userId) {
        return this.guild.addMember(accessToken, userId);
    }

    public boolean isLoaded() {
        return this.guild.isLoaded();
    }

    public void pruneMemberCache() {
        this.guild.pruneMemberCache();
    }

    public boolean unloadMember(long userId) {
        return this.guild.unloadMember(userId);
    }

    public int getMemberCount() {
        return this.guild.getMemberCount();
    }

    public @Nonnull String getName() {
        return this.guild.getName();
    }

    @Nullable
    public String getIconId() {
        return this.guild.getIconId();
    }

    @Nullable
    public String getIconUrl() {
        return this.guild.getIconUrl();
    }

    public @Nonnull Set<String> getFeatures() {
        return this.guild.getFeatures();
    }

    @Contract(" -> new")
    public @Nonnull YusufMember getBot() {
        return new YusufMember(this.guild.getSelfMember());
    }

    @Contract("_ -> new")
    public @Nonnull YusufMember getMember(@Nonnull YusufUser user) {
        return new YusufMember(this.guild.getMember(user.getUser()));
    }

    @Nullable
    String getSplashId() {
        return this.guild.getSplashId();
    }

    @Nullable
    public String getSplashUrl() {
        return this.guild.getSplashUrl();
    }

    @Nullable
    public String getVanityCode() {
        return this.guild.getVanityCode();
    }

    public @Nonnull String getId() {
        return this.guild.getId();
    }

    public long getIdLong() {
        return this.guild.getIdLong();
    }

    public @Nonnull String getOwnerId() {
        return this.guild.getOwnerId();
    }

    @Nonnull
    public Guild.Timeout getAfkTimeout() {
        return this.guild.getAfkTimeout();
    }

    public boolean isMember(@Nonnull User user) {
        return this.guild.isMember(user);
    }

    @Nonnull
    public YusufMember getSelfMember() {
        return new YusufMember(this.guild.getSelfMember());
    }

    @Nonnull
    public Guild.NSFWLevel getNSFWLevel() {
        return this.guild.getNSFWLevel();
    }

    @Nonnull
    public MemberCacheView getMemberCache() {
        return this.guild.getMemberCache();
    }

    @Nullable
    public String getVanityUrl() {
        return this.guild.getVanityUrl();
    }

    @CheckReturnValue
    public @Nonnull RestAction<VanityInvite> retrieveVanityInvite() {
        return this.guild.retrieveVanityInvite();
    }

    @org.jetbrains.annotations.Nullable
    public String getDescription() {
        return this.guild.getDescription();
    }

    @Nonnull
    public Locale getLocale() {
        return this.guild.getLocale();
    }

    @org.jetbrains.annotations.Nullable
    public String getBannerId() {
        return this.guild.getBannerId();
    }

    @Nonnull
    public Guild.BoostTier getBoostTier() {
        return this.guild.getBoostTier();
    }

    public int getBoostCount() {
        return this.guild.getBoostCount();
    }

    public @Nonnull AuditableRestAction<Void> changeUserNickname(@Nonnull Member member,
            String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    public @Nonnull AuditableRestAction<Void> changeUserNickname(@Nonnull YusufMember member,
            String nickname) {
        return this.guild.modifyNickname(member.getMember(), nickname);
    }

    public @Nonnull String getGuildId() {
        return this.guild.getId();
    }

    public boolean checkReasonLength(@Nonnull String reason,
            @Nonnull YusufSlashCommandEvent event) {
        if (reason.length() > REASON_MAX_LENGTH) {
            event.replyEphemeral("You have gone over the reason character limit which is "
                    + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }

    public @Nonnull String getGuildName() {
        return this.guild.getName();
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull User user, String reason) {
        return this.guild.unban(user).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull User user) {
        return this.guild.unban(user);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull String userId) {
        return this.guild.unban(userId);
    }


    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull YusufUser user, String reason) {
        return this.guild.unban(user.getUser()).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> unBan(@Nonnull YusufUser user) {
        return this.guild.unban(user.getUser());
    }

    public @Nonnull Boolean canYouUnBanUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotUnBanUser(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("I don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotUnBanUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You or the bot do not have the permission BAN_MEMBERS");
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufMember member) {
        return this.guild.ban(member.getMember(), 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufMember member, String reason) {
        return this.guild.ban(member.getMember(), 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufMember member, int days,
            String reason) {
        return this.guild.ban(member.getMember(), days, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member) {
        return this.guild.ban(member, 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member, String reason) {
        return this.guild.ban(member, 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull Member member, int days, String reason) {
        return this.guild.ban(member, days, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user) {
        return this.guild.ban(user, 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user, String reason) {
        return this.guild.ban(user, 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull User user, int days, String reason) {
        return this.guild.ban(user, days, reason);
    }

    @Nonnull
    public AuditableRestAction<Void> ban(@Nonnull String userId, int delDays,
            @org.jetbrains.annotations.Nullable String reason) {
        return this.guild.ban(userId, delDays, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufUser user) {
        return this.guild.ban(user.getUser(), 0);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufUser user, String reason) {
        return this.guild.ban(user.getUser(), 0, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> ban(@Nonnull YusufUser user, int days,
            String reason) {
        return this.guild.ban(user.getUser(), days, reason);
    }

    public @Nonnull Boolean canYouBanUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You don't have the permission to ban users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotBanUser(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("I don't have the permission to ban users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotBanUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You or the bot do not have the permission BAN_MEMBERS");
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull YusufMember member) {
        return this.guild.kick(member.getMember(), null);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull YusufMember member, String reason) {
        return this.guild.kick(member.getMember(), reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull Member user) {
        return this.guild.kick(user, null);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull Member member, String reason) {
        return this.guild.kick(member, reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> kick(@Nonnull String userId, String reason) {
        return this.guild.kick(userId, reason);
    }

    public @Nonnull Boolean canYouKickUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyEphemeral("You don't have the permission to kick users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotKickUser(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.KICK_MEMBERS)) {
            event.replyEphemeral("I don't have the permission to kick users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotKickUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.KICK_MEMBERS)
                && !member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyEphemeral("You or the bot do not have the permission KICK_MEMBERS");
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(@Nonnull Member member, Boolean mute,
            String reason) {
        return this.guild.mute(member, mute).reason(reason);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> mute(@Nonnull YusufMember member, Boolean mute,
            String reason) {
        return this.guild.mute(member.getMember(), mute).reason(reason);
    }

    public @Nonnull Boolean canYouMuteUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyEphemeral("You don't have the permission to mute users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotMuteUser(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyEphemeral("I don't have the permission to mute users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotMuteUser(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.VOICE_MUTE_OTHERS)
                && !member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyEphemeral("You or the bot do not have the permission VOICE_MUTE_OTHERS");
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull Member member,
            @Nonnull Role role) {
        return this.guild.addRoleToMember(member, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull YusufMember member,
            @Nonnull Role role) {
        return this.guild.addRoleToMember(member.getMember(), role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(long userId, @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> addRoleToMember(@Nonnull String userId,
            @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }

    public @Nonnull Boolean canYouAddRoleToMember(@Nonnull YusufMember member) {
        return member.hasPermission(Permission.MANAGE_ROLES);
    }

    public @Nonnull Boolean canYouAddRoleToMember(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("You don't have the permission to add roles to users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotAddRoleToMember(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("I don't have the permission to add roles to users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotAddRoleToMember(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)
                && !member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral(USER_AND_BOT_MANAGER_ROLE_PERMISSION);
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull Member member,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(member, role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull YusufMember member,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(member.getMember(), role);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(@Nonnull String userId,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyMemberRoles(@Nonnull Member member,
            @org.jetbrains.annotations.Nullable Collection<Role> rolesToAdd,
            @org.jetbrains.annotations.Nullable Collection<Role> rolesToRemove) {
        return this.guild.modifyMemberRoles(member, rolesToAdd, rolesToRemove);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyMemberRoles(@Nonnull Member member,
            @Nonnull Collection<Role> roles) {
        return this.guild.modifyMemberRoles(member, roles);
    }

    @Nonnull
    public AuditableRestAction<Void> transferOwnership(@Nonnull Member newOwner) {
        return this.guild.transferOwnership(newOwner);
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Void> removeRoleFromMember(long userId,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }

    public @Nonnull Boolean canYouRemoveRoleFromMember(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("You don't have the permission to remove roles from users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotRemoveRoleFromMember(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("I don't have the permission to remove roles from users!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotRemoveRoleFromMember(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)
                && !member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral(USER_AND_BOT_MANAGER_ROLE_PERMISSION);
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @Nonnull AuditableRestAction<Integer> prune(@Nonnull Integer days,
            @Nonnull Role... roles) {
        return this.guild.prune(days, roles);
    }

    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Integer> prune(int days, boolean wait, @Nonnull Role... roles) {
        return this.guild.prune(days, wait, roles);
    }

    public @Nonnull Boolean canYouPrune(@Nonnull YusufMember member) {
        return member.hasPermission(Permission.MESSAGE_MANAGE);
    }

    public @Nonnull Boolean canYouPrune(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("You don't have the permission to remove messages in this guild!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotPrune(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyEphemeral("I don't have the permission to remove messages in this guild!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotPrune(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MESSAGE_MANAGE)
                && !member.hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyEphemeral("You or the bot do not have the permission MESSAGE_MANAGE");
            return false;
        }
        return true;
    }

    @Deprecated(since = "1.0.36")
    @ForRemoval(deadline = "2.0.0")
    public @Nonnull YusufGuildChannel getYusufGuildChannelById(@Nonnull String id) {
        return new YusufGuildChannel(this.guild.getGuildChannelById(id));
    }

    @Deprecated(since = "1.0.36")
    @ForRemoval(deadline = "2.0.0")
    public @Nonnull YusufGuildChannel getYusufGuildChannelById(long id) {
        return new YusufGuildChannel(this.guild.getGuildChannelById(id));
    }

    @Deprecated(since = "1.0.36")
    @ForRemoval(deadline = "2.0.0")
    public @Nonnull YusufGuildChannel getYusufGuildChannelById(@Nonnull ChannelType type, long id) {
        return new YusufGuildChannel(this.guild.getGuildChannelById(type, id));
    }

    @Nullable
    public GuildChannel getGuildChannelById(@Nonnull String id) {
        return this.guild.getGuildChannelById(id);
    }

    @Nullable
    public GuildChannel getGuildChannelById(long id) {
        return this.guild.getGuildChannelById(id);
    }

    @Nullable
    public GuildChannel getGuildChannelById(@Nonnull ChannelType type, long id) {
        return this.guild.getGuildChannelById(type, id);
    }

    @Nonnull
    public SortedSnowflakeCacheView<Category> getCategoryCache() {
        return this.guild.getCategoryCache();
    }

    @Nonnull
    public SortedSnowflakeCacheView<StoreChannel> getStoreChannelCache() {
        return this.guild.getStoreChannelCache();
    }

    @Nonnull
    public SortedSnowflakeCacheView<TextChannel> getTextChannelCache() {
        return this.guild.getTextChannelCache();
    }

    @Nonnull
    public SortedSnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
        return this.guild.getVoiceChannelCache();
    }

    @Nonnull
    public List<GuildChannel> getChannels(boolean includeHidden) {
        return this.guild.getChannels(includeHidden);
    }

    @Nonnull
    public SortedSnowflakeCacheView<Role> getRoleCache() {
        return this.guild.getRoleCache();
    }

    @Nonnull
    public SnowflakeCacheView<Emote> getEmoteCache() {
        return this.guild.getEmoteCache();
    }

    @Nonnull
    public RestAction<List<ListedEmote>> retrieveEmotes() {
        return this.guild.retrieveEmotes();
    }

    @Nonnull
    public RestAction<ListedEmote> retrieveEmoteById(@Nonnull String id) {
        return this.guild.retrieveEmoteById(id);
    }

    @Nonnull
    public RestAction<List<Guild.Ban>> retrieveBanList() {
        return this.guild.retrieveBanList();
    }

    @Nonnull
    public RestAction<Guild.Ban> retrieveBanById(@Nonnull String userId) {
        return this.guild.retrieveBanById(userId);
    }

    @Nonnull
    public RestAction<Integer> retrievePrunableMemberCount(int days) {
        return this.guild.retrievePrunableMemberCount(days);
    }

    @Nonnull
    public Role getPublicRole() {
        return this.guild.getPublicRole();
    }

    @Nullable
    public TextChannel getDefaultChannel() {
        return this.guild.getDefaultChannel();
    }

    @Nonnull
    public GuildManager getManager() {
        return this.guild.getManager();
    }

    @Nonnull
    public AuditLogPaginationAction retrieveAuditLogs() {
        return this.guild.retrieveAuditLogs();
    }

    @Nonnull
    public RestAction<Void> leave() {
        return this.guild.leave();
    }

    @Nonnull
    public RestAction<Void> delete() {
        return this.guild.delete();
    }

    @Nonnull
    public RestAction<Void> delete(@Nullable String mfaCode) {
        return this.guild.delete(mfaCode);
    }

    @Nonnull
    public AudioManager getAudioManager() {
        return this.guild.getAudioManager();
    }

    @Nonnull
    public Task<Void> requestToSpeak() {
        return this.guild.requestToSpeak();
    }

    @Nonnull
    public Task<Void> cancelRequestToSpeak() {
        return this.guild.cancelRequestToSpeak();
    }

    @Nonnull
    public JDA getJDA() {
        return this.guild.getJDA();
    }

    @Nonnull
    public RestAction<List<Invite>> retrieveInvites() {
        return this.guild.retrieveInvites();
    }

    @Nonnull
    public RestAction<List<Template>> retrieveTemplates() {
        return this.guild.retrieveTemplates();
    }

    @Nonnull
    public RestAction<Template> createTemplate(@Nonnull String name,
            @org.jetbrains.annotations.Nullable String description) {
        return this.guild.createTemplate(name, description);
    }

    @Nonnull
    public RestAction<List<Webhook>> retrieveWebhooks() {
        return this.guild.retrieveWebhooks();
    }

    @Nonnull
    public List<GuildVoiceState> getVoiceStates() {
        return this.guild.getVoiceStates();
    }

    @Nonnull
    public Guild.VerificationLevel getVerificationLevel() {
        return this.guild.getVerificationLevel();
    }

    @Nonnull
    public Guild.NotificationLevel getDefaultNotificationLevel() {
        return this.guild.getDefaultNotificationLevel();
    }

    @Nonnull
    public Guild.MFALevel getRequiredMFALevel() {
        return this.guild.getRequiredMFALevel();
    }

    @Nonnull
    @Deprecated(since = "1.0.36")
    @ForRemoval(deadline = "2.0.0")
    public Guild.ExplicitContentLevel getExplicitContentLevel() {
        return this.guild.getExplicitContentLevel();
    }

    @Nonnull
    public Task<Void> loadMembers(@Nonnull Consumer<Member> callback) {
        return this.guild.loadMembers(callback);
    }

    @Nonnull
    public RestAction<Member> retrieveMemberById(long id, boolean update) {
        return this.guild.retrieveMemberById(id, update);
    }

    @Nonnull
    public Task<List<Member>> retrieveMembersByIds(boolean includePresence, @Nonnull long... ids) {
        return this.guild.retrieveMembersByIds(includePresence, ids);
    }

    @Nonnull
    public Task<List<Member>> retrieveMembersByPrefix(@Nonnull String prefix, int limit) {
        return this.guild.retrieveMembersByPrefix(prefix, limit);
    }

    @Nonnull
    public RestAction<Void> moveVoiceMember(@Nonnull Member member,
            @org.jetbrains.annotations.Nullable VoiceChannel voiceChannel) {
        return this.guild.moveVoiceMember(member, voiceChannel);
    }

    @Nonnull
    public AuditableRestAction<Void> modifyNickname(@Nonnull Member member,
            @org.jetbrains.annotations.Nullable String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    @CheckReturnValue
    public @Nonnull RoleOrderAction modifyRolePositions(boolean useAscendingOrder) {
        return this.guild.modifyRolePositions(useAscendingOrder);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> mute(@Nonnull Member member, boolean mute) {
        return this.guild.mute(member, mute);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> mute(@Nonnull YusufMember member, boolean mute) {
        return this.guild.mute(member.getMember(), mute);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> deafen(@Nonnull Member member, boolean deafen) {
        return this.guild.deafen(member, deafen);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @Nonnull
    AuditableRestAction<Void> deafen(@Nonnull YusufMember member, boolean deafen) {
        return this.guild.deafen(member.getMember(), deafen);
    }

    /**
     * @see Guild#getBoosters()
     */
    public @Nonnull List<Member> getBoosters() {
        return this.guild.getBoosters();
    }

    /**
     * @see Guild#getMaxBitrate()
     */
    public int getMaxBitrate() {
        return this.guild.getMaxBitrate();
    }

    /**
     * @see Guild#getMaxFileSize()
     */
    public long getMaxFileSize() {
        return this.guild.getMaxFileSize();
    }

    /**
     * @see Guild#getMaxEmotes()
     */
    public int getMaxEmotes() {
        return this.guild.getMaxEmotes();
    }

    public int getMaxMembers() {
        return this.guild.getMaxMembers();
    }

    public int getMaxPresences() {
        return this.guild.getMaxPresences();
    }

    @Nonnull
    public RestAction<Guild.MetaData> retrieveMetaData() {
        return this.guild.retrieveMetaData();
    }

    @org.jetbrains.annotations.Nullable
    public VoiceChannel getAfkChannel() {
        return this.guild.getAfkChannel();
    }

    @org.jetbrains.annotations.Nullable
    public TextChannel getSystemChannel() {
        return this.guild.getSystemChannel();
    }

    @org.jetbrains.annotations.Nullable
    public TextChannel getRulesChannel() {
        return this.guild.getRulesChannel();
    }

    @org.jetbrains.annotations.Nullable
    public TextChannel getCommunityUpdatesChannel() {
        return this.guild.getCommunityUpdatesChannel();
    }

    public boolean isMember(@Nonnull YusufUser user) {
        return this.guild.isMember(user.getUser());
    }

    public @Nonnull ChannelAction<TextChannel> createTextChannel(@Nonnull String name) {
        return this.guild.createTextChannel(name);
    }

    public @Nonnull ChannelAction<TextChannel> createTextChannel(@Nonnull String name,
            @Nonnull Category parent) {
        return this.guild.createTextChannel(name, parent);
    }

    @Nonnull
    public ChannelAction<VoiceChannel> createVoiceChannel(@Nonnull String name,
            @org.jetbrains.annotations.Nullable Category parent) {
        return this.guild.createVoiceChannel(name, parent);
    }

    @Nonnull
    public ChannelAction<StageChannel> createStageChannel(@Nonnull String name,
            @org.jetbrains.annotations.Nullable Category parent) {
        return this.guild.createStageChannel(name, parent);
    }

    @Nonnull
    public ChannelAction<Category> createCategory(@Nonnull String name) {
        return this.guild.createCategory(name);
    }

    public @Nonnull Boolean canYouCreateTextChannel(@Nonnull YusufMember member) {
        return member.hasPermission(Permission.MANAGE_CHANNEL);
    }

    public @Nonnull Boolean canBotCreateTextChannel() {
        return this.getBot().hasPermission(Permission.MANAGE_CHANNEL);
    }

    public @Nonnull Boolean canYouAndBotCreateTextChannel(@Nonnull YusufMember member) {
        return this.getBot().hasPermission(Permission.MANAGE_CHANNEL)
                || member.hasPermission(Permission.MANAGE_CHANNEL);
    }

    public @Nonnull RoleAction createRole() {
        return this.guild.createRole();
    }

    @Nonnull
    public AuditableRestAction<Emote> createEmote(@Nonnull String name, @Nonnull Icon icon,
            @Nonnull Role... roles) {
        return this.guild.createEmote(name, icon, roles);
    }

    @Nonnull
    public ChannelOrderAction modifyCategoryPositions() {
        return this.guild.modifyCategoryPositions();
    }

    public @Nonnull Boolean canYouCreateRole(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("You don't have the permission to create roles!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canBotCreateRole(@Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral("I don't have the permission to create roles!");
            return false;
        }
        return true;
    }

    public @Nonnull Boolean canYouAndBotCreateRole(@Nonnull YusufMember member,
            @Nonnull YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.MANAGE_ROLES)
                && !member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyEphemeral(USER_AND_BOT_MANAGER_ROLE_PERMISSION);
            return false;
        }
        return true;
    }

    public @Nonnull ChannelOrderAction modifyTextChannelPositions() {
        return this.guild.modifyTextChannelPositions();
    }

    @Nonnull
    public ChannelOrderAction modifyVoiceChannelPositions() {
        return this.guild.modifyVoiceChannelPositions();
    }

    public @Nonnull CategoryOrderAction modifyTextChannelPositions(@Nonnull Category category) {
        return this.guild.modifyTextChannelPositions(category);
    }

    @Nonnull
    public CategoryOrderAction modifyVoiceChannelPositions(@Nonnull Category category) {
        return this.guild.modifyVoiceChannelPositions(category);
    }

    /**
     * @see Guild#getOwner()
     */
    @Contract(" -> new")
    public @Nonnull YusufMember getOwner() {
        return new YusufMember(this.guild.getOwner());
    }

    public long getOwnerIdLong() {
        return this.guild.getOwnerIdLong();
    }
}