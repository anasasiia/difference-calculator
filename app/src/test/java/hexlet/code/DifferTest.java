package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    public void testWithGoodFiles() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";

        String actual = Differ.generate(filepath1, filepath2);
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(expected, actual);
    }
/*
    @Test
    public void testWithNoExistFile() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file3.json";
        String actual = Differ.generate(filepath1, filepath2);
        Assertions.assertEquals(actual, "File '" + filepath2 + "' does not exist");
    }

    @Test
    public void testWithWrongFormat() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/helloworld.json";
        String actual = Differ.generate(filepath1, filepath2);
        Assertions.assertEquals(actual, "Wrong format!");
    }
 */
}
