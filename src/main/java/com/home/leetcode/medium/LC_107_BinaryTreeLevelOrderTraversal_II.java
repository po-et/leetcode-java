package com.home.leetcode.medium;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 *
 * @see <a href ="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_107_BinaryTreeLevelOrderTraversal_II {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> retList = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            retList.add(0, levelList);
        }

        return retList;
    }


    /**
     * 模仿 {@link LC_102_BinaryTreeLevelOrderTraversal}，然后返回结果reverse
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> retList = new ArrayList<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root, 0));

        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();

            if(retList.size() == pairNode.level){
                retList.add(pairNode.level, new ArrayList<>());
            }
            retList.get(pairNode.level).add(pairNode.node.val);

            if (pairNode.node.left != null) {
                queue.add(new PairNode(pairNode.node.left, pairNode.level + 1));
            }
            if (pairNode.node.right != null) {
                queue.add(new PairNode(pairNode.node.right, pairNode.level + 1));
            }
        }

        // reverse retList
        Collections.reverse(retList);

        return retList;
    }

    class PairNode {
        TreeNode node;
        Integer level;
        public PairNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }
}
