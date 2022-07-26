package com.home.leetcode.easy;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_235_LowestCommonAncestorOfABinarySearchTree {

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
        if (root == null) {
            return null;
        }

        // 值都比root小，则最小公共祖先在root的左子树中
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 值都比root大，则最小公共祖先在root的右子树中
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 同时包含三种情况：1)p q分布在root的左右, 2)p就是root, 3)q就是root
        return root;
    }


    // 另一种写法，将结束条件写在最前
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val
                || (root.val < p.val && root.val > q.val)
                || (root.val > p.val && root.val < q.val)) {
            return root;
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
