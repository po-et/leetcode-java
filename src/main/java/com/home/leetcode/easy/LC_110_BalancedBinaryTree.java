package com.home.leetcode.easy;

/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * @see <a href = "https://leetcode.cn/problems/balanced-binary-tree/ " />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_110_BalancedBinaryTree {

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
     * 递归写法
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getMaxDepth(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }

}
