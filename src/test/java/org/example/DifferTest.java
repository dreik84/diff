package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static final String FORMAT = "stylish";

    String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize().toString();
    }

    String getFixture(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath));
    }

    @Test
    void testJsonToStylish() throws IOException {
        String filepath1 = getFixturePath("file1.json");
        String filepath2 = getFixturePath("file2.json");

        String expected = getFixture(getFixturePath("stylish.txt"));
        String actual = Differ.generate(filepath1, filepath2, FORMAT);

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToStylish() throws IOException {
        String filepath1 = getFixturePath("file1.yml");
        String filepath2 = getFixturePath("file2.yml");

        String expected = getFixture(getFixturePath("stylish.txt"));
        String actual = Differ.generate(filepath1, filepath2, FORMAT);

        assertEquals(expected, actual);
    }

    @Test
    void testJsonToPlain() throws IOException {
        String filepath1 = getFixturePath("file1.json");
        String filepath2 = getFixturePath("file2.json");

        String expected = getFixture(getFixturePath("plain.txt"));
        String actual = Differ.generate(filepath1, filepath2, "plain");

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToPlain() throws IOException {
        String filepath1 = getFixturePath("file1.yml");
        String filepath2 = getFixturePath("file2.yml");

        String expected = getFixture(getFixturePath("plain.txt"));
        String actual = Differ.generate(filepath1, filepath2, "plain");

        assertEquals(expected, actual);
    }

    @Test
    void testJsonToJson() throws IOException {
        String filepath1 = getFixturePath("file1.json");
        String filepath2 = getFixturePath("file2.json");

        String expected = getFixture(getFixturePath("json.txt"));
        String actual = Differ.generate(filepath1, filepath2, "json");

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToJson() throws IOException {
        String filepath1 = getFixturePath("file1.yml");
        String filepath2 = getFixturePath("file2.yml");

        String expected = getFixture(getFixturePath("json.txt"));
        String actual = Differ.generate(filepath1, filepath2, "json");

        assertEquals(expected, actual);
    }
}
