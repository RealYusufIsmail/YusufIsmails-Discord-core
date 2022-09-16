package io.github.yusufsdiscordbot.jconfig;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JConfigBuilder {
    private String filename = "config.json";
    private String directoryPath = "./";

    public JConfigBuilder() {}

    public JConfigBuilder setFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public JConfigBuilder setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
        return this;
    }

    public JConfig build() throws JConfigException {
        ObjectMapper mapper = new ObjectMapper();
        File json = new File(directoryPath + filename);
        try {
            JsonNode root = mapper.readTree(json);
            List<JsonEntry> entries = new ArrayList<>();

            for (Iterator<Map.Entry<String, JsonNode>> it = root.fields(); it.hasNext();) {
                Map.Entry<String, JsonNode> entry = it.next();
                entries.add(new JsonEntry(entry.getKey(), entry.getValue()));
            }

            return new JConfigImpl(entries);
        } catch (IOException e) {
            throw new JConfigException("Could not read the config file.", e);
        }
    }
}
