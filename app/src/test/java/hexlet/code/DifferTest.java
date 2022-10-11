package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    public void testWithJSONFiles() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";

        String actual1 = Differ.generate(filepath1, filepath2);
        String expected1 = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void testWithYAMLFiles() throws Exception {
        String filepath1 = "src/test/resources/file3.yaml";
        String filepath2 = "src/test/resources/file4.yaml";
        String actual2 = Differ.generate(filepath1, filepath2);
        String expected2 = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(actual2, expected2);
    }
/*
    @Test
    public void testWithWrongFormat() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/helloworld.json";
        String actual = Differ.generate(filepath1, filepath2);
        Assertions.assertEquals(actual, "Wrong format!");
    }
 */
}
