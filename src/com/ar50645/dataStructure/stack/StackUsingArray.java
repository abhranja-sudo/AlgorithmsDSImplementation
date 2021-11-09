package com.ar50645.dataStructure.stack;

/**
 * Use an array to implement 2 stacks.
 */
public class StackUsingArray {

    int[] a;
    int s1;
    int s2;

    public StackUsingArray(int arraySize) {
        a = new int[arraySize];
        s1 = 0;
        s2 = arraySize - 1;
    }

    public void push(int stackNumber, int item) {
        if(stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid Stack number");
        }
        if(s1 > s2)
            throw new RuntimeException("Stack overflow");

        if(stackNumber == 1) {
            a[s1++] = item;
        } else {
            a[s2--] = item;
        }
    }

    public int pop(int stackNumber) {
        if(stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid Stack number");
        }

        if(stackNumber == 1  && s1 > 0) {
            return a[--s1];
        } else if(stackNumber == 2  && s2 < a.length - 1) {
            return a[++s2];
        }

        throw new RuntimeException("Stack underflow");
    }
}
