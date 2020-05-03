package com.home.leetcode.medium;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @see <a href ="https://leetcode.com/problems/binary-tree-level-order-traversal/" />
 * @author Poet
 * @date 2020/5/3
 */
public class BinaryTreeLevelOrderTraversal_102 {

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

    static class PairNode {
        TreeNode node;
        Integer level;
        public PairNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> respList = new ArrayList<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.offer(new PairNode(root, 0));

        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();

            if(respList.size() == pairNode.level){
                respList.add(pairNode.level, new ArrayList<>());
            }
            respList.get(pairNode.level).add(pairNode.node.val);

            if (pairNode.node.left != null) {
                queue.offer(new PairNode(pairNode.node.left, pairNode.level + 1));
            }
            if (pairNode.node.right != null) {
                queue.offer(new PairNode(pairNode.node.right, pairNode.level + 1));
            }
        }

        return respList;
    }

}
