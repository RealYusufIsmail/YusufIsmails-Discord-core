package io.github.yusufsdiscordbot.jconfig;

import java.util.Set;

/**
 * Used to get a value from the config.json file. Also creates a new JConfig instance.
 */
public interface JConfig {

    /**
     * Gets the builder for the JConfig instance.
     * 
     * @return The builder for the JConfig instance.
     */
    static JConfigBuilder builder() {
        return new JConfigBuilder();
    }

    /**
     * Used to build a new JConfig instance.
     * 
     * @return A new JConfigBuilder instance.
     * @throws JConfigException If an error occurs while trying to read the config file.
     */
    static JConfig build() {
        return new JConfigBuilder().build();
    }

    /**
     * Used to get all the entries in the config file.
     *
     * @return A list of all the entries in the config file.
     */
    Set<JsonEntry> getEntries();

    /**
     * Gets the value of the key from the config file.
     * 
     * @param key The key of the value.
     * @return The value of the key.
     */
    Object get(String key);

    /**
     * Gets the value of the key from the config file.
     * 
     * @param key The key of the value.
     * @param defaultValue The default value to return if the key does not exist.
     * @return The value of the key.
     */
    Object get(String key, Object defaultValue);
}
