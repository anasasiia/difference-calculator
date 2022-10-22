package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String formatType) throws Exception {
        switch (formatType) {
            case "json" -> {
                return parseJson(content);
            }
            case "yaml", "yml" -> {
                return parseYaml(content);
            }
            default -> throw new Exception(formatType + " is not supported extension");
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
