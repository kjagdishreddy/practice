package com.jagdish.interview.codesignal;

import java.util.Arrays;

/*
Create a program that combines arrays and manipulates the resulting combination.
Combine two arrays, representing morning and evening fruits, then repeat this combined array 2 times.
The power of arrays is in your hands!
 */
public class ArrayManipulator {
    public String[] combineArrays(String[] arrayA, String[] arrayB, int multiplier) {
        // TODO: Concatenate arrayA and arrayB, then repeat the result using the multiplier
        int totalLength = arrayA.length + arrayB.length;
        String[] newArray = new String[totalLength];

        System.arraycopy(arrayA, 0, newArray, 0, arrayA.length);
        System.arraycopy(arrayB, 0, newArray, arrayA.length, arrayB.length);

        String[]  result = new String[totalLength * multiplier];

        for (int i = 0; i < multiplier; i++) {
            System.arraycopy(newArray, 0, result, i * totalLength, totalLength);
        }
        return result;
    }
    public static void main(String[] args) {

        ArrayManipulator manipulator = new ArrayManipulator();

        String[] morningFruits = {"Banana", "Orange"};
        String[] eveningFruits = {"Apple", "Cherry"};

        String[] result = manipulator.combineArrays(morningFruits, eveningFruits, 2);

        System.out.println(String.join(", ", result));

        Arrays.stream(result).forEach(System.out::println);

    }
}
