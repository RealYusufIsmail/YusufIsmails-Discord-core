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
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionMapping;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionType;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class YusufSlashCommandEvent extends YusufSlashCommandUtility {
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

    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(this.event.getGuild());
    }

    @Contract(" -> new")
    public @NotNull YusufMember getMember() {
        return new YusufMember(this.event.getMember());
    }

    @Contract(" -> new")
    public @NotNull YusufUser getUser() {
        return new YusufUser((this.event.getUser()));
    }

    public @NotNull JDA getJDA() {
        return this.event.getJDA();
    }

    public Command getCommand() {
        return slashCommand;
    }

    @Contract(" -> new")
    public YusufBot getBot() {
        return new YusufBot(this.getJDA().getSelfUser());
    }

    @Nonnull
    public MessageChannel getChannel() {
        return this.event.getChannel();
    }
}
