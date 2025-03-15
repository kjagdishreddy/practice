package com.jagdish.interview;

import java.util.Scanner;
/*
A string is beautiful if no tow adjacent characters either 1. the same, for example 'aa' 2. adjacent in the alphabet, for example 'ef'

the following operations can be performed on a string s.
- choose any index i (0<= i <|s|) and change s[i] to any lowercase English letter.

Find the minimum number of operations required to make the string beautiful.

Example:
s = "abdde"
String is not beautiful because:
- 'dd' violates constrain 1, no two adjacent characters are the same
- 'ab' and 'de' violate constraint 2, no two adjacent characters are adjacent in the alphabet.

The string can be converted into a beautiful string after 2 operations. One solution is below

- choose i=1 and change s[i] to 'z'. s becomes "azdde".
- Chose i=3 and change s[i] to'k'. s becomes "azdke" which is beautiful
 */
public class BeautifulString {
    public static int makeBeautiful(String s) {
        char[] arr = s.toCharArray();
        int changes = 0;

        for (int i = 1; i < arr.length; i++) {
            // If the current character violates the beautiful string condition
            if (arr[i] == arr[i - 1] || Math.abs(arr[i] - arr[i - 1]) == 1) {
                // Find a suitable replacement that avoids adjacent violations
                arr[i] = getSafeReplacement(arr, i);
                changes++;
            }
        }
        return changes;
    }

    private static char getSafeReplacement(char[] arr, int index) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if ((index == 0 || (ch != arr[index - 1] && Math.abs(ch - arr[index - 1]) > 1)) &&
                    (index == arr.length - 1 || (ch != arr[index + 1] && Math.abs(ch - arr[index + 1]) > 1))) {
                return ch;
            }
        }
        return 'z';  // Fallback (should never reach here)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.next();
        scanner.close();

        int result = makeBeautiful(s);
        System.out.println("Minimum changes required: " + result);
    }
}