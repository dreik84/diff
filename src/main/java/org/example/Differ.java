package org.example;

import org.example.formatter.StylishFormatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathToFile1, String pathToFile2, String format) throws IOException {
        Map<String, Object> map1 = Parser.parseFile(pathToFile1);
        Map<String, Object> map2 = Parser.parseFile(pathToFile2);

        List<Entry> diffList = Comparator.compareMaps(map1, map2);
        String result = StylishFormatter.diffToString(diffList);

        System.out.println(map1);
        System.out.println(map2);

        return result;
    }
}
