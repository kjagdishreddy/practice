package com.jagdish.interview;

import java.util.Scanner;

public class NumberToWords {
    private static final String[] belowTwenty = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        String words = "";
        int place = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[place] + " " + words;
            }
            num /= 1000;
            place++;
        }
        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return belowTwenty[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println("In Words: " + numberToWords(num));
    }
}
