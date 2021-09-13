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

    //    Given a linked list that has a cycle, find the length of the cycle. The length is in number of nodes
    public static int findCycleLength(Node head){
        Node fast = head, slow = head;
        while (fast != null) {
            fast = fast.getNext();
            if(fast == slow){
                break;
            }
            if(fast != null){
                fast = fast.getNext();
                if(fast == slow){
                    break;
                }
            }
            slow = slow.getNext();
        }

        if(fast == null){  // no cycle found
            return -1;
        }

        fast = fast.getNext();
        int nodesPassed = 1;

        while (fast != slow){
            fast = fast.getNext();
            nodesPassed++;
        }
        return nodesPassed;
    }

    //Given a Linked List with a cycle, find the node where the cycle begins.
    public static Node findCycleStart(Node head){

        //find the length of loop
        Node fast = head, slow = head;
        while (fast != null){
            fast = fast.getNext();
            if(fast == slow){
                break;
            }
            if(fast != null) {
                fast = fast.getNext();
                if(fast == slow) {
                    break;
                }
            }
            slow = slow.getNext();
        }

        // not a cycle
        if(fast == null){
            return null;
        }

        // Calculate total length of the cycle
        fast = fast.getNext();
        int nodesPassed = 1;

        while (fast != slow){
            fast = fast.getNext();
            nodesPassed++;
        }

        //find start of the cycle
        fast = head;
        slow = head;
        for(int i = 0; i < nodesPassed; i++){
            fast = fast.getNext();
        }

        while (fast != slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return fast;
    }

}
