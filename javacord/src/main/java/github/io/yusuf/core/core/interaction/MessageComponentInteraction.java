package github.io.yusuf.core.core.interaction;

import org.javacord.api.interaction.ButtonInteraction;
import org.javacord.api.interaction.InteractionBase;
import org.javacord.api.interaction.MessageComponentInteractionBase;
import org.javacord.api.interaction.SelectMenuInteraction;
import org.javacord.api.util.SafeSpecializable;

import java.util.Optional;

public interface MessageComponentInteraction extends MessageComponentInteractionBase, SafeSpecializable<InteractionBase> {

    /**
     * Get this interaction as button interaction if the type matches.
     *
     * @return the interaction as button interaction if the type matches; an empty optional otherwise
     */
    default Optional<ButtonInteraction> asButtonInteraction() {
        return as(ButtonInteraction.class);
    }

    /**
     * Get this interaction as select menu interaction if the type matches.
     *
     * @return the interaction as select menu interaction if the type matches; an empty optional otherwise
     */
    default Optional<SelectMenuInteraction> asSelectMenuInteraction() {
        return as(SelectMenuInteraction.class);
    }
}
