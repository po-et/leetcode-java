package com.home.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum (层数最深叶子节点的和)
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 *
 * @see <a href="https://leetcode.cn/problems/deepest-leaves-sum/" />
 * @author Poet
 * @date 2022/8/17
 */
public class LC_1302_DeepestLeavesSum {

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
     * 方法一：深度优先搜索 DFS
     *
     * time:  O(n)
     * space: O(n) 空间复杂度主要取决于递归调用栈的深度，为二叉树的深度，最坏情况下二叉树的深度是 O(n)
     */
    int maxLevel = -1;
    int sum = 0;

    public int deepestLeavesSum_DFS(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
            sum = root.val;
        } else if (level == maxLevel) {
            sum += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


    /**
     * 方法二：广度优先搜索
     *
     * time:  O(n)
     * space: O(n) 空间复杂度主要取决于队列空间，队列中的节点个数不超过 n 个
     */
    public int deepestLeavesSum_BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            sum = 0;    // 每一层重置sum
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                sum += node.val;
            }
        }

        return sum;
    }

}
