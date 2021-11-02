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

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class YusufSlashCommandEvent {
    private final SlashCommandEvent event;

    public YusufSlashCommandEvent(SlashCommandEvent event) {
        this.event = event;
    }

    public SlashCommandEvent getEvent() {
        return this.event;
    }

    public YusufJDA getJDA() {
        return new YusufJDA(this.event.getJDA());
    }

    public YusufGuild getGuild() {
        return new YusufGuild(this.event.getGuild());
    }

    public YusufMember getMember() {
        return new YusufMember(this.event.getMember());
    }

    public void replyMessage(String message) {
        this.event.reply(message).queue();
    }

    public void replyEphemeralMessage(String message) {
        this.event.reply(message)
                .setEphemeral(true)
                .queue();
    }

    public void replyEmbed(MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).queue();
    }
}
