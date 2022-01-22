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
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionMapping;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YusufSlashCommandEvent extends YusufCommandInteraction {
    private final Command slashCommand;
    private final SlashCommandEvent event;

    public YusufSlashCommandEvent(Command slashCommand, SlashCommandEvent event) {
        super(event);
        this.slashCommand = slashCommand;
        this.event = event;
    }

    public SlashCommandEvent getSlashCommandEvent() {
        return event;
    }

    public Command getCommand() {
        return slashCommand;
    }

    @Nonnull
    @Override
    public MessageChannel getMessageChannel() {
        return event.getChannel();
    }

    @Nonnull
    @Override
    public String getName() {
        return event.getName();
    }

    @Nullable
    @Override
    public String getSubcommandName() {
        return event.getSubcommandName();
    }

    @Nullable
    @Override
    public String getSubcommandGroup() {
        return event.getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return event.getCommandIdLong();
    }

    @Nonnull
    @Override
    public List<YusufOptionMapping> getOptions() {
        return event.getOptions().stream().map(YusufOptionMapping::new).toList();
    }

    @Nonnull
    @Override
    public String getCommandString() {
        return event.getCommandString();
    }

    @Override
    public void replyQueuedMessage(@Nonnull String message) {
        event.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        event.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        event.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        event.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
