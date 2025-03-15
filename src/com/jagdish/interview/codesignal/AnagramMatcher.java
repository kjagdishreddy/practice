package com.jagdish.interview.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Problem 2: Anagram Matcher
Now, imagine a different scenario in which you have two arrays of strings,
and your task is to find all the unique words from the first array that have an anagram in the second array.
*/
public class AnagramMatcher {
    private static String sortCharacters(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static List<String> findAnagrams(String[] arr1, String[] arr2) {
        HashSet<String> sortedWordsArray2 = new HashSet<>();
        for (String word : arr2) {
            sortedWordsArray2.add(sortCharacters(word));
        }

        HashSet<String> anagramsMatched = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for(String word : arr1) {
            if (sortedWordsArray2.contains(sortCharacters(word))) {
                if (!anagramsMatched.contains(word)) {
                    result.add(word);
                    anagramsMatched.add(word);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr1 = {"listen", "hello", "silent", "world", "python"};
        String[] arr2 = {"enlist", "world", "java", "hello"};

        List<String> anagramWords = findAnagrams(arr1, arr2);
        System.out.println(anagramWords); // Output: [listen, hello, silent, world]

    }

}
