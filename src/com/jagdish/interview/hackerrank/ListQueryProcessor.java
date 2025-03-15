package com.jagdish.interview.hackerrank;

// Reference : https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true
import java.util.*;

public class ListQueryProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read initial list size
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        // Step 2: Read 'n' integers into the list
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Step 3: Read number of queries
        int q = scanner.nextInt();

        // Step 4: Process queries
        for (int i = 0; i < q; i++) {
            String command = scanner.next(); // Read "Insert" or "Delete"

            if (command.equals("Insert")) {
                int x = scanner.nextInt(); // Index
                int y = scanner.nextInt(); // Value
                list.add(x, y);
            } else if (command.equals("Delete")) {
                int x = scanner.nextInt(); // Index to remove
                list.remove(x);
            }
        }

        scanner.close();

        // Step 5: Print final list
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}