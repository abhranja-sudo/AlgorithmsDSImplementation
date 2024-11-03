package com.ar50645.dataStructure.binaryTree;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        buildIndex(inOrder);
        return helper(preOrder, 0, preOrder.length - 1);
    }

    private TreeNode helper(int[] preOrder, int i, int j) {
        if(preOrderIndex >= preOrder.length || i > j) {
            return null;
        }
        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);

        root.left = helper(preOrder, i, index - 1);
        root.right = helper(preOrder, index + 1, j);

        return root;
    }

    private void buildIndex(int[] preOrder) {
        for(int i = 0; i < preOrder.length; i++) {
            map.put(preOrder[i], i);
        }
    }
}