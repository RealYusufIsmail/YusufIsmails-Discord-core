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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufBot;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.InteractionType;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufInteraction {
    private final Interaction interaction;

    public YusufInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public int getTypeRaw() {
        return interaction.getTypeRaw();
    }

    public @NotNull InteractionType getType() {
        return interaction.getType();
    }

    public @NotNull String getToken() {
        return interaction.getToken();
    }

    @Contract(" -> new")
    public @NotNull YusufGuild getGuild() {
        return new YusufGuild(interaction.getGuild());
    }

    public boolean isFromGuild() {
        return interaction.isFromGuild();
    }

    public @NotNull ChannelType getChannelType() {
        return interaction.getChannelType();
    }

    @Contract(" -> new")
    @NotNull
    public YusufUser getUser() {
        return new YusufUser(interaction.getUser());
    }

    @Contract(" -> new")
    @NotNull
    public YusufMember getMember() {
        return new YusufMember(interaction.getMember());
    }

    @Nullable
    public Channel getChannel() {
        return this.interaction.getChannel();
    }

    @NotNull
    public InteractionHook getHook() {
        return this.interaction.getHook();
    }

    public boolean isAcknowledged() {
        return this.interaction.isAcknowledged();
    }

    @NotNull
    public ReplyAction deferReply() {
        return this.interaction.deferReply();
    }

    @NotNull
    public JDA getJDA() {
        return this.interaction.getJDA();
    }

    public String getId() {
        return this.interaction.getId();
    }

    public long getIdLong() {
        return this.interaction.getIdLong();
    }

    @Contract(" -> new")
    public @NotNull YusufBot getBot() {
        return new YusufBot(this.getJDA().getSelfUser());
    }

    public String toString() {
        return this.interaction.toString();
    }
}
