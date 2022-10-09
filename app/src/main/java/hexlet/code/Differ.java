package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + filepath1 + "' does not exist");
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '" + filepath2 + "' does not exist");
        }

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> mapFile1 = getData(content1);
        Map<String, Object> mapFIle2 = getData(content2);
        Set<String> keys = Stream.concat(mapFile1.entrySet().stream(), mapFIle2.entrySet().stream())
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        var result = new StringBuilder();
        result.append("{\n");
        for (String key: keys) {
            if (!mapFile1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(mapFIle2.get(key)).append("\n");
            }
            if (!mapFIle2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
            }
            if (mapFile1.containsKey(key) && mapFIle2.containsKey(key)) {
                if (mapFile1.get(key).equals(mapFIle2.get(key))) {
                    result.append("    ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(mapFIle2.get(key)).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }

    private static Map<String, Object> getData(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, new TypeReference<>() {  });
        } catch (JsonProcessingException e) {
            throw new Exception("Wrong format!");
        }

    }
}
