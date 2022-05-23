package com.home.leetcode.medium;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * @see <a href ="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_103_BinaryTreeZigzagLevelOrderTraversal {

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
        if(root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> respList = new LinkedList<>();
        queue.offer(root);
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

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            while (!levelStack.isEmpty()) {
                levelList.add(levelStack.pop().val);
            }

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


    class PairNode {
        TreeNode node;
        Integer level;
        public PairNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

}
