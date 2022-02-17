package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.exception;

import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public class DuplicateNameException extends Exception {
    private final SlashCommandInteraction event;

    public DuplicateNameException(SlashCommandInteraction event) {
        this(event, "This command " + event.getCommandPath() + " has a duplicate name");
    }

    public DuplicateNameException(SlashCommandInteraction event, String message) {
        super(message);
        this.event = event;
    }

    public SlashCommandInteraction getEvent() {
        return event;
    }
}
