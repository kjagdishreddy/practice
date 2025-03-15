package com.jagdish.interview.codesignal;

/*
Given a string, you need to return a new string where every letter is shifted to its right by one place in alphabetical order.
The last letters z and Z should be replaced with the first ones: a and A, respectively.
If the character isn't a letter, it should stay the same.

It is not allowed to use string built-in methods here.

For example, given the string "abc123XYz!", the function should return "bcd123YZa!".
 */
public class LetterShifter {
    public String shiftLetters(String s) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result[i] = (c == 'z' ) ? 'a' : (char) (c + 1);
            } else if (c >= 'A' && c <= 'Z') {
                result[i] = (c == 'Z' ) ? 'A' : (char) (c + 1);
            } else {
                result[i] = c;
            }

        }

        return new String(result);
    }

    public static void main(String[] args) {
        LetterShifter ls = new LetterShifter();
        System.out.println(ls.shiftLetters("abc123XYz!"));
    }
}
