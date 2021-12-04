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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.*;
import net.dv8tion.jda.api.requests.restaction.order.CategoryOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.ChannelOrderAction;
import net.dv8tion.jda.api.requests.restaction.order.RoleOrderAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

@SuppressWarnings("unused")
public class YusufGuild extends YusufGuildUtility implements ISnowflake {
    private final Guild guild;
    private static final Integer REASON_MAX_LENGTH = 512;

    public YusufGuild(Guild guild) {
        super(guild);
        this.guild = guild;
    }

    /**
     * @see Guild
     */
    public Guild getGuild() {
        return this.guild;
    }

    /**
     * @see Guild#retrieveCommands();
     */
    @CheckReturnValue
    public @NotNull RestAction<List<Command>> retrieveCommands() {
        return this.guild.retrieveCommands();
    }

    /**
     * @see Guild#retrieveCommandById(String)
     */
    @CheckReturnValue
    public @NotNull RestAction<Command> retrieveCommandById(@Nonnull String commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    /**
     * @see Guild#retrieveCommandById(long)
     */
    @CheckReturnValue
    public @NotNull RestAction<Command> retrieveCommandById(long commandId) {
        return this.guild.retrieveCommandById(commandId);
    }

    @CheckReturnValue
    public @NotNull CommandCreateAction upsertCommand(@Nonnull CommandData command) {
        return this.guild.upsertCommand(command);
    }

    @CheckReturnValue
    public @NotNull CommandCreateAction upsertCommand(@Nonnull String name,
            @Nonnull String description) {
        return this.guild.upsertCommand(name, description);
    }

    @CheckReturnValue
    public @NotNull CommandListUpdateAction updateCommands() {
        return this.guild.updateCommands();
    }

    @CheckReturnValue
    public @NotNull CommandEditAction editCommandById(@Nonnull String commandId) {
        return this.guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @NotNull CommandEditAction editCommandById(long commandId) {
        return this.guild.editCommandById(commandId);
    }

    @CheckReturnValue
    public @NotNull RestAction<Void> deleteCommandById(@Nonnull String commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @NotNull RestAction<Void> deleteCommandById(long commandId) {
        return this.guild.deleteCommandById(commandId);
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            @Nonnull String commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> retrieveCommandPrivilegesById(
            long commandId) {
        return this.guild.retrieveCommandPrivilegesById(commandId);
    }

    @CheckReturnValue
    public @NotNull RestAction<Map<String, List<CommandPrivilege>>> retrieveCommandPrivileges() {
        return this.guild.retrieveCommandPrivileges();
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull Collection<? extends CommandPrivilege> privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(
            @Nonnull String id, @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @NotNull RestAction<List<CommandPrivilege>> updateCommandPrivilegesById(long id,
            @Nonnull CommandPrivilege... privileges) {
        return this.guild.updateCommandPrivilegesById(id, privileges);
    }

    @CheckReturnValue
    public @NotNull RestAction<Map<String, List<CommandPrivilege>>> updateCommandPrivileges(
            @Nonnull Map<String, Collection<? extends CommandPrivilege>> privileges) {
        return this.guild.updateCommandPrivileges(privileges);
    }

    @CheckReturnValue
    public @NotNull MemberAction addMember(@Nonnull String accessToken, @Nonnull String userId) {
        return this.guild.addMember(accessToken, userId);
    }

    @CheckReturnValue
    public @NotNull MemberAction addMember(@Nonnull String accessToken, @Nonnull User user) {
        return this.guild.addMember(accessToken, user);
    }

    @CheckReturnValue
    public @NotNull MemberAction addMember(@Nonnull String accessToken, @Nonnull YusufUser user) {
        return this.guild.addMember(accessToken, user.getUser());
    }

    @CheckReturnValue
    public @NotNull MemberAction addMember(@Nonnull String accessToken, long userId) {
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

    public @NotNull String getName() {
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

    public @NotNull Set<String> getFeatures() {
        return this.guild.getFeatures();
    }

    @Contract(" -> new")
    public @NotNull YusufMember getBot() {
        return new YusufMember(this.guild.getSelfMember());
    }

    @Contract("_ -> new")
    public @NotNull YusufMember getMember(@Nonnull YusufUser user) {
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

    @Override
    public @NotNull String getId() {
        return this.guild.getId();
    }

    public long getIdLong() {
        return this.guild.getIdLong();
    }

    public @NotNull String getOwnerId() {
        return this.guild.getOwnerId();
    }

    @Nullable
    public String getVanityUrl() {
        return this.guild.getVanityUrl();
    }

    @CheckReturnValue
    public @NotNull RestAction<VanityInvite> retrieveVanityInvite() {
        return this.guild.retrieveVanityInvite();
    }

    public @NotNull AuditableRestAction<Void> changeUserNickname(Member member, String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    public @NotNull AuditableRestAction<Void> changeUserNickname(@NotNull YusufMember member,
            String nickname) {
        return this.guild.modifyNickname(member.getMember(), nickname);
    }

    public @NotNull String getGuildId() {
        return this.guild.getId();
    }

    @CheckReturnValue
    public @NotNull Boolean checkReasonLength(@NotNull String reason,
            YusufSlashCommandEvent event) {
        if (reason.length() > REASON_MAX_LENGTH) {
            event.replyEphemeral("You have gone over the reason character limit which is "
                    + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }

    public @NotNull String getGuildName() {
        return this.guild.getName();
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(User user, String reason) {
        return this.guild.unban(user).reason(reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(User user) {
        return this.guild.unban(user);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(String userId) {
        return this.guild.unban(userId);
    }


    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(@NotNull YusufUser user, String reason) {
        return this.guild.unban(user.getUser()).reason(reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(@NotNull YusufUser user) {
        return this.guild.unban(user.getUser());
    }

    public @NotNull Boolean canYouUnBanUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotUnBanUser(YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("I don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotUnBanUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.getBot().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyEphemeral("You or the bot do not have the permission BAN_MEMBERS");
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufMember member) {
        return this.guild.ban(member.getMember(), 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufMember member, String reason) {
        return this.guild.ban(member.getMember(), 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufMember member, int days,
            String reason) {
        return this.guild.ban(member.getMember(), days, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(Member member) {
        return this.guild.ban(member, 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(Member member, String reason) {
        return this.guild.ban(member, 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(Member member, int days, String reason) {
        return this.guild.ban(member, days, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(User user) {
        return this.guild.ban(user, 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(User user, String reason) {
        return this.guild.ban(user, 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(User user, int days, String reason) {
        return this.guild.ban(user, days, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufUser user) {
        return this.guild.ban(user.getUser(), 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufUser user, String reason) {
        return this.guild.ban(user.getUser(), 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull YusufUser user, int days,
            String reason) {
        return this.guild.ban(user.getUser(), days, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(@NotNull YusufMember member) {
        return this.guild.kick(member.getMember(), null);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(@NotNull YusufMember member, String reason) {
        return this.guild.kick(member.getMember(), reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(Member user) {
        return this.guild.kick(user, null);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(Member member, String reason) {
        return this.guild.kick(member, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(String userId, String reason) {
        return this.guild.kick(userId, reason);
    }



    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> mute(Member member, Boolean mute, String reason) {
        return this.guild.mute(member, mute).reason(reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> mute(@NotNull YusufMember member, Boolean mute,
            String reason) {
        return this.guild.mute(member.getMember(), mute).reason(reason);
    }



    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> addRoleToMember(@Nonnull Member member,
            @Nonnull Role role) {
        return this.guild.addRoleToMember(member, role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> addRoleToMember(@Nonnull YusufMember member,
            @Nonnull Role role) {
        return this.guild.addRoleToMember(member.getMember(), role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> addRoleToMember(long userId, @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> addRoleToMember(String userId, @Nonnull Role role) {
        return this.guild.addRoleToMember(userId, role);
    }



    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> removeRoleFromMember(@Nonnull Member member,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(member, role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> removeRoleFromMember(@Nonnull YusufMember member,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(member.getMember(), role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> removeRoleFromMember(@Nonnull String userId,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> removeRoleFromMember(long userId,
            @Nonnull Role role) {
        return this.guild.removeRoleFromMember(userId, role);
    }



    @CheckReturnValue
    public @NotNull AuditableRestAction<Integer> prune(@Nonnull Integer days,
            @Nonnull Role... roles) {
        return this.guild.prune(days, roles);
    }

    @CheckReturnValue
    @NotNull
    AuditableRestAction<Integer> prune(int days, boolean wait, @Nonnull Role... roles) {
        return this.guild.prune(days, wait, roles);
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

    @CheckReturnValue
    public @NotNull RoleOrderAction modifyRolePositions(boolean useAscendingOrder) {
        return this.guild.modifyRolePositions(useAscendingOrder);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @NotNull
    AuditableRestAction<Void> mute(@Nonnull Member member, boolean mute) {
        return this.guild.mute(member, mute);
    }

    /**
     * @see Guild#mute(Member, boolean)
     */
    @CheckReturnValue
    @NotNull
    AuditableRestAction<Void> mute(@Nonnull YusufMember member, boolean mute) {
        return this.guild.mute(member.getMember(), mute);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @NotNull
    AuditableRestAction<Void> deafen(@Nonnull Member member, boolean deafen) {
        return this.guild.deafen(member, deafen);
    }

    /**
     * @see Guild#deafen(Member, boolean)
     */
    @CheckReturnValue
    @NotNull
    AuditableRestAction<Void> deafen(@Nonnull YusufMember member, boolean deafen) {
        return this.guild.deafen(member.getMember(), deafen);
    }

    /**
     * @see Guild#getBoosters()
     */
    public @NotNull List<Member> getBoosters() {
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

    public boolean isMember(@NotNull YusufUser user) {
        return this.guild.isMember(user.getUser());
    }

    public @NotNull ChannelAction<TextChannel> createTextChannel(@Nonnull String name) {
        return this.guild.createTextChannel(name);
    }

    public @NotNull ChannelAction<TextChannel> createTextChannel(@Nonnull String name,
            @Nonnull Category parent) {
        return this.guild.createTextChannel(name, parent);
    }


    public @NotNull RoleAction createRole() {
        return this.guild.createRole();
    }


    public @NotNull ChannelOrderAction modifyTextChannelPositions() {
        return this.guild.modifyTextChannelPositions();
    }

    public @NotNull CategoryOrderAction modifyTextChannelPositions(@Nonnull Category category) {
        return this.guild.modifyTextChannelPositions(category);
    }

    /**
     * @see Guild#getOwner()
     */
    @Contract(" -> new")
    public @NotNull YusufMember getOwner() {
        return new YusufMember(this.guild.getOwner());
    }
}
