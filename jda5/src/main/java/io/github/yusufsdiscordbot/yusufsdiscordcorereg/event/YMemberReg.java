package io.github.yusufsdiscordbot.yusufsdiscordcorereg.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YUser;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.internal.entities.GuildImpl;
import net.dv8tion.jda.internal.entities.MemberImpl;
import org.jetbrains.annotations.NotNull;

public class YMemberReg extends MemberImpl implements YMember {
    public YMemberReg(@NotNull Member member) {
        super((GuildImpl) member.getGuild(), member.getUser());
    }

    @Override
    public AudioManager getAudioManager() {
        return null;
    }

    @Override
    public @NotNull YUser getUser() {
        return (YUser) super.getUser();
    }
}
