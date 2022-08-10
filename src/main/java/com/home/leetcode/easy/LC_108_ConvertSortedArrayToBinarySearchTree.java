package com.home.leetcode.easy;

/**
 * 108. Convert Sorted Array to Binary Search Tree （将有序数组转换为二叉搜索树）
 *
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
 * @see <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_108_ConvertSortedArrayToBinarySearchTree {

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
     * 方法一：中序遍历，总是选择中间位置左边的数字作为根节点
     *
     * solution: https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 方法一：总是选择中间位置左边的数字作为根节点
        int mid = (left + right ) /2;
        // 方法二：总是选择中间位置右边的数字作为根节点
//        int mid = (left + right + 1) / 2;
        // 方法三：选择任意一个中间位置数字作为根节点
//        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

}
