package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-paths/" />
 * @author Poet
 * @date 2020/5/4
 */
public class BinaryTreePaths_257 {

    // Definition for a binary tree node.
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new ArrayList<>();

        if (root == null)
            return retList;

        if (root.left == null && root.right == null) {
            retList.add(root.val + "");
            return retList;
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (String str : leftList)
            retList.add(root.val + "->" + str);

        List<String> rightList = binaryTreePaths(root.right);
        for (String str : rightList)
            retList.add(root.val + "->" + str);

        return retList;
    }
}
