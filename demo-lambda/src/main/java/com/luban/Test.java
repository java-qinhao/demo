package com.luban;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] arr = {"program", "creek", "is", "a", "java", "site"};
        Arrays.sort(arr, (String m, String n) -> Integer.compare(m.length(), n.length()));
        System.out.println(Arrays.toString(arr));
    }
}
