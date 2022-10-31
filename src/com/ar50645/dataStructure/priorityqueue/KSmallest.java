package com.ar50645.dataStructure.priorityqueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KSmallest {

    public void printKSmallest(int[] a, int k) {

        if(k > a.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
            pq.add(a[i]);
        }

        for(int i = k; i < a.length; i++) {
            if(pq.peek() > a[i]) {
                pq.remove();
                pq.add(a[i]);
            }
        }

        //print it
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    //Kth Largest or Kth Smallest number through quickSelect
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            return quickSelect(nums, 0, nums.length - 1, k);
        }


        private int quickSelect(int[] nums, int start, int end, int k) {
            int pivotLocation = getPivotLocation(nums, start, end);
            if(pivotLocation == k){
                return nums[pivotLocation];
            }
            if(pivotLocation < k) {
                return quickSelect(nums, pivotLocation + 1, end, k);
            } else
                return quickSelect(nums, start, pivotLocation - 1, k);
        }


        private int getPivotLocation(int[] nums, int start, int end) {
            int pivot = nums[end];

            int startPointer = start;

            int i = start;
            while(i < end) {
                if(nums[i] > pivot) {
                    i++;
                }
                else{
                    swap(nums, i, startPointer);
                    startPointer++;
                    i++;
                }
            }
            swap(nums, startPointer, end);
            return startPointer;

            // [3,2,1,5,6,4] pivot 4;
            // [3,2,1,4,6,5]
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
