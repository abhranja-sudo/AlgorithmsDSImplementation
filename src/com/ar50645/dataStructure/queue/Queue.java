package com.ar50645.dataStructure.queue;

/**
 * Implement a Queue using an array.
 */
public class Queue {
    int[] a;

    int front;
    int back;
    int length;

    public Queue(int capacity) {
        a = new int[capacity];
        front = 0;
        back = 0;
        length = 0;
    }

    public void add(int item) {
        if(length == a.length)
            throw new RuntimeException("Queue overflow error");
        a[back] = item;
        back = (back + 1) % a.length;
        length++;
    }

    public int remove() {
        if(length == 0)
            throw new RuntimeException("Queue empty");
        int res = a[front];
        front = (front + 1) % a.length;
        length--;
        return res;
    }
}
