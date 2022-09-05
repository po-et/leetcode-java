package com.home.leetcode.medium;

import java.util.*;

/**
 * 652. Find Duplicate Subtrees (寻找重复的子树)
 * 
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 * Example 1:
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 *
 * Example 2:
 * Input: root = [2,1,1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 *
 * @see <a href="https://leetcode.cn/problems/find-duplicate-subtrees" />
 * @author Poet
 * @date 2022/9/5
 */
public class LC_652_FindDuplicateSubtrees {

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
     * 方法一：序列化
     */
    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(node.val);
        builder.append("(");
        builder.append(dfs(node.left));
        builder.append(")(");
        builder.append(dfs(node.right));
        builder.append(")");

        String serial = builder.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }

}
