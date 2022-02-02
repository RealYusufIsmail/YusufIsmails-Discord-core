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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions;

import io.github.yusufsdiscordbot.annotations.Author;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.SlashCommand;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YusufSlashCommandInteractionEvent extends YusufCommandInteraction {
    private final SlashCommand command;
    private final SlashCommandInteractionEvent event;

    public YusufSlashCommandInteractionEvent(SlashCommand command,
            SlashCommandInteractionEvent event) {
        super(event, event);
        this.command = command;
        this.event = event;
    }


    public SlashCommandInteractionEvent getSlashCommandEvent() {
        return event;
    }

    public SlashCommand getCommand() {
        return command;
    }

    @Nonnull
    public YusufSlashCommandInteraction getInteraction() {
        IReplyCallback callback = getCallback();
        return new YusufSlashCommandInteraction(callback, getCommandInteractionPayload(),
                event.getInteraction());
    }

    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return event.getChannel();
    }
}
