package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.YusufCommandInteraction;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.RestAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class YusufButtonInteractionEvent extends YusufCommandInteraction {
    private final ButtonInteractionEvent event;

    public YusufButtonInteractionEvent(ButtonInteractionEvent event) {
        super(event);
        this.event = event;
    }

    public ButtonInteractionEvent getEvent() {
        return event;
    }

    @Nonnull
    public Button getComponent()
    {
        return getButton();
    }

    @Nonnull
    public Button getButton()
    {
        return event.getButton();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> editButton(@Nullable Button newButton) {
        return event.editButton(newButton);
    }

    /**
     * The custom component ID provided to the component when it was originally created.
     * <br>This value should be used to determine what action to take in regard to this interaction.
     *
     * <br>This id does not have to be numerical.
     *
     * @return The component ID
     *
     * @see    ActionComponent#getId()
     */
    @Nonnull
    public String getComponentId() {
        return event.getComponentId();
    }


    /**
     * The {@link Message} instance.
     *
     * @return The {@link Message}
     */
    @Nonnull
    public Message getMessage() {
        return event.getMessage();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    public long getMessageIdLong() {
        return event.getMessageIdLong();
    }

    /**
     * The id of the message.
     *
     * @return The message id
     */
    @Nonnull
    public String getMessageId()
    {
        return event.getMessageId();
    }

    /**
     * The {@link Component.Type}
     *
     * @return The {@link Component.Type}
     */
    @Nonnull
    public Component.Type getComponentType() {
        return event.getComponentType();
    }

    /**
     * The respective {@link MessageChannel} for this interaction.
     *
     * @return The {@link MessageChannel}
     */
    @Nonnull
    @Override
    public MessageChannel getChannel() {
        return event.getChannel();
    }
}
