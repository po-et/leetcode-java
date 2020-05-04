package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/path-sum-ii/" />
 * @author Poet
 * @date 2020/5/4
 */
public class PathSum_II_113 {

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> retList = new LinkedList<>();

        if(root == null)
            return retList;
        if (root.left == null && root.right == null) {
            if(root.val == sum){
                List<Integer> innerList = new ArrayList<>();
                innerList.add(root.val);
                retList.add(innerList);
            }
        }

        List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
        for (List<Integer> innerList : leftList) {
            if (innerList != null) {
                innerList.add(0, root.val);
                retList.add(innerList);
            }
        }

        List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
        for (List<Integer> innerList : rightList) {
            if (innerList != null) {
                innerList.add(0, root.val);
                retList.add(innerList);
            }
        }

        return retList;
    }
}
