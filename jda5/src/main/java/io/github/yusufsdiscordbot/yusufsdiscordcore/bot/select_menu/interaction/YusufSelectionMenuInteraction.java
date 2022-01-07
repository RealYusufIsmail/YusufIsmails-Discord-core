package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponentInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteraction;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufInteractionHook;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu.YusufSelectionMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenuInteraction;
import net.dv8tion.jda.api.requests.RestAction;

import javax.annotation.Nullable;
import java.util.List;

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

    public YusufComponent getYusufComponent() {
        return new YusufComponent(interaction.getComponent());
    }

    public YusufSelectionMenu getYusufSelectionMenu() {
        return new YusufSelectionMenu(interaction.getSelectionMenu());
    }

    public List<SelectOption> getSelectedOptions() {
        return interaction.getSelectedOptions();
    }

    public List<String> getValues() {
        return interaction.getValues();
    }

    public RestAction<Void> editSelectionMenu(@Nullable SelectionMenu newMenu) {
        return interaction.editSelectionMenu(newMenu);
    }
}
