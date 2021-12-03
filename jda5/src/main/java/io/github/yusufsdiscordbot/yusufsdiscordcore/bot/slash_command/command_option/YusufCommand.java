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

import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.DataType;
import net.dv8tion.jda.internal.utils.Checks;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Represents a subcommand group.
 *
 * Credits to the JDA team for the code for this class. This code was taken from {@link net.dv8tion.jda.api.interactions.commands.Command}
 */
@SuppressWarnings("unused")
public record YusufCommand(YusufChoices yusufChoices, Command command) implements ISnowflake {

    @Override
    public long getIdLong() {
        return this.command.getIdLong();
    }

    /**
     * This was originally from {@link Command} but it was modified by Yusuf and changed to
     * {@link YusufCommand}
     */
    public static class YusufChoices {
        private static final String VALUE = "value";
        private final String name;
        private long intValue = 0;
        private double doubleValue = Double.NaN;
        private String stringValue = null;

        public YusufChoices(@Nonnull String name, long value) {
            this.name = name;
            setIntValue(value);
        }

        public YusufChoices(@Nonnull String name, double value) {
            this.name = name;
            setDoubleValue(value);
        }

        public YusufChoices(@Nonnull String name, @Nonnull String value) {
            this.name = name;
            setStringValue(value);
        }

        public YusufChoices(@Nonnull DataObject json) {
            Checks.notNull(json, "DataObject");
            this.name = json.getString("name");
            if (json.isType(VALUE, DataType.INT)) {
                setIntValue(json.getLong(VALUE));
            } else if (json.isType(VALUE, DataType.FLOAT)) {
                setDoubleValue(json.getDouble(VALUE));
            } else {
                setStringValue(json.getString(VALUE));
            }
        }

        @Nonnull
        public String getName() {
            return name;
        }

        public double getAsDouble() {
            return doubleValue;
        }

        public long getAsLong() {
            return intValue;
        }

        public String getAsString() {
            return stringValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, stringValue);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof YusufChoices other))
                return false;
            return Objects.equals(other.name, name)
                    && Objects.equals(other.stringValue, stringValue);
        }

        @Override
        public String toString() {
            return "Choice(" + name + "," + stringValue + ")";
        }

        private void setIntValue(long value) {
            this.doubleValue = value;
            this.intValue = value;
            this.stringValue = Long.toString(value);
        }

        private void setDoubleValue(double value) {
            this.doubleValue = value;
            this.intValue = (long) value;
            this.stringValue = Double.toString(value);
        }

        private void setStringValue(@Nonnull String value) {
            this.doubleValue = Double.NaN;
            this.intValue = 0;
            this.stringValue = value;
        }
    }
}
