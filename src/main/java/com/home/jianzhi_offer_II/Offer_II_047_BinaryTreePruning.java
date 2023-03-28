package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 *
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 *
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 *
 * 示例 1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 示例 2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 * 示例 3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 * 注意：本题与主站 814 题相同：https://leetcode-cn.com/problems/binary-tree-pruning/
 *
 * @see <a href="https://leetcode.cn/problems/pOCWxh/" />
 * @author Poet
 * @date 2023/3/28
 */
public class Offer_II_047_BinaryTreePruning {

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
     * time:  O(N) 其中 n 是二叉树节点的个数，每个节点都需要遍历一次
     * space: O(N)
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
