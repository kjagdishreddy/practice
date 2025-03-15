package com.jagdish.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j< s.length(); j++) {
                if(sb.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                sb.append(s.charAt(j));
                maxLength = Math.max(maxLength, sb.length());
            }

        }
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        Map<Character, Integer> visitedCharacers = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++) {
            if ( visitedCharacers.containsKey(s.charAt(right)) &&
                visitedCharacers.get(s.charAt(right)) >= left) {
                left = visitedCharacers.get(s.charAt(right)) + 1;
            }
        }
        return maxLength;
    }


}
