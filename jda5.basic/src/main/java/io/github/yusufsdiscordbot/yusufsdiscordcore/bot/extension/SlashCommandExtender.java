package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.jetbrains.annotations.NotNull;

public abstract class SlashCommandExtender extends SlashCommand {

    protected SlashCommandExtender(SlashCommandData commandData) {
        super(commandData);
    }

    // This method is called when the command is executed.
    @Override
    public abstract void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event);

    protected abstract SlashCommand build();
}
