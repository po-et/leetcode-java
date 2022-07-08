package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 508. Most Frequent Subtree Sum (出现次数最多的子树元素和)
 *
 * Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
 *
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 *
 * Example 1:
 * Input: root = [5,2,-3]
 * Output: [2,-3,4]
 *
 * Example 2:
 * Input: root = [5,2,-5]
 * Output: [2]
 *
 * @see <a href="https://leetcode.cn/problems/most-frequent-subtree-sum" />
 * @author Poet
 * @date 2022/6/19
 */
public class LC_508_MostFrequentSubtreeSum {

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
     * 方法一：深度优先搜索
     */
    Map<Integer, Integer> freq = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Integer sum = dfs(node.left) + dfs(node.right) + node.val;
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, freq.get(sum));

        return sum;
    }

}
