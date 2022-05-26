package example;

import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder.SlashCommandFinalizer;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YSlashCommandInteractionEvent;

public class ExampleCommand implements SlashCommandExtender {
    @Override
    public void onSlashCommand(YSlashCommandInteractionEvent slash) {

    }

    @Override
    public SlashCommandFinalizer build() {
        return new SlashCommandBuilder("", "")
                .build();
    }


}
