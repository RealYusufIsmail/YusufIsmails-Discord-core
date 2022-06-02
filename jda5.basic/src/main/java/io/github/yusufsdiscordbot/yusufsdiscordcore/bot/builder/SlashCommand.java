package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.type.CommandType;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;


public class SlashCommand {
    private final SlashCommandData commandData;
    private Permission[] userPerms = null;
    private Permission[] botPerms = null;
    private boolean isGuildOnly = false;
    private boolean isOwnerOnly = false;
    private CommandType commandType;

    SlashCommand(final SlashCommandData commandData, CommandType commandType) {
        this.commandData = commandData;
        //if null then it is a normal command
        this.commandType = commandType == null ? CommandType.NORMAL : commandType;
    }

    public SlashCommandData getSlashCommandData() {
        return commandData;
    }

    public SlashCommand setBotPerms(final Permission... perms) {
        this.botPerms = perms;
        return this;
    }

    public SlashCommand setUserPerms(final Permission... perms) {
        this.userPerms = perms;
        return this;
    }

    public SlashCommand setToOwnerOnly() {
        this.isOwnerOnly = true;
        return this;
    }

    public SlashCommand setToGuildOnly() {
        this.isGuildOnly = true;
        return this;
    }

    public Permission[] getBotPerms() {
        return botPerms;
    }

    public Permission[] getUserPerms() {
        return userPerms;
    }

    public boolean isGuildOnly() {
        return isGuildOnly;
    }

    public boolean isOwnerOnly() {
        return isOwnerOnly;
    }
    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }
}
