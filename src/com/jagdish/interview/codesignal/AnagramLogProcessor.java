package com.jagdish.interview.codesignal;
import java.util.*;

/*
Alright, Space Explorer, let's add another feather to your coding cap!
Picture two spacecraft log files, each a whole array of words. Your mission?
Find the unique words from the second log file that have an anagram in the first log file.
Then, add up the length of these matching anagram words.
You must return this total length as an integer.
Now, remember, anagrams are words that have the same letters but rearranged.
If a word has no anagram in the other array or if it's not unique in its own array, abandon it like a black hole.
Don't worry, whether these arrays have one word or a thousand, your code should be ready!
Now, get set to crunch some cosmic anagram numbers!

 */
class AnagramLogProcessor {
    // Method to return a unique character signature for each string.
    static String sortCharacters(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Method to find unique words from array2 that have an anagram in array1
    public static int findAnagrams(String[] array1, String[] array2) {
        // HashSet<String> sortedWordsInArray1 = new HashSet<>(Arrays.asList(array1));
        HashSet<String> sortedWordsInArray1 = new HashSet<>();
        // TODO: fill in sortedWordsInArray1
        for (String id : array1) {
            sortedWordsInArray1.add(sortCharacters(id));
        }

        HashSet<String> anagramsMatched = new HashSet<>();
        int lengthSum = 0;

        for (String word : array2) {
            //word = sortCharacters(word);
            if(!anagramsMatched.contains(word)) {
                System.out.println(word);
                anagramsMatched.add(word);
                if (sortedWordsInArray1.contains(sortCharacters(word))) {
                    lengthSum += word.length();
                }
            }
        }

        return lengthSum;
    }

    public static void main(String []args){
        String[] array1 = {"cat", "dog", "tac", "god", "act"};
        String[] array2 = {"tca", "ogd", "atc", "taco"};
        int result = findAnagrams(array1, array2);
        System.out.println(result);   // output: 9

        // additional test samples
        String[] array3 = {"rat", "tar", "bat", "tab","bats"};
        String[] array4 = {"tra", "art", "abr"};
        int result2 = findAnagrams(array3, array4);
        System.out.println(result2);  // output: 6

        String[] log1 = {"listen", "silent", "hello", "world", "space"};
        String[] log2 = {"enlist", "hello", "cosmic", "silent", "space", "hello"};

        int result3 = findAnagrams(log1, log2);
        System.out.println(result3);
    }
}