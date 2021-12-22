package com.ar50645.arraysandstring;

public class TraverseReverse {

    //(Level: Easy) Given an array of numbers, replace each even number with two of the same number.
    // e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8]. Assume that the array has enough space to accommodate the result.

    public static int[] cloneEvenNumber(int[] a) {

        if(a == null || a.length == 0)
            return a;

        int end = a.length;
        int i = findLastElement(a);

        while (i >=0 ) {

            if(a[i] % 2 == 0)
                a[--end] = a[i];

            a[--end] = a[i];
            i--;
        }
        return a;
    }

    private static int findLastElement(int[] a) {
        int i = a.length - 1;
        while (i >= 0 && a[i] == -1) {
            i--;
        }
        return i;
    }
}
