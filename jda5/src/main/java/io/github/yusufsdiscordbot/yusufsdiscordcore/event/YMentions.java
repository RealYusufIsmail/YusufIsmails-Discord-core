package io.github.yusufsdiscordbot.yusufsdiscordcore.event;

import net.dv8tion.jda.api.entities.Mentions;
import org.apache.commons.collections4.Bag;

import java.util.List;

public interface YMentions extends Mentions {
    List<YUser> getUserAsList();

    Bag<YUser> getUsersAsBag();

    List<YMember> getMemberAsList();

    Bag<YMember> getMembersAsBag();
}
