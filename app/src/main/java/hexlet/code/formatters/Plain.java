package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> differences) {
        var result = new StringBuilder();
        for (Map<String, Object> difference : differences) {
            if (difference.get("type").equals("added")) {
                result.append("Property '").append(difference.get("key")).append("' was added with value: ")
                        .append(getValuePlain(difference.get("value"))).append("\n");
            }
            if (difference.get("type").equals("removed")) {
                result.append("Property '").append(difference.get("key")).append("' was removed").append("\n");
            }
            if (difference.get("type").equals("updated")) {
                result.append("Property '").append(difference.get("key")).append("' was updated.").append(" From ")
                        .append(getValuePlain(difference.get("value1"))).append(" to ")
                        .append(getValuePlain(difference.get("value2"))).append("\n");
            }
        }
        return result.toString().trim();
    }

    private static Object getValuePlain(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Collection || value instanceof Map || value.getClass().isArray()) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
