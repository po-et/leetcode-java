package com.home.leetcode.easy;

/**
 * 543. Diameter of Binary Tree （二叉树的直径）
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Example 2:
 * Input: root = [1,2]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/diameter-of-binary-tree" />
 * @author Poet
 * @date 2022/6/17
 */
public class LC_543_DiameterOfBinaryTree {

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
     * time:  O(n)
     * space: O(Height) 其中 Height 为二叉树的高度
     */
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {                                 // 访问到空节点了，返回0
            return 0;
        }

        int leftDepth = depth(node.left);                   // 左儿子为根的子树的深度
        int rightDepth = depth(node.right);                 // 右儿子为根的子树的深度
        res = Math.max(res, leftDepth + rightDepth + 1);    // 计算d_node 即 L+R+1 并更新res
        return Math.max(leftDepth, rightDepth) + 1;         // 返回该节点为根的子树的深度
    }

}
