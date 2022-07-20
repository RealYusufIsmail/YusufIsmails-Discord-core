package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers;

import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
@ToString
public enum CommandType {
    /**
     * This command is a moderation command.
     */
    MODERATION("moderation"),
    /**
     * This command is a fun command.
     */
    FUN("fun"),
    /**
     * This command is a utility command.
     */
    UTILITY("utility"),
    /**
     * This command is a music command.
     */
    MUSIC("music"),
    /**
     * This command is owner only.
     */
    OWNER_ONLY("owner_only"),
    /**
     * This command is used to provide info.
     */
    INFO("info"),
    /**
     * This command is used to provide support
     */
    SUPPORT("support"),
    /**
     * This command is used to set up something
     */
    SETUP("set_up"),
    /**
     * This command is under development.
     */
    DEVELOPMENT("development"),
    /**
     * This command is an example command.
     */
    EXAMPLE("example"),
    /**
     * No yet determined.
     */
    UNKNOWN("unknown");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    /**
     * The command type as a String
     * 
     * @return the command type as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * The command type as a String
     * 
     * @param name the Name of the command type
     * @return the CommandType of the given name in lowercase.
     */
    public static @NotNull CommandType getCommandType(String name) {
        for (CommandType type : CommandType.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
