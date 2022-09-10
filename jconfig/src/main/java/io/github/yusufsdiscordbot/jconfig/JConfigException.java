package io.github.yusufsdiscordbot.jconfig;

import java.io.IOException;

/**
 * Used to indicate that an error occurred while trying to get a value from the config file.
 */
public class JConfigException extends RuntimeException {
    public JConfigException(String message, IOException e) {
        super(message);
    }
}
