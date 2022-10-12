package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    private static List<Map<String, Object>> getDifferences(Map<String, Object> mapFile1,
                                                            Map<String, Object> mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        List<Map<String, Object>> differences = new ArrayList<>();

        for (String key : keys) {
            if (!mapFile1.containsKey(key)) {
                differences.add(getMapWithOneValue("secondFileHas", key, mapFile2.get(key)));
            }
            if (!mapFile2.containsKey(key)) {
                differences.add(getMapWithOneValue("firstFileHas", key, mapFile1.get(key)));
            }
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (mapFile1.get(key) == null && mapFile2.get(key) == null) {
                    differences.add(getMapWithOneValue("haveIdenticalKeyValue", key, mapFile1.get(key)));
                } else if (mapFile1.get(key) == null || mapFile2.get(key) == null) {
                    differences.add(getMapWithTwoValues(key, mapFile1.get(key), mapFile2.get(key)));
                } else {
                    if (mapFile1.get(key).equals(mapFile2.get(key))) {
                        differences.add(getMapWithOneValue("haveIdenticalKeyValue", key, mapFile1.get(key)));
                    } else {
                        differences.add(getMapWithTwoValues(key, mapFile1.get(key), mapFile2.get(key)));
                    }
                }
            }
        }
        return differences;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + filepath1 + "' does not exist");
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '" + filepath2 + "' does not exist");
        }

        String content1 = Files.readString(path1);
        String extension1 = String.valueOf(path1);
        String content2 = Files.readString(path2);
        String extension2 = String.valueOf(path2);
        Map<String, Object> mapFile1 = Parser.parse(content1, extension1);
        Map<String, Object> mapFIle2 = Parser.parse(content2, extension2);

        List<Map<String, Object>> differences = getDifferences(mapFile1, mapFIle2);
        String result = null;

        if (format.equals("stylish")) {
            result = Stylish.formatStylish(differences);
        }
        return result;
    }

    private static Map<String, Object> getMapWithOneValue(String type, String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put("Type", type);
        map.put("Key", key);
        map.put("Value", value);
        return map;
    }

    private static Map<String, Object> getMapWithTwoValues(String key, Object value1, Object value2) {
        Map<String, Object> map = new HashMap<>();
        map.put("Type", "haveDifferentValues");
        map.put("Key", key);
        map.put("Value1", value1);
        map.put("Value2", value2);
        return map;
    }
}
