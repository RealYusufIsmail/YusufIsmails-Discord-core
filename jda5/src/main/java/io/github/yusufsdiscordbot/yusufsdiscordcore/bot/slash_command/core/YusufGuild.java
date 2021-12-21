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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.utility.YusufGuildUtility;
import net.dv8tion.jda.api.JDA;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class YusufGuild extends YusufGuildUtility {
    private final Guild guild;

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

    public @NotNull String getGuildId() {
        return this.guild.getId();
    }

    public @NotNull Long getGuildILong() {
        return this.guild.getIdLong();
    }

    public @NotNull String getGuildName() {
        return this.guild.getName();
    }


    /**
     * @see Guild#retrieveCommands()
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

    @NotNull
    public RestAction<EnumSet<Region>> retrieveRegions(boolean includeDeprecated) {
        return this.guild.retrieveRegions(includeDeprecated);
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

    public boolean isLoaded() {
        return false;
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

    public @NotNull String getOwnerId() {
        return this.guild.getOwnerId();
    }

    @NotNull
    public Guild.Timeout getAfkTimeout() {
        return this.guild.getAfkTimeout();
    }

    public boolean isMember(@NotNull User user) {
        return this.guild.isMember(user);
    }

    @NotNull
    public Member getSelfMember() {
        return this.guild.getSelfMember();
    }

    @NotNull
    public Guild.NSFWLevel getNSFWLevel() {
        return this.guild.getNSFWLevel();
    }

    @Nullable
    public YusufMember getMember(@NotNull User user) {
        return new YusufMember(this.guild.getMember(user));
    }

    @NotNull
    public MemberCacheView getMemberCache() {
        return this.guild.getMemberCache();
    }

    @Nullable
    public String getVanityUrl() {
        return this.guild.getVanityUrl();
    }

    @CheckReturnValue
    public @NotNull RestAction<VanityInvite> retrieveVanityInvite() {
        return this.guild.retrieveVanityInvite();
    }

    @Nullable
    public String getDescription() {
        return this.guild.getDescription();
    }

    @NotNull
    public Locale getLocale() {
        return this.guild.getLocale();
    }

    @Nullable
    public String getBannerId() {
        return this.guild.getBannerId();
    }

    @NotNull
    public Guild.BoostTier getBoostTier() {
        return this.guild.getBoostTier();
    }

    public int getBoostCount() {
        return this.guild.getBoostCount();
    }

    public @NotNull AuditableRestAction<Void> changeUserNickname(@NotNull Member member,
            String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    public @NotNull AuditableRestAction<Void> changeUserNickname(@NotNull YusufMember member,
            String nickname) {
        return this.guild.modifyNickname(member.getMember(), nickname);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(@NotNull User user, String reason) {
        return this.guild.unban(user).reason(reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(@NotNull User user) {
        return this.guild.unban(user);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> unBan(@NotNull String userId) {
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
    public @NotNull AuditableRestAction<Void> ban(@NotNull Member member) {
        return this.guild.ban(member, 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull Member member, String reason) {
        return this.guild.ban(member, 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull Member member, int days, String reason) {
        return this.guild.ban(member, days, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull User user) {
        return this.guild.ban(user, 0);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull User user, String reason) {
        return this.guild.ban(user, 0, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> ban(@NotNull User user, int days, String reason) {
        return this.guild.ban(user, days, reason);
    }

    @NotNull
    public AuditableRestAction<Void> ban(@NotNull String userId, int delDays,
            @Nullable String reason) {
        return this.guild.ban(userId, delDays, reason);
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
    public @NotNull AuditableRestAction<Void> kick(@NotNull Member user) {
        return this.guild.kick(user, null);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(@NotNull Member member, String reason) {
        return this.guild.kick(member, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> kick(@NotNull String userId, String reason) {
        return this.guild.kick(userId, reason);
    }

    @CheckReturnValue
    public @NotNull AuditableRestAction<Void> mute(@NotNull Member member, Boolean mute,
            String reason) {
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
    public @NotNull AuditableRestAction<Void> addRoleToMember(@NotNull String userId,
            @Nonnull Role role) {
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

    @NotNull
    public AuditableRestAction<Void> modifyMemberRoles(@NotNull Member member,
            @Nullable Collection<Role> rolesToAdd, @Nullable Collection<Role> rolesToRemove) {
        return this.guild.modifyMemberRoles(member, rolesToAdd, rolesToRemove);
    }

    @NotNull
    public AuditableRestAction<Void> modifyMemberRoles(@NotNull Member member,
            @NotNull Collection<Role> roles) {
        return this.guild.modifyMemberRoles(member, roles);
    }

    @NotNull
    public AuditableRestAction<Void> transferOwnership(@NotNull Member newOwner) {
        return this.guild.transferOwnership(newOwner);
    }

    @NotNull
    public AuditableRestAction<Void> transferOwnership(@NotNull YusufMember newOwner) {
        return this.guild.transferOwnership(newOwner.getMember());
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

    @NotNull
    public SortedSnowflakeCacheView<StageChannel> getStageChannelCache() {
        return this.guild.getStageChannelCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<ThreadChannel> getThreadChannelCache() {
        return this.guild.getThreadChannelCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<Category> getCategoryCache() {
        return this.guild.getCategoryCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<StoreChannel> getStoreChannelCache() {
        return this.guild.getStoreChannelCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<TextChannel> getTextChannelCache() {
        return this.guild.getTextChannelCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<NewsChannel> getNewsChannelCache() {
        return this.guild.getNewsChannelCache();
    }

    @NotNull
    public SortedSnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
        return this.guild.getVoiceChannelCache();
    }

    @NotNull
    public List<GuildChannel> getChannels(boolean includeHidden) {
        return this.guild.getChannels(includeHidden);
    }

    @NotNull
    public SortedSnowflakeCacheView<Role> getRoleCache() {
        return this.guild.getRoleCache();
    }

    @NotNull
    public SnowflakeCacheView<Emote> getEmoteCache() {
        return this.guild.getEmoteCache();
    }

    @NotNull
    public RestAction<List<ListedEmote>> retrieveEmotes() {
        return this.guild.retrieveEmotes();
    }

    @NotNull
    public RestAction<ListedEmote> retrieveEmoteById(@NotNull String id) {
        return this.guild.retrieveEmoteById(id);
    }

    @NotNull
    public RestAction<List<Guild.Ban>> retrieveBanList() {
        return this.guild.retrieveBanList();
    }

    @NotNull
    public RestAction<Guild.Ban> retrieveBanById(@NotNull String userId) {
        return this.guild.retrieveBanById(userId);
    }

    @NotNull
    public RestAction<Integer> retrievePrunableMemberCount(int days) {
        return this.guild.retrievePrunableMemberCount(days);
    }

    @NotNull
    public Role getPublicRole() {
        return this.guild.getPublicRole();
    }

    @Nullable
    public TextChannel getDefaultChannel() {
        return this.guild.getDefaultChannel();
    }

    @NotNull
    public GuildManager getManager() {
        return this.guild.getManager();
    }

    public boolean isBoostProgressBarEnabled() {
        return this.guild.isBoostProgressBarEnabled();
    }

    @NotNull
    public AuditLogPaginationAction retrieveAuditLogs() {
        return this.guild.retrieveAuditLogs();
    }

    @NotNull
    public RestAction<Void> leave() {
        return this.guild.leave();
    }

    @NotNull
    public RestAction<Void> delete() {
        return this.guild.delete();
    }

    @NotNull
    public RestAction<Void> delete(@Nullable String mfaCode) {
        return this.guild.delete(mfaCode);
    }

    @NotNull
    public AudioManager getAudioManager() {
        return this.guild.getAudioManager();
    }

    @NotNull
    public Task<Void> requestToSpeak() {
        return this.guild.requestToSpeak();
    }

    @NotNull
    public Task<Void> cancelRequestToSpeak() {
        return this.guild.cancelRequestToSpeak();
    }

    @NotNull
    public JDA getJDA() {
        return this.guild.getJDA();
    }

    @NotNull
    public RestAction<List<Invite>> retrieveInvites() {
        return this.guild.retrieveInvites();
    }

    @NotNull
    public RestAction<List<Template>> retrieveTemplates() {
        return this.guild.retrieveTemplates();
    }

    @NotNull
    public RestAction<Template> createTemplate(@NotNull String name, @Nullable String description) {
        return this.guild.createTemplate(name, description);
    }

    @NotNull
    public RestAction<List<Webhook>> retrieveWebhooks() {
        return this.guild.retrieveWebhooks();
    }

    @NotNull
    public List<GuildVoiceState> getVoiceStates() {
        return this.guild.getVoiceStates();
    }

    @NotNull
    public Guild.VerificationLevel getVerificationLevel() {
        return this.guild.getVerificationLevel();
    }

    @NotNull
    public Guild.NotificationLevel getDefaultNotificationLevel() {
        return this.guild.getDefaultNotificationLevel();
    }

    @NotNull
    public Guild.MFALevel getRequiredMFALevel() {
        return this.guild.getRequiredMFALevel();
    }

    @NotNull
    public Guild.ExplicitContentLevel getExplicitContentLevel() {
        return this.guild.getExplicitContentLevel();
    }

    @NotNull
    public Task<Void> loadMembers(@NotNull Consumer<Member> callback) {
        return this.guild.loadMembers(callback);
    }

    @NotNull
    public RestAction<Member> retrieveMemberById(long id, boolean update) {
        return this.guild.retrieveMemberById(id, update);
    }

    @NotNull
    public Task<List<Member>> retrieveMembersByIds(boolean includePresence, long... ids) {
        return this.guild.retrieveMembersByIds(includePresence, ids);
    }

    @NotNull
    public Task<List<Member>> retrieveMembersByPrefix(@NotNull String prefix, int limit) {
        return this.guild.retrieveMembersByPrefix(prefix, limit);
    }

    @NotNull
    public RestAction<List<ThreadChannel>> retrieveActiveThreads() {
        return this.guild.retrieveActiveThreads();
    }

    @NotNull
    public RestAction<Void> moveVoiceMember(@NotNull Member member,
            @Nullable AudioChannel audioChannel) {
        return this.guild.moveVoiceMember(member, audioChannel);
    }

    @NotNull
    public AuditableRestAction<Void> modifyNickname(@NotNull Member member,
            @Nullable String nickname) {
        return this.guild.modifyNickname(member, nickname);
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

    public int getMaxMembers() {
        return this.guild.getMaxMembers();
    }

    public int getMaxPresences() {
        return this.guild.getMaxPresences();
    }

    @NotNull
    public RestAction<Guild.MetaData> retrieveMetaData() {
        return this.guild.retrieveMetaData();
    }

    @Nullable
    public VoiceChannel getAfkChannel() {
        return this.guild.getAfkChannel();
    }

    @Nullable
    public TextChannel getSystemChannel() {
        return this.guild.getSystemChannel();
    }

    @Nullable
    public TextChannel getRulesChannel() {
        return this.guild.getRulesChannel();
    }

    @Nullable
    public TextChannel getCommunityUpdatesChannel() {
        return this.guild.getCommunityUpdatesChannel();
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

    @NotNull
    public ChannelAction<NewsChannel> createNewsChannel(@NotNull String name,
            @Nullable Category parent) {
        return this.guild.createNewsChannel(name, parent);
    }

    @NotNull
    public ChannelAction<VoiceChannel> createVoiceChannel(@NotNull String name,
            @Nullable Category parent) {
        return this.guild.createVoiceChannel(name, parent);
    }

    @NotNull
    public ChannelAction<StageChannel> createStageChannel(@NotNull String name,
            @Nullable Category parent) {
        return this.guild.createStageChannel(name, parent);
    }

    @NotNull
    public ChannelAction<Category> createCategory(@NotNull String name) {
        return this.guild.createCategory(name);
    }

    public @NotNull RoleAction createRole() {
        return this.guild.createRole();
    }

    @NotNull
    public AuditableRestAction<Emote> createEmote(@NotNull String name, @NotNull Icon icon,
            @NotNull Role... roles) {
        return this.guild.createEmote(name, icon, roles);
    }

    @NotNull
    public ChannelOrderAction modifyCategoryPositions() {
        return this.guild.modifyCategoryPositions();
    }

    public @NotNull ChannelOrderAction modifyTextChannelPositions() {
        return this.guild.modifyTextChannelPositions();
    }

    @NotNull
    public ChannelOrderAction modifyVoiceChannelPositions() {
        return this.guild.modifyVoiceChannelPositions();
    }

    public @NotNull CategoryOrderAction modifyTextChannelPositions(@Nonnull Category category) {
        return this.guild.modifyTextChannelPositions(category);
    }

    @NotNull
    public CategoryOrderAction modifyVoiceChannelPositions(@NotNull Category category) {
        return this.guild.modifyVoiceChannelPositions(category);
    }

    /**
     * @see Guild#getOwner()
     */
    @Contract(" -> new")
    public @NotNull YusufMember getOwner() {
        return new YusufMember(this.guild.getOwner());
    }

    public long getOwnerIdLong() {
        return this.guild.getOwnerIdLong();
    }
}
