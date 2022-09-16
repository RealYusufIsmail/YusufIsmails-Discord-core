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

    public static int getInt(String key) {
        if (jConfig.get(key) instanceof IntNode) {
            return ((IntNode) jConfig.get(key)).asInt();
        } else {
            throw new JConfigException("The value at the key " + key + " is not an interger.");
        }
    }

    public static int getInt(String key, int defaultValue) {
        if (jConfig.get(key) instanceof IntNode) {
            return ((IntNode) jConfig.get(key)).intValue();
        } else {
            return defaultValue;
        }
    }

    public static boolean getBoolean(String key) {
        if (jConfig.get(key) instanceof BooleanNode) {
            return ((BooleanNode) jConfig.get(key)).booleanValue();
        } else {
            throw new JConfigException("The value at the key " + key + " is not a boolean.");
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        if (jConfig.get(key, defaultValue) instanceof BooleanNode) {
            return ((BooleanNode) jConfig.get(key, defaultValue)).booleanValue();
        } else {
            return defaultValue;
        }
    }

    public static double getDouble(String key) {
        if (jConfig.get(key) instanceof DoubleNode) {
            return ((DoubleNode) jConfig.get(key)).doubleValue();
        } else {
            throw new JConfigException("The value at the key " + key + " is not a double.");
        }
    }

    public static double DoubleNode(String key, double defaultValue) {
        if (jConfig.get(key) instanceof DoubleNode) {
            return ((DoubleNode) jConfig.get(key)).doubleValue();
        } else {
            return defaultValue;
        }
    }

    public static long getLong(String key) {
        if (jConfig.get(key) instanceof LongNode) {
            return ((LongNode) jConfig.get(key)).longValue();
        } else {
            throw new JConfigException("The value at the key " + key + " is not a long.");
        }
    }

    public static long getLong(String key, long defaultValue) {
        if (jConfig.get(key) instanceof LongNode) {
            return ((LongNode) jConfig.get(key)).longValue();
        } else {
            return defaultValue;
        }
    }

    public static float getFloat(String key) {
        if (jConfig.get(key) instanceof FloatNode) {
            return ((FloatNode) jConfig.get(key)).floatValue();
        } else {
            throw new JConfigException("The value at the key " + key + " is not a float.");
        }
    }

    public static float getFloat(String key, float defaultValue) {
        if (jConfig.get(key, defaultValue) instanceof FloatNode) {
            return ((FloatNode) jConfig.get(key, defaultValue)).floatValue();
        } else {
            return defaultValue;
        }
    }

    public static Object get(String key) {
        return jConfig.get(key);
    }

    public static Object get(String key, Object defaultValue) {
        return jConfig.get(key, defaultValue);
    }
}
