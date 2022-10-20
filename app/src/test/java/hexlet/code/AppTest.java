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
    public void testWithYAMLFiles() throws Exception {
        String filepath1 = "src/test/resources/file3.yaml";
        String filepath2 = "src/test/resources/file4.yaml";
        BufferedReader reader1 = new BufferedReader(new FileReader("src/test/resources/resultTestYaml"));
        String expected1 = readAllLinesWithStream(reader1);
        Assertions.assertEquals(expected1, Differ.generate(filepath1, filepath2));
        reader1.close();
    }

    @Test
    public void testWithNestedFilesStylishFormat() throws Exception {
        String filepath3 = "src/test/resources/file5.json";
        String filepath4 = "src/test/resources/file6.json";
        BufferedReader reader2 = new BufferedReader(new FileReader("src/test/resources/resultTestStylish"));
        String expected2 = readAllLinesWithStream(reader2);
        Assertions.assertEquals(expected2, Differ.generate(filepath3, filepath4));
        reader2.close();
    }

    @Test
    public void testWithNestedFilesPlainFormat() throws Exception {
        String filepath5 = "src/test/resources/file5.json";
        String filepath6 = "src/test/resources/file6.json";
        BufferedReader reader3 = new BufferedReader(new FileReader("src/test/resources/resultTestPlainFormat"));
        String expected3 = readAllLinesWithStream(reader3);
        Assertions.assertEquals(expected3, Differ.generate(filepath5, filepath6, "plain"));
        reader3.close();
    }

    @Test
    public void testWithNestedFilesJsonFormat() throws Exception {
        String filepath7 = "src/test/resources/file5.json";
        String filepath8 = "src/test/resources/file6.json";
        BufferedReader reader4 = new BufferedReader(new FileReader("src/test/resources/resultTestJsonFormat"));
        String expected4 = readAllLinesWithStream(reader4);
        Assertions.assertEquals(expected4, Differ.generate(filepath7, filepath8, "json"));
        reader4.close();
    }
}
