package com.ar50645.subarray;

import com.ar50645.common.Pair;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

//    https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = nums[0];

        int minLength = Integer.MAX_VALUE;
        while(end < nums.length) {
            if(sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum-=nums[start];
                start++;
            }
            else if(sum < target) {
                end++;
                if(end < nums.length)
                    sum+=nums[end];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

//    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int result = 0;

        while(end < s.length()) {
            char temp = s.charAt(end);
            if(set.contains(temp)) {
                set.remove(s.charAt(start));
                start++;
                if(start > end) {
                    start = end;
                }
            }
            else {
                set.add(temp);
                result = Math.max(result, end - start + 1);
                end++;
            }

        }

        return result;
    }


}
