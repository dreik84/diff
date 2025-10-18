package org.example.formatters;

import org.example.Entry;

import java.util.List;
import java.util.Map;

public class PlainFormatter implements Formatter {

    @Override
    public String diffToString(List<Entry> entries) {
        StringBuilder sb = new StringBuilder();

        for (Entry entry : entries) {

            switch (entry.getStatus()) {
                case SAVED -> sb.append("");
                case ADDED -> sb.append(String.format("Property '%s' was %s with value: %s\n",
                        entry.getKey(), entry.getStatus().toString().toLowerCase(), checkValue(entry.getValue())));
                case REMOVED -> sb.append("Property ").append("'").append(entry.getKey()).append("'").append(" was ")
                        .append(entry.getStatus().toString().toLowerCase()).append("\n");
                case UPDATED -> sb.append("Property ").append("'").append(entry.getKey()).append("'").append(" was ")
                        .append(entry.getStatus().toString().toLowerCase()).append(". ")
                        .append("From ").append(checkValue(entry.getValue())).append(" to ")
                        .append(checkValue(entry.getNewValue())).append("\n");
                default -> throw new IllegalStateException("Invalid status of Entry");
            }
        }

        return sb.toString().trim();
    }

    private String checkValue(Object value) {

        return switch (value) {
            case null -> "null";
            case List<?> list -> "[complex value]";
            case Map<?, ?> map -> "[complex value]";
            case String s -> "'" + value + "'";
            default -> value.toString();
        };
    }
}
