public class Fibonacci {
    public static void main(String[] args) {
        int index = 15;

        for (int i=1; i<=index; i++) {
            // System.out.println("index-" + i + " no-" +next + " with recurrsion calculateFibonnaci-" + calculateFibonacci(i));
            System.out.println("index-" + i + " calculateFib-" +calculateFib(i) + " calculateFibonnaci-" + calculateFibonacci(i));
        }



    }

    public static int calculateFibonacci(int index) {
        int start = 0;
        int next = 1;
        if (index == 1) {
            return start;
        } else if (index == 2) {
            return next;
        } else {
            return calculateFibonacci(index -1) + calculateFibonacci(index -2);
        }
    }

    public static int calculateFib(int index) {
        int start = 0;
        int next = 1;
        int fib = 0;
        if (index == 1) {
            return start;
        } else if (index == 2) {
            return next;
        } else {
            for (int i = 3; i <= index; i++) {
                fib = start + next;
                start = next;
                next = fib;
            }

            return fib;
        }
    }

}
