package org.example;

import java.util.*;

public class Comparator {

    public static List<Entry> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        List<Entry> result = new ArrayList<>();
        Set<String> keys = new HashSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                result.add(new Entry(key, map2.get(key), EntryStatus.ADDED));
            } else if (!map2.containsKey(key)) {
                result.add(new Entry(key, map1.get(key), EntryStatus.DELETED));
            } else if (!map1.get(key).equals(map2.get(key))) {
                result.add(new Entry(key, map1.get(key), map2.get(key), EntryStatus.UPDATED));
            } else {
                result.add(new Entry(key, map1.get(key), EntryStatus.SAVED));
            }
        }

        Collections.sort(result);

        return result;
    }
}
