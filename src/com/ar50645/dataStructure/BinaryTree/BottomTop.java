package com.ar50645.dataStructure.BinaryTree;

public class BottomTop {

    //Find the height of the Binary Tree. The solution requires to ask its children for their height
    public static int height(Node n) {
        if( n == null) {
            return -1;
        }
        return Math.max(height(n.getRight()), height(n.getLeft())) + 1;
    }

    //Find if the tree is balanced
    public static boolean isBalanced(Node root) {
        return isBalancedHelper(root) != -1;
    }

    public static int isBalancedHelper(Node root) {
        if(root == null)
            //We are denoting 0 for leaf node and -1 for non-balanced tree
            return 0;

        int leftHeight = isBalancedHelper(root.getLeft());
        int rightHeight = isBalancedHelper(root.getRight());

        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
