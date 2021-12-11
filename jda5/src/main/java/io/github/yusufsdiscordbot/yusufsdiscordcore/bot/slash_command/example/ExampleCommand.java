package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.core.YusufUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.Command;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.YusufSlashCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class ExampleCommand extends Command {
    private static final String EXAMPLE_OPTION = "example_option";

    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true);

        getYusufCommandData().addOptions(
                new OptionData(OptionType.STRING, EXAMPLE_OPTION, "This is an example option")
                    .addChoice("Test", "Works"));
    }

    @Override
    public void onSlashCommand(@NotNull YusufSlashCommandEvent yusufSlashCommandEvent) {
        YusufUser sender = yusufSlashCommandEvent.getUser();
        EmbedBuilder builder = new EmbedBuilder();

        final String example = yusufSlashCommandEvent.getOption(EXAMPLE_OPTION).getAsString();

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
            yusufSlashCommandEvent.replyQueuedMessage("Error");
            return;
        }

        yusufSlashCommandEvent.replyQueuedEmbed(builder.build());
    }
}
