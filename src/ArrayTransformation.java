public class ArrayTransformation {
    public static int[] transformArray(int[] a) {
        int n = a.length;
        int[] b = new int[n];

        for (int i =0; i < n; i++) {
            int left = (i > 0 ) ? a[i-1] : 0;
            int right = (i < n -1) ? a[i+1] : 0;
            b[i] = left + a[i] + right;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {4, 0, 1, -2, 3};
        int[] b = transformArray(a);

        for (int num : b) {
            System.out.println(num + " ");
        }
    }
}
