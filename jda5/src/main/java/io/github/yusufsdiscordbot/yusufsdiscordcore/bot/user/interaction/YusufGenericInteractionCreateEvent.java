package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.user.interaction;

import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;

public class YusufGenericInteractionCreateEvent {
    private final GenericInteractionCreateEvent event;

    public YusufGenericInteractionCreateEvent(GenericInteractionCreateEvent event) {
        this.event = event;
    }

    public GenericInteractionCreateEvent getEvent() {
        return event;
    }
}
