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

@SuppressWarnings({"unused", "java:S6206"})
public class PermissionChecker {
    private final Guild guild;

    public PermissionChecker(Guild guild) {
        this.guild = guild;
    }

    // can you perms

    public @NotNull Boolean canYouUnBanUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission BAN_MEMBERS which means you can not unban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouBanUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission BAN_MEMBERS which means you can not ban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouKickUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission KICK MEMBERS which means you can not kick users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouDeafenUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission VOICE MUTE OTHERS which means you can not deafen users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAddRoleToMember(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission MANAGE_ROLES which means you can not give a role to a user");
            return false;
        }
        return true;
    }


    public @NotNull Boolean canYouDeleteMessages(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission MANAGE_ROLES which means you can not removed a role from a user");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouCreateRole(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission MANAGE_ROLES which means you can not create a role");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouManageChannel(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission MANAGE_CHANNEL which means you can not manage channels");
            return false;
        }
        return true;
    }

    // Also use for mute perms
    public @NotNull Boolean canYouTimeOutUsers(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral(
                    "You don't have the permission MANAGE_CHANNEL which means you can not mute/time out users");
            return false;
        }
        return true;
    }

    // can bot perms

    public @NotNull Boolean canBotUnBanUser(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission BAN_MEMBERS which means I can not unban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotBanUser(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission BAN_MEMBERS which means I can not ban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotKickUser(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission KICK_MEMBERS which means I can not kick users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotDeafenUser(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission VOICE_MUTE_OTHERS which means I can not deafen users");
            return false;
        }
        return true;
    }


    public @NotNull Boolean canBotAddRoleToMember(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MANAGE_ROLES which means I can not add roles to members");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotRemoveRoleFromMember(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MANAGE_ROLES which means I can not remove roles from members");
            return false;
        }
        return true;
    }



    public @NotNull Boolean canBotDeleteMessages(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MESSAGE_MANAGE which means I can not delete messages");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotCreateRole(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MANAGE_ROLES which means I can not create roles");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canBotManageChannel(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MANAGE_CHANNEL which means I can not manage channels");
            return false;
        }
        return true;
    }

    // also use for mute
    public @NotNull Boolean canBotTimeOutUsers(@NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MODERATE_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "I don't have the permission MODERATE_MEMBERS which means I can not timeout/mute users");
            return false;
        }
        return true;
    }

    // can you and bot perms

    public @NotNull Boolean canYouAndBotUnBanUsers(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission BAN_MEMBERS which means I/you can not unban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotBanUsers(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.BAN_MEMBERS)
                && !member.hasPermission(Permission.BAN_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission BAN_MEMBERS which means I/you can not ban users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotKickUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)
                && !member.hasPermission(Permission.KICK_MEMBERS)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission KICK_MEMBERS which means I/you can not kick users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotDeafenUser(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.VOICE_MUTE_OTHERS)
                && !member.hasPermission(Permission.VOICE_MUTE_OTHERS)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission VOICE_MUTE_OTHERS which means I/you can not deafen users");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouRemoveRoleFromMember(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "You do not have the permission MANAGE_ROLES which means you can not remove roles from members");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotDeleteMessages(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)
                && !member.hasPermission(Permission.MESSAGE_MANAGE)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission MESSAGE_MANAGE which means I/you can not delete messages");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotManageRoles(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_ROLES)
                && !member.hasPermission(Permission.MANAGE_ROLES)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission MANAGE_ROLES which means I/you can not manage roles");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotManageChannel(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MANAGE_CHANNEL)
                && !member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission MANAGE_CHANNEL which means I/you can not manage channels");
            return false;
        }
        return true;
    }

    public @NotNull Boolean canYouAndBotTimeOutUsers(@NotNull YusufMember member,
            @NotNull YusufSlashCommandEvent event) {
        if (!this.guild.getSelfMember().hasPermission(Permission.MODERATE_MEMBERS)
                && !member.hasPermission(Permission.MANAGE_CHANNEL)) {
            event.replyQueuedEphemeral(
                    "You or the bot do not have the permission MODERATE_MEMBERS which means I/you can not timeout/mute users");
            return false;
        }
        return true;
    }
}
