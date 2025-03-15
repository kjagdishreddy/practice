package com.jagdish.interview.codesignal;

/*
Given a string inputString, your task is to write a method that transforms all the lowercase letters to uppercase
and all the uppercase letters to lowercase. If the character is not a letter, do not transform it.

The transformation should be done without using any built-in Java methods like toLowerCase(), toUpperCase(),
or similar in your code.

For example, for the input string "HelLo WoRld 123", the output should be "hELlO wOrLD 123".
 */
public class CaseTransformer {
    public String swapCase(String input) {
        char[] result = new char[input.length()];

        char[] inputChar = input.toCharArray();

        for(int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] >= 'A' && inputChar[i] <= 'Z') {
                result[i] = (char) (inputChar[i] + 32);
            } else if (inputChar[i] >= 'a' && inputChar[i] <= 'z') {
                result[i] = (char) (inputChar[i] - 32);
            } else {
                result[i] = inputChar[i];
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        CaseTransformer caseTransformer = new CaseTransformer();
        System.out.println(caseTransformer.swapCase("Hello World 2025"));
    }
}
