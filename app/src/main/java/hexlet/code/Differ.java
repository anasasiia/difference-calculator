package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        String formatType1 = getFormatType(filepath1);
        String content2 = Files.readString(path2);
        String formatType2 = getFormatType(filepath2);

        Map<String, Object> mapFile1 = Parser.parse(content1, formatType1);
        Map<String, Object> mapFIle2 = Parser.parse(content2, formatType2);
        List<Map<String, Object>> differences = Differencer.getDifferences(mapFile1, mapFIle2);
        return Formatter.formatData(differences, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String getFormatType(String filepath) {
        return Stream.of(filepath)
                .map(f -> f.substring(filepath.lastIndexOf(".") + 1))
                .collect(Collectors.joining(""));
    }
}
