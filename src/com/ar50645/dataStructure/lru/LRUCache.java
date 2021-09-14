package com.ar50645.dataStructure.lru;

import com.ar50645.common.Pair;

import java.util.HashMap;

public class LRUCache<K, V> {

    //Map keys to nodes
    HashMap<K, Node<K, V>> map;

    //Linked List variables. We can also abstract doubly LL code into separate class
    Node<K, V> head;
    Node<K, V> tail;

    //Maximum nodes cache can hold
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    // Write a value to cache
    public void write(K key, V value) {
        if (map.size() == capacity) {
            remove(head.getKey());
        }

        add(key, value);
    }

    // Read a value from cache
    public V read(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }

        //Remove the key from linked hash table
        remove(key);

        //Add back to the front
        add(node.getKey(), node.getValue());

        return node.getValue();
    }

    // Add a node to the end of the Linked Hash Table
    private void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        appendToLinkedList(newNode);
        map.put(key, newNode);
    }

    private void appendToLinkedList(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
    }

    //Remove a node from Linked Hash Table
    private void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node<K, V> toRemove = map.get(key);
        removeFromLinkedList(toRemove);
        map.remove(key);
    }

    //Remove a Node from a doubly LL.
    private void removeFromLinkedList(Node<K, V> toRemove) {
        if (toRemove.getPrev() != null) {
            toRemove.getPrev().setNext(toRemove.getNext());
        }

        if (toRemove.getNext() != null) {
            toRemove.getNext().setPrev(toRemove.getPrev());
        }

        if (toRemove == head) {
            head = toRemove.getNext();
        }

        if (toRemove == tail) {
            tail = toRemove.getPrev();
        }
    }



}
