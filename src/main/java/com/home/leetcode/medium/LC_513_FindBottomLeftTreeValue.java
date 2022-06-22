package com.home.leetcode.medium;

/**
 * 513. Find Bottom Left Tree Value
 *
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: 1
 *
 * Example 2:
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 * @see <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/" />
 * @author Poet
 * @date 2022/6/22
 */
public class LC_513_FindBottomLeftTreeValue {

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
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}
