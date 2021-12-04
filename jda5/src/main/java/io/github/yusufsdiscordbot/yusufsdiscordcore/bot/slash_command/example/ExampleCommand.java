package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufOptionData;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class ExampleCommand extends Command {
    private static final String EXAMPLE_OPTION = "example_option";

    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);

        getCommandData().addOptions(
                new YusufOptionData(OptionType.BOOLEAN, EXAMPLE_OPTION, "This is an example option")
                    .addChoice("Test", "Works"));
    }

    private static final List<YusufCommand.YusufChoices> getChoices =
            List.of(new YusufCommand.YusufChoices("Example Choice 1", 1));

    @Override
    public void onSlashCommand(@NotNull YusufSlashCommandEvent yusufSlashCommandEvent) {
        YusufUser sender = yusufSlashCommandEvent.getUser();
        EmbedBuilder builder = new EmbedBuilder();

        final String example =
                Objects.requireNonNull(yusufSlashCommandEvent.getOption(EXAMPLE_OPTION))
                    .getAsString();

        HashMap<String, String> test = new HashMap<>();

        test.put("Test", "Works");

        builder.setAuthor("Made by " + yusufSlashCommandEvent.getMember().getName(), null,
                sender.getEffectiveAvatarUrl());
        builder.setTitle("Github org/users");
        builder.setDescription("Github org/repo" + test);
        builder.setColor(0x34d8eb);

        if (test.containsKey(example)) {
            builder.setDescription(test.get(example));
        } else {
            yusufSlashCommandEvent.replyMessage("Error");
            return;
        }

        yusufSlashCommandEvent.replyEmbed(builder.build());
    }
}
