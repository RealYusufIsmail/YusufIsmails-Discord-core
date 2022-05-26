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

package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event;

import io.github.yusufsdiscordbot.annotations.Author;
import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YSlashCommandInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YGenericCommandInteractionEvent;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

import javax.annotation.Nonnull;

@ToString
@EqualsAndHashCode(callSuper = false)
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YSlashCommandInteractionEvent extends YGenericCommandInteractionEvent
        implements YSlashCommandInteraction {

    private final YSlashCommandInteraction interaction;

    public YSlashCommandInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YSlashCommandInteraction interaction) {
        super(api, responseNumber, interaction);
        this.interaction = interaction;
    }


    @Nonnull
    @Override
    public YSlashCommandInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return interaction.getChannel();
    }
}

