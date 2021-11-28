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

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Used to determine weather the command will be removed or not.
 *
 * @author Yusuf Arfan Ismail
 *
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = {METHOD, TYPE})
public @interface ToBeRemoved {
    /**
     * @return The expected version of when the code will be removed.
     *
     * @since 1.0.1
     */
    String versionOfRemoval() default "";

    /**
     * @return The expected date when the command will be removed.
     *
     * @since 1.0.1
     */
    String dateOfChange() default "";

    /**
     * @return Used to determine if the command will be removed in the near future.
     *
     * @since 1.0.1
     */
    boolean willBeRemovedSoon() default true;

    /**
     * @return The reason why the command will be removed.
     *
     * @since 1.0.1
     */
    String reasonForRemoval() default "";
}
