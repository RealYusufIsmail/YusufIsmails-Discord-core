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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.YusufUser;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public record YusufInteraction(Interaction interaction) {

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
    YusufUser getUser() {
        return new YusufUser(interaction.getUser());
    }

    @Contract(" -> new")
    @NotNull
    YusufMember getMember() {
        return new YusufMember(interaction.getMember());
    }
}
