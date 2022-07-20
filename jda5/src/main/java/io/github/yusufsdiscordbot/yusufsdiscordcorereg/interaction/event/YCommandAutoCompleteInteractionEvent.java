package io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event.YCommandAutoCompleteInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.command_option.YOptionMapping;
import io.github.yusufsdiscordbot.yusufsdiscordcorereg.interaction.events.YGenericAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.restaction.interactions.AutoCompleteCallbackAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public class YCommandAutoCompleteInteractionEvent extends YGenericAutoCompleteInteractionEvent
        implements YCommandAutoCompleteInteraction {
    private final YCommandAutoCompleteInteraction interaction;

    public YCommandAutoCompleteInteractionEvent(@Nonnull JDA api, long responseNumber,
            @Nonnull YCommandAutoCompleteInteraction interaction) {
        super(api, responseNumber, interaction);
        this.interaction = interaction;
    }

    @Nonnull
    @Override
    public YCommandAutoCompleteInteraction getInteraction() {
        return interaction;
    }

    @Nonnull
    @Override
    public AutoCompleteQuery getFocusedOption() {
        return interaction.getFocusedOption();
    }

    @Nonnull
    @Override
    public Command.Type getCommandType() {
        return interaction.getCommandType();
    }

    @Nonnull
    @Override
    public String getName() {
        return interaction.getName();
    }

    @Nullable
    @Override
    public String getSubcommandName() {
        return interaction.getSubcommandName();
    }

    @Nullable
    @Override
    public String getSubcommandGroup() {
        return interaction.getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return interaction.getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return interaction.isGuildCommand();
    }

    @Nonnull
    @Override
    public List<YOptionMapping> getOptions() {
        return interaction.getOptions();
    }

    @Nonnull
    @Override
    public AutoCompleteCallbackAction replyChoices(@Nonnull Collection<Command.Choice> choices) {
        return interaction.replyChoices(choices);
    }
}
