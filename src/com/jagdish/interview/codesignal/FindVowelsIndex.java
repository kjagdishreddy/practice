package com.jagdish.interview.codesignal;

import java.util.*;

public class FindVowelsIndex {
    static List<Integer> getVowelIndex(String s) {
        List<Integer> list = new ArrayList<>();
        Set<Character> vowelSet = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))) {
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(getVowelIndex("Hello World"));
    }


}
