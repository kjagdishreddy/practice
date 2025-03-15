package com.jagdish.interview.codesignal;

public class PalindromeChecker {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Ignore non-letter characters
            if (!isLetter(leftChar)) {
                left++;
                continue;
            }
            if (!isLetter(rightChar)) {
                right--;
                continue;
            }

            // Convert uppercase to lowercase manually
            if (isUppercase(leftChar)) {
                leftChar = (char) (leftChar + 32);
            }
            if (isUppercase(rightChar)) {
                rightChar = (char) (rightChar + 32);
            }
            // Compare valid letters
            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isUppercase(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        System.out.println(checker.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(checker.isPalindrome("race a car")); // false
        System.out.println(checker.isPalindrome("No 'x' in Nixon")); // true
        System.out.println(checker.isPalindrome("Hello")); // false
    }
}
