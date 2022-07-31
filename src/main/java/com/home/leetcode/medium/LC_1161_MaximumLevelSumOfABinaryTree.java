package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree (最大层内元素和)
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 * Example 1:
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 *
 * Example 2:
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 * @see <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/" />
 * @author Poet
 * @date 2022/7/31
 */
public class LC_1161_MaximumLevelSumOfABinaryTree {

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
     * 方法一：广度优先搜索
     *
     * 思路一：直接套用DFS的思路，我们需要在队列中存储节点和节点的层号。
     * 思路二：一次遍历完一整层的节点，遍历的同时，累加该层的节点的元素之和，同时用这层的节点得到下一层的节点，这种做法不需要记录层号。
     *
     * time:  O(n) 其中 n 是二叉树的节点个数
     * space: O(n) 最坏情况下，数组中有 O(n) 个节点
     */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelList = new ArrayList<>();
        int res = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelList.add(sum);

            if (sum > max) {
                max = sum;
                res = levelList.size();
            }
        }

        return res;
    }


    /**
     * 方法二：深度优先搜索
     *
     * time:  O(n) 其中 n 是二叉树的节点个数
     * space: O(n) 最坏情况下二叉树是一条链，需要 O(n) 的数组空间以及 O(n) 的递归栈空间
     */
    // 用动态数组来维护每一层的元素之和
    private List<Integer> sum = new ArrayList<>();

    public int maxLevelSum_DFS(TreeNode root) {
        dfs(root, 0);
        int ans = 0;
        for (int i = 0; i < sum.size(); ++i) {
            if (sum.get(i) > sum.get(ans)) {
                ans = i;
            }
        }
        return ans + 1; // 层号从 1 开始
    }

    private void dfs(TreeNode node, int level) {
        if (level == sum.size()) {
            sum.add(node.val);
        } else {
            sum.set(level, sum.get(level) + node.val);
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }

}
