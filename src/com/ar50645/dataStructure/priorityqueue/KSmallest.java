package com.ar50645.dataStructure.priorityqueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KSmallest {

    public void printKSmallest(int[] a, int k) {

        if(k > a.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
            pq.add(a[i]);
        }

        for(int i = k; i < a.length; i++) {
            if(pq.peek() > a[i]) {
                pq.remove();
                pq.add(a[i]);
            }
        }

        //print it
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
