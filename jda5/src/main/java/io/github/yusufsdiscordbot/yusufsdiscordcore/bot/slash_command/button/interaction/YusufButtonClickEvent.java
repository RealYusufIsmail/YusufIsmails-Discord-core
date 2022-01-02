package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.button.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.button.YusufButton;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.Command;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;

import javax.annotation.Nonnull;

public class YusufButtonClickEvent extends YusufButtonInteraction {
    private final Command command;
    private final ButtonClickEvent buttonClickEvent;

    public YusufButtonClickEvent(Command command, ButtonClickEvent buttonClickEvent) {
        super(buttonClickEvent);
        this.command = command;
        this.buttonClickEvent = buttonClickEvent;
    }

    public Command getCommand() {
        return command;
    }

    public ButtonClickEvent getButtonClickEvent() {
        return buttonClickEvent;
    }

    public YusufButtonInteraction getYusufButtonInteraction() {
        return new YusufButtonInteraction(buttonClickEvent.getInteraction());
    }

    public YusufComponent getComponent() {
        return new YusufComponent(buttonClickEvent.getComponent());
    }

    public YusufButton getYusufButton() {
        return new YusufButton(buttonClickEvent.getButton());
    }

    public void replyQueuedMessage(@Nonnull String message) {
        this.buttonClickEvent.reply(message).queue();
    }

    /**
     * replays as an ephemeral message.
     */
    public void replyQueuedEphemeral(@Nonnull String message) {
        this.buttonClickEvent.reply(message).setEphemeral(true).queue();
    }

    /**
     * replays as an embed message.
     */
    public void replyQueuedEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.buttonClickEvent.replyEmbeds(messageEmbed).queue();
    }

    public void replyQueuedEphemeralEmbed(@Nonnull MessageEmbed messageEmbed) {
        this.buttonClickEvent.replyEmbeds(messageEmbed).setEphemeral(true).queue();
    }
}
