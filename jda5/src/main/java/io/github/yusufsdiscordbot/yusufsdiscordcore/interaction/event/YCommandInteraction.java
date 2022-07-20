package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.callback.YReplyCallback;
import net.dv8tion.jda.api.interactions.callbacks.IModalCallback;

public interface YCommandInteraction
        extends YReplyCallback, YCommandInteractionPayload, IModalCallback {
}
