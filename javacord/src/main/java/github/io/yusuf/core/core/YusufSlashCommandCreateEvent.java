package github.io.yusuf.core.core;

import github.io.yusuf.core.core.interaction.YusufInteraction;
import github.io.yusuf.core.core.interaction.YusufSlashCommandInteraction;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public record YusufSlashCommandCreateEvent(SlashCommandCreateEvent event) {

    /**
     * Gets the created interaction.
     *
     * @return The interaction.
     */
    @Contract(" -> new")
    @NotNull
    YusufInteraction getInteraction() {
        return new YusufInteraction(this.event.getInteraction());
    }

    /**
     * Gets the created interaction as SlashCommandInteraction, if the interaction is of this type.
     *
     * @return The interaction.
     */
    public @NotNull YusufSlashCommandInteraction getSlashCommandInteraction() {
        return getInteraction().asSlashCommandInteraction().get();
    }

    /**
     * Gets the created interaction as SlashCommandInteraction, if the interaction is of this type and the
     * command id equals the given command id.
     *
     * @param commandId The command it to match.
     * @return The interaction.
     */
    public Optional<YusufSlashCommandInteraction> getSlashCommandInteractionWithCommandId(long commandId) {
        return getInteraction().asSlashCommandInteractionWithCommandId(commandId);
    }

}
