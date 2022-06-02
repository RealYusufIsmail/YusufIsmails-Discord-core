package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Json {
    public static ArrayNode slashCommandOptionsToJson(List<OptionData> options) {
        ArrayNode optionsNode = JsonNodeFactory.instance.arrayNode();
        for (OptionData option : options) {
            optionsNode.add(Json.optionToJson(option));
        }
        return optionsNode;
    }

    private static String optionToJson(@NotNull OptionData option) {
        return JsonNodeFactory.instance.arrayNode()
            .add(JsonNodeFactory.instance.objectNode()
                .put("name", option.getName())
                .put("description", option.getDescription())
                .put("type", option.getType().name())
                .put("required", option.isRequired()))
            .toString();
    }

    public static String userPermsToJson(Permission @NotNull [] userPerms) {
        ArrayNode userPermsNode = JsonNodeFactory.instance.arrayNode();
        for (Permission userPerm : userPerms) {
            userPermsNode.add(userPerm.getName());
        }
        return userPermsNode.toString();
    }
}
