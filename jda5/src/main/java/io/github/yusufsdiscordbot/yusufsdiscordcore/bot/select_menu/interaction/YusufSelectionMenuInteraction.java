package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponentInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteractionHook;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenuInteraction;

// TODO: make this class
public class YusufSelectionMenuInteraction extends YusufComponentInteraction {
    private final SelectionMenuInteraction interaction;

    public YusufSelectionMenuInteraction(SelectionMenuInteraction interaction) {
        super(interaction);
        this.interaction = interaction;
    }

    public SelectionMenuInteraction getSelectionMenuInteraction() {
        return interaction;
    }


    public YusufComponentInteraction getYusufButtonInteraction() {
        return new YusufComponentInteraction(interaction);
    }

    public YusufInteractionHook getYusufInteractionHook() {
        return new YusufInteractionHook(interaction.getHook());
    }

    public YusufInteraction getYusufInteraction() {
        return getYusufInteractionHook().getInteraction();
    }


}
