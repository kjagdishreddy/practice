package com.jagdish.interview.hackerrank;

import java.util.Scanner;

public class PalindromeCheck {
    public static String isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if(s.charAt(left ) != s.charAt(right)) {
                return "No";
            }
            left++;
            right--;
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        System.out.println(isPalindrome(s));
    }

}
