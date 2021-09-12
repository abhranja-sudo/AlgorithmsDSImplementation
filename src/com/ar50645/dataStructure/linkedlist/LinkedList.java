package com.ar50645.dataStructure.linkedlist;

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void append(Node toAdd){
        if(head == null){
            head = toAdd;
        }
        else {
            tail.setNext(toAdd);
        }
        tail = toAdd;
    }

    /**
     * Get the nth element in the list
     * 1 - based index i.e the first element is in 1st index
     */
    public Node get(int n){
        Node node = getHead();
        for(int i = 0; i < n - 1; i++){
            if(node == null){
                throw new IndexOutOfBoundsException("no node at index "+ n);
            }
            node = node.getNext();
        }
        if(node == null){
            throw new IndexOutOfBoundsException("no node at index "+ n);
        }
        return node;
    }
}
