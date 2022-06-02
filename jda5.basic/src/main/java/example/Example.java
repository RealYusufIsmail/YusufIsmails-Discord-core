package example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.type.CommandType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.jetbrains.annotations.NotNull;

public class Example extends SlashCommandExtender {
    protected Example(SlashCommandData commandDate) {
        super(commandDate);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

    }


    @Override
    public SlashCommand build() {
        return new SlashCommandBuilder("example", "example").build();
    }
}
