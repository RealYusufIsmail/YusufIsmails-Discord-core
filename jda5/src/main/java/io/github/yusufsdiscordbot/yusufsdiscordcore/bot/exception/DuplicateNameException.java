package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.exception;

import lombok.experimental.StandardException;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;

@StandardException
public class DuplicateNameException extends Exception {
    @Serial
    private static final long serialVersionUID = Serial.class.getName().hashCode();

    public DuplicateNameException(@NotNull SlashCommandInteraction event) {
        this(event, "This command " + event.getCommandPath() + " has a duplicate name");
    }

    public DuplicateNameException(SlashCommandInteraction event, String message) {
        super(message);
    }

    public DuplicateNameException(String message) {
        super(message);
    }
}
