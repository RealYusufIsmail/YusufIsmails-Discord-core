package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.util;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.core.YMember;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.interaction.callback.YReplyCallback;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import org.jetbrains.annotations.NotNull;

public class Verify {
    private Verify() {}


    public static void isInVc(@NotNull YMember member, @NotNull YReplyCallback callback) {
        if (!member.getVoiceState().inAudioChannel()) {
            callback.replyQueuedEphemeral("You are not in a voice channel!");
        }
    }

    public static void isInVc(@NotNull Member member, @NotNull YReplyCallback callback) {
        if (!member.getVoiceState().inAudioChannel()) {
            callback.replyQueuedEphemeral("You are not in a voice channel!");
        }
    }

    public static void isInVc(@NotNull Member member, @NotNull IReplyCallback callback) {
        if (!member.getVoiceState().inAudioChannel()) {
            callback.reply("You are not in a voice channel!").setEphemeral(true).queue();
        }
    }

    public static void isNotInVc(@NotNull YMember member, @NotNull YReplyCallback callback) {
        if (member.getVoiceState().inAudioChannel()) {
            callback.replyQueuedEphemeral("You are in a voice channel!");
        }
    }

    public static void isNotInVc(@NotNull Member member, @NotNull YReplyCallback callback) {
        if (member.getVoiceState().inAudioChannel()) {
            callback.replyQueuedEphemeral("You are in a voice channel!");
        }
    }

    public static void isNotInVc(@NotNull Member member, @NotNull IReplyCallback callback) {
        if (member.getVoiceState().inAudioChannel()) {
            callback.reply("You are in a voice channel!").setEphemeral(true).queue();
        }
    }

    public static boolean isInVc(@NotNull YMember member) {
        return member.getVoiceState().inAudioChannel();
    }

    public static boolean isInVc(@NotNull Member member) {
        return member.getVoiceState().inAudioChannel();
    }

    public static boolean isNotInVc(@NotNull YMember member) {
        return !isInVc(member);
    }

    public static boolean isNotInVc(@NotNull Member member) {
        return !isInVc(member);
    }
}
