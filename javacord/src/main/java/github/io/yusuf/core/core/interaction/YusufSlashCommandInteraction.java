package github.io.yusuf.core.core.interaction;

import org.javacord.api.interaction.SlashCommandInteraction;

public record YusufSlashCommandInteraction(SlashCommandInteraction slashCommandInteraction) {
        /**
         * Gets the id of the invoked slash command.
         *
         * @return The id of the invoked command.
         */
        public long getCommandId() {
            return this.slashCommandInteraction.getCommandId();
        }

        /**
         * Gets the id of the invoked slash command as string.
         *
         * @return The id of the invoked command as string.
         */
        public String getCommandIdAsString() {
            return this.slashCommandInteraction.getCommandIdAsString();
        }

        /**
         * Gets the name of the invoked slash command.
         *
         * @return The name of the invoked command.
         */
        public String getCommandName() {
            return this.slashCommandInteraction.getCommandName();
        }
}
