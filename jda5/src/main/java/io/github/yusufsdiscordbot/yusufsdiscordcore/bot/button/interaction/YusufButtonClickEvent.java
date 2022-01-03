package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.YusufButton;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.Command;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;

import javax.annotation.Nonnull;

@SuppressWarnings({"unused"})
public class YusufButtonClickEvent extends YusufButtonInteraction {
    private final Command command;
    private final ButtonClickEvent event;

    public YusufButtonClickEvent(Command command, ButtonClickEvent event) {
        super(event);
        this.command = command;
        this.event = event;
    }

    public Command getCommand() {
        return command;
    }

    public ButtonClickEvent getButtonClickEvent() {
        return event;
    }

    public YusufButtonInteraction getYusufButtonInteraction() {
        return new YusufButtonInteraction(event.getInteraction());
    }

    public YusufComponent getComponent() {
        return new YusufComponent(event.getComponent());
    }

    public YusufButton getYusufButton() {
        return new YusufButton(event.getButton());
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
