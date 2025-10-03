package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        Path filepath1 = normalizeFilePath(pathToFile1);
        Path filepath2 = normalizeFilePath(pathToFile2);

        System.out.println(filepath1);
        System.out.println(filepath2);

        String file1 = readFileToString(filepath1);
        String file2 = readFileToString(filepath2);

        System.out.println(file1);
        System.out.println(file2);

        Map<String, Object> map1 = parseStringToMap(file1);
        Map<String, Object> map2 = parseStringToMap(file2);

        System.out.println(map1);
        System.out.println(map2);

        return diffToString(Comparator.compareMaps(map1, map2));
    }

    private static Path normalizeFilePath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    private static String readFileToString(Path filepath) throws IOException {
        return Files.readString(filepath);
    }

    private static Map<String, Object> parseStringToMap(String file) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }

    private static String diffToString(List<Entry> entries) {
        StringBuilder sb = new StringBuilder("{\n");

        for (Entry entry : entries) {

            switch (entry.getStatus()) {
                case SAVED ->
                        sb.append("    ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                case ADDED ->
                        sb.append("  + ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                case DELETED ->
                        sb.append("  - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                case UPDATED ->
                        sb.append("  - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n")
                        .append("  + ").append(entry.getKey()).append(": ").append(entry.getNewValue()).append("\n");
                default -> throw new IllegalStateException("Invalid status of Entry");
            }
        }

        return sb.append("}").toString();
    }
}
