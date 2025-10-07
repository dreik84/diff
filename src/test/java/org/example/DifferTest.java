package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    String filepath1;
    String filepath2;
    String expected;

    String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", filename)
                .toAbsolutePath().normalize().toString();
    }

    String getFixture(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath));
    }

    @BeforeEach
    void initFilePath() throws IOException {
        filepath1 = getFixturePath("file1.json");
        filepath2 = getFixturePath("file2.json");
        expected = getFixture(getFixturePath("result.txt"));
    }

    @Test
    void generate() throws IOException {
        String actual = Differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }
}
