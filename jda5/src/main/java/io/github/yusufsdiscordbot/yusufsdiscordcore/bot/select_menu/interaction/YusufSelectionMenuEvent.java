package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.interaction;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

// TODO : make this class
public class YusufSelectionMenuEvent extends YusufSelectionMenuInteraction {
    private final SelectionMenuEvent event;

    public YusufSelectionMenuEvent(SelectionMenuEvent event) {
        super(event);
        this.event = event;
    }

    public SelectionMenuEvent getEvent() {
        return event;
    }

    public @NotNull String getMessageId() {
        return event.getMessageId();
    }


    public void replyQueuedMessage(@Nonnull String message) {
        this.event.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        this.event.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.event.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
