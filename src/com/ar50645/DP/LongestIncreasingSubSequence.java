package com.ar50645.DP;

//Given an array of integers, find the length of the longest increasing subsequence.
//        For e.g, in [1, 3, 2, 5, 3, 5, 6], the longest increasing subsequence is [1, 2, 3, 5, 6] of length 5.
public class LongestIncreasingSubSequence {

    public static int calculateLongestIncreasingSubSequence(int[] a) {
        if(a == null || a.length == 0)
            return 0;

        int[] longest = new int[a.length];

        //check for all the element that is smaller than the current element if including them will increase the
        // current longest Increasing subsequence,
        int result = 1;
        for(int i = 1; i < a.length; i++) {

            // longest Increasing subsequence atLeast will be one
            longest[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    longest[i] = Math.max(longest[j] + 1, longest[i]);
                }
            }
            result = Math.max(result, longest[i]);
        }
        return result;
    }

}
