package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;
import com.ar50645.dataStructure.linkedlist.LinkedList;

public class Reconstruction {

    /**
     * @param a is sorted array
     * @return a valid balanced BST
     */
    public static Node getBST(int[] a) {
        return buildBST(a,0, a.length - 1);
    }

    private static Node buildBST(int[] a, int start, int end) {
        if(end < start || isOOB(a, start) || isOOB(a, end))
            return null;

        int mid = start + (end - start) / 2;
        Node root = new Node(a[mid]);
        root.setLeft(buildBST(a, start, mid - 1));
        root.setRight(buildBST(a, mid + 1, end));
        return root;
    }

    private static boolean isOOB(int[] a, int i) {
        return i < 0 || i >= a.length;
    }

    public static Node getBST(com.ar50645.dataStructure.linkedlist.Node head, com.ar50645.dataStructure.linkedlist.Node tail) {
        if(head == null || tail == null)
            return null;
        MedianPair mid = findMedian(head, tail);
        Node root = new Node(mid.median.getData());
        root.setLeft(getBST(head, mid.previous));
        root.setRight(getBST(mid.median.getNext(), tail));
        return root;
    }

    private static MedianPair findMedian(com.ar50645.dataStructure.linkedlist.Node head, com.ar50645.dataStructure.linkedlist.Node tail) {
        if(head == null || tail == null)
            return null;

        com.ar50645.dataStructure.linkedlist.Node fast = head;
        com.ar50645.dataStructure.linkedlist.Node slow = head;
        com.ar50645.dataStructure.linkedlist.Node prev = null;

        while (fast != tail) {
            fast = fast.getNext();
            if(fast != tail) {
                fast = fast.getNext();
                prev = fast;
                slow = slow.getNext();
            }
        }
        return new MedianPair(slow, prev);
    }

    private static class MedianPair {
        com.ar50645.dataStructure.linkedlist.Node median;
        com.ar50645.dataStructure.linkedlist.Node previous;

        public MedianPair(com.ar50645.dataStructure.linkedlist.Node median, com.ar50645.dataStructure.linkedlist.Node previous) {
            this.median = median;
            this.previous = previous;
        }
    }
}