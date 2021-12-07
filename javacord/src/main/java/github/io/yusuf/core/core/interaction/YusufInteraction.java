package github.io.yusuf.core.core.interaction;

import org.javacord.api.interaction.InteractionBase;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.util.SafeSpecializable;

import java.util.Optional;

public interface YusufInteraction extends InteractionBase, SafeSpecializable<InteractionBase> {

    default Optional<YusufSlashCommandInteraction> asSlashCommandInteraction() {
        return as(YusufSlashCommandInteraction.class);
    }

    /**
     * Get this interaction as slash command interaction if the type and the command id match.
     *
     * @param commandId The command id to match.
     * @return the interaction as slash command interaction if the properties match; an empty optional otherwise
     */
    default Optional<YusufSlashCommandInteraction> asSlashCommandInteractionWithCommandId(long commandId) {
        return asSlashCommandInteraction().filter(interaction -> interaction.getCommandId() == commandId);
    }

    /**
     * Get this interaction as message component interaction if the type matches.
     *
     * @return the interaction as message component interaction if the type matches; an empty optional otherwise
     */
    default Optional<MessageComponentInteraction> asMessageComponentInteraction() {
        return as(MessageComponentInteraction.class);
    }

    /**
     * Get this interaction as message component interaction if the type and the given custom id match.
     *
     * @param customId The custom id to match.
     * @return the interaction as message component interaction if the properties match; an empty optional otherwise
     */
    default Optional<MessageComponentInteraction> asMessageComponentInteractionWithCustomId(String customId) {
        return asMessageComponentInteraction().filter(interaction -> interaction.getCustomId().equals(customId));
    }
}
