package com.jagdish.interview.codesignal;

import java.util.HashMap;

/*
Consider this: you have an extensive text — perhaps a short story or a section of a report —
and want to analyze word usage. How many times does each word appear? This isn't just about curiosity;
such a tool benefits writers aiming for diverse vocabulary.

Visualize yourself tasked with developing a feature for a text editor that gives feedback on word usage.
A writer could use this feature to refine their work, ensuring they use only certain words.
 */
public class WordCount {
    public static void main(String[] args) {
        String text = "Java Java Java";
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split(" ");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println(wordCount);
    }
}
