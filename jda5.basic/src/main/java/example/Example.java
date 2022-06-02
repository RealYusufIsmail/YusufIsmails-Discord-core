package example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension.SlashCommandExtender;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Example implements SlashCommandExtender {
    @Override
    public void onSlashCommand(SlashCommandInteractionEvent slash) {

    }

    @Override
    public SlashCommand build() {
        return new SlashCommandBuilder("example", "example").build();
    }
}
