package com.home.leetcode.medium;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/" />
 * @author Poet
 * @date 2020/5/5
 */
public class KthSmallestElementInBST_230 {

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

    // 定义全局变量
    private int counter;
    private TreeNode resNode;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return resNode.val;
    }

    private void inOrder(TreeNode root, int k) {
        if(root == null)
            return;

        inOrder(root.left, k);
        counter++;
        if(counter == k){
            resNode = root;
            return;
        }
        inOrder(root.right, k);
    }

}
