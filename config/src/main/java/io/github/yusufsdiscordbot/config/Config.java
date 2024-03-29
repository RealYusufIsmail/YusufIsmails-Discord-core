/*
 * GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007 Copyright (C) 2007 Free Software Foundation,
 * Inc. <https://fsf.org/> Everyone is permitted to copy and distribute verbatim copies of this
 * license document, but changing it is not allowed. Yusuf Arfan Ismail The GNU General Public
 * License is a free, copyleft license for software and other kinds of works. The licenses for most
 * software and other practical works are designed to take away your freedom to share and change the
 * works. By contrast, the GNU General Public License is intended to guarantee your freedom to share
 * and change all versions of a program--to make sure it remains free software for all its users.
 * We, the Free Software Foundation, use the GNU General Public License for most of our software; it
 * applies also to any other work released this way by its authors. You can apply it to your
 * programs, too.
 */

package io.github.yusufsdiscordbot.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.yusufsdiscordbot.annotations.Author;
import org.jetbrains.annotations.NotNull;

/**
 * This class is used to store the configuration for the bot which is stored in an .env file.
 *
 * @author Yusuf Arfan Ismail
 */
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public class Config {
    private Config() {}

    private static final Dotenv dotenv = Dotenv.configure().load();

    private static String get(@NotNull String key) {
        return dotenv.get(key);
    }

    private static String get(@NotNull String key, String defaultValue) {
        return dotenv.get(key, defaultValue);
    }

    public static String getString(@NotNull String key) {
        return dotenv.get(key.toUpperCase());
    }

    public static String getString(@NotNull String key, String defaultValue) {
        return dotenv.get(key.toUpperCase(), defaultValue);
    }

    public static int getInt(@NotNull String key) {
        return Integer.parseInt(get(key));
    }

    public static int getInt(@NotNull String key, int defaultValue) {
        return Integer.parseInt(get(key, Integer.toString(defaultValue)));
    }

    public static boolean getBoolean(@NotNull String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static boolean getBoolean(@NotNull String key, boolean defaultValue) {
        return Boolean.parseBoolean(get(key, Boolean.toString(defaultValue)));
    }

    public static double getDouble(@NotNull String key) {
        return Double.parseDouble(get(key));
    }

    public static double getDouble(@NotNull String key, double defaultValue) {
        return Double.parseDouble(get(key, Double.toString(defaultValue)));
    }

    public static long getLong(@NotNull String key) {
        return Long.parseLong(get(key));
    }

    public static long getLong(@NotNull String key, long defaultValue) {
        return Long.parseLong(get(key, Long.toString(defaultValue)));
    }

    public static float getFloat(@NotNull String key) {
        return Float.parseFloat(get(key));
    }

    public static float getFloat(@NotNull String key, float defaultValue) {
        return Float.parseFloat(get(key, Float.toString(defaultValue)));
    }

    public static short getShort(@NotNull String key) {
        return Short.parseShort(get(key));
    }

    public static short getShort(@NotNull String key, short defaultValue) {
        return Short.parseShort(get(key, Short.toString(defaultValue)));
    }

    public static byte getByte(@NotNull String key) {
        return Byte.parseByte(get(key));
    }

    public static byte getByte(@NotNull String key, byte defaultValue) {
        return Byte.parseByte(get(key, Byte.toString(defaultValue)));
    }

    public static char getChar(@NotNull String key) {
        return get(key).charAt(0);
    }

    public static char getChar(@NotNull String key, char defaultValue) {
        return get(key, Character.toString(defaultValue)).charAt(0);
    }

    public static String @NotNull [] getStringArray(@NotNull String key) {
        return get(key).split(",");
    }

    public static String @NotNull [] getStringArray(@NotNull String key,
            @NotNull String[] defaultValue) {
        return get(key, String.join(",", defaultValue)).split(",");
    }

    public static int @NotNull [] getIntArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public static boolean @NotNull [] getBooleanArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        boolean[] booleanArray = new boolean[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            booleanArray[i] = Boolean.parseBoolean(stringArray[i]);
        }
        return booleanArray;
    }

    public static double @NotNull [] getDoubleArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    public static long @NotNull [] getLongArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        long[] longArray = new long[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            longArray[i] = Long.parseLong(stringArray[i]);
        }
        return longArray;
    }

    public static float @NotNull [] getFloatArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        float[] floatArray = new float[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            floatArray[i] = Float.parseFloat(stringArray[i]);
        }
        return floatArray;
    }

    public static short @NotNull [] getShortArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        short[] shortArray = new short[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            shortArray[i] = Short.parseShort(stringArray[i]);
        }
        return shortArray;
    }

    public static byte @NotNull [] getByteArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        byte[] byteArray = new byte[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            byteArray[i] = Byte.parseByte(stringArray[i]);
        }
        return byteArray;
    }

    public static char @NotNull [] getCharArray(@NotNull String key) {
        String[] stringArray = getStringArray(key);
        char[] charArray = new char[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            charArray[i] = stringArray[i].charAt(0);
        }
        return charArray;
    }
}

