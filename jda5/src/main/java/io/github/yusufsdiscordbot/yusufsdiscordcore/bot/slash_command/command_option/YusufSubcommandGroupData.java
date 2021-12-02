/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/> Everyone is permitted to
 * copy and distribute verbatim copies of this license document, but changing it is not allowed.
 * Yusuf Arfan Ismail
 * The GNU General Public License is a free, copyleft license for software and other kinds of works.
 * The licenses for most software and other practical works are designed to take away your freedom
 * to share and change the works. By contrast, the GNU General Public License is intended to
 * guarantee your freedom to share and change all versions of a program--to make sure it remains
 * free software for all its users. We, the Free Software Foundation, use the GNU General Public
 * License for most of our software; it applies also to any other work released this way by its
 * authors. You can apply it to your programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

public class YusufSubcommandGroupData implements SerializableData {
    private final DataArray options = DataArray.empty();
    private final SubcommandGroupData subcommandGroupData;

    public YusufSubcommandGroupData(@Nonnull String name, @Nonnull String description) {
        subcommandGroupData = new SubcommandGroupData(name, description);
    }

    public SubcommandGroupData setName(@Nonnull String name) {
        return subcommandGroupData.setName(name);
    }

    public SubcommandGroupData setDescription(@Nonnull String description) {
        return subcommandGroupData.setDescription(description);
    }

    public String getName() {
        return subcommandGroupData.getName();
    }

    public String getDescription() {
        return subcommandGroupData.getDescription();
    }

    public List<YusufSubcommandData> getSubcommands() {
        return options.stream(DataArray::getObject)
                .map(YusufSubcommandData::fromData)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public DataObject toData() {
        return subcommandGroupData.toData();
    }

}
