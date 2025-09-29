package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static void generate(String _filepath1, String _filepath2) throws IOException {
        Path filepath1 = normalizeFilePath(_filepath1);
        Path filepath2 = normalizeFilePath(_filepath2);

        System.out.println(filepath1);
        System.out.println(filepath2);

        String file1 = readFileToString(filepath1);
        String file2 = readFileToString(filepath2);

        System.out.println(file1);
        System.out.println(file2);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(file1, Map.class);

        System.out.println(map);
    }

    private static Path normalizeFilePath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    private static String readFileToString(Path filepath) throws IOException {
        return Files.readString(filepath);
    }
}
