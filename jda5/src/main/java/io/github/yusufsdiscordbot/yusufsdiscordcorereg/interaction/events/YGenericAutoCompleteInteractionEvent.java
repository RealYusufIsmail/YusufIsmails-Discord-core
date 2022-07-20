package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback.YAutoCompleteCallback;
import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YInteraction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.restaction.interactions.AutoCompleteCallbackAction;

import javax.annotation.Nonnull;
import java.util.Collection;

public class YGenericAutoCompleteInteractionEvent extends YGenericInteractionCreateEvent
        implements YAutoCompleteCallback {

    public YGenericAutoCompleteInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YInteraction interaction) {
        super(api, responseNumber, interaction);
    }

    @Nonnull
    @Override
    public YAutoCompleteCallback getInteraction() {
        return (YAutoCompleteCallback) super.getInteraction();
    }

    @Nonnull
    @Override
    public AutoCompleteCallbackAction replyChoices(@Nonnull Collection<Command.Choice> choices) {
        return getInteraction().replyChoices(choices);
    }
}
