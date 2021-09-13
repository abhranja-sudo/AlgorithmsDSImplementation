package com.ar50645.dataStructure.linkedlist;

public class Cycle {

    // Find if a given Linked List has a cycle
    public static boolean hasCycle(Node head){
        Node fast = head, slow = head;

        while (fast != null){
            fast = fast.getNext();
            if(fast == slow){
                return true;
            }
            if(fast != null){
                fast = fast.getNext();
                if(fast == slow){
                    return true;
                }
            }
            slow = slow.getNext();
        }
        return false;
    }

}
