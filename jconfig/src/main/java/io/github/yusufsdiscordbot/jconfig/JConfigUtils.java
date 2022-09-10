package io.github.yusufsdiscordbot.jconfig;

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
        return (int) jConfig.get(key);
    }

    public static int getInt(String key, int defaultValue) {
        return (int) jConfig.get(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return (boolean) jConfig.get(key);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return (boolean) jConfig.get(key, defaultValue);
    }

    public static double getDouble(String key) {
        return (double) jConfig.get(key);
    }

    public static double getDouble(String key, double defaultValue) {
        return (double) jConfig.get(key, defaultValue);
    }

    public static long getLong(String key) {
        return (long) jConfig.get(key);
    }

    public static long getLong(String key, long defaultValue) {
        return (long) jConfig.get(key, defaultValue);
    }

    public static float getFloat(String key) {
        return (float) jConfig.get(key);
    }

    public static float getFloat(String key, float defaultValue) {
        return (float) jConfig.get(key, defaultValue);
    }

    public static Object get(String key) {
        return jConfig.get(key);
    }

    public static Object get(String key, Object defaultValue) {
        return jConfig.get(key, defaultValue);
    }
}
