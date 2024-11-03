package com.ar50645.dataStructure.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class Reconstruction {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node construct(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> inOrderMap = getInorderMap(inOrder);
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inOrderMap);
    }

    // Recursive helper method
    public Node construct(int[] preOrder, int preStart, int preEnd, int[] inOrder,
                          int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        // Base case
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Create root node
        int rootValue = preOrder[preStart];
        Node root = new Node(rootValue);

        // Find root index in inorder traversal
        int k = inOrderMap.get(rootValue);

        // Number of nodes in the left subtree
        int leftTreeSize = k - inStart;

        // Recursively construct the left and right subtrees
        root.left = construct(preOrder, preStart + 1, preStart + leftTreeSize, inOrder, inStart, k - 1, inOrderMap);
        root.right = construct(preOrder, preStart + leftTreeSize + 1, preEnd, inOrder, k + 1, inEnd, inOrderMap);

        return root;
    }

    // Utility method to create a map for inorder indices
    public Map<Integer, Integer> getInorderMap(int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return map;
    }
}
