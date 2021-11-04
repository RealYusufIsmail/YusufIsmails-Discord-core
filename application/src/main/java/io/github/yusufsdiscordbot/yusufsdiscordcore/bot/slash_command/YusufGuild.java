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

import net.dv8tion.jda.api.Region;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.CheckReturnValue;
import java.util.*;

public class YusufGuild {
    private static final Integer REASON_MAX_LENGTH = 512;
    private final Guild guild;

    public YusufGuild(Guild guild) {
        this.guild = guild;
    }


    @Nonnull
    @CheckReturnValue
    public RestAction<List<Command>> retrieveCommands() {
        return this.guild.retrieveCommands();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Command> retrieveCommandById(@Nonnull String commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Command> retrieveCommandById(long commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public CommandCreateAction upsertCommand(@Nonnull CommandData command) {
        return this.guild.upsertCommand(command);
    }

    @Nonnull
    @CheckReturnValue
    public CommandCreateAction upsertCommand(@Nonnull String name, @Nonnull String description) {
        return this.guild.upsertCommand(name, description);
    }

    @Nonnull
    @CheckReturnValue
    public CommandListUpdateAction updateCommands() {
        return this.guild.updateCommands();
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction editCommandById(@Nonnull String commandId) {
        return this.guild.editCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction editCommandById(long commandId) {
        return this.guild.editCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> deleteCommandById(@Nonnull String commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> deleteCommandById(long commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            @Nonnull String commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(long commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Map<String, List<CommandPrivilege>>> retrieveCommandPrivileges() {
        return this.guild.retrieveCommandPrivileges();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(@Nonnull String id,
            @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(@Nonnull String id,
            @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(@Nonnull long id,
            @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Map<String, List<CommandPrivilege>>> updateCommandPrivileges(
            @Nonnull Map<String, Collection<? extends CommandPrivilege>> privileges) {
        return this.guild.updateCommandPrivileges(privileges);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<EnumSet<Region>> retrieveRegions() {
        return this.guild.retrieveRegions(true);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<EnumSet<Region>> retrieveRegions(boolean includeDeprecated) {
        return this.guild.retrieveRegions();
    }

    @Nonnull
    @CheckReturnValue
    public MemberAction addMember(@Nonnull String accessToken, @Nonnull String userId) {
        return this.guild.addMember(accessToken, userId);
    }

    @Nonnull
    @CheckReturnValue
    public MemberAction addMember(@Nonnull String accessToken, @Nonnull User user) {
        return this.guild.addMember(accessToken, user);
    }

    @Nonnull
    @CheckReturnValue
    public MemberAction addMember(@Nonnull String accessToken, long userId) {
        return this.guild.addMember(accessToken, userId);
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

    @Nonnull
    public String getName() {
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

    @Nonnull
    public Set<String> getFeatures() {
        return this.guild.getFeatures();
    }

    @Nonnull
    public Member getBot() {
        return this.guild.getSelfMember();
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

    @Nonnull
    public String getId() {
        return this.guild.getId();
    }

    @Nonnull
    public String getOwnerId() {
        return this.guild.getOwnerId();
    }

    @Nullable
    public String getVanityUrl() {
        return this.guild.getVanityUrl();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<VanityInvite> retrieveVanityInvite() {
        return this.guild.retrieveVanityInvite();
    }

    public AuditableRestAction<Void> changeUserNickname(Member member, String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    public String getGuildId() {
        return this.guild.getId();
    }

    @Nonnull
    @CheckReturnValue
    public Boolean checkReasonLength(String reason, YusufSlashCommandEvent event) {
        if (reason.length() > REASON_MAX_LENGTH) {
            event.replyEphemeralMessage("You have gone over the reason character limit which is "
                    + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }

    @Nonnull
    public String getGuildName() {
        return this.guild.getName();
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> unBanWithReason(User user, String reason) {
        return this.guild.unban(user).reason(reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> unBan(User user) {
        return this.guild.unban(user);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> unBan(String userId) {
        return this.guild.unban(userId);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> ban(Member user, String reason) {
        return this.guild.ban(user, 0, reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> ban(Member user, int days, String reason) {
        return this.guild.ban(user, days, reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> ban(User user, String reason) {
        return this.guild.ban(user, 0, reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> kick(Member user, String reason) {
        return this.guild.kick(user, reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> kick(String userId, String reason) {
        return this.guild.kick(userId, reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> kick(Member user) {
        return this.guild.kick(user, null);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> mute(Member user, Boolean mute, String reason) {
        return this.guild.mute(user, mute).reason(reason);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> addRoleToMember(@Nonnull Member member, @Nonnull Role role) {
        return this.guild.addRoleToMember(member, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> addRoleToMember(long userId, @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> addRoleToMember(String userId, @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> removeRoleFromMember(@Nonnull Member member,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(member, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> removeRoleFromMember(@Nonnull String userId,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Void> removeRoleFromMember(long userId, @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }

    @Nonnull
    @CheckReturnValue
    public AuditableRestAction<Integer> prune(@Nonnull Integer days, @Nonnull Role... roles) {
        return this.guild.prune(days, roles);
    }

    @Nonnull
    @CheckReturnValue
    AuditableRestAction<Integer> prune(int days, boolean wait, @Nonnull Role... roles) {
        return this.guild.prune(days, wait, roles);
    }
}
