package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST (二叉搜索树中第K小的元素)
 *
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
 * @see <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/" />
 * @author Poet
 * @date 2020/5/5
 */
public class LC_230_KthSmallestElementInBST {

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
     * 方法一：中序遍历（找到立即结束）
     *
     * 思路：因为二叉搜索树和中序遍历的性质，所以二叉搜索树的中序遍历是按照键增加的顺序进行的。于是我们可以通过中序遍历找到第 k 个最小元素。
     */
    private int counter;
    private TreeNode resNode;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return resNode.val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);
        counter++;
        if (counter == k) {
            resNode = root;
            return;
        }
        inOrder(root.right, k);
    }


    /**
     * 方法二：中序遍历（使用额外空间）
     */
    List<Integer> orderList = new ArrayList<>();
    public int kthSmallest_inorder(TreeNode root, int k) {
        inOrder_2(root);
        return orderList.get(k - 1);
    }

    private void inOrder_2(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder_2(root.left);
        orderList.add(root.val);
        inOrder_2(root.right);
    }
}
