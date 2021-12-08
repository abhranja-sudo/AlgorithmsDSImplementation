package com.ar50645.binarysearch;

/**
 * eg: a = [4, 5, 6, 1, 2, 3]
 *
 * pivot: 3 (last element)
 * Group 1: element greater than pivot
 * Group 2: element smaller than ...
 *
 * for every mid-candidate, check if it belongs to which group, If it belongs to group 1, than move right
 * If it belongs to group 2, then move left.
 *
 * @Return Condition:  see below
 */
public class CyclicallySorted {

    public int getSmallestIndex(int[] a) {

        if(a == null)
            return -1;

        int low = 0, high = a.length - 1, pivot = a[high];

        while (low <= high) {
            int mid = (low + high) / 2;

            if(a[mid] <= pivot && (mid == 0 || a[mid - 1] > a[mid]))
                return a[mid];

            else if(a[mid] > pivot)
                low  = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

}
