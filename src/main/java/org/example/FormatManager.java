package org.example;

import org.example.formatters.Formatter;
import org.example.formatters.PlainFormatter;
import org.example.formatters.StylishFormatter;

public class FormatManager {

    public static Formatter getFormatter(String format) {
        return switch (format) {
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            default -> throw new IllegalArgumentException("Invalid format");
        };
    }
}
