package org.example.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Entry;

import java.util.List;

public class JsonFormatter implements Formatter {

    @Override
    public String diffToString(List<Entry> entries) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entries);
    }
}
