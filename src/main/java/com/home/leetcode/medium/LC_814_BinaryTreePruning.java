package com.home.leetcode.medium;

/**
 * 814. Binary Tree Pruning (二叉树剪枝)
 *
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * A subtree of a node is node plus every node that is a descendant of node.
 *
 * Example 1:
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 *
 * Example 2:
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 * Example 3:
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-pruning" />
 * @author Poet
 * @date 2022/7/21
 */
public class LC_814_BinaryTreePruning {

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
     * 方法一：递归
     *
     * time:  O(n)，其中 n 是二叉树节点的个数。每个节点都需要遍历一次
     * space: O(n)，其中 n 是二叉树节点的个数。递归的深度最多为 O(n)
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
