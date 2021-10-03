package github.io.yusuf.core.bot.prefix_command;

import java.util.List;

public interface PrefixCommand {
    void handle(CommandContext ctx);

    String getName();

    String getHelp();

    default List<String> getAliases() {
        return List.of(); // Arrays.asLis in java 8
    }
}
