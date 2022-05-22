package com.home.leetcode.medium;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @see <a href ="https://leetcode.cn/problems/binary-tree-level-order-traversal/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_102_BinaryTreeLevelOrderTraversal {

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

    class PairNode {
        TreeNode node;
        Integer level;
        public PairNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> resList = new ArrayList<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.offer(new PairNode(root, 0));

        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();

            if (resList.size() == pairNode.level) {
                resList.add(pairNode.level, new ArrayList<>());
            }
            resList.get(pairNode.level).add(pairNode.node.val);

            if (pairNode.node.left != null) {
                queue.offer(new PairNode(pairNode.node.left, pairNode.level + 1));
            }
            if (pairNode.node.right != null) {
                queue.offer(new PairNode(pairNode.node.right, pairNode.level + 1));
            }
        }

        return resList;
    }

}
