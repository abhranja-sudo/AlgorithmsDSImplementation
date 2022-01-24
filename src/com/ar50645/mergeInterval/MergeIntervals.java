package com.ar50645.mergeInterval;

import java.util.*;

public class MergeIntervals {

/**    Given an array of intervals where intervals[i] = [start i, end i], merge all overlapping intervals, and
    return an array of the non-overlapping intervals that cover all the intervals in the input.
 **/

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++ ) {
            if(intervals[i][0] <= end)
                end = Math.max(end, intervals[i][1]);
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[0][0]);
    }
}
