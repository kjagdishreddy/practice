package com.jagdish.interview.codesignal;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueIds {
    public static void main(String[] args) {
        int[] addresses = {1, 2, 3, 2, 1, 5, 3, 1, 2, 1, 4, 5, 6};
        int[] uniqueAddresses = processAddresses(addresses);
        System.out.println(Arrays.toString(uniqueAddresses));   // Returns [1, 2, 3, 5, 4, 6]
    }

    static int[] processAddresses(int[] addresses) {
        HashSet<Integer> set = new HashSet<>();

        // TODO: fill in the set
        for (int i : addresses) {
            set.add(i);
        }

        int[] result = new int[set.size()];

        // TODO: fill in the result array
        result = set.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}
