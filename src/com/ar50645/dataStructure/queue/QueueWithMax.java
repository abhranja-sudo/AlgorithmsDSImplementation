package com.ar50645.dataStructure.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax {

    private Queue<Integer> main;
    private Deque<Integer> max;

    public QueueWithMax() {
        main = new LinkedList<>();
        max = new LinkedList<>();
    }

    public void enqueue(int item) {
        main.add(item);

        while (!max.isEmpty() || max.getLast() < item)
            max.removeLast();

        max.add(item);
    }

    public int dequeue() {
        if(main.isEmpty())
            throw new RuntimeException("Queue is empty");

        int itemRemoved = main.remove();
        if(max.peek() == itemRemoved) {
            max.remove();
        }
        return itemRemoved;
    }

    public int findMax() {
        if(max.isEmpty())
            throw new RuntimeException("Empty Queue");
        return max.peek();
    }
}
