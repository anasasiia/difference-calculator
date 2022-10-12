package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    public void testWithJSONFiles() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";

        String actual1 = Differ.generate(filepath1, filepath2);
        String expected1 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void testWithYAMLFiles() throws Exception {
        String filepath3 = "src/test/resources/file3.yaml";
        String filepath4 = "src/test/resources/file4.yaml";
        String actual2 = Differ.generate(filepath3, filepath4);
        String expected2 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void testWithNestedFiles() throws Exception {
        String filepath5 = "src/test/resources/file5.json";
        String filepath6 = "src/test/resources/file6.json";
        String actual3 = Differ.generate(filepath5, filepath6);
        String expected3 = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        Assertions.assertEquals(expected3, actual3);
    }
}
