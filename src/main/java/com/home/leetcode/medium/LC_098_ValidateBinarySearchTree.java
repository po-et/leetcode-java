package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree (验证二叉搜索树)
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_098_ValidateBinarySearchTree {

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
     * 方法一: 递归
     *
     * 利用本身的性质: 即 左<根<右
     * 初始化时带入系统最大值和最小值，在递归过程中换成它们自己的节点值，用long代替int是为了包括int的边界条件
     *
     * time:  O(n)，其中 n 为二叉树的节点个数
     * space: O(n)，其中 n 为二叉树的节点个数
     */
    public boolean isValidBST(TreeNode root) {
        // 函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }


    /**
     * 方法二：【中序遍历】的方法
     *
     * time: O(n)，其中 n 为二叉树的节点个数
     * space: O(n)，其中 n 为二叉树的节点个数
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> records = new ArrayList<>();
        inOrder(root, records);

        for (int i = 1; i < records.size(); i++) {
            if (records.get(i - 1) >= records.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> records) {
        if (root == null) {
            return;
        }

        inOrder(root.left, records);
        records.add(root.val);
        inOrder(root.right, records);
    }

}
