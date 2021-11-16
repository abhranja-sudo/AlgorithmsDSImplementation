package com.ar50645.dataStructure.binarySearchTree;

import com.ar50645.dataStructure.binaryTree.Node;

/**
 *   Is BST: Given a Binary Tree, determine if it is a Binary Search Tree (BST).
 */
public class VerifyBST {

    public static MinMaxPair isBST(Node root) {
        if(root == null)
            return new MinMaxPair(Integer.MAX_VALUE, Integer.MIN_VALUE);

        MinMaxPair left = isBST(root.getLeft());
        MinMaxPair right = isBST(root.getRight());

        if(left == null || right == null)
            return null;
        if(left.max > root.getValue() || right.min < root.getValue())
            return null;

        int min = root.getLeft() == null ? root.getValue() : left.min;
        int max = root.getRight() == null ? root.getValue() : right.max;

        return new MinMaxPair(min, max);
    }

    private static class MinMaxPair{
        int min;
        int max;

        public MinMaxPair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
