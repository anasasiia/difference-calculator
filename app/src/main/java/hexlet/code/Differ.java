package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {
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
        List<Map<String, Object>> differences = Differencer.getDifferences(mapFile1, mapFIle2);
        return Formatter.chooseFormatter(differences, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
