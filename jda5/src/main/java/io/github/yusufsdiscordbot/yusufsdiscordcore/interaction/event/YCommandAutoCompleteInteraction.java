package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback.YAutoCompleteCallback;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.annotation.Nonnull;

/**
 * Interaction for auto-complete options in slash-commands. <br>
 * These interactions may provide incomplete lists of options with invalid values as they represent
 * partial command executions. Some required options may be missing. All the provided options can be
 * used as "context" for the focused option, but they might not be valid.
 *
 * <p>
 * This is used to suggest up to 25 choices for the focused option.
 *
 * @see #getFocusedOption()
 * @see OptionData#setAutoComplete(boolean)
 */
public interface YCommandAutoCompleteInteraction
        extends YAutoCompleteCallback, YCommandInteractionPayload {
    /**
     * The focused option which the user is typing.
     *
     * <p>
     * This is not validated by the Discord API and may contain invalid/incomplete inputs.
     *
     * @return The focused {@link AutoCompleteQuery}
     */
    @Nonnull
    AutoCompleteQuery getFocusedOption();
}
