/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/> Everyone is permitted to
 * copy and distribute verbatim copies of this license document, but changing it is not allowed.
 * Yusuf Arfan Ismail
 * The GNU General Public License is a free, copyleft license for software and other kinds of works.
 * The licenses for most software and other practical works are designed to take away your freedom
 * to share and change the works. By contrast, the GNU General Public License is intended to
 * guarantee your freedom to share and change all versions of a program--to make sure it remains
 * free software for all its users. We, the Free Software Foundation, use the GNU General Public
 * License for most of our software; it applies also to any other work released this way by its
 * authors. You can apply it to your programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

public class YusufGuild {
    private static final Integer REASON_MAX_LENGTH = 512;
    private final Guild guild;

    public YusufGuild(Guild guild) {
        this.guild = guild;
    }

    public Member getBot() {
        return this.guild.getSelfMember();
    }

    public AuditableRestAction<Void> changeUserNickname(Member member, String nickname) {
        return this.guild.modifyNickname(member, nickname);
    }

    public String getGuildId() {
        return this.guild.getId();
    }

    public Boolean checkReasonLength(String reason, YusufSlashCommandEvent event) {
        if(reason.length() > REASON_MAX_LENGTH) {
            event.replyEphemeralMessage("You have gone over the reason character limit which is " + REASON_MAX_LENGTH + " .");
            return false;
        }
        return true;
    }


}
