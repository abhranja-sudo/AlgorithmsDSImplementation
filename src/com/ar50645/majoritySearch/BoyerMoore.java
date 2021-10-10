package com.ar50645.majoritySearch;

/*
Boyer-Moore's Voting Algorithm  or  simply majority search.

You are given an array of numbers. Find a number that occurs more than half the time. Find the number.
 */

import java.util.Arrays;

public class BoyerMoore {
    public static Integer majorityFind(int[] a) {
        if(a == null || a.length == 0) {
            return null;
        }
        int candidate = a[0];
        int count = 1;

        for(int i = 1; i < a.length; i++) {
            if(a[i] == candidate)
                count++;
            else if(count > 0) {
                count--;
            }
            else {
                candidate = a[i];
                count = 1;
            }
        }

        //verify if the candidate is actually is a majority

        int finalCandidate = candidate;
        long countFinalCandidate = Arrays.stream(a)
                .filter(i -> i == finalCandidate)
                .count();
        return countFinalCandidate > a.length/2 ? finalCandidate : null;
    }
}
