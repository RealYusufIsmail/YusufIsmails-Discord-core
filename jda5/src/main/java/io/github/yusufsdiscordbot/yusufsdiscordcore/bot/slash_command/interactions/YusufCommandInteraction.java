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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufCommandInteraction {
    private final SlashCommandEvent interaction;

    public YusufCommandInteraction(SlashCommandEvent interaction) {
        this.interaction = interaction;
    }

    public YusufInteraction getInteraction() {
        return new YusufInteraction(interaction.getInteraction());
    }

    public int getTypeRaw() {
        return getInteraction().getTypeRaw();
    }

    public @NotNull InteractionType getType() {
        return getInteraction().getType();
    }

    public @NotNull String getToken() {
        return getInteraction().getToken();
    }

    @Contract(" -> new")
    public @Nullable YusufGuild getGuild() {
        return getInteraction().getGuild();
    }

    public boolean isFromGuild() {
        return getInteraction().isFromGuild();
    }

    public @NotNull ChannelType getChannelType() {
        return interaction.getChannelType();
    }

    @Contract(" -> new")
    @NotNull
    public YusufUser getUser() {
        return getInteraction().getUser();
    }

    @Contract(" -> new")
    @NotNull
    public YusufMember getMember() {
        return getInteraction().getMember();
    }

    @Nullable
    public Channel getChannel() {
        return this.getInteraction().getChannel();
    }

    @NotNull
    public InteractionHook getHook() {
        return this.getInteraction().getHook();
    }

    public boolean isAcknowledged() {
        return this.getInteraction().isAcknowledged();
    }

    @NotNull
    public ReplyAction deferReply() {
        return this.getInteraction().deferReply();
    }

    @NotNull
    public JDA getJDA() {
        return this.getInteraction().getJDA();
    }

    public String getId() {
        return this.getInteraction().getInteractionId();
    }

    public long getIdLong() {
        return this.getInteraction().getInteractionIdLong();
    }

    @Contract(" -> new")
    public @NotNull YusufBot getBot() {
        return new YusufBot(this.getJDA().getSelfUser());
    }

    public String toString() {
        return this.getInteraction().toString();
    }
}
