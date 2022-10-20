package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differencer {
    public static List<Map<String, Object>> getDifferences(Map<String, Object> mapFile1,
                                                            Map<String, Object> mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        List<Map<String, Object>> differences = new ArrayList<>();

        for (String key : keys) {
            if (!mapFile1.containsKey(key)) {
                differences.add(getMapWithOneValue("added", key, mapFile2.get(key)));
            } else if (!mapFile2.containsKey(key)) {
                differences.add(getMapWithOneValue("removed", key, mapFile1.get(key)));
            } else {
                if (mapFile1.get(key) == null && mapFile2.get(key) == null) {
                    differences.add(getMapWithOneValue("unchanged", key, null));
                } else if (mapFile1.get(key) != null && mapFile2.get(key) != null
                        && mapFile1.get(key).equals(mapFile2.get(key))) {
                    differences.add(getMapWithOneValue("unchanged", key, mapFile1.get(key)));
                } else {
                    differences.add(getMapWithTwoValues(key, mapFile1.get(key), mapFile2.get(key)));
                }
            }
        }
        return differences;
    }

    private static Map<String, Object> getMapWithOneValue(String type, String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("key", key);
        map.put("value", value);
        return map;
    }

    private static Map<String, Object> getMapWithTwoValues(String key, Object value1, Object value2) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "updated");
        map.put("key", key);
        map.put("value1", value1);
        map.put("value2", value2);
        return map;
    }
}
