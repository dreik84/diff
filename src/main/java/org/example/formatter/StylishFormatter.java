package org.example.formatter;

import org.example.Entry;

import java.util.List;

public class StylishFormatter {

    public static String diffToString(List<Entry> entries) {
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
