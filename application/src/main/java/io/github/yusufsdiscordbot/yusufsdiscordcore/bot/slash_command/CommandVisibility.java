/*
* Credits to https://github.com/Together-Java/TJ-Bot
 */
package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

/**
 * Visibility of a slash command.
 */
public enum CommandVisibility {
    /**
     * The command can be used within the context of a certain server.
     */
    SERVER,
    /**
     * The command can be used on all servers
     */
    GLOBAL
}
