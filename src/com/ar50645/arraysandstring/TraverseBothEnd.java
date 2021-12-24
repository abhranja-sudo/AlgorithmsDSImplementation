package com.ar50645.arraysandstring;

public class TraverseBothEnd {
    /**
     * Reverse the order of elements in an array. For example, A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
     */
    public int[] reverse(int[] a) {

        if(a == null)
            return null;

        int start = 0;
        int end = a.length - 1;

        while (end > start) {
            swap(a, start, end);
            start++;
            end--;
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
