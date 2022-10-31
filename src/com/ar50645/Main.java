package com.ar50645;

import java.util.*;

class Solution {
    public long maxPoints(int[][] points) {
        return helper(points, 0, 0, 0);
    }

    private int helper(int[][] points, int row, int columnSelected, int val) {

        int max = 0;

        if(row == points.length - 1) {
            for(int i = 0; i < points[0].length; i++) {
                Math.max(max, val + points[row][i] - Math.abs(columnSelected - i));
            }
            return max;
        }

        for(int i = 0; i < points[0].length; i++) {
            if(row == 0)
                max = Math.max(max, helper(points, row + 1, i, val + points[row][i]));
            else
                max = Math.max(max, helper(points, row + 1, i, val + points[row][i] - Math.abs(columnSelected - i)));
        }

        return max;
    }
    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(start,end);
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[2][1];
        arr[0] = new int[]{1};
        arr[1] = new int[]{2};
        System.out.println(s.maxPoints(arr));


        //[[0,1,1],[1,1,1],[1,0,0]]
        //1
    }
}

