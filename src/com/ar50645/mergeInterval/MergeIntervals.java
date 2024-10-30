package com.ar50645.mergeInterval;

import java.util.*;

public class MergeIntervals {

/**    Given an array of intervals where intervals[i] = [start i, end i], merge all overlapping intervals, and
    return an array of the non-overlapping intervals that cover all the intervals in the input.


 Overlap condition:
 startA ≤ endB AND startB ≤ endA both inclusive
 startA < endB AND startB < endA </>

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

//    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.\
//    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//    Return intervals after the insertion.
//    Note that you don't need to modify intervals in-place. You can make a new array and return it.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }

        // add the overlapping intervals
        int[] prev = newInterval;
        while(i < intervals.length && overlap(prev, intervals[i])) {
            prev = merge(prev, intervals[i]);
            i++;
        }

        result.add(prev);

        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][0]);
    }

        int[] merge(int[] a1, int[] a2) {
            int min = Math.min(a1[0], a2[0]);
            int max = Math.max(a1[1], a2[1]);

            return new int[]{min, max};
        }

        private boolean overlap(int[] a1, int[] a2) {
            return a1[0] <= a2[1] && a2[0] <= a1[1];
        }

}
