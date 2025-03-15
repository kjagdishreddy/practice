package com.jagdish.interview.codesignal;
/*
Given a string inputString, return a new string in which all occurrences of character c1 in the original string are
replaced by c2. You cannot use any built-in string methods or functions in Java, such as replace().

Here’s an example:

Java
Copy to clipboard
System.out.println(new Solution().replaceCharacter("hello, world", 'o', 'a'));
// Output: "hella, warld"
In this example, all occurrences of o have been replaced by a.
 */
public class CharacterReplacer {

    public String replaceCharacters(String inputString, char c1, char c2) {
        char[] input = inputString.toCharArray();

        for (int i = 0; i <  input.length; i++) {
            if (input[i] == c1) {
                input[i] = c2;
            }
        }

        return new String(input);
    }

    public static void main(String[] args) {
        CharacterReplacer cr = new CharacterReplacer();
        System.out.println(cr.replaceCharacters("Hello, world", 'o', 'a'));
    }
}
