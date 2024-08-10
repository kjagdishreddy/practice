import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[10];
        for(int i=0; i < n; i++){
            System.out.println("a[" + i + "] - " + a[i]);
        }
        for(int i=0; i < n; i++){
            a[in.nextInt()]++;
        }
        // 1 - a[1] = 1
        // 2 - a[2] = 1
        // 3 - a[2] - 2
        // 4 - a[3] - 1
        // 5 - a[1] - 2
        // 6 - a[2] - 3
        // 0 2 3 1 0 0
        for(int i=0; i < n; i++){
            System.out.println("a[" + i + "] - " + a[i]);
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, a[i]+a[i+1]);
        }
        System.out.println(max);
    }
}