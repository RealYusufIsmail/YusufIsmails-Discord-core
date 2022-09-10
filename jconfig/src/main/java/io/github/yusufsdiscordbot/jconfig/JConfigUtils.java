package io.github.yusufsdiscordbot.jconfig;

import com.fasterxml.jackson.databind.node.*;

/**
 * A utility class used to get values from the config file.
 */
public class JConfigUtils {
    private JConfigUtils() {}

    private static final JConfig jConfig = JConfig.builder().build();

    public static String getString(String key) {
        return (String) jConfig.get(key);
    }

    public static String getString(String key, String defaultValue) {
        return (String) jConfig.get(key, defaultValue);
    }

    public static IntNode getInt(String key) {
        return (IntNode) jConfig.get(key);
    }

    public static IntNode getInt(String key, int defaultValue) {
        return (IntNode) jConfig.get(key, defaultValue);
    }

    public static BooleanNode getBoolean(String key) {
        return (BooleanNode) jConfig.get(key);
    }

    public static BooleanNode getBoolean(String key, boolean defaultValue) {
        return (BooleanNode) jConfig.get(key, defaultValue);
    }

    public static DoubleNode getDouble(String key) {
        return (DoubleNode) jConfig.get(key);
    }

    public static DoubleNode DoubleNode(String key, double defaultValue) {
        return (DoubleNode) jConfig.get(key, defaultValue);
    }

    public static LongNode getLong(String key) {
        return (LongNode) jConfig.get(key);
    }

    public static LongNode getLong(String key, long defaultValue) {
        return (LongNode) jConfig.get(key, defaultValue);
    }

    public static FloatNode getFloat(String key) {
        return (FloatNode) jConfig.get(key);
    }

    public static FloatNode getFloat(String key, float defaultValue) {
        return (FloatNode) jConfig.get(key, defaultValue);
    }

    public static Object get(String key) {
        return jConfig.get(key);
    }

    public static Object get(String key, Object defaultValue) {
        return jConfig.get(key, defaultValue);
    }
}
