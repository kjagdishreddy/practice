package com.jagdish.interview;

import java.util.Arrays;

public class SecondLargestInArrays {

    static int getSecondLargest(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;

        for (int i = len - 2; i > 0; i--) {
            if (numbers[i] != numbers[len - 1] ) {
                return numbers[i];
            }
        }

        return -1;
    }

    static int getSecondLargest1(int[] numbers) {
        int n = numbers.length;
        int largest = -1;
        int second = -1;

        for (int i = 0; i < n; i++) {
            if(numbers[i] > largest) {
                second = largest;
                largest = numbers[i];

            } else if (numbers[i] < largest && numbers[i] > second) {
                second = numbers[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1, 35, 35, 36};

        System.out.println("Second Largest - " + getSecondLargest(numbers));
        System.out.println("Second Largest - " + getSecondLargest1(numbers));
    }
}
