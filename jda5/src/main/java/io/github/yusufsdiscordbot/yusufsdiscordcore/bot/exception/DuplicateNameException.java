package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.exception;

import lombok.Getter;
import lombok.experimental.StandardException;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

@StandardException
public class DuplicateNameException extends Exception {
    @Getter
    private final SlashCommandInteraction event;

    public DuplicateNameException(@NotNull SlashCommandInteraction event) {
        this(event, "This command " + event.getCommandPath() + " has a duplicate name");
    }

    public DuplicateNameException(SlashCommandInteraction event, String message) {
        super(message);
        this.event = event;
    }
}
