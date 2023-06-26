package com.home.jianzhi_offer_II;

import java.util.*;

/**
 * 剑指 Offer II 046. 二叉树的右侧视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 * 示例 3:
 * 输入: []
 * 输出: []
 *
 * 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @see <a href="https://leetcode.cn/problems/WNC0Lk/" />
 * @author Poet
 * @date 2023/3/27
 */
public class Offer_II_046_BinaryTreeRightSideView {

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }

    /**
     * 方法二：深度优先搜索
     *
     * time:  O(n)
     * space: O(n)
     */
    int targetHeight = 0;

    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int curHeight) {
        if (root == null) {
            return;
        }

        if (curHeight == targetHeight) {
            targetHeight++;
            res.add(root.val);
        }
        dfs(root.right, res, curHeight + 1);
        dfs(root.left, res, curHeight + 1);
    }

}
