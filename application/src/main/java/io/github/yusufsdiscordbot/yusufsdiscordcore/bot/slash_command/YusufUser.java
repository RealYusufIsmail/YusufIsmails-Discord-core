package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.slash_command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public record YusufUser(User user) {

    /**
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**
     * @see User#getAsTag()
     */
    public @NotNull String getUserTag() {
        return this.user.getAsTag();
    }

    /**
     * @see User#getId()
     */
    public @NotNull String getUserId() {
        return this.user.getId();
    }

    /**
     * @see User#getIdLong()
     */
    public @NotNull Long getUserIdLong() {
        return this.user.getIdLong();
    }

    /**
     * @see User#getName()
     */
    public @NotNull String getName() {
        return this.user.getName();
    }

    /**
     * @see User#isBot()
     */
    public @NotNull Boolean isBot() {
        return this.user.isBot();
    }

    /**
     * @see User#getDiscriminator()
     */
    public @NotNull String getDiscriminator() {
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
    public @NotNull String getDefaultAvatarId() {
        return this.user.getDefaultAvatarId();
    }

    /**
     * @see User#getDefaultAvatarUrl()
     */
    public @NotNull String getEffectiveAvatarUrl() {
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
    public @NotNull RestAction<PrivateChannel> openPrivateChannel() {
        return this.user.openPrivateChannel();
    }

    /**
     * @see User#getMutualGuilds()
     */
    public @NotNull List<Guild> getMutualGuilds() {
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
    public @NotNull JDA getJDA() {
        return this.user.getJDA();
    }

    /**
     * @see User#getFlags()
     */
    public @NotNull Set<User.UserFlag> getFlags() {
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
    public @NotNull String getAsMention() {
        return this.user.getAsMention();
    }

    /**
     * @see YusufBot
     */
    public @NotNull YusufBot getBot() {
        return new YusufBot(this.user.getJDA().getSelfUser());
    }

    /**
     * @see YusufBot#getBotTag()
     */
    @Contract(pure = true)
    public @NotNull String getBotTag() {
        return this.getBot().getBotTag();
    }

    /**
     * @see YusufBot#getBotId()
     */
    @Contract(pure = true)
    public @NotNull String getBotId() {
        return this.getBot().getBotId();
    }

    /**
     * @see YusufBot#getBotIdLong()
     */
    @Contract(pure = true)
    public @NotNull Long getBotIdLong() {
        return this.getBot().getBotIdLong();
    }

    /**
     * @see YusufBot#getBotName()
     */
    @Contract(pure = true)
    public @NotNull String getBotName() {
        return this.getBot().getBotName();
    }

    /**
     * @see YusufBot#getDiscriminator()
     */
    @Contract(pure = true)
    public @NotNull String getBotDiscriminator() {
        return this.getBot().getDiscriminator();
    }

    /**
     * @see YusufBot#getAvatarId()
     */
    @Contract(pure = true)
    public @NotNull String getBotAvatarId() {
        return this.getBot().getAvatarId();
    }

    /**
     * @see YusufBot#getAvatarUrl()
     */
    @Contract(pure = true)
    public @NotNull String getBotAvatarUrl() {
        return this.getBot().getAvatarUrl();
    }

    /**
     * @see YusufBot#getDefaultAvatarId()
     */
    @Contract(pure = true)
    public @NotNull String getBotDefaultAvatarId() {
        return this.getBot().getDefaultAvatarId();
    }

    /**
     * @see YusufBot#getBotEffectiveAvatarUrl()
     */
    @Contract(pure = true)
    public @NotNull String getBotEffectiveAvatarUrl() {
        return this.getBot().getBotEffectiveAvatarUrl();
    }

    /**
     * @param user the user who you want to check is null
     * @param event the slash command event.
     * @return not null
     */
    @Contract("null,_->false;!null,_->true")
    public boolean userIsNotNull(YusufUser user, YusufSlashCommandEvent event) {
        boolean result = user == null;
        if (result) {
            event.replyEphemeral("The given user is null");
            return false;
        }
        return true;
    }
}
