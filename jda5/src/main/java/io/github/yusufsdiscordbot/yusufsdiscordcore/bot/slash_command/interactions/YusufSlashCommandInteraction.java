package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions;

import net.dv8tion.jda.api.entities.GuildMessageChannel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class YusufSlashCommandInteraction extends YusufCommandInteraction {
    private final SlashCommandInteraction slashCommandInteraction;

    public YusufSlashCommandInteraction(IReplyCallback callback,
            CommandInteractionPayload commandInteractionPayload,
            SlashCommandInteraction slashCommandInteraction) {
        super(callback, commandInteractionPayload);
        this.slashCommandInteraction = slashCommandInteraction;
    }

    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return slashCommandInteraction.getChannel();
    }

    @Nonnull
    @Override
    public GuildMessageChannel getGuildChannel() {
        return slashCommandInteraction.getGuildChannel();
    }

    @NotNull
    @Override
    public YusufSlashCommandInteraction getInteraction() {
        return this;
    }
}
