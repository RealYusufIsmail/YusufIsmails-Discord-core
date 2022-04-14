package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.callback.YMessageEditCallback;
import net.dv8tion.jda.api.interactions.ModalInteraction;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class YModalInteraction extends YMessageEditCallback {
    private final ModalInteraction event;

    public YModalInteraction(IReplyCallback callback, ModalInteraction event,
            IMessageEditCallback callback1) {
        super(callback, callback1);
        this.event = event;
    }

    /**
     * @return The current selected value
     */
    @NotNull
    public String getModalId() {
        return event.getModalId();
    }

    /**
     * @return The current selected value
     */
    @NotNull
    public List<ModalMapping> getValues() {
        return event.getValues();
    }

    /**
     * @param id The custom id
     * @return The current selected value
     */
    @Nullable
    public ModalMapping getValue(@NotNull String id) {
        return event.getValue(id);
    }
}
