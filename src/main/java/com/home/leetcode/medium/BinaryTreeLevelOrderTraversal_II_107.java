package com.home.leetcode.medium;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * @see <a href ="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/" />
 * @author Poet
 * @date 2020/5/3
 */
public class BinaryTreeLevelOrderTraversal_II_107 {

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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> respList = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> levelList  = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.peek();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(queue.poll().val);
            }
            respList.add(0, levelList);
        }

        return respList;
    }



    /**
     * 模仿 {@link BinaryTreeLevelOrderTraversal_102}
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> respList = new ArrayList<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root, 0));

        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();

            if(respList.size() == pairNode.level){
                respList.add(pairNode.level, new ArrayList<>());
            }
            respList.get(pairNode.level).add(pairNode.node.val);

            if (pairNode.node.left != null) {
                queue.add(new PairNode(pairNode.node.left, pairNode.level + 1));
            }
            if (pairNode.node.right != null) {
                queue.add(new PairNode(pairNode.node.right, pairNode.level + 1));
            }
        }

        // reverse respList
        Collections.reverse(respList);

        return respList;
    }

    static class PairNode {
        TreeNode node;
        Integer level;
        public PairNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }
}
