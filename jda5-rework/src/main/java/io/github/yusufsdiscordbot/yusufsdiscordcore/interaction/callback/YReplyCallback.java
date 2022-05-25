package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;

import javax.annotation.Nonnull;

public interface YReplyCallback extends IReplyCallback {
    void replyQueuedMessage(@Nonnull String message);

    void replyQueuedEphemeral(@Nonnull String message);

    void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed);

    void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed);
}
