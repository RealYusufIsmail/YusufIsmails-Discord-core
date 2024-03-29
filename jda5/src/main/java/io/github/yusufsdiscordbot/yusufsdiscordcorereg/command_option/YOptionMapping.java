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

package io.github.yusufsdiscordbot.yusufsdiscordcorereg.command_option;

import gnu.trove.map.TLongObjectMap;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YMentions;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class YOptionMapping extends OptionMapping {

    public YOptionMapping(DataObject data, TLongObjectMap<Object> resolved, JDA jda, Guild guild) {
        super(data, resolved, jda, guild);
    }

    @Override
    public @NotNull YUser getAsUser() {
        return (YUser) super.getAsUser();
    }

    @Override
    public YMember getAsMember() {
        return (YMember) super.getAsMember();
    }

    @Override
    public @NotNull YMentions getMentions() {
        return (YMentions) super.getMentions();
    }
}
