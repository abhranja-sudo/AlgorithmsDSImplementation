package com.ar50645.binarysearch;

public class Search {
    // Given a sorted array, search for a target item.

    public int search(int[] a, int target) {
        if(a == null || a.length == 0)
            return -1;

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
