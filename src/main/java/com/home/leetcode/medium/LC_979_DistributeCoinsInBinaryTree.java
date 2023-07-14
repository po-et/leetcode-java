package com.home.leetcode.medium;

/**
 * 979. Distribute Coins in Binary Tree
 *
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
 *
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 * Example 1:
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 *
 * Example 2:
 * Input: root = [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
 *
 * @see <a href="https://leetcode.cn/problems/distribute-coins-in-binary-tree/" />
 * @author Poet
 * @date 2023/7/14
 */
public class LC_979_DistributeCoinsInBinaryTree {

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

    // hard: 参考答案

    /**
     * DFS
     */
    int move = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int moveLeft = 0;
        int moveRight = 0;
        if (root.left != null) {
            moveLeft = dfs(root.left);
        }
        if (root.right != null) {
            moveRight = dfs(root.right);
        }
        move += Math.abs(moveLeft) + Math.abs(moveRight);
        return moveLeft + moveRight + root.val - 1;
    }

}
