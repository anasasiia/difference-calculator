package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatData(List<Map<String, Object>> differences, String format)
                                                                throws JsonProcessingException {
        switch (format) {
            case "plain" -> {
                return Plain.formatPlain(differences);
            }
            case "json" -> {
                return Json.formatJson(differences);
            }
            default -> {
                return Stylish.formatStylish(differences);
            }
        }
    }
}
