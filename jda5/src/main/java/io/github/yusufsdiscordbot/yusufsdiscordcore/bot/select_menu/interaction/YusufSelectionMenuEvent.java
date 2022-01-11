package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.Command;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

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

    public @NotNull String getMessageId() {
        return event.getMessageId();
    }

    public YusufComponent getComponent() {
        return new YusufComponent(event.getComponent());
    }

    public YusufSelectionMenuInteraction getYusufSelectionMenuInteraction() {
        return new YusufSelectionMenuInteraction(event.getInteraction());
    }

    @Nonnull
    public List<String> getValues() {
        return event.getValues();
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
