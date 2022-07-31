package com.home.leetcode.medium;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal (二叉树的层序遍历)
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/" />
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

    /**
     * 方法一：广度优先搜索
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.offer(new PairNode(root, 0));     // 记录节点和节点的层号

        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();

            if (res.size() == pairNode.level) {
                res.add(pairNode.level, new ArrayList<>());
            }
            res.get(pairNode.level).add(pairNode.node.val);

            if (pairNode.node.left != null) {
                queue.offer(new PairNode(pairNode.node.left, pairNode.level + 1));
            }
            if (pairNode.node.right != null) {
                queue.offer(new PairNode(pairNode.node.right, pairNode.level + 1));
            }
        }

        return res;
    }


    /**
     * 方法一：广度优先搜索 (不同写法 Better!)
     *
     * time:  每个点进队出队各一次，故渐进时间复杂度为 O(n)
     * space: 队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)
     */
    public List<List<Integer>> levelOrder_better(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(levelList);
        }

        return res;
    }

}
