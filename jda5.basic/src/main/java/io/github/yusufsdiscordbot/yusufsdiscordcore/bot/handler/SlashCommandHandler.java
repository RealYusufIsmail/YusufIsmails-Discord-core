package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handler;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension.SlashCommandExtender;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SlashCommandHandler extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SlashCommandHandler.class);
    private static final Map<Category, List<SlashCommand>> commandsInCategory = new EnumMap<>(Category.class);

    public static Map<Category, List<SlashCommand>> getCommandsInCategory() {
        return commandsInCategory;
    }

    private static final Map<String, Pair<Long, SlashCommand>> commands = new HashMap<>();

    public static Map<String, Pair<Long, SlashCommand>> getCommands() {
        return commands;
    }

    private static final Map<Class<? extends SlashCommand>, SlashCommand> commandInstances = new HashMap<>();

    private static JSONObject commandsJson;

    public static JSONObject getCommandsJson() {
        return commandsJson;
    }

    private static final ExecutorService commandPool = Executors.newCachedThreadPool();

    /**
     * Used to determine whether the commands should be global or guild only.
     */
    private final @NotNull CommandListUpdateAction globalCommandsData;
    private final @NotNull CommandListUpdateAction guildCommandsData;
    private final @NotNull JDA jda;

    /**
     * Creates a new SlashCommandHandler
     * @param jda The JDA instance. Also used to register global commands.
     * @param guild The guild instance. Also used to register guild commands.
     */
    protected SlashCommandHandler(@NotNull JDA jda, @NotNull Guild guild) {
        globalCommandsData = jda.updateCommands();
        guildCommandsData = guild.updateCommands();
        this.jda = jda;
    }

    public static void addSlashCommand() {

    }
}

