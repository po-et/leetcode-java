package com.home.leetcode.medium;

/**
 * 437. Path Sum III （路径总和）
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *      1.  5 -> 3
 *      2.  5 -> 2 -> 1
 *      3. -3 -> 11
 *
 * @see <a href="https://leetcode.cn/problems/path-sum-iii/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_437_PathSum_III {

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
     * time:  O(n^2)
     * space: O(n)
     */
    // 在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        // 当前包含root节点
        int res = findPath(root, sum);
        // 当前不包含root节点
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    // 在以node为根节点的二叉树中，寻找包含node的路径，和为num，返回这样的路径个数
    private int findPath(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

}
