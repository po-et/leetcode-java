package com.home.jianzhi_offer_II;

import java.util.*;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 *           1
 *          / \
 *         2   3
 *
 * 示例3：
 * 输入: root = [1]
 * 输出: [1]
 *
 * 示例4：
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 *            1
 *             \
 *              2
 *
 * 示例5：
 * 输入: root = []
 * 输出: []
 *
 * 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @see <a href="https://leetcode.cn/problems/hPov7L/" />
 * @author Poet
 * @date 2023/3/27
 */
public class Offer_II_044_FindLargestValueInEachTreeRow {

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
     * 方法一：广度优先搜索
     *
     * time:  O(n)
     * space: O(n)
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    /**
     * 方法二：深度优先搜索
     */

}
