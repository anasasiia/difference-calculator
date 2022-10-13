package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<Map<String, Object>> differences) {
        var result = new StringBuilder();
        result.append("{\n");
        for (Map<String, Object> difference : differences) {
            if (difference.get("Type").equals("added")) {
                result.append("  + ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("removed")) {
                result.append("  - ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("unchanged")) {
                result.append("    ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value")).append("\n");
            }
            if (difference.get("Type").equals("updated")) {
                result.append("  - ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value1")).append("\n");
                result.append("  + ").append(difference.get("Key")).append(": ")
                        .append(difference.get("Value2")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
