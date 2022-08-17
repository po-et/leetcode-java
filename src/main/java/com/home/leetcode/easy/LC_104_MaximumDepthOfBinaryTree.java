package com.home.leetcode.easy;

/**
 * 104. Maximum Depth of Binary Tree (二叉树的最大深度)
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_104_MaximumDepthOfBinaryTree {

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
     * 第一种递归写法（更好理解）
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;   // 不用声明局部变量
    }


    /**
     * 第二种递归写法
     */
    public int maxDepth_2(TreeNode root) {
        return calcDepth(root, 0);
    }

    public int calcDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = calcDepth(node.left, depth + 1);
        int rightDepth = calcDepth(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

}
