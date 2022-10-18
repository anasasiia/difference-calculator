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
        String expected3 = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'
                """;
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void testWithNestedFilesJsonFormat() throws Exception {
        String filepath7 = "src/test/resources/file5.json";
        String filepath8 = "src/test/resources/file6.json";
        String actual4 = Differ.generate(filepath7, filepath8, "json");
        String expected4 = "[{\"Type\":\"unchanged\",\"Value\":[\"a\",\"b\",\"c\"],\"Key\":\"chars1\"},{\"Type\":"
                + "\"updated\",\"Value1\":[\"d\",\"e\",\"f\"],\"Value2\":false,\"Key\":\"chars2\"},{\"Type\":"
                + "\"updated\",\"Value1\":false,\"Value2\":true,\"Key\":\"checked\"},{\"Type\":\"updated\",\"Value1\":"
                + "null,\"Value2\":[\"value1\",\"value2\"],\"Key\":\"default\"},{\"Type\":\"updated\",\"Value1\":45,"
                + "\"Value2\":null,\"Key\":\"id\"},{\"Type\":\"removed\",\"Value\":\"value1\",\"Key\":\"key1\"},{\"Type"
                + "\":\"added\",\"Value\":\"value2\",\"Key\":\"key2\"},{\"Type\":\"unchanged\",\"Value\":[1,2,3,4],"
                + "\"Key\":\"numbers1\"},{\"Type\":\"updated\",\"Value1\":[2,3,4,5],\"Value2\":[22,33,44,55],\"Key\":"
                + "\"numbers2\"},{\"Type\":\"removed\",\"Value\":[3,4,5],\"Key\":\"numbers3\"},{\"Type\":\"added\","
                + "\"Value\":[4,5,6],\"Key\":\"numbers4\"},{\"Type\":\"added\",\"Value\":{\"nestedKey\":\"value\","
                + "\"isNested\":true},\"Key\":\"obj1\"},{\"Type\":\"updated\",\"Value1\":\"Some value\",\"Value2\":"
                + "\"Another value\",\"Key\":\"setting1\"},{\"Type\":\"updated\",\"Value1\":200,\"Value2\":300,\"Key\":"
                + "\"setting2\"},{\"Type\":\"updated\",\"Value1\":true,\"Value2\":\"none\",\"Key\":\"setting3\"}]";
        Assertions.assertEquals(expected4, actual4);
    }
}
