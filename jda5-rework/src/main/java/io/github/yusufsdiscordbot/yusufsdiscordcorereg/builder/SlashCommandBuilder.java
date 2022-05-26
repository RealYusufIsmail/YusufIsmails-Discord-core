package io.github.yusufsdiscordbot.yusufsdiscordcorereg.builder;

import io.github.yusufsdiscordbot.yusufsdiscordcorereg.data.YSlashCommandData;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

public class SlashCommandBuilder {
    private String name;
    private String description;

    public SlashCommandBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SlashCommandBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public YSlashCommandData build() {
        return new YSlashCommandData(Commands.slash(name, description));
    }
}
