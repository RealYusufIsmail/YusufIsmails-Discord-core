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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interactions;

import io.github.yusufsdiscordbot.annotations.ToBeChanged;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YusufGuild;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YusufGuildChannel;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YusufMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YusufUser;
import net.dv8tion.jda.api.entities.AbstractChannel;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@ToBeChanged(reasonForChange = "Will replace YusufSlashCommandUtility", versionOfChange = "2.0.0",
        willBeChangedSoon = true)
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

    public @Nullable AbstractChannel getChannel() {
        return this.interaction.getChannel();
    }

    @Contract(" -> new")
    public @NotNull YusufGuildChannel getGuildChannel() {
        return new YusufGuildChannel(interaction.getGuildChannel());
    }
}
