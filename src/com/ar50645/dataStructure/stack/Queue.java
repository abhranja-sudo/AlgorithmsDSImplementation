package com.ar50645.dataStructure.stack;

import java.util.Stack;

/**
 * Implement a Queue using stack
 */
public class Queue<E> {

    /**
     * we can use two stack to implement queue. we can enqueue using direct push to s1. for dequeue, need to flush s1 to s2.
     * time complexity: enqueue = O(1) and for dequeue O(n), but O(1) amortized time.
     *
     * We can reverse the implementation if we need to dequeue in O(1) instead of enqueue
     */
    Stack<E> s1;
    Stack<E> s2;

    public Queue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(E e) {
        s1.push(e);
    }

    public E dequeue() {

        if(s2.isEmpty())
            flushToS2();

        if(s2.isEmpty())
            throw new RuntimeException("Queue is empty");

        return s2.pop();
    }

    private void flushToS2() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }
}
