public class DecodeString {
    public String decodeString(String s) {
        return decode(s, new int[]{0});
    }

    private String decode(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (index[0] < s.length()) {
            char ch = s.charAt(index[0]);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
                index[0]++;
            } else if (ch == '[') {
                index[0]++;
                String decodedString = decode(s, index);
                for (int i = 0; i < k; i++) {
                    result.append(decodedString);
                }
                k = 0;
            } else if (ch == ']') {
                index[0]++;
                return result.toString();
            } else {
                result.append(ch);
                index[0]++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        // Example usage
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(solution.decodeString(s1));  // Output: "aaabcbc"
        System.out.println(solution.decodeString(s2));  // Output: "accaccacc"
        System.out.println(solution.decodeString(s3));  // Output: "abcabccdcdcdef"
    }
}
