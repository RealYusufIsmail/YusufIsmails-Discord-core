package github.io.yusuf.core.core.interaction;

import org.javacord.api.interaction.Interaction;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.util.Optional;

public record YusufInteraction(Interaction interaction) {

    public Optional<YusufSlashCommandInteraction> asSlashCommandInteraction() {
        return new YusufSlashCommandInteraction(this.interaction.asSlashCommandInteraction());
    }

    /**
     * Get this interaction as slash command interaction if the type and the command id match.
     *
     * @param commandId The command id to match.
     * @return the interaction as slash command interaction if the properties match; an empty optional otherwise
     */
    //TODO finish this
    public Optional<YusufSlashCommandInteraction> asSlashCommandInteractionWithCommandId(long commandId) {
        return new YusufSlashCommandInteraction(this.interaction.asSlashCommandInteractionWithCommandId(commandId));
    }

    /**
     * Get this interaction as message component interaction if the type matches.
     *
     * @return the interaction as message component interaction if the type matches; an empty optional otherwise
     */
    public Optional<MessageComponentInteraction> asMessageComponentInteraction() {
        return this.interaction.asMessageComponentInteraction();
    }

    /**
     * Get this interaction as message component interaction if the type and the given custom id match.
     *
     * @param customId The custom id to match.
     * @return the interaction as message component interaction if the properties match; an empty optional otherwise
     */
    public Optional<MessageComponentInteraction> asMessageComponentInteractionWithCustomId(String customId) {
        return this.interaction.asMessageComponentInteractionWithCustomId(customId);
    }
}
