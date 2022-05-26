package com.home.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @see <a href = "https://leetcode.cn/problems/sum-of-left-leaves/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_404_SumOfLeftLeaves {

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
     * 方法一：DFS 深度优先搜索（递归）
     *
     * time: O(n) 其中 n 是树中的节点个数。
     * space: O(n) 空间复杂度与深度优先搜索使用的栈的最大深度相关。在最坏的情况下，树呈现链式结构，深度为 O(n)，对应的空间复杂度也为 O(n)。
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 根节点不是左叶子节点
        if(root == null) {
            return 0;
        }

        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if (root.left != null && isLeafNode(root.left)) {
            sum += root.left.val;
        }
        return sum;
    }


    /**
     * 方法二：BFS 广度优先搜索（迭代）
     *
     * time: O(n) 其中 n 是树中的节点个数
     * space: O(n) 空间复杂度与广度优先搜索使用的队列需要的容量相关，为 O(n)
     */
    public int sumOfLeftLeavesIteratively(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if(isLeafNode(node.left))
                    sum += node.left.val;
                else
                    queue.offer(node.left);
            }

            if (node.right != null) {
                if(isLeafNode(node.right))
                    continue;
                else
                    queue.offer(node.right);
            }
        }
        return sum;
    }


    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

}
