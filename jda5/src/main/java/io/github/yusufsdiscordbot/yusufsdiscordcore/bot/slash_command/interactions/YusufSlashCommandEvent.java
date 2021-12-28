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
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionMapping;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YusufSlashCommandEvent extends YusufInteraction {
    private final Command slashCommand;
    private final SlashCommandEvent event;

    public YusufSlashCommandEvent(Command slashCommand, SlashCommandEvent event) {
        super(event);
        this.slashCommand = slashCommand;
        this.event = event;
    }

    public SlashCommandEvent getSlashCommandEvent() {
        return this.event;
    }

    public Command getCommand() {
        return slashCommand;
    }

    @Nonnull
    public String getName() {
        return this.event.getName();
    }

    public @Nonnull String getCommandString() {
        return this.event.getCommandString();
    }

    @Nullable
    public String getSubcommandName() {
        return this.event.getSubcommandName();
    }

    @Nullable
    public String getSubcommandGroup() {
        return this.event.getSubcommandGroup();
    }

    @Contract("_ -> new")
    public @Nonnull YusufOptionMapping getOption(@Nonnull String option) {
        return new YusufOptionMapping(this.event.getOption(option));
    }

    public @Nonnull List<OptionMapping> getOptionByType(@Nonnull OptionType type) {
        return this.event.getOptionsByType(type);
    }

    public void replyQueuedMessage(@Nonnull String message) {
        this.event.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        this.event.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
