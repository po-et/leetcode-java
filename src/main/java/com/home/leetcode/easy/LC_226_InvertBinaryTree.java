package com.home.leetcode.easy;

/**
 * 226. Invert Binary Tree (翻转二叉树)
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @see <a href="https://leetcode.cn/problems/invert-binary-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_226_InvertBinaryTree {

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
     * time:  O(N) 其中 N 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树
     * space: O(N) 使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。
     *        在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logN)。
     *        而在最坏情况下，树形成链状，空间复杂度为 O(N)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }


}
