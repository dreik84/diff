package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize().toString();
    }

    String getFixture(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void testJsonYamlToStylish(String extension) throws IOException {
        String filepath1 = getFixturePath("file1." + extension);
        String filepath2 = getFixturePath("file2." + extension);

        String expected = getFixture(getFixturePath("stylish.txt"));
        String actual = Differ.generate(filepath1, filepath2, "stylish");

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void testJsonYamlToPlain(String extension) throws IOException {
        String filepath1 = getFixturePath("file1." + extension);
        String filepath2 = getFixturePath("file2." + extension);

        String expected = getFixture(getFixturePath("plain.txt"));
        String actual = Differ.generate(filepath1, filepath2, "plain");

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void testJsonYamlToJson(String extension) throws IOException {
        String filepath1 = getFixturePath("file1." + extension);
        String filepath2 = getFixturePath("file2." + extension);

        String expected = getFixture(getFixturePath("json.txt"));
        String actual = Differ.generate(filepath1, filepath2, "json");

        assertEquals(expected, actual);
    }
}
