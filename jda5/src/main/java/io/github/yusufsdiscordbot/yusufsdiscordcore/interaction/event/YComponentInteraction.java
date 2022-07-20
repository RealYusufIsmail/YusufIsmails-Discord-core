package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback.YReplyCallback;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;

import javax.annotation.Nonnull;

public interface YComponentInteraction
        extends YReplyCallback, IMessageEditCallback, YModalCallback {
    /**
     * The custom component ID provided to the component when it was originally created. <br>
     * This value should be used to determine what action to take in regard to this interaction.
     *
     * <br>
     * This id does not have to be numerical.
     *
     * @return The component ID
     *
     * @see ActionComponent#getId()
     */
    @Nonnull
    String getComponentId();

    /**
     * The {@link ActionComponent} instance.
     *
     * @return The {@link ActionComponent}
     */
    @Nonnull
    ActionComponent getComponent();

    /**
     * The {@link Message} instance.
     *
     * @return The {@link Message}
     */
    @Nonnull
    Message getMessage();

    /**
     * The id of the message.
     *
     * @return The message id
     */
    long getMessageIdLong();

    /**
     * The id of the message.
     *
     * @return The message id
     */
    @Nonnull
    default String getMessageId() {
        return Long.toUnsignedString(getMessageIdLong());
    }

    /**
     * The {@link Component.Type}
     *
     * @return The {@link Component.Type}
     */
    @Nonnull
    Component.Type getComponentType();

    /**
     * The respective {@link MessageChannel} for this interaction.
     *
     * @return The {@link MessageChannel}
     */
    @Nonnull
    @Override
    MessageChannel getChannel();
}
