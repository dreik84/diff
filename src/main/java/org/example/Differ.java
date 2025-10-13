package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        Map<String, Object> map1 = Parser.parseFile(pathToFile1);
        Map<String, Object> map2 = Parser.parseFile(pathToFile2);

        System.out.println(map1);
        System.out.println(map2);

        return diffToString(Comparator.compareMaps(map1, map2));
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
