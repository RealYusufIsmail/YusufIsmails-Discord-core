package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;

import javax.annotation.Nonnull;
import java.util.EnumSet;
import java.util.List;


public class YusufUser {
    private final User user;

    public YusufUser(User user) {
        this.user = user;
    }

    /**
     * @see User
     */
    @Nonnull
    public User getUser() {
        return user;
    }

    /**
     * @see User#getAsTag()
     */
    @Nonnull
    public String getUserTag() {
        return this.user.getAsTag();
    }

    /**
     * @see User#getId()
     */
    @Nonnull
    public String getUserId() {
        return this.user.getId();
    }

    /**
     * @see User#getIdLong()
     */
    @Nonnull
    public Long getUserIdLong() {
        return this.user.getIdLong();
    }

    /**
     * @see User#getName()
     */
    @Nonnull
    public String getName() {
        return this.user.getName();
    }

    /**
     * @see User#isBot()
     */
    @Nonnull
    public Boolean isBot() {
        return this.user.isBot();
    }

    /**
     * @see User#getDiscriminator()
     */
    @Nonnull
    public String getDiscriminator() {
        return this.user.getDiscriminator();
    }

    /**
     * @see User#getAvatarId()
     */
    public String getAvatarId() {
        return this.user.getAvatarId();
    }

    /**
     * @see User#getAvatarUrl()
     */
    public String getAvatarUrl() {
        return this.user.getAvatarUrl();
    }

    /**
     * @see User#getDefaultAvatarId()
     */
    @Nonnull
    public String getDefaultAvatarId() {
        return this.user.getDefaultAvatarId();
    }

    /**
     * @see User#getDefaultAvatarUrl()
     */
    @Nonnull
    public String getEffectiveAvatarUrl() {
        return this.user.getEffectiveAvatarUrl();
    }

    /**
     * @see User#hasPrivateChannel()
     */
    public boolean hasPrivateChannel() {
        return this.user.hasPrivateChannel();
    }

    /**
     * @see User#openPrivateChannel()
     */
    @Nonnull
    public RestAction<PrivateChannel> openPrivateChannel() {
        return this.user.openPrivateChannel();
    }

    /**
     * @see User#getMutualGuilds()
     */
    @Nonnull
    public List<Guild> getMutualGuilds() {
        return this.user.getMutualGuilds();
    }

    /**
     * @see User#isSystem()
     */
    public boolean isSystem() {
        return this.user.isSystem();
    }

    /**
     * @see User#getJDA()
     */
    @Nonnull
    public JDA getJDA() {
        return this.user.getJDA();
    }

    /**
     * @see User#getFlags()
     */
    @Nonnull
    public EnumSet<User.UserFlag> getFlags() {
        return this.user.getFlags();
    }

    /**
     * @see User#getFlagsRaw()
     */
    public int getFlagsRaw() {
        return this.user.getFlagsRaw();
    }

    /**
     * @see User#getAsMention()
     */
    @Nonnull
    String getAsMention() {
        return this.user.getAsMention();
    }
}
