package org.example.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Entry;

import java.util.List;

public interface Formatter {
    String diffToString(List<Entry> entries) throws JsonProcessingException;
}
