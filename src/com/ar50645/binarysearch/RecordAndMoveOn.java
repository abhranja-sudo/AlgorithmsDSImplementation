package com.ar50645.binarysearch;

/*
Given a sorted array of Integers, find the target. If the target is not found,return the element closest to the target.
 */
public class RecordAndMoveOn {
    public static int closestElement(int[] a, int target) {

        if(a == null || a.length == 0)
            return -1;

        int result = -1;

        int low = 0, high = a.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            result = record(result, mid, a, target);

            if(a[mid] == target)
                return mid;

            else if(a[mid] > target)
                high = mid - 1;

            else
                low = mid + 1;
        }
        return result;
    }

    private static int record(int result, int mid, int[] a, int target) {

        if(result == -1 || Math.abs(a[mid] - target) < Math.abs(a[result] - target))
            return mid;

        return result;
    }
}
