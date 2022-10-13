package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormatter(List<Map<String, Object>> differences, String format) {
        if (format.endsWith("plain")) {
            return Plain.formatPlain(differences);
        }
        return Stylish.formatStylish(differences);
    }
}
