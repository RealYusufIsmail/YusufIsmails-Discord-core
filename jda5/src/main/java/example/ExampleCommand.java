package example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.slash.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YSlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class ExampleCommand implements SlashCommandExtender {

    @Override
    public void onSlashCommandInteraction(@NotNull YSlashCommandInteractionEvent event) {

    }

    @Override
    public SlashCommand build() {
        return null;
    }
}
