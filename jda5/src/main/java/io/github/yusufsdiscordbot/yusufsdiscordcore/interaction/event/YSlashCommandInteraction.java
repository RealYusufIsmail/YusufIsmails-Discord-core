package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import net.dv8tion.jda.api.entities.GuildMessageChannel;
import net.dv8tion.jda.api.entities.MessageChannel;

import javax.annotation.Nonnull;

public interface YSlashCommandInteraction extends YCommandInteraction {
    @Nonnull
    @Override
    MessageChannel getChannel();

    @Nonnull
    @Override
    default GuildMessageChannel getGuildChannel() {
        return (GuildMessageChannel) YCommandInteraction.super.getGuildChannel();
    }
}
