package com.ar50645.subarray;

import com.ar50645.common.Pair;

public class Kadane {
    /**
     * Given an array of integers that can be both +ve and -ve, find the contiguous subarray with the largest sum.
     */
    public int subArrayMaxSum(int[] a) {

        int max = a[0];

        int maxEndingHere = a[0];

        for(int i = 1; i < a.length; i++) {
            maxEndingHere = Integer.max(a[i], a[i] + maxEndingHere);
            max = Integer.max(maxEndingHere, max);
        }
        return max;
    }
}
