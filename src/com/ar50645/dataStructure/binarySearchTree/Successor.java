package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;

public class Successor {

    /**
     *   Given a Node N in a BST, find the node with the next largest value, also known as the successor of the node.
     */

    public static Node findSuccessor(Node root, Node n) {
        if(root == null)
            return null;

        if(root.getRight() != null)
            return getLeftMostNodeFromRight(n);

        return getFirstRightParentNode(root, n);
    }

    private static Node getFirstRightParentNode(Node root, Node n) {
        Node current = root;
        Node result = null;

        while (current != null) {
            if(n.getValue() < current.getValue()) {
                result = current;
                current = current.getLeft();
            }
            else if(n.getValue() > current.getValue())
                current = current.getRight();

            else
                break;
        }
        return result;
    }

    private static Node getLeftMostNodeFromRight(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
