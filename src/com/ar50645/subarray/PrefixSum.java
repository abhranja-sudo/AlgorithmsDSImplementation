package com.ar50645.subarray;

import com.ar50645.common.Pair;

import java.util.*;

public class PrefixSum {

    /**
     * Given an array of integers, find the contiguous subarray that sums to 0. The array can contain both negative and positive integers.
     */
    public Pair<Integer, Number> subArraySumZero(int[] a) {

        if(a == null || a.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        for(int i = 0; i < a.length; i++) {
            prefixSum+=a[i];
            if(prefixSum == 0)
                return new Pair<>(0, i);

            if(map.containsKey(prefixSum))
                return new Pair<>(map.get(prefixSum) + 1, i);

            map.put(prefixSum, i);
        }

        return null;
    }

    /**
     * Given an array of integers, both -ve and +ve, find a contiguous subarray that sums to a number X
     */

    public Pair<Integer, Number> subArraySum(int[] a, int target) {
        if(a == null || a.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i = 0; i < a.length; i++) {
            sum += a[i];

            if(sum == target)
                return new Pair(0, i);

            if(map.containsKey(sum - target))
                return new Pair(map.get(sum - target) + 1, i);

            map.put(sum, i);
        }

        return null;
    }
}
