package com.home.leetcode.easy;

/**
 * 617. Merge Two Binary Trees（合并二叉树）
 *
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 *
 * Return the merged tree.
 *
 * Example 1:
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 *
 * Example 2:
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 *
 * @see <a href="https://leetcode.cn/problems/merge-two-binary-trees" />
 * @author poet
 * @date 2022/6/15
 */
public class LC_617_MergeTwoBinaryTrees {

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
     *
     * time:  O(min(m,n)) 其中 m 和 n 分别是两个二叉树的节点个数
     * space: O(min(m,n)) 空间复杂度取决于递归调用的层数
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }

}
