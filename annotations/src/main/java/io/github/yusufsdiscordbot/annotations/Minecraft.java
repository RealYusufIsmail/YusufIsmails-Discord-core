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

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;

/**
 * Used to indicate that this part of the core is related to minecraft not the discord bot.
 *
 * All methods and fields annotated with this annotation will be only be used for my minecraft mods
 * hence you should ignore it.
 *
 * @since 1.0.4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {METHOD, TYPE, LOCAL_VARIABLE, CONSTRUCTOR})
@Documented
public @interface Minecraft {
    /**
     * The name of the minecraft mod.
     *
     * @return The name of the minecraft mod.
     * @since 1.0.4
     */
    String mod() default "";

    /**
     * The version of the minecraft mod.
     *
     * @return The version of the minecraft mod.
     * @since 1.0.4
     */
    String version() default "";

    /**
     * The description of the minecraft mod.
     *
     * @return The description of the minecraft mod.
     * @since 1.0.4
     */
    String description() default "";

    /**
     * The url of the minecraft mod.
     *
     * @return The url of the minecraft mod.
     * @since 1.0.4
     */
    String url() default "";

    /**
     * The license of the minecraft mod.
     *
     * @return The license of the minecraft mod.
     * @since 1.0.4
     */
    String license() default "";

    /**
     * The minecraft mod's website.
     *
     * @return The minecraft mod's website.
     * @since 1.0.4
     */
    String website() default "";

    /**
     * The minecraft mod's GitHub.
     *
     * @return The minecraft mod's GitHub.
     * @since 1.0.4
     */
    String github() default "";

    /**
     * The minecraft mod's Discord.
     *
     * @return The minecraft mod's Discord.
     * @since 1.0.4
     */
    String discord() default "";

    /**
     * Used to determine if the minecraft mod is a mod or a plugin.
     *
     * @return If the minecraft mod is a mod or a plugin.
     * @since 1.0.4
     */
    boolean isPlugin() default false;
}
