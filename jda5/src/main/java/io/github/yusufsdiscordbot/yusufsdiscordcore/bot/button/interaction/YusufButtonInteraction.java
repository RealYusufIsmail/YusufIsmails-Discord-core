package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponentInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteractionHook;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button.YusufButton;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.components.*;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"unused", "java:S6206"})
public class YusufButtonInteraction extends YusufComponentInteraction {
    private final ButtonInteraction buttonInteraction;

    public YusufButtonInteraction(ButtonInteraction buttonInteraction) {
        super(buttonInteraction);
        this.buttonInteraction = buttonInteraction;
    }

    public ButtonInteraction getButtonInteraction() {
        return buttonInteraction;
    }

    public YusufComponentInteraction getYusufButtonInteraction() {
        return new YusufComponentInteraction(buttonInteraction);
    }

    public YusufInteractionHook getYusufInteractionHook() {
        return new YusufInteractionHook(buttonInteraction.getHook());
    }

    @Override
    public YusufInteraction getYusufInteraction() {
        return getYusufInteractionHook().getInteraction();
    }

    @Nullable
    public YusufButton getButton() {
        return new YusufButton(this.buttonInteraction.getButton());
    }

    @NotNull
    @Override
    public String getComponentId() {
        return getYusufButtonInteraction().getComponentId();
    }

    /**
     * The {@link Component} instance. <br>
     * This is null on interactions for ephemeral messages.
     *
     * @return The {@link Component}, or null if this message is ephemeral
     */
    @Nullable
    @Override
    public YusufComponent getComponent() {
        return getYusufButtonInteraction().getComponent();
    }

    @NotNull
    @Override
    public Message getMessage() {
        return getYusufButtonInteraction().getMessage();
    }

    @Override
    public long getMessageIdLong() {
        return getYusufButtonInteraction().getMessageIdLong();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    @NotNull
    @Override
    public String getMessageId() {
        return this.getYusufButtonInteraction().getMessageId();
    }

    @NotNull
    @Override
    public Component.Type getComponentType() {
        return getYusufButtonInteraction().getComponentType();
    }

    @Override
    public int getTypeRaw() {
        return getYusufInteraction().getTypeRaw();
    }

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return Never-null String containing the Id.
     */
    @NotNull
    public String getButtonId() {
        return buttonInteraction.getId();
    }

    public long getButtonIdLong() {
        return buttonInteraction.getIdLong();
    }

    public RestAction<Void> editButton(@Nullable Button newButton) {
        return buttonInteraction.editButton(newButton);
    }

    @Override
    public boolean equals(Object obj) {
        return this.buttonInteraction.equals(obj);
    }
}
