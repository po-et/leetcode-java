package com.home.leetcode.medium;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * @see <a href ="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/" />
 * @author Poet
 * @date 2020/5/3
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> respList = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int level = 0;

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            Stack<TreeNode> levelStack = new Stack<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (isOdd(level)) {
                    levelStack.push(treeNode);
                } else {
                    levelList.add(treeNode.val);
                }

                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }

            while(!levelStack.isEmpty())
                levelList.add(levelStack.pop().val);

            level++;
            respList.add(levelList);
        }
        return respList;
    }

    /**
     * judge is odd or even num
     */
    private Boolean isOdd(Integer num){
        return (num & 0x1) == 1;
    }


    /**
     * 模仿 {@link LC_102_BinaryTreeLevelOrderTraversal}
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
