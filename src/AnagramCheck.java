import java.util.Arrays;

public class AnagramCheck {
    public boolean isAnagram(String s, String t) {
        // If the lengths of the strings are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort the character arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }


    public static void main(String[] args) {
        AnagramCheck solution = new AnagramCheck();

        // Example usage
        System.out.println("Anagram");
        System.out.println("--------");
        System.out.println(solution.isAnagram("anagram", "nagaram")); // Output: true
        System.out.println(solution.isAnagram("rat", "car"));         // Output: false
        System.out.println(solution.isAnagram("fe", "ja"));

        // Example usage
        System.out.println("Anagram1");
        System.out.println("--------");
        System.out.println(solution.isAnagram1("anagram", "nagaram")); // Output: true
        System.out.println(solution.isAnagram1("rat", "car"));         // Output: false
        System.out.println(solution.isAnagram1("fe", "ja"));

    }
}
