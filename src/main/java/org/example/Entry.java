package org.example;

public class Entry implements Comparable<Entry>{

    private final String key;
    private final Object value;
    private final Object newValue;
    private final EntryStatus status;

    public Entry(String key, Object value, Object newValue, EntryStatus status) {
        this.key = key;
        this.value = value;
        this.newValue = newValue;
        this.status = status;
    }

    public Entry(String key, Object value, EntryStatus status) {
        this(key, value, null, status);
    }

    @Override
    public int compareTo(Entry entry) {
        return key.compareTo(entry.key);
    }
}
