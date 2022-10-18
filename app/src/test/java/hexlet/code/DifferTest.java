package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    public void testWithYAMLFiles() throws Exception {
        String filepath1 = "src/test/resources/file3.yaml";
        String filepath2 = "src/test/resources/file4.yaml";
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
    public void testWithNestedFilesStylishFormat() throws Exception {
        String filepath3 = "src/test/resources/file5.json";
        String filepath4 = "src/test/resources/file6.json";
        String actual2 = Differ.generate(filepath3, filepath4);
        String expected2 = """
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
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void testWithNestedFilesPlainFormat() throws Exception {
        String filepath5 = "src/test/resources/file5.json";
        String filepath6 = "src/test/resources/file6.json";
        String actual3 = Differ.generate(filepath5, filepath6, "plain");
        String expected3 = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void testWithNestedFilesJsonFormat() throws Exception {
        String filepath7 = "src/test/resources/file5.json";
        String filepath8 = "src/test/resources/file6.json";
        String actual4 = Differ.generate(filepath7, filepath8, "json");
        String expected4 = "[{\"type\":\"unchanged\",\"value\":[\"a\",\"b\",\"c\"],\"key\":\"chars1\"},"
                + "{\"value2\":false,\"value1\":[\"d\",\"e\",\"f\"],\"type\":\"updated\",\"key\":\"chars2\"},"
                + "{\"value2\":true,\"value1\":false,\"type\":\"updated\",\"key\":\"checked\"},{\"value2\":[\"value1\","
                + "\"value2\"],\"value1\":null,\"type\":\"updated\",\"key\":\"default\"},{\"value2\":null,\"value1"
                + "\":45,\"type\":\"updated\",\"key\":\"id\"},{\"type\":\"removed\",\"value\":\"value1\",\"key\":"
                + "\"key1\"},{\"type\":\"added\",\"value\":\"value2\",\"key\":\"key2\"},{\"type\":\"unchanged\","
                + "\"value\":[1,2,3,4],\"key\":\"numbers1\"},{\"value2\":[22,33,44,55],\"value1\":[2,3,4,5],\"type\":"
                + "\"updated\",\"key\":\"numbers2\"},{\"type\":\"removed\",\"value\":[3,4,5],\"key\":\"numbers3\"},"
                + "{\"type\":\"added\",\"value\":[4,5,6],\"key\":\"numbers4\"},{\"type\":\"added\",\"value\":"
                + "{\"nestedKey\":\"value\",\"isNested\":true},\"key\":\"obj1\"},{\"value2\":\"Another value\","
                + "\"value1\":\"Some value\",\"type\":\"updated\",\"key\":\"setting1\"},{\"value2\":300,\"value1\":200,"
                + "\"type\":\"updated\",\"key\":\"setting2\"},{\"value2\":\"none\",\"value1\":true,"
                + "\"type\":\"updated\",\"key\":\"setting3\"}]";
        Assertions.assertEquals(expected4, actual4);
    }
}
