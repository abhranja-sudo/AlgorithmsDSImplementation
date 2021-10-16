package com.ar50645.dataStructure.binaryTree;

public class Node {
    Node left;
    Node right;
    int value;
    boolean isVisited;

    public Node(Node left, Node right, int value, boolean isVisited) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.isVisited = isVisited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
