package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<Map<String, Object>> differences) {
        var result = new StringBuilder();
        result.append("{\n");
        for (Map<String, Object> difference : differences) {
            if (difference.get("type").equals("added")) {
                result.append("  + ").append(difference.get("key")).append(": ").append(difference.get("value"))
                        .append("\n");
            }
            if (difference.get("type").equals("removed")) {
                result.append("  - ").append(difference.get("key")).append(": ").append(difference.get("value"))
                        .append("\n");
            }
            if (difference.get("type").equals("unchanged")) {
                result.append("    ").append(difference.get("key")).append(": ").append(difference.get("value"))
                        .append("\n");
            }
            if (difference.get("type").equals("updated")) {
                result.append("  - ").append(difference.get("key")).append(": ").append(difference.get("value1"))
                        .append("\n");
                result.append("  + ").append(difference.get("key")).append(": ").append(difference.get("value2"))
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
