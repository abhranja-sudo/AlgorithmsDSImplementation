package com.ar50645.dataStructure.linkedlist;

// You are given a Linked List with nodes that have values 0, 1 or 2.Sort the linked list.
// Return head and tail as a pair
public class SortLL {
    public static LinkedList sortLinkedList(LinkedList input){

        if(input == null){
            return null;
        }

        LinkedList list0 = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        Node current = input.getHead();
        while (current != null){
            switch (current.getData()){
                case 0:
                    list0.append(current);
                case 1:
                    list1.append(current);
                case 2:
                    list2.append(current);
                default:
                    throw new IllegalArgumentException("Invalid value " + current.getData());
            }
        }

        //set tails to null if not already
        if(list0.getTail() != null){
            list0.getTail().setNext(null);
        }
        if(list1.getTail() != null){
            list1.getTail().setNext(null);
        }
        if(list2.getTail() != null){
            list2.getTail().setNext(null);
        }

        //combine LL in sequence
        LinkedList result = new LinkedList();
        appendList(list0, result);
        appendList(list1, result);
        appendList(list2, result);

        return result;
    }

    private static void appendList(LinkedList toAppend, LinkedList original){
        if(original == null || toAppend == null){
            return;
        }
        original.append(toAppend.getHead());
        original.setTail(toAppend.getTail());
    }
}
