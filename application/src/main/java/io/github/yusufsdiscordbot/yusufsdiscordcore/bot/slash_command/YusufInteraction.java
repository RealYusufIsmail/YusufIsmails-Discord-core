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

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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

    @Nonnull
    public InteractionType getType() {
        return interaction.getType();
    }

    @Nonnull
    public String getToken() {
        return interaction.getToken();
    }

    @Nullable
    public YusufGuild getGuild() {
        return new YusufGuild(interaction.getGuild());
    }

    public boolean isFromGuild() {
        return interaction.isFromGuild();
    }

    @Nonnull
    public ChannelType getChannelType() {
        return interaction.getChannelType();
    }

    @Nonnull
    YusufUser getUser() {
        return new YusufUser(interaction.getUser());
    }

    @Nullable
    YusufMember getMember() {
        return new YusufMember(interaction.getMember());
    }

    @Nullable
    AbstractChannel getChannel() {
        return this.interaction.getChannel();
    }

    @Nonnull
    public YusufGuildChannel getGuildChannel() {
        return new YusufGuildChannel(interaction.getGuildChannel());
    }
}
