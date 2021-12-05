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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.utility;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class YusufGuildUtility {
    private final Guild guild;

    private static final Integer REASON_MAX_LENGTH = 512;

    public YusufGuildUtility(Guild guild) {
        this.guild = guild;
    }

    public @NotNull Boolean canYouUnBanUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral("You don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotUnBanUser(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral("I don't have the permission to unban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotUnBanUserAndBan(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission BAN_MEMBERS");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouBanUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral("You don't have the permission to ban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotBanUser(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral("I don't have the permission to ban users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouKickUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral("You don't have the permission to kick users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotKickUser(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral("I don't have the permission to kick users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotKickUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)
                && !member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission KICK_MEMBERS");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouMuteUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral("You don't have the permission to mute users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotMuteUser(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral("I don't have the permission to mute users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotMuteUser(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.VOICE_MUTE_OTHERS)
                && !member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission VOICE_MUTE_OTHERS");
            return false;
        }
        return true;
    }


    public @NotNull Boolean canYouAddRoleToMember(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("You don't have the permission to add roles to users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotAddRoleToMember(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("I don't have the permission to add roles to users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouRemoveRoleFromMember(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("You don't have the permission to remove roles from users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotRemoveRoleFromMember(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("I don't have the permission to remove roles from users!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouPrune(@NotNull YusufMember member, YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("You don't have the permission to remove messages in this guild!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotPrune(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyQueuedEphemeral("I don't have the permission to remove messages in this guild!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotPrune(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)
                && !member.hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission MESSAGE_MANAGE");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouCreateRole(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("You don't have the permission to create roles!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotCreateRole(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("I don't have the permission to create roles!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotManageRoles(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)
                && !member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission MANAGE_ROLES");
            return false;
        }
        return true;
    }


    public @NotNull Boolean canYouManageChannel(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral("You don't have the permission to manage channels!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotManageChannel(YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral("I don't have the permission to manage channels!");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotManageChannel(@NotNull YusufMember member,
            YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_CHANNEL)
                && !member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral("You or the bot do not have the permission MANAGE_CHANNEL");
            return false;
        }
        return true;
    }

    public @NotNull Boolean checkReasonLength(@NotNull String reason,
            YusufSlashCommandEvent event) {
        if (reason.length() > REASON_MAX_LENGTH) {
            event.replyQueuedEphemeral("You have gone over the reason character limit which is "
                    + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }
}
