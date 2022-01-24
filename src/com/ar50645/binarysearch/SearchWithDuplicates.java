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


    //find insertion index
    public static int findInsertionIndex(int[] a, int target) {
        if (a == null)
            return -1;
        if (a.length == 0)
            return 0;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= target) {
                if (mid == a.length - 1)
                    return a.length;
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] <= target)
                    return mid;
                high = mid - 1;
            }
        }
        return -1; // should not happen, you can also throw an exception here}

    }
    }
