package github.io.yusuf.core.bot.slash_command;

/**
 * Visibility of a slash command, i.e. in which context it can be used by users.
 */
public enum SlashCommandVisibility {
    /**
     * The command can be used within the context of a guild.
     */
    GUILD,
    /**
     * The command can be used globally, outside a guild context.
     */
    GLOBAL
}
