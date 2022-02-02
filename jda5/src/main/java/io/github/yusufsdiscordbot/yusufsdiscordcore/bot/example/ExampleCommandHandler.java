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

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.CoreSlashCommandHandler;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.SlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommandHandler extends CoreSlashCommandHandler {
    /**
     * Handles and registers the commands
     *
     * @param jda used to register global command
     * @param guild used to register guild commands
     */
    public ExampleCommandHandler(@NotNull JDA jda, @NotNull Guild guild) {
        super(jda, guild);

        List<SlashCommand> handler = new ArrayList<>();

        handler.add(new ExampleCommand());
        queueAndRegisterSlashCommands(handler);
    }

    @Override
    protected long botOwnerId() {
        return ExampleConfig.getOwnerId();
    }
}
