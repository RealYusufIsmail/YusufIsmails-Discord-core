// Originally from
// https://github.com/Together-Java/TJ-Bot/blob/95d7f323a998b15abfa2c0723c30636d2f00c4cf/application/src/main/java/org/togetherjava/tjbot/commands/SlashCommandAdapter.java,
// then modified by Yusuf
package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.extensions;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.data.YCommandData;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handlers.CommandType;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class MessageCommand extends BaseCommand {
    private final @Nonnull String name;
    private final boolean isGuildOnly;
    private final @Nonnull CommandType[] commandType;
    private final @NotNull YCommandData commandData;

    protected MessageCommand(@Nonnull String name, boolean isGuildOnly,
            @Nonnull CommandType... commandType) {
        this.name = name;
        this.isGuildOnly = isGuildOnly;
        this.commandType = commandType;

        commandData = new YCommandData(Commands.message(name));
    }

    /**
     * Provides the user with name of the command
     *
     * @return {@link CommandDataImpl#getName()}
     */
    @Override
    public @Nonnull String getName() {
        return name;
    }

    /**
     * Used to determine whether the command is Global(can be used on all servers) or whether it is
     * only a Guild command(can only be used in specific servers)
     */
    public boolean checkIfIsGuildOnly() {
        return isGuildOnly;
    }

    /**
     * Used to determine what type of command it is.
     *
     * @return Must be one of the following:
     *         <ul>
     *         <li>{@link CommandType#MODERATION}</li>
     *         <li>{@link CommandType#FUN}</li>
     *         <li>{@link CommandType#MUSIC}</li>
     *         <li>{@link CommandType#UTILITY}</li>
     *         <li>{@link CommandType#OWNER_ONLY}</li>
     *         <li>{@link CommandType#DEVELOPMENT}</li>
     *         <li>{@link CommandType#INFO}</li>
     *         <li>{@link CommandType#SETUP}</li>
     *         <li>{@link CommandType#SUPPORT}</li>
     *         <li>{@link CommandType#EXAMPLE}</li>
     *         <li>{@link CommandType#UNKNOWN}</li>
     *         </ul>
     */
    public CommandType getCommandType() {
        return commandType[0];
    }

    /**
     * Retrieves all the command data such as the name and description of the command. Also used to
     * create options and sub commands.
     *
     * @return {@link CommandDataImpl#CommandDataImpl(String, String)} and can also return
     *         {@link CommandDataImpl#addOption(OptionType, String, String)} <br >
     *         <br >
     *         Choices can also be used which makes it easier for the user. which returns
     *         {@link OptionData#addChoice(String, long)} <br>
     *         <br>
     */
    public final @Nonnull CommandData getCommandData() {
        return commandData;
    }

    @Override
    public abstract void onMessageContextInteraction(@NotNull MessageContextInteractionEvent event);
}
