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

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Can be used to give the author of the code credit.
 *
 * @author Yusuf Arfan Ismail
 *
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {METHOD, TYPE, LOCAL_VARIABLE, CONSTRUCTOR})
public @interface Author {
    /**
     * @return the name of the person who wrote the code.
     *
     * @since 1.0.0
     */
    String firstName() default "";

    /**
     * @return the last name of the person who wrote the code.
     *
     * @since 1.0.0
     */
    @NotNull
    String lastName() default "";

    /**
     * @return the GitHub username of the person who wrote the code.
     *
     * @since 1.0.0
     */
    @NotNull
    String githubUserName() default "";
}
