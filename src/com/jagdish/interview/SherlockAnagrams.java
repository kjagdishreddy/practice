package com.jagdish.interview;

import java.util.*;

public class SherlockAnagrams {
    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> substringCount = new HashMap<>();
        int n = s.length();
        int anagramPairs = 0;

        // Generate all possible substrings
        for (int len = 1; len < n; len++) { // Length of the substring
            for (int i = 0; i + len <= n; i++) { // Starting index
                String substring = s.substring(i, i + len);

                // Convert substring to character array, sort it, and use as key
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // Store in HashMap: Count frequency of each unique sorted substring
                substringCount.put(key, substringCount.getOrDefault(key, 0) + 1);
            }
        }

        // Compute the number of anagrammatic pairs
        for (int count : substringCount.values()) {
            if (count > 1) {
                anagramPairs += (count * (count - 1)) / 2; // Combination formula
            }
        }

        return anagramPairs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int t = 0; t < testCases; t++) {
            String s = scanner.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }

        scanner.close();
    }
}
