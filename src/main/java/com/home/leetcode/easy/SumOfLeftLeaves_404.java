package com.home.leetcode.easy;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @see <a href = "https://leetcode.com/problems/sum-of-left-leaves/" />
 * @author Poet
 * @date 2020/5/4
 */
public class SumOfLeftLeaves_404 {

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
     * 递归
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 根节点不是左叶子节点
        if(root == null)
            return 0;

        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        return sum;
    }

    /**
     * 迭代
     */
    public int sumOfLeftLeavesIteratively(TreeNode root) {
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                if(node.left.left == null && node.left.right == null)
                    sum += node.left.val;
                else
                    stack.push(node.left);
            }

            if (node.right != null) {
                if(node.right.left == null && node.right.right == null)
                    continue;
                else
                    stack.push(node.right);
            }
        }
        return sum;
    }



    @Deprecated
    private boolean isLeaf(TreeNode node){
        if(node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
