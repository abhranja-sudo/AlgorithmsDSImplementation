package com.ar50645.dataStructure.queue;

//   Given an array A and an integer K, find the maximum element in each sliding window of size K.

import java.util.*;
import java.util.Queue;

public class MaximumOfSlidingWindow {

    public List<Integer> getMaxInEachSlidingWindow(int[] a, int windowSize) {

        List<Integer> result = new ArrayList<>();

        QueueWithMax queue = new QueueWithMax();

        for(int i = 0; i < a.length; i++) {
            if(queue.size() == windowSize)
                queue.dequeue();

            queue.enqueue(a[i]);
            if(queue.size() == windowSize)
                result.add(queue.max());

        }
        return result;
    }

    private class QueueWithMax {

        private Queue<Integer> main;
        private Deque<Integer> max;

        public QueueWithMax() {
            this.main = new LinkedList<>();
            this.max = new LinkedList<>();
        }

        public void enqueue(int element) {
            main.add(element);
            while (!max.isEmpty() && max.peekLast() < element) {
                max.removeLast();
            }
            max.add(element);
        }

        public int dequeue() {
            int element = main.remove();
            if(max.peek() == element) {
                max.remove();
            }
            return element;
        }

        public int max() {
            return max.peek();
        }

        public int size() {
            return main.size();
        }
    }
}
