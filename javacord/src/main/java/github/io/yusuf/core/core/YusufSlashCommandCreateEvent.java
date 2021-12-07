package github.io.yusuf.core.core;

import github.io.yusuf.core.core.interaction.YusufInteraction;
import github.io.yusuf.core.core.interaction.YusufSlashCommandInteraction;
import org.javacord.api.event.Event;

import java.util.Optional;

public interface YusufSlashCommandCreateEvent  extends Event {

    /**
     * Gets the created interaction.
     *
     * @return The interaction.
     */
    YusufInteraction getInteraction();

    /**
     * Gets the created interaction as SlashCommandInteraction, if the interaction is of this type.
     *
     * @return The interaction.
     */
    default YusufSlashCommandInteraction getSlashCommandInteraction() {
        return getInteraction().asSlashCommandInteraction().get();
    }

    /**
     * Gets the created interaction as SlashCommandInteraction, if the interaction is of this type and the
     * command id equals the given command id.
     *
     * @param commandId The command it to match.
     * @return The interaction.
     */
    default Optional<YusufSlashCommandInteraction> getSlashCommandInteractionWithCommandId(long commandId) {
        return getInteraction().asSlashCommandInteractionWithCommandId(commandId);
    }
}
