package com.jagdish.interview.codesignal;

public class SumOfDigitsRecursion {
    static int sumOfDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            return num % 10 + sumOfDigits(num/10);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
    }
}
