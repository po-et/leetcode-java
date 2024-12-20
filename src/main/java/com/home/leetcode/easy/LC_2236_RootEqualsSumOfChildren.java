package com.home.leetcode.easy;

/**
 * 2236. Root Equals Sum of Children
 *
 * You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
 *
 * Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
 *
 * Example 1:
 * Input: root = [10,4,6]
 * Output: true
 * Explanation: The values of the root, its left child, and its right child are 10, 4, and 6, respectively.
 * 10 is equal to 4 + 6, so we return true.
 *
 * Example 2:
 * Input: root = [5,3,1]
 * Output: false
 * Explanation: The values of the root, its left child, and its right child are 5, 3, and 1, respectively.
 * 5 is not equal to 3 + 1, so we return false.
 *
 * @see <a href="https://leetcode.cn/problems/root-equals-sum-of-children/description/" />
 * @author Poet
 * @date 2023/8/20
 */
public class LC_2236_RootEqualsSumOfChildren {

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

    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        return root.val == root.left.val + root.right.val;
    }
}
