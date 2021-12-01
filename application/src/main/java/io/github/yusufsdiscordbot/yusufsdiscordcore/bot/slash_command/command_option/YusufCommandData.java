package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public record YusufCommandData(CommandData commandData) {
    //TODO add command data code
    @Contract("_, _ -> new")
    public @NotNull CommandData YusufCommandData(@Nonnull String name, @Nonnull String description) {
        return new CommandData(name, description);
    }
}
