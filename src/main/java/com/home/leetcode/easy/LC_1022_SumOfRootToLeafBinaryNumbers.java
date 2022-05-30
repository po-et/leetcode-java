package com.home.leetcode.easy;


/**
 * 1022. Sum of Root To Leaf Binary Numbers
 *
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 *
 * Example 1:
 *
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * @see <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/" />
 * @author bin.yang
 * @date 2022/5/30
 */
public class LC_1022_SumOfRootToLeafBinaryNumbers {

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

    private int res = 0;

    /**
     * 递归
     * @see <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/solution/by-fuxuemingzhu-mtsp/" />
     */
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int preSum) {
        if (root == null) {
            return;
        }

        preSum = preSum * 2 + root.val;

        if (root.left == null && root.right == null) {
            res += preSum;
        }

        dfs(root.left, preSum);
        dfs(root.right, preSum);
    }

}
