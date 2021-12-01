/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/> Everyone is permitted to
 * copy and distribute verbatim copies of this license document, but changing it is not allowed.
 * Yusuf Arfan Ismail
 * The GNU General Public License is a free, copyleft license for software and other kinds of works.
 * The licenses for most software and other practical works are designed to take away your freedom
 * to share and change the works. By contrast, the GNU General Public License is intended to
 * guarantee your freedom to share and change all versions of a program--to make sure it remains
 * free software for all its users. We, the Free Software Foundation, use the GNU General Public
 * License for most of our software; it applies also to any other work released this way by its
 * authors. You can apply it to your programs, too.
 */

package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.handlers;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.command_option.YusufCommandData;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public record YusufCommandListUpdateAction(
        CommandListUpdateAction action) implements RestAction<List<Command>> {

    @Override
    public @NotNull
    YusufCommandListUpdateAction timeout(long timeout, @Nonnull TimeUnit unit) {
        action.timeout(timeout, unit);
        return this;
    }

    @Override
    public @NotNull
    YusufCommandListUpdateAction deadline(long timestamp) {
        action.deadline(timestamp);
        return this;
    }

    @Override
    public void queue(@org.jetbrains.annotations.Nullable Consumer<? super List<Command>> success, @org.jetbrains.annotations.Nullable Consumer<? super Throwable> failure) {
        action.queue(success, failure);
    }

    @Override
    public List<Command> complete(boolean shouldQueue) throws RateLimitedException {
        return action.complete();
    }

    @NotNull
    @Override
    public CompletableFuture<List<Command>> submit(boolean shouldQueue) {
        return action.submit();
    }


    @NotNull
    @Override
    public JDA getJDA() {
        return action.getJDA();
    }

    public @NotNull
    YusufCommandListUpdateAction setCheck(@Nullable BooleanSupplier checks) {
        action.setCheck(checks);
        return this;
    }

    @Override
    public @NotNull
    YusufCommandListUpdateAction addCheck(@Nonnull BooleanSupplier checks) {
        action.addCheck(checks);
        return this;
    }

    public YusufCommandListUpdateAction addCommands(@Nonnull Collection<? extends YusufCommandData> commands) {
        for (YusufCommandData command : commands) {
            action.addCommands(command.getCommandData());
        }
        return this;
    }

    public YusufCommandListUpdateAction addCommands(@Nonnull YusufCommandData... commands) {
        for (YusufCommandData command : commands) {
            action.addCommands(command.getCommandData());
        }
        return this;
    }
}
