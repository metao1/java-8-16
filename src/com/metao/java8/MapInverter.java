package com.metao.java8;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapInverter {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> items = List.of("apple", "cucumber", "egg", "egg", "apple", "orange", "pineapple", "blueberry", "apple", "banana", "egg", "cucumber");
        Comparator<Map.Entry<String, Long>> reversedOrderValues = Map.Entry.<String, Long>comparingByKey();
//        LinkedHashMap<Long, String> collect = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getVertex, Map.Entry::getKey, (v1, v2) -> v1, LinkedHashMap::new));
        Map<Long, List<String>> collect = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        System.out.println(collect);
    }
}
