package com.ar50645.dataStructure.binaryTree;

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
}
