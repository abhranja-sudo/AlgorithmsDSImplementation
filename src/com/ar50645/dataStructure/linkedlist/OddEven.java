package com.ar50645.dataStructure.linkedlist;

import com.ar50645.common.Pair;

//OddEvenLinkedList: Given a LinkedList L, separate it into 2 LinkedLists.
// One contains L's odd nodes and the other contains L's even nodes.
public class OddEven {
    public static Pair<LinkedList> getOddEvenList(LinkedList input) {

        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();

        int index = 1;
        Node currentNode = input.getHead();

        while (currentNode != null) {
            LinkedList destination = index % 2 == 0 ? even : odd;
            destination.append(currentNode);
            currentNode = currentNode.getNext();
            index++;
        }

        even.getTail().setNext(null);
        odd.getTail().setNext(null);

        return new Pair<>(odd, even);
    }
}
