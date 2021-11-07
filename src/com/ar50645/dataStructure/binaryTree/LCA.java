package com.ar50645.dataStructure.binaryTree;

public class LCA {

    /**
     * Given 2 nodes of a tree, find their lowest common ancestor (LCA). Assume that each node has a parent pointer.
     */

    public static Node findLCA(Node a , Node b) {
        if(a == null || b == null) {
            return null;
        }
        Node aPointer = a, bPointer = b;

        //get aDepth
        int aDepth = -1;
        while (aPointer != null) {
            aDepth++;
            aPointer = aPointer.getParent();
        }

        //get bDepth
        int bDepth = -1;
        while (bPointer != null) {
            bDepth++;
            bPointer = bPointer.getParent();
        }

        //Raise the lower node
        Node x = aDepth > bDepth ? a : b;
        for(int i = 0; i < Math.abs(aDepth - bDepth); i++) {
            x = x.getParent();
        }

        //Raise both node until they meet at LCA
        Node y = aDepth > bDepth ? b: a;
        while (x != y) {
            x = x.getParent();
            y = y.getParent();
        }

        return x;
    }

    //If you don't have a parent pointer available
    public static Node findLCAWithoutParent(Node root, final Node a, final Node b) {

        if(root == null)
            return null;

        if(root == a || root == b)
            return root;

        Node left = findLCAWithoutParent(root.left, a, b);
        Node right = findLCAWithoutParent(root.right, a, b);

        if(left != null && right != null)
            return root;

        return left == null ? right : left;
    }


    private class Node {
        Node left;
        Node right;
        Node parent;
        int value;
        boolean isVisited;

        public Node(Node left, Node right, int value, boolean isVisited) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.isVisited = isVisited;
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

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }
    }
}
