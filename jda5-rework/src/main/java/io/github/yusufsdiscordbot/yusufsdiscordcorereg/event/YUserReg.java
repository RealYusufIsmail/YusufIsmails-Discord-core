package io.github.yusufsdiscordbot.yusufsdiscordcorereg.event;

import io.github.yusufsdiscordbot.yusufsdiscordcore.event.YUser;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.UserImpl;
import org.jetbrains.annotations.NotNull;

public class YUserReg extends UserImpl implements YUser {

    public YUserReg(long id, JDAImpl api) {
        super(id, api);
    }

    @NotNull
    @Override
    public String getUserName() {
        return this.getName();
    }

    @NotNull
    @Override
    public String getUserTag() {
        return this.getAsTag();
    }
}
