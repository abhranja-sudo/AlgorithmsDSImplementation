package com.ar50645.dataStructure.binaryTree;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    //PreOrder Visit
    public static void preOrderVisitRecursive(Node n) {
        if(n == null) {
            return;
        }
        System.out.println(n.getValue());
        preOrderVisitRecursive(n.getLeft());
        preOrderVisitRecursive(n.getRight());
    }

    //InOrder Visit
    public static void inOrderVisit(Node n) {
        if(n == null) {
            return;
        }
        inOrderVisit(n.getLeft());
        System.out.println(n.getValue());
        inOrderVisit(n.getRight());
    }

    //Iterative traversal for InOrder
    public static void inOrderVisitIterative(Node root) {
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.isVisited()){
                System.out.println(node.getValue());
                continue;
            }
            node.setVisited(true);
            if(root.getRight() != null) {
                stack.push(root.getRight());
            }
            stack.push(node);
            if(node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    //PostOrder Visit
    public static void postOrder(Node n) {
        if( n == null) {
            return;
        }
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.println(n.getValue());
    }

//    Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum
//    of all the node values of that path equals ‘S’

    public static boolean hasPath(TreeNode root, int sum) {
        // TODO: Write your code here
        return hasPathHelper(root, sum, 0);
    }

    private static boolean hasPathHelper(TreeNode node, int target, int sum) {
        if(node != null) {
            sum += node.val;

            if(target == sum && node.left == null && node.right == null)
                return true;

            return hasPathHelper(node.left, target, sum) || hasPathHelper(node.right, target, sum);

        }
        return false;
    }

    //Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of
    // each path equals ‘S’.
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsHelper(root, 0, targetSum, allPaths, new Stack<>());
        return allPaths;
    }

    private static List<List<Integer>> findPathsHelper(TreeNode node, int sum, int target,
                                                       List<List<Integer>> allPaths, Stack<Integer> stack) {

        if(node != null){
            sum += node.val;
            stack.push(node.val);
            if(sum == target && node.left == null && node.right == null) {
                allPaths.add(new ArrayList<>(stack));
                stack.pop();

                return allPaths;
            }
            else{
                findPathsHelper(node.left, sum, target, allPaths, stack);
                findPathsHelper(node.right, sum, target, allPaths, stack);

                stack.pop();

                return allPaths;
            }

        }
        return allPaths;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

}
