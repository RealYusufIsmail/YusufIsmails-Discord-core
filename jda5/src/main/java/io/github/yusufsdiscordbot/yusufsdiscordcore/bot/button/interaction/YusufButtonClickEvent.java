package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.YusufButton;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command.interactions.Command;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;

@SuppressWarnings({"unused"})
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
}
