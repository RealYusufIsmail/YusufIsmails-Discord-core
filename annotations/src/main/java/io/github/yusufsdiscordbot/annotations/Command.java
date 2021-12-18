package io.github.yusufsdiscordbot.annotations;

/**
 * This annotation is used to mark a method as a command.
 *
 * @author yusuf
 * @since 1.0.5
 */
public @interface Command {
    /**
     * The name of the command.
     * 
     * @return The name of the command.
     *
     * @since 1.0.5
     */
    String name();

    /**
     * The description of the command.
     * 
     * @return The description of the command.
     *
     * @since 1.0.5
     */
    String description();

    /**
     * The usage of the command.
     * 
     * @return The usage of the command.
     *
     * @since 1.0.5
     */
    String usage();

    /**
     * The permission of the command.
     * 
     * @return The permission of the command.
     *
     * @since 1.0.5
     */
    String permission();

    /**
     * The category of the command.
     * 
     * @return The category of the command.
     *
     * @since 1.0.5
     */
    String category();

    /**
     * The subcommands of the command.
     * 
     * @return The subcommands of the command.
     *
     * @since 1.0.5
     */
    String[] subcommands() default {};
}
