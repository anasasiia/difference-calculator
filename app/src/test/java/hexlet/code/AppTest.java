package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class AppTest {

    public static String readAllLinesWithStream(BufferedReader reader) {
        return reader.lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }
    @Test
    public void testYAMLFiles() throws Exception {
        String filepath1 = "src/test/resources/file3.yaml";
        String filepath2 = "src/test/resources/file4.yaml";
        BufferedReader reader1 = new BufferedReader(new FileReader("src/test/resources/resultTestYaml"));
        String expected1 = readAllLinesWithStream(reader1);
        Assertions.assertEquals(expected1, Differ.generate(filepath1, filepath2));
        reader1.close();
    }

    @Test
    public void testJsonFileStylishFormat() throws Exception {
        String filepath3 = "src/test/resources/file5.json";
        String filepath4 = "src/test/resources/file6.json";
        BufferedReader reader2 = new BufferedReader(new FileReader("src/test/resources/resultTestStylish"));
        String expected2 = readAllLinesWithStream(reader2);
        Assertions.assertEquals(expected2, Differ.generate(filepath3, filepath4));
        reader2.close();
    }

    @Test
    public void testJsonFilePlainFormat() throws Exception {
        String filepath5 = "src/test/resources/file5.json";
        String filepath6 = "src/test/resources/file6.json";
        BufferedReader reader3 = new BufferedReader(new FileReader("src/test/resources/resultTestPlainFormat"));
        String expected3 = readAllLinesWithStream(reader3);
        Assertions.assertEquals(expected3, Differ.generate(filepath5, filepath6, "plain"));
        reader3.close();
    }

    @Test
    public void testJsonFileJsonFormat() throws Exception {
        String filepath7 = "src/test/resources/file5.json";
        String filepath8 = "src/test/resources/file6.json";
        BufferedReader reader4 = new BufferedReader(new FileReader("src/test/resources/resultTestJsonFormat"));
        String expected4 = readAllLinesWithStream(reader4);
        Assertions.assertEquals(expected4, Differ.generate(filepath7, filepath8, "json"));
        reader4.close();
    }

    @Test
    public void testJsonFiles() throws Exception {
        String filepath9 = "src/test/resources/file1.json";
        String filepath10 = "src/test/resources/file2.json";
        BufferedReader reader5 = new BufferedReader(new FileReader("src/test/resources/resultTestJson"));
        String expected5 = readAllLinesWithStream(reader5);
        Assertions.assertEquals(expected5, Differ.generate(filepath9, filepath10));
        reader5.close();
    }

    @Test
    public void testYamlFileStylishFormat() throws Exception {
        String filepath11 = "src/test/resources/file7.yml";
        String filepath12 = "src/test/resources/file8.yml";
        BufferedReader reader6 = new BufferedReader(new FileReader("src/test/resources/resultTestStylish"));
        String expected6 = readAllLinesWithStream(reader6);
        Assertions.assertEquals(expected6, Differ.generate(filepath11, filepath12));
        reader6.close();
    }

    @Test
    public void testYamlFilePlainFormat() throws Exception {
        String filepath13 = "src/test/resources/file7.yml";
        String filepath14 = "src/test/resources/file8.yml";
        BufferedReader reader7 = new BufferedReader(new FileReader("src/test/resources/resultTestPlainFormat"));
        String expected7 = readAllLinesWithStream(reader7);
        Assertions.assertEquals(expected7, Differ.generate(filepath13, filepath14, "plain"));
        reader7.close();
    }

    @Test
    public void testYamlFileJsonFormat() throws Exception {
        String filepath15 = "src/test/resources/file7.yml";
        String filepath16 = "src/test/resources/file8.yml";
        BufferedReader reader8 = new BufferedReader(new FileReader("src/test/resources/resultTestJsonFormat"));
        String expected8 = readAllLinesWithStream(reader8);
        Assertions.assertEquals(expected8, Differ.generate(filepath15, filepath16, "json"));
        reader8.close();
    }
}
