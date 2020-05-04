package com.home.leetcode.medium;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LowestCommonAncestorOfBinaryTree_236 {

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


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果找到 p 或者 q 那么就没有必要接着递归，因为共同祖先只可能是该节点或该节点祖先
        //如果 root 为空，说明这条路径上不可能有 p 或 q 节点，返回空
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);    //往左分支上寻找
        TreeNode right = lowestCommonAncestor(root.right, p, q);  //往右分支上寻找

        if (left != null && right != null)
            return root;  //说明 p 和 q 是分布在 root 两侧，返回即可
        if (left != null)
            return left;  //说明在 left 分支上找到 p 或 q 节点，返回即可
        else
            return right;  //否则返回 right
    }

}
