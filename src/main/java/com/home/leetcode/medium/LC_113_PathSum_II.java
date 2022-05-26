package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 *
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
 * @see <a href="https://leetcode.cn/problems/path-sum-ii/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_113_PathSum_II {

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

    /**
     * 方法一
     */
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


    /**
     * 方法二 （更好懂！更简洁！）
     * https://leetcode.com/problems/path-sum-ii/discuss/665522/Java-99.9-faster-1ms
     */
    List<List<Integer>> res;
    public List<List<Integer>> pathSum_Better(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null)
            return res;

        List<Integer> p = new ArrayList<>();
        recursive(root, sum, p);
        return res;
    }

    private void recursive(TreeNode root, int sum, List<Integer> p) {
        if (root == null)
            return;

        p.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(p));
        }

        recursive(root.left, sum, p);
        recursive(root.right, sum, p);

        p.remove(p.size() - 1);
    }

}
