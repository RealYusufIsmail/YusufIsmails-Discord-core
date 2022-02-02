package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;

public class YusufGenericContextInteractionEvent {
    private final GenericContextInteractionEvent event;

    public YusufGenericContextInteractionEvent(GenericContextInteractionEvent event) {
        this.event = event;
    }

    public GenericContextInteractionEvent getEvent() {
        return event;
    }


}
