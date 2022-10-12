package hexlet.code;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<Map<String, Object>> differences) {
        var result = new StringBuilder();
        result.append("{\n");
        for (Map<String, Object> difference : differences) {
            if (difference.get("Type").equals("secondFileHas")) {
                result.append("  + ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("firstFileHas")) {
                result.append("  - ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("haveIdenticalKeyValue")) {
                result.append("    ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("haveDifferentValues")) {
                result.append("  - ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value1")).append("\n");
                result.append("  + ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value2")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }


    private static Object getRightValue(Object value) {
        if (!value.getClass().isPrimitive()) {
            if (value.getClass().isArray()) {
                return value.toString();
            } else if (value instanceof Collection || value instanceof Map) {
                return value.toString();
            }
        }
        return value;
    }
}
