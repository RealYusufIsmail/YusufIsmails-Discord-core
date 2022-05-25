package io.github.yusufsdiscordbot.yusufsdiscordcore.event;

import io.github.yusufsdiscordbot.yusufsdiscordcorereg.event.YMemberReg;
import net.dv8tion.jda.api.entities.Member;
import org.jetbrains.annotations.NotNull;

public interface YMember extends Member {

    static @NotNull YMember from(Member member) {
        return new YMemberReg(member);
    }


}
