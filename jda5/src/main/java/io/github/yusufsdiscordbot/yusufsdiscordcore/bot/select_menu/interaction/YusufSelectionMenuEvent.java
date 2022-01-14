package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.Command;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;

import javax.annotation.Nonnull;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufSelectionMenuEvent extends YusufSelectionMenuInteraction {
    private final Command command;
    private final SelectionMenuEvent event;

    public YusufSelectionMenuEvent(Command command, SelectionMenuEvent event) {
        super(event);
        this.command = command;
        this.event = event;
    }

    public Command getCommand() {
        return command;
    }

    public SelectionMenuEvent getEvent() {
        return event;
    }

    public YusufSelectionMenuInteraction getYusufSelectionMenuInteraction() {
        return new YusufSelectionMenuInteraction(event.getInteraction());
    }

    @Override
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
