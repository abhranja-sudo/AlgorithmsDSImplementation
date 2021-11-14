package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;

/**
 * The idea is that when we do a binary search, we are moving closer to our target element.
 * If we find anode equal to the target, we record it in a variable. We then continue our search on the left,
 * because if there is another equal node that came earlier, it will be on the left
 */
public class RecordAndMoveOn {

    //Given a BST that can contain duplicate elements, find the first occurrence of a number N.
    public static Node findFirstOccurrence(Node root, int data) {

        Node current = root;
        Node result = null;

        while (current != null) {
            if(current.getValue() == data) {
                result = current;
                current = current.getLeft();
            } else if(data > current.getValue())
                current = current.getRight();
              else if(data < current.getValue())
                current = current.getLeft();
        }
        if(result == null)
            throw new RuntimeException("No data found");

        return result;
    }
}
