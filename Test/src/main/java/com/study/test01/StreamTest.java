package com.study.test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc","","bc","efg","hij","","abc");
        List<String> filtered = strings.stream()
                                        .filter(string -> !string.isEmpty())
                                        .collect(Collectors.toList());
        System.out.println(filtered);
    }

}
