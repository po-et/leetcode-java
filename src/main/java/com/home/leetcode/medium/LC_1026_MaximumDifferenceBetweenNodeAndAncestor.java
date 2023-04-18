package com.home.leetcode.medium;

/**
 * 1026. Maximum Difference Between Node and Ancestor (节点与其祖先之间的最大差值)
 *
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 * Example 1:
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 *
 * Example 2:
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/" />
 * @author Poet
 * @date 2023/4/18
 */
public class LC_1026_MaximumDifferenceBetweenNodeAndAncestor {

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
     * 方法一：深度优先搜索
     *
     * time:  O(N)
     * space: O(N)
     */
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }

        int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, dfs(root.left, min, max));
        diff = Math.max(diff, dfs(root.right, min, max));
        return diff;
    }

}
