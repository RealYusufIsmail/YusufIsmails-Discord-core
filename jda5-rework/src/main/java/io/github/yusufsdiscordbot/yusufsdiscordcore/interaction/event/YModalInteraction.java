package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback.YReplyCallback;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.internal.utils.Checks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Interaction on a {@link Modal}
 *
 * <p>
 * If the modal of this interaction was a reply to a
 * {@link net.dv8tion.jda.api.interactions.components.ComponentInteraction ComponentInteraction},
 * you can also use {@link #deferEdit()} to edit the original message that contained the component
 * instead of replying.
 *
 * @see net.dv8tion.jda.api.events.interaction.ModalInteractionEvent
 */
public interface YModalInteraction extends YReplyCallback, IMessageEditCallback {

    /**
     * Returns the custom id of the Modal in question
     *
     * @return Custom id
     *
     * @see Modal.Builder#setId(String)
     */
    @Nonnull
    String getModalId();

    /**
     * Returns a List of {@link net.dv8tion.jda.api.interactions.modals.ModalMapping ModalMappings}
     * representing the values input by the user for each field when the modal was submitted.
     *
     * @return Immutable List of {@link net.dv8tion.jda.api.interactions.modals.ModalMapping
     *         ModalMappings}
     *
     * @see #getValue(String)
     */
    @Nonnull
    List<ModalMapping> getValues();

    /**
     * Convenience method to get a {@link net.dv8tion.jda.api.interactions.modals.ModalMapping
     * ModalMapping} by its id from the List of
     * {@link net.dv8tion.jda.api.interactions.modals.ModalMapping ModalMappings}
     *
     * <p>
     * Returns null if no component with that id has been found
     *
     * @param id The custom id
     *
     * @throws IllegalArgumentException If the provided id is null
     *
     * @return ModalMapping with this id, or null if not found
     *
     * @see #getValues()
     */
    @Nullable
    default ModalMapping getValue(@Nonnull String id) {
        Checks.notNull(id, "ID");
        return getValues().stream()
            .filter(mapping -> mapping.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
