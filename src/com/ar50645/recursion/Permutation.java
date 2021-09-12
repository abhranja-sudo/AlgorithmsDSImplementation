package com.ar50645.recursion;

import java.util.Arrays;

//Given an array A, print all permutations of size X.
public class Permutation {
    public static void main(String[] args) {
        printPermutation(new int[]{0,1,2,3,4}, 3);
    }
    public static void printPermutation(int[] a, int x){
        if(a == null || a.length == 0 || x > a.length){
            return;
        }
        int[] buffer = new int[x];
        boolean[] visiting = new boolean[a.length];
        printPermutation(a, buffer, 0, visiting);
    }

    private static void printPermutation(int[] a, int[] buffer, int bufferIndex, boolean[] visiting) {

        //termination case
        if(buffer.length == bufferIndex){
            System.out.println(Arrays.toString(buffer));
            return;
        }

        //find candidate for the buffer
        for(int i = 0; i < a.length; i++){
            if(!visiting[i]){
                buffer[bufferIndex] = a[i];
                visiting[i] = true;
                printPermutation(a, buffer, bufferIndex + 1, visiting);
                visiting[i] = false;
            }
        }

    }



}
