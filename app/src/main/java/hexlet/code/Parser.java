package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String filepath) throws Exception {
        String extension = "";

        int i = filepath.lastIndexOf(".");
        if (i > 0) {
            extension = filepath.substring(i + 1);
        }

        switch (extension) {
            case "json" -> {
                return parseJson(content);
            }
            case "yaml", "yml" -> {
                return parseYaml(content);
            }
            default -> throw new Exception(extension + " is not supported extension");
        }
    }

    private static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {  });
    }

    private static Map<String, Object> parseYaml(String content) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, new TypeReference<>() {  });
    }
}
