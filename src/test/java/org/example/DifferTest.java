package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", filename)
                .toAbsolutePath().normalize().toString();
    }

    String getFixture(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath));
    }

    @Test
    void testJson() throws IOException {
        String filepath1 = getFixturePath("file1.json");
        String filepath2 = getFixturePath("file2.json");

        String expected = getFixture(getFixturePath("result.txt"));
        String actual = Differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    void testYaml() throws IOException {
        String filepath1 = getFixturePath("file1.yml");
        String filepath2 = getFixturePath("file2.yml");

        String expected = getFixture(getFixturePath("result.txt"));
        String actual = Differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }
}
