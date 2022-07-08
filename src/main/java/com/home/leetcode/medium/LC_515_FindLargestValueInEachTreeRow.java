package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 *
 * Example 2:
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 * @see <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/" />
 * @author Poet
 * @date 2022/6/25
 */
public class LC_515_FindLargestValueInEachTreeRow {

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
     * 方法一：深度优先搜索
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int curHeight, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (curHeight == res.size()) {
            res.add(node.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), node.val));
        }

        dfs(node.left, curHeight + 1, res);
        dfs(node.right, curHeight + 1, res);
    }
}
