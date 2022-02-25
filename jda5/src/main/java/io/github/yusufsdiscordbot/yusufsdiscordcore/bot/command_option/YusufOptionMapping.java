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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.command_option;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public record YusufOptionMapping(OptionMapping optionMapping) {

    @Nonnull
    public List<YMember> getMentionedMembers() {
        return optionMapping.getMentionedMembers().stream().map(YMember::new).toList();
    }

    @Nonnull
    public List<YUser> getMentionedUsers() {
        return optionMapping.getMentionedUsers().stream().map(YUser::new).toList();
    }

    @Nonnull
    public List<Role> getMentionedRoles() {
        return optionMapping.getMentionedRoles().stream().toList();
    }

    @Nonnull
    public List<GuildChannel> getMentionedChannels() {
        return optionMapping.getMentionedChannels().stream().toList();
    }

    @Nonnull
    public List<IMentionable> getMentions() {
        return optionMapping.getMentions().stream().toList();
    }

    @Nonnull
    public OptionType getType() {
        return optionMapping.getType();
    }

    @Nonnull
    public String getName() {
        return optionMapping.getName();
    }

    @NotNull
    public YMember getAsMember() {
        return new YMember(optionMapping.getAsMember());
    }

    @Nonnull
    public YUser getAsUser() {
        return new YUser(optionMapping.getAsUser());
    }

    public boolean getAsBoolean() {
        return optionMapping.getAsBoolean();
    }

    public long getAsLong() {
        return optionMapping.getAsLong();
    }

    public double getAsDouble() {
        return optionMapping.getAsDouble();
    }

    public @NotNull String getAsString() {
        return optionMapping.getAsString();
    }

    @Nonnull
    public IMentionable getAsMentionable() {
        return optionMapping.getAsMentionable();
    }

    @Nonnull
    public Role getAsRole() {
        return optionMapping.getAsRole();
    }

    @Nonnull
    public GuildChannel getAsGuildChannel() {
        return optionMapping.getAsGuildChannel();
    }

    @Nullable
    public MessageChannel getAsMessageChannel() {
        return optionMapping.getAsMessageChannel();
    }

    @Nonnull
    public ChannelType getChannelType() {
        return optionMapping.getChannelType();
    }

    @Nullable
    public TextChannel getAsTextChannel() {
        return optionMapping.getAsTextChannel();
    }

    @Nullable
    public NewsChannel getAsNewsChannel() {
        return optionMapping.getAsNewsChannel();
    }

    @Nullable
    public ThreadChannel getAsThreadChannel() {
        return optionMapping.getAsThreadChannel();
    }

    @Nullable
    public AudioChannel getAsAudioChannel() {
        return optionMapping.getAsAudioChannel();
    }

    @Nullable
    public VoiceChannel getAsVoiceChannel() {
        return optionMapping.getAsVoiceChannel();
    }

    @Nullable
    public StageChannel getAsStageChannel() {
        return optionMapping.getAsStageChannel();
    }
}
