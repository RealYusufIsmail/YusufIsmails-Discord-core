package example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event.YSlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class ExampleCommand implements SlashCommandExtender {
    @Override
    public void onSlashCommand(@NotNull YSlashCommandInteractionEvent slash) {
        slash.replyQueuedMessage("Hello, " + slash.getUser().getAsMention() + "!");
    }

    @Override
    public SlashCommand build() {
        return new SlashCommandBuilder("Example", "An example command").build();
    }
}
