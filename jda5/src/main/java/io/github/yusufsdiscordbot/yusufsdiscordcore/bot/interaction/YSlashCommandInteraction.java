package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.dv8tion.jda.api.entities.GuildMessageChannel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@EqualsAndHashCode(callSuper = false)
public class YSlashCommandInteraction extends YCommandInteraction {
    @Getter
    private final SlashCommandInteraction slashCommandInteraction;

    public YSlashCommandInteraction(IReplyCallback callback,
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
    public YSlashCommandInteraction getInteraction() {
        return this;
    }
}
