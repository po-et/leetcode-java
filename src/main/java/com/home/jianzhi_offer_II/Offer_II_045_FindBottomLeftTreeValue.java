package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 * @see <a href="https://leetcode.cn/problems/LwUNpT/" />
 * @author Poet
 * @date 2023/3/27
 */
public class Offer_II_045_FindBottomLeftTreeValue {

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = -1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            res = node.val;
        }
        return res;
    }

    /**
     * 方法二：深度优先搜索
     *
     * time:  O(n)
     * space: O(n)
     */
    int targetVal = 0;
    int targetHeight = 0;

    public int findBottomLeftValue_dfs(TreeNode root) {
        dfs(root, 0);
        return targetVal;
    }

    private void dfs(TreeNode root, int curHeight) {
        if (root == null) {
            return;
        }
        curHeight++;
        dfs(root.left, curHeight);
        dfs(root.right, curHeight);
        if (curHeight > targetHeight) {
            targetHeight = curHeight;
            targetVal = root.val;
        }
    }
}
