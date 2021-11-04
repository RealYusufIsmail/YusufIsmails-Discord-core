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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class YusufSlashCommandEvent {
    private final CommandConnector command;
    private final SlashCommandEvent event;

    public YusufSlashCommandEvent(CommandConnector command, SlashCommandEvent event) {
        this.command = command;
        this.event = event;
    }

    public SlashCommandEvent getEvent() {
        return this.event;
    }

    public CommandConnector getCommand() {
        return this.command;
    }

    public YusufGuild getGuild() {
        return new YusufGuild(this.event.getGuild());
    }

    public YusufMember getMember() {
        return new YusufMember(this.event.getMember());
    }

    public YusufUser getUser() {
        return new YusufUser((this.event.getUser()));
    }

    public TextChannel getTextChannel() {
        return this.event.getTextChannel();
    }

    public JDA getJDA() {
        return this.event.getJDA();
    }

    public ChannelType getChannelType() {
        return this.event.getChannelType();
    }

    @Nullable
    public OptionMapping getOption(String option) {
        return this.event.getOption(option);
    }

    @Nullable
    public List<OptionMapping> getOptionByType(OptionType type) {
        return this.event.getOptionsByType(type);
    }

    @Nullable
    public String getSubcommandName() {
        return this.event.getSubcommandName();
    }

    @Nullable
    public String getSubcommandGroup() {
        return this.event.getSubcommandGroup();
    }

    @Nonnull
    public MessageChannel getChannel() {
        return this.event.getChannel();
    }

    @Nonnull
    public String getName() {
        return this.event.getName();
    }

    /**
     * replays as a normal message.
     */
    public void replyMessage(String message) {
        this.event.reply(message).queue();
    }

    public void replyMessage(String message, Boolean setEphemeral) {
        this.event.reply(message)
                .setEphemeral(setEphemeral)
                .queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyEphemeralMessage(String message) {
        this.event.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyEmbed(MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed, new MessageEmbed[0]).queue();
    }

    @Nonnull
    public Interaction getInteraction()
    {
        return this.event.getInteraction();
    }

    @Nonnull
    public String getToken()
    {
        return this.event.getToken();
    }

    public int getTypeRaw()
    {
        return this.event.getTypeRaw();
    }

    @Nonnull
    public InteractionHook getHook()
    {
        return this.event.getHook();
    }

    public long getIdLong()
    {
        return this.event.getIdLong();
    }

    public boolean isAcknowledged()
    {
        return this.event.isAcknowledged();
    }

    @Nonnull
    public ReplyAction deferReply()
    {
        return this.event.deferReply();
    }
}
