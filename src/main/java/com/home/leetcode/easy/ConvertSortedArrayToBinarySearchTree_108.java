package com.home.leetcode.easy;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class ConvertSortedArrayToBinarySearchTree_108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
        if(l > r)
            return null;

        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, l, mid-1);
        root.right = buildBST(nums, mid+1, r);
        return root;
    }
}
