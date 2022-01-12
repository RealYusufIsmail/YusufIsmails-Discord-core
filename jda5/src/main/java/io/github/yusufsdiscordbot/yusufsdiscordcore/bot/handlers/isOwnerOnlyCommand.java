package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers;

import java.lang.annotation.Documented;

/**
 * Used to make a command owner only
 */
@Documented
// TODO: finish this class
public @interface isOwnerOnlyCommand {
    /**
     * @return true if command is owner only, false if it is not.
     * @since 2.0.0
     */
    boolean isOwnerOnly();
}
