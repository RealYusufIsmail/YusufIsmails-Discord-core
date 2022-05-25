package io.github.yusufsdiscordbot.yusufsdiscordcore.interaction.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YUser;
import net.dv8tion.jda.api.interactions.Interaction;
import org.jetbrains.annotations.NotNull;

public interface YInteraction extends Interaction {
    @NotNull
    YUser getUser();

    YMember getMember();
}
