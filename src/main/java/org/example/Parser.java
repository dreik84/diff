package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parseFile(String pathToFile) throws IOException {
        Path filepath = normalizeFilePath(pathToFile);
        String fileContent = readFileToString(filepath);
        String extension = getExtension(filepath);
        ObjectMapper mapper = getMapper(extension);

        return mapper.readValue(fileContent, new TypeReference<>() {
        });
    }

    private static Path normalizeFilePath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    private static String readFileToString(Path filepath) throws IOException {
        return Files.readString(filepath);
    }

    private static String getExtension(Path filepath) {
        String[] parts = filepath.getFileName().toString().split("\\.");
        String extension = parts[parts.length - 1];

        extension = switch (extension) {
            case "json", "jsn" -> "json";
            case "yaml", "yml" -> "yml";
            default -> throw new IllegalArgumentException("Invalid extension - " + extension);
        };

        return extension;
    }

    private static ObjectMapper getMapper(String extension) {
        return switch (extension) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalArgumentException("Invalid extension - " + extension);
        };
    }
}
