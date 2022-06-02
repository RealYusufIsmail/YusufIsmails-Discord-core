package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.github.yusufsdiscordbot.annotations.Author;
import io.github.yusufsdiscordbot.annotations.Credits;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommand;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.builder.SlashCommandBuilder;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.extension.SlashCommandExtender;
import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.type.CommandType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.internal.utils.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Credits(source = "https://github.com/Black0nion/BlackOnion-Bot/blob/597d67fbf389a172c05a1bf431e3ab5848e52402/src/main/java/com/github/black0nion/blackonionbot/bot/SlashCommandBase.java",
reason = "I have been allowed to use this code by the owner.")
public class SlashCommandHandler extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SlashCommandHandler.class);
    private static final Map<CommandType, List<SlashCommand>> commandTypes = new EnumMap<>(Category.class);

    private static final Map<String, Pair<Long, SlashCommand>> commands = new HashMap<>();


    private static final Map<Class<? extends SlashCommand>, SlashCommand> commandInstances = new HashMap<>();

    private static JsonNode commandsJson;

    private static int numberOfCommands = 0;


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
        numberOfCommands = 0;
        commands.clear();
        commandTypes.clear();
        commandInstances.clear();
        commandsJson = JsonNodeFactory.instance.objectNode();
        final ArrayNode commandsArray = JsonNodeFactory.instance.arrayNode();
        final Reflections reflections = new Reflections(SlashCommand.class.getPackage().getName());
        final Set<Class<? extends SlashCommand>> annotated = reflections.getSubTypesOf(SlashCommand.class);

        for (final Class<?> command : annotated) {
            try {
                final SlashCommand newSlashCommand = (SlashCommand) command.getConstructor().newInstance();
                final String[] packageName = command.getPackage().getName().split("\\.");
                final CommandType commandType = CommandType.getCommandType(packageName[packageName.length - 1]);
                newSlashCommand.setCommandType(commandType != CommandType.UNKNOWN ? commandType : newSlashCommand.getCommandType());
                SlashCommandData data = newSlashCommand.getSlashCommandData();

                final JsonNode commandJson = JsonNodeFactory.instance.objectNode()
                        .put("name", data.getName())
                        .put("description", data.getDescription())
                        .put("permissions", Arrays.toString(newSlashCommand.getUserPerms()))
                        .put("options", data.getOptions());

            } catch (Exception e) {
                logger.error("Failed to add command {}", command.getName(), e);
            }
        }
    }
}

