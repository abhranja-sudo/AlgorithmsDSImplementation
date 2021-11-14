package com.ar50645.dataStructure.binaryTree;

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


    // Find the Diameter of a Binary Tree. The Diameter is the longest path from any 2 nodes in the tree.
    public static int diameter(Node root) {
        return diameterHelper(root).longestPath;
    }

    public static Result diameterHelper(Node root) {
        if(root == null) {
            return new Result(-1, 0);
        }

        Result leftResult = diameterHelper(root.left);
        if(leftResult == null) {
            leftResult = new Result(0, 0);
        }

        Result rightResult = diameterHelper(root.right);
        if(rightResult == null) {
            rightResult = new Result(0, 0);
        }

        int height = 1 + Math.max(leftResult.height, rightResult.height);

        int longestPath = Math.max(Math.max(leftResult.longestPath, rightResult.longestPath),
                leftResult.height + rightResult.height + 1);
        return new Result(height, longestPath);

    }

    public static class Result {
        int height;
        int longestPath;

        public Result(int height, int longestPath) {
            this.height = height;
            this.longestPath = longestPath;
        }
    }

}