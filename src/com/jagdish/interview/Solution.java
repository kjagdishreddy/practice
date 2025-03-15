package com.jagdish.interview;

import java.util.Arrays;

public class Solution {

    public static int[] moveZerosToEnd(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int counter = 0;

        for (int val : arr) {
            if (val != 0) {
                arr[counter] = val;
                counter++;
            }
        }

        while (counter < arr.length) {
            arr[counter] = 0;
            counter++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0,1, 2,4, 0, 2, 5};
        System.out.println("Before move = " + Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println("After move = " + Arrays.toString(arr));
    }
}
