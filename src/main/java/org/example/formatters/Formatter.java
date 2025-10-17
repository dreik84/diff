package org.example.formatters;

import org.example.Entry;

import java.util.List;

public interface Formatter {
    String diffToString(List<Entry> entries);
}
