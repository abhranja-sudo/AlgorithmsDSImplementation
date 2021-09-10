package com.ar50645.algorithms.recursion;

//Given an array of integers, print all combinations of size X.

import java.util.Arrays;

public class Combination {
    public static void printCombination(int[] a, int x){
        if(a == null || a.length == 0){
            return;
        }
        int[] buffer = new int[x];
        printCombinationHelper(a, buffer, 0, 0);
    }

    private static void printCombinationHelper(int[] a , int[] buffer, int startIndex, int bufferIndex) {

        //termination case - buffer full
        if(bufferIndex == buffer.length){
            printArray(buffer);
            return;
        }
        if(startIndex == a.length){
            return;
        }

        //find candidates to go into the current buffer index
        for(int i = startIndex; i < a.length; i++){
            //place item into the buffer
            buffer[bufferIndex] = a[i];
            //recurse to the new buffer
            printCombinationHelper(a, buffer, startIndex + 1, bufferIndex + 1);
        }
    }

    private static void printArray(int[] buffer) {
        System.out.println(Arrays.toString(buffer));
    }


}
