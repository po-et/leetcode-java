package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree (将二叉搜索树变平衡)
 *
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 * Example 1:
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 *
 * @see <a href="https://leetcode.cn/problems/balance-a-binary-search-tree/" />
 * @author Poet
 * @date 2022/8/10
 */
public class LC_1382_BalanceABinarySearchTree {

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
     * 方法一：贪心构造
     */
    List<Integer> inOrderList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return build(0, inOrderList.size() - 1);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        inOrderList.add(node.val);
        inOrder(node.right);
    }

    public TreeNode build(int l, int r) {
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(inOrderList.get(mid));

        if (l <= mid - 1) {
            node.left = build(l, mid - 1);
        }
        if (mid + 1 <= r) {
            node.right = build(mid + 1, r);
        }
        return node;
    }

}
