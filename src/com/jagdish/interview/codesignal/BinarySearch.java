package com.jagdish.interview.codesignal;

public class BinarySearch {
    static int binarySearch(int[] ids, int start, int end,  int target) {
        if (start > end) return -1;
        int mid = start + (end-start) / 2;
        if(ids[mid] == target) return mid;
        if(ids[mid] > target)
            return binarySearch(ids,start, mid - 1, target);
        return binarySearch(ids, mid + 1, end, target);
    }

    public static void main(String[] args) {
        int[] ids = {101, 203, 307, 404, 513, 628, 734, 850, 961};
        int target = 404;

        int index = binarySearch(ids, 0, ids.length - 1, target);
        if (index != -1)
            System.out.println("Book with ID " + target + " is at index: " + index);
        else
            System.out.println("Book with ID " + target + " not found.");
    }



}
