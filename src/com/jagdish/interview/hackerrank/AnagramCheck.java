package com.jagdish.interview.hackerrank;

import java.util.Scanner;

public class AnagramCheck {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] charCount = new int[26];

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
            charCount[b.charAt(i) -'a']--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        scanner.close();

        System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
    }

}
