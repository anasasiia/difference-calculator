package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String extension) throws Exception {
        if (extension.endsWith("json")) {
            return parseJson(content);
        } else if (extension.endsWith("yaml") || extension.endsWith("yml")) {
            return parseYaml(content);
        } else {
            throw new Exception(extension + " is not supported extension");
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
