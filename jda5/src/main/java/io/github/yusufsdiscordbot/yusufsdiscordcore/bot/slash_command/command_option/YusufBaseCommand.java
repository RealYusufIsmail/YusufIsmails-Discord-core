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

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.utils.Checks;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The base class for all classes in the command option package.
 *
 * This was taken from the JDA library.
 * {@link net.dv8tion.jda.api.interactions.commands.build.BaseCommand}
 */
public abstract class YusufBaseCommand<T extends YusufBaseCommand<T>> implements SerializableData {
    protected final DataArray options = DataArray.empty();
    protected String name;
    protected String description;

    public YusufBaseCommand(@Nonnull String name, @Nonnull String description) {
        Checks.notEmpty(name, "Name");
        Checks.notEmpty(description, "Description");
        Checks.notLonger(name, 32, "Name");
        Checks.notLonger(description, 100, "Description");
        Checks.matches(name, Checks.ALPHANUMERIC_WITH_DASH, "Name");
        Checks.isLowercase(name, "Name");
        this.name = name;
        this.description = description;
    }

    @Nonnull
    public T setName(@Nonnull String name) {
        Checks.notEmpty(name, "Name");
        Checks.notLonger(name, 32, "Name");
        Checks.isLowercase(name, "Name");
        Checks.matches(name, Checks.ALPHANUMERIC_WITH_DASH, "Name");
        this.name = name;
        return (T) this;
    }

    @Nonnull
    public T setDescription(@Nonnull String description) {
        Checks.notEmpty(description, "Description");
        Checks.notLonger(description, 100, "Description");
        this.description = description;
        return (T) this;
    }

    @Nonnull
    public String getConfigurationName() {
        return name;
    }

    @Nonnull
    public String getConfigurationDescription() {
        return description;
    }

    public List<YusufOptionData> getOptions() {
        return options.stream(DataArray::getObject)
            .map(YusufOptionData::fromData)
            .filter(it -> it.getOptionType().getKey() > OptionType.SUB_COMMAND_GROUP.getKey())
            .collect(Collectors.toList());
    }
}
