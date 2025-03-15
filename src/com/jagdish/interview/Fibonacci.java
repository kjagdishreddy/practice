package com.jagdish.interview;

public class Fibonacci {

    private static  long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 10;

        fibonacciCache = new long[n+1];

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long nthFib = fibonacci(n-1) + fibonacci( n - 2);
        fibonacciCache[n] = nthFib;
        return nthFib;

    }
}
