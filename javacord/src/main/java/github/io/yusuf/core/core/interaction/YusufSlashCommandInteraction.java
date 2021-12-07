package github.io.yusuf.core.core.interaction;

import org.javacord.api.interaction.InteractionBase;
import org.javacord.api.interaction.SlashCommandInteractionOptionsProvider;

public interface YusufSlashCommandInteraction extends InteractionBase, SlashCommandInteractionOptionsProvider {
    /**
     * Gets the id of the invoked slash command.
     *
     * @return The id of the invoked command.
     */
    long getCommandId();

    /**
     * Gets the id of the invoked slash command as string.
     *
     * @return The id of the invoked command as string.
     */
    String getCommandIdAsString();

    /**
     * Gets the name of the invoked slash command.
     *
     * @return The name of the invoked command.
     */
    String getCommandName();
}
