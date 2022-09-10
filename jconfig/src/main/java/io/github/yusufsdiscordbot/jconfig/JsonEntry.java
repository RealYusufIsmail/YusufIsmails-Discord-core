package io.github.yusufsdiscordbot.jconfig;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonEntry {
    private final String key;
    private final Object value;

    /**
     * Creates a new JsonEntry instance.
     * 
     * @param key The key of the entry.
     * @param value The value of the entry.
     */
    public JsonEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public static Map<String, Object> toMap(@NotNull List<JsonEntry> entries) {
        return entries.stream().collect(Collectors.toMap(JsonEntry::getKey, JsonEntry::getValue));
    }

    /**
     * Gets the key of the entry.
     * 
     * @return The key of the entry.
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the value of the entry.
     * 
     * @return The value of the entry.
     */
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "JsonEntry{" + "key='" + key + '\'' + ", value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JsonEntry jsonEntry = (JsonEntry) o;
        return Objects.equals(key, jsonEntry.key) && Objects.equals(value, jsonEntry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
