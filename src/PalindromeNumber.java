public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Store the original number to compare later
        int originalNumber = x;
        int reversedNumber = 0;

        // Reverse the number
        while (x != 0) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        // Compare the original number with the reversed number
        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();

        // Example usage
        System.out.println(solution.isPalindrome(121));  // Output: true
        System.out.println(solution.isPalindrome(-121)); // Output: false
        System.out.println(solution.isPalindrome(10));   // Output: false
    }
}
