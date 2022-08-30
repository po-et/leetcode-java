package com.home.leetcode.medium;

/**
 * 998. Maximum Binary Tree II (最大二叉树)
 *
 * A maximum tree is a tree where every node has a value greater than any other value in its subtree.
 *
 * You are given the root of a maximum binary tree and an integer val.
 *
 * Just as in the previous problem, the given tree was constructed from a list a (root = Construct(a)) recursively with the following Construct(a) routine:
 *
 * If a is empty, return null.
 * Otherwise, let a[i] be the largest element of a. Create a root node with the value a[i].
 * The left child of root will be Construct([a[0], a[1], ..., a[i - 1]]).
 * The right child of root will be Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]).
 * Return root.
 * Note that we were not given a directly, only a root node root = Construct(a).
 *
 * Suppose b is a copy of a with the value val appended to it. It is guaranteed that b has unique values.
 *
 * Return Construct(b).
 *
 * Example 1:
 * Input: root = [4,1,3,null,null,2], val = 5
 * Output: [5,4,null,1,3,null,null,2]
 * Explanation: a = [1,4,2,3], b = [1,4,2,3,5]
 *
 * Example 2:
 * Input: root = [5,2,4,null,1], val = 3
 * Output: [5,2,4,null,1,null,3]
 * Explanation: a = [2,1,5,4], b = [2,1,5,4,3]
 *
 * Example 3:
 * Input: root = [5,2,3,null,1], val = 4
 * Output: [5,2,4,null,1,3]
 * Explanation: a = [2,1,5,3], b = [2,1,5,3,4]
 *
 * @see <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/" />
 * @author Poet
 * @date 2022/8/30
 */
public class LC_998_MaximumBinaryTree_II {

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
     * 方法一：遍历右子节点
     *
     * time:  O(n) 在最坏情况下，树呈现链状结构，前 n-1 个节点有唯一的右子节点，并且 val 比树中任一节点的值都要小，此时需要遍历完整棵树，时间复杂度为 O(n)
     * space: O(1)
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        // 没有遍历到 val > cur.val 的情况
        parent.right = new TreeNode(val);
        return root;
    }

}
