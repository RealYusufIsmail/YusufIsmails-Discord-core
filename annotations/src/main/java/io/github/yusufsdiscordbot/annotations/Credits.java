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

package io.github.yusufsdiscordbot.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(credits.class)
public @interface Credits {
    /**
     * @return The link or the class name of were the code was taken from or where inspiration was
     *         taken from.
     *
     * @since 1.0.1
     */
    String source();

    /**
     * @return A description for the reason you are giving credits
     *
     * @since 1.0.6
     */
    String reason() default "";
}
/**
 * Used to determine when a class was created.
 *
 * @since 1.0.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface credits {
    Credits[] value();
}
