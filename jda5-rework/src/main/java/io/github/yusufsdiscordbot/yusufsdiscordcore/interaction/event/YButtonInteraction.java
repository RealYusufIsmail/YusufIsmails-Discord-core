package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.RestAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface YButtonInteraction extends YComponentInteraction {

    @Nonnull
    @Override
    default Button getComponent() {
        return getButton();
    }

    /**
     * The {@link Button} this interaction belongs to.
     *
     * @return The {@link Button}
     *
     * @see #getComponentId()
     */
    @Nonnull
    Button getButton();

    /**
     * Update the button with a new button instance.
     *
     * <p>
     * If this interaction is already acknowledged this will use {@link #getHook()} and otherwise
     * {@link #editComponents(Collection)} directly to acknowledge the interaction.
     *
     * @param newButton The new button to use, or null to remove this button from the message
     *        entirely
     *
     * @return {@link RestAction}
     */
    @Nonnull
    @CheckReturnValue
    default RestAction<Void> editButton(@Nullable Button newButton) {
        Message message = getMessage();
        List<ActionRow> components = new ArrayList<>(message.getActionRows());
        LayoutComponent.updateComponent(components, getComponentId(), newButton);

        if (isAcknowledged())
            return getHook().editMessageComponentsById(message.getId(), components).map(it -> null);
        else
            return editComponents(components).map(it -> null);
    }
}
