import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonCharacters {
    public List<String> commonChars1(String[] words) {
        // Initialize the character map with the frequency of characters in the first word
        HashMap<Character, Integer> characterMap = new HashMap<>();

        for(String word : words) {
            for (char c: word.toCharArray()) {
                characterMap.put(c, characterMap.getOrDefault(c,0)+1);
            }
        }


        // Build the result list based on the frequencies in the character map
        List<String> characters = new ArrayList<>();
        for (char c : characterMap.keySet()) {
            int count = characterMap.get(c);
            if (count > 1) {
                characters.add(String.valueOf(c));
            }
        }

        return characters;
    }

    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"bella", "label", "roller"};
        // Output: ["e","l","l"]
        String[] words2 = {"cool", "lock", "cook"};
        // Output: ["c","o"]
        CommonCharacters cc = new CommonCharacters();
        List<String> output = cc.commonChars(words1);

        System.out.println("Common characters: " + output);

        output = cc.commonChars(words2);
        System.out.println("Common characters: " + output);
    }
}
