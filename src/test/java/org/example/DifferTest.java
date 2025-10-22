package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @CsvSource({
        "json, stylish",
        "yml, stylish",
        "json, plain",
        "yml, plain",
        "json, json",
        "yml, json"

    })
    void testDiff(String extension, String format) throws IOException {
        String filepath1 = getFixturePath("file1." + extension);
        String filepath2 = getFixturePath("file2." + extension);

        String expected = getFixture(getFixturePath(format + ".txt"));
        String actual = Differ.generate(filepath1, filepath2, format);

        assertEquals(expected, actual);
    }
}
