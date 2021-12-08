package com.ar50645.binarysearch;

public class SearchWithDuplicates {

    //Given a sorted array that can contain duplicates, find the first occurrence of a target element T.
    public int findFirst(int[] a, int target) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == target) {
                if(mid == 0 || a[mid - 1] < target)
                    return mid;
            }

            if(a[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

    public int findLast(int[] a, int target) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == target) {
                if(mid == a.length - 1 || a[mid + 1] > target)
                    return mid;
            }

            if(a[mid] > target)
                high = mid - 1;

            else
                low = mid + 1;
        }
        return -1;
    }


}
