package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-right-side-view/" />
 * @author Poet
 * @date 2020/5/3
 */
public class BinaryTreeRightSideView_199 {

    // Definition for a binary tree node.
    public class TreeNode {
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

    /**
     * 思路1： BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> respList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (i == size - 1) {
                    respList.add(treeNode.val);
                }

                if(treeNode.left!=null) queue.offer(treeNode.left);
                if(treeNode.right!=null) queue.offer(treeNode.right);
            }
        }

        return respList;
    }

    /**
     * 思路2: DFS， preorder改一下顺序
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        preOrder(root, 0, retList);
        return retList;
    }

    public void preOrder(TreeNode node, int level, List<Integer> retList) {
        if(node == null) return;
        if (retList.size() == level) {
            retList.add(node.val);
        }
        preOrder(node.right, level + 1, retList);
        preOrder(node.left, level + 1, retList);
    }

}
