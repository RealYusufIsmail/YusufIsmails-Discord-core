package io.github.yusufsdiscordbot.jconfig;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JConfigImpl implements JConfig {
    private final Map<String, Object> entries;
    private final Set<JsonEntry> jsonEntries;

    public JConfigImpl(List<JsonEntry> entries) {
        this.entries = JsonEntry.toMap(entries);
        this.jsonEntries = this.entries.entrySet()
            .stream()
            .map(entry -> new JsonEntry(entry.getKey(), entry.getValue()))
            .collect(
                    Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    @Override
    public Set<JsonEntry> getEntries() {
        return jsonEntries;
    }

    @Override
    public Object get(String key) {
        return entries.get(key);
    }

    @Override
    public Object get(String key, Object defaultValue) {
        return entries.get(key) == null ? defaultValue : entries.get(key);
    }
}
