package com.home.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 * @see <a href = "https://leetcode.com/problems/count-complete-tree-nodes/" />
 * @author Poet
 * @date 2020/5/4
 */
public class CountCompleteTreeNodes_222 {

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
     * BFS
     */
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ret = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ret++;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return ret;
    }


    /**
     * 在LeetCode上Time Limited Exceeded
     * 这种方法可以处理普通二叉树，能够统计任意二叉树的节点数，但并没有利用到完全二叉树的特性。
     */
    public int countNodes4NormalRecursively(TreeNode root) {
        return root == null ? 0 : 1 + countNodes4NormalRecursively(root.left) + countNodes4NormalRecursively(root.right);
    }

    /**
     * 对完全二叉子树进行合并统计
     * @see <a href = "https://blog.csdn.net/jmspan/article/details/51056085" />
     */
    public int countNodes4Recursively(TreeNode root) {
        if(root == null ) return 0;

        int leftMost = 0;
        TreeNode left = root;
        while (left != null) {
            leftMost ++;
            left = left.left;
        }

        int rightMost = 0;
        TreeNode right = root;
        while (right != null) {
            rightMost ++;
            right = right.right;
        }

        if(leftMost == rightMost)
            return (1<<leftMost) - 1;
        else {
            return countNodes4Recursively(root.left) + countNodes4Recursively(root.right) + 1;
        }
    }


}
