package com.home.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 * @see <a href = "https://leetcode.com/problems/minimum-depth-of-binary-tree/" />
 * @author Poet
 * @date 2020/5/4
 */
public class MinimumDepthOfBinaryTree_111 {

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
     * DFS
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        if (root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null)
            return minDepth(root.right) + 1;

        // 左右孩子节点都存在
        return Math.min( minDepth(root.left), minDepth(root.right) ) + 1;
    }


    /**
     * BFS
     * 思路：利用队列来实现，依次将每个结点的左右子树入队列，出队列的时候看这个结点的左右子树是否为空，为空的话则这个结点的深度就是我们要求的最小深度。
     *     （因为按照层次遍历第一个左右子树都为空的结点肯定就是深度最小的叶子结点）
     */
    public int minDepth2(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            depth ++;
        }
        return depth;
    }
}
