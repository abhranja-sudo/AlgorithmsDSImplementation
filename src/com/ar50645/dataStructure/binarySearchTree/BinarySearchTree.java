package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;

public class BinarySearchTree {
    Node root;

    public void addNode(int value) {
        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            current = value > current.getValue() ? current.getRight() : current.getLeft();

        }
        if(parent == null)
            root = new Node(value);
        else {
            if(value > parent.getValue())
                parent.setRight(new Node(value));
            else
                parent.setLeft(new Node(value));
        }
    }

    public boolean search(int target) {
        Node current = root;

        while (current != null) {
            if(current.getValue() == target)
                return true;
            current = (target > current.getValue()) ? current.getRight() : current.getLeft();
        }

        return false;
    }

    public void deleteNode(Node node, Node parent) {
        if(node.getRight() == null && node.getLeft() == null)
            replaceChild(parent, node, null);

        else if(node.getLeft() == null)
            replaceChild(parent, node, node.getRight());

        else if(node.getRight() == null)
            replaceChild(parent, node, node.getLeft());

        //Node have both the child, find the next successor which is leftmost child and replace it
        else {
            Node successor = node.getRight();
            Node successorParent = node;

            while (successor.getLeft() != null){
                successorParent = successor;
                successor = successor.getLeft();
            }

            node.setValue(successor.getValue());
            deleteNode(successor, successorParent);
        }
    }


    public void replaceChild(Node parent, Node oldChild, Node newChild) {
        if(parent == null) //root node
            root = newChild;
        else if(parent.getLeft() == oldChild)
            parent.setLeft(newChild);
        else if (parent.getRight() == oldChild)
            parent.setRight(newChild);
        else
            throw new IllegalArgumentException("Invalid Parent-Child ");
    }
}
