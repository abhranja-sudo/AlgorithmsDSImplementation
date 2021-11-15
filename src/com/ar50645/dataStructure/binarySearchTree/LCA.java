package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;

public class LCA {

    public static Node findLCA(Node root, Node a, Node b) {

        Node current = root;
        while (current != null) {
            if(root.getValue() > a.getValue() && root.getValue() > b.getValue())
                current = current.getLeft();
            else if(root.getValue() < a.getValue() && root.getValue() < b.getValue())
                current = current.getRight();
            else
                return current;
        }
        return null;
    }

}
