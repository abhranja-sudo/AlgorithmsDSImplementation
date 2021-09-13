package com.ar50645.dataStructure.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
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
     * 1 - based index ie the first element is in 1st index
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

    public void deleteWithoutPrev(Node n){
        Node next = n.getNext();
        if(head == null){
            return; //cannot delete
        }

        n.setData(next.getData());
        delete(n, next);
    }

    public void delete(Node n, Node prev){

        if(n == null){
            return;
        }

        if(n == head){
            head = head.getNext();
        }
        else if(n == tail){
            tail = prev;
        }

        if(prev != null){
            prev.setNext(n.getNext());
        }
    }
}
