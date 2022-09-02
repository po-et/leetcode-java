package com.home.leetcode.medium;

/**
 * 687. Longest Univalue Path (最长同值路径)
 *
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 * Input: root = [5,4,5,1,1,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value (i.e. 5).
 *
 * Example 2:
 * Input: root = [1,4,5,4,4,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value (i.e. 4).
 *
 * @see <a href="https://leetcode.cn/problems/longest-univalue-path/" />
 * @author Poet
 * @date 2022/9/2
 */
public class LC_687_LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 方法一：深度优先搜索
     */
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int left1 = 0;
        if (root.left != null && root.val == root.left.val) {
            left1 = 1 + left;
        }

        int right = dfs(root.right);
        int right1 = 0;
        if (root.right != null && root.val == root.right.val) {
            right1 = 1 + right;
        }

        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }

}
