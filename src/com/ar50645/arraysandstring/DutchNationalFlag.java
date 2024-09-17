package com.ar50645.arraysandstring;

/*
https://leetcode.com/problems/sort-colors/description/
 */

public class DutchNationalFlag {
    class Solution {
        public void sortColors(int[] nums) {
            shiftLeft(nums);
            shiftRight(nums);
        }

        void shiftLeft(int[] nums) {
            int startPointer = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    swap(nums, i, startPointer);
                    startPointer++;
                }
            }
        }

        void shiftRight(int [] nums) {
            int endPointer = nums.length - 1;
            for(int i = nums.length - 1; i >= 0; i--) {
                if(nums[i] == 2) {
                    swap(nums, i, endPointer);
                    endPointer--;
                }
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
