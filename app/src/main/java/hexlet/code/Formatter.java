package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormatter(List<Map<String, Object>> differences, String format)
                                                                throws JsonProcessingException {
        if (format.endsWith("plain")) {
            return Plain.formatPlain(differences);
        } else if (format.endsWith("json")) {
            return Json.formatJson(differences);
        }
        return Stylish.formatStylish(differences);
    }
}
