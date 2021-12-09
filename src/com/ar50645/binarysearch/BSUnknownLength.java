package com.ar50645.binarysearch;

/**
 * Search Array of Unknown length.
 * You are given an array, but you don't know the length.
 * Write a program to find a target element in the array
 */
public class BSUnknownLength {

    public static int findWithUnknownLength(int[] a, int target) {
        if(a == null || a.length == 0)
            return -1;

        int high = 1;

        // consider putting sanity checks here, like high can't access 1M, discuss with interviewer
        while (true) {
            try{
                int temp = a[high];
            } catch (ArrayIndexOutOfBoundsException e) {
                high = getLength(a, high / 2, high);
                break;
            }
            high = high * 2;
        }
        return binarySearch(a, 0, high, target);
    }

    // find length
    private static int getLength(int[] a, int low, int high) {

        while (low <= high) {
            int mid = 0;
            try {
                mid = (low + high) / 2;
                int temp = a[mid];
            } catch(IndexOutOfBoundsException e) {
                high = mid - 1;
                continue;
            }

            try {
                int temp = a[mid + 1];
            } catch (IndexOutOfBoundsException e) {
                return mid;
            }
            low = mid + 1;
        }
        return -1;

    }

    //Regular binary Search
    private static int binarySearch(int[] a, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
