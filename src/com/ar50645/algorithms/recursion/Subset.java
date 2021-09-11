package com.ar50645.algorithms.recursion;

import java.util.Arrays;

//Given an array of integers A, print all its subsets.
public class Subset {

    public static void main(String[] args) {
        printSubset(new int[]{0,1,2,3});
    }
    public static void printSubset(int[] a){
        if( a == null || a.length == 0){
            return;
        }
        int[] buffer = new int[a.length];
        printSubset(a, buffer, 0, 0);
    }

    private static void printSubset(int[] a, int[] buffer, int startIndex, int bufferIndex) {

        printBuffer(buffer, bufferIndex);

        //termination case
        if(startIndex == a.length){
            return;
        }

        //find candidates for current buffer index
        for(int i = startIndex; i < a.length; i++){
            buffer[bufferIndex] = a[i];
            printSubset(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    private static void printBuffer(int[] buffer, int index){
        System.out.println(Arrays.toString(Arrays.copyOf(buffer, index)));
    }
}
