/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007 Copyright (C) 2007 Free Software Foundation,
 * Inc. <https://fsf.org/> Everyone is permitted to copy and distribute verbatim copies of this
 * license document, but changing it is not allowed. Yusuf Arfan Ismail The GNU General Public
 * License is a free, copyleft license for software and other kinds of works. The licenses for most
 * software and other practical works are designed to take away your freedom to share and change the
 * works. By contrast, the GNU General Public License is intended to guarantee your freedom to share
 * and change all versions of a program--to make sure it remains free software for all its users.
 * We, the Free Software Foundation, use the GNU General Public License for most of our software; it
 * applies also to any other work released this way by its authors. You can apply it to your
 * programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.example;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.CommandType;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YusufUser;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.YusufSlashCommandInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.button.YusufButtonInteractionEvent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events.select_menu.YusufSelectMenuInteractionEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashMap;

class ExampleCommand extends SlashCommand {
    private static final String EXAMPLE_OPTION = "example_option";

    /**
     * Were the command is registered.
     */
    protected ExampleCommand() {
        super("example", "This is an example", true, CommandType.EXAMPLE);

        getSlashCommandData().addOptions(
                new OptionData(OptionType.STRING, EXAMPLE_OPTION, "This is an example option")
                    .addChoice("Test", "Works"));
    }

    @Override
    public void onSlashCommand(@NotNull YusufSlashCommandInteractionEvent yusufSlashCommandEvent) {
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

    @Override
    // example button click event
    public void onButtonInteraction(@Nonnull YusufButtonInteractionEvent buttonClickEvent) {}

    @Override
    public void onSelectMenuInteraction(@Nonnull YusufSelectMenuInteractionEvent event) {}
}
