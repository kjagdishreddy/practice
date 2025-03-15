package com.jagdish.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonStrings
{
    public static String checkCommonString(String s1, String s2) {
        String response = "NO";
        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c) != -1) {
                response = "YES";
            }
        }
        return response;
    }

    public static String checkCommonString1(String s1, String s2) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : s1.toCharArray()) {
            characterSet.add(c);
        }

        for(char c : s2.toCharArray()) {
            if(characterSet.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(checkCommonString1(s1, s2));
        }
    }
}
