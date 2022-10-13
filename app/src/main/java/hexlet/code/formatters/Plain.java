package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> differences) {
        var result = new StringBuilder();
        for (Map<String, Object> difference : differences) {
            if (difference.get("Type").equals("added")) {
                result.append("Property '").append(difference.get("Key")).append("' was added with value: ")
                        .append(getValuePlain(difference.get("Value"))).append("\n");
            }
            if (difference.get("Type").equals("removed")) {
                result.append("Property '").append(difference.get("Key")).append("' was removed").append("\n");
            }
            if (difference.get("Type").equals("updated")) {
                result.append("Property '").append(difference.get("Key")).append("' was updated.").append(" From ")
                        .append(getValuePlain(difference.get("Value1"))).append(" to ")
                        .append(getValuePlain(difference.get("Value2"))).append("\n");
            }
        }
        return result.toString();
    }

    private static Object getValuePlain(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        } else if (value.getClass().isArray()) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
