package com.ar50645.dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowSum {

    //  Given an array of integers A, find the sum of each sliding window of size K.
    public static void slidingWindowSum(int[] a, int k) {
        if(a == null || k == 0 || a.length == 0)
            return;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;

        for(int i = 0; i < a.length; i++) {
            if(queue.size() == k) {
                int last = queue.remove();
                sum -= last;
            }
            queue.add(a[i]);
            sum += a[i];
        }
        if(queue.size() == k) {
            System.out.println(sum);
        }
    }
}
