package com.home.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 589. N-ary Tree Preorder Traversal （N 叉树的前序遍历）
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 *
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 *
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @see <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/" />
 * @author Poet
 * @date 2022/7/24
 */
public class LC_589_N_Ary_Tree_PreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 方法一：递归
     *
     * time:  O(m)，其中 m 为 N 叉树的节点。每个节点恰好被遍历一次。
     * space: O(m)，递归过程中需要调用栈的开销，平均情况下为 O(logm)，最坏情况下树的深度为 m-1，此时需要的空间复杂度为 O(m)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder_recursive(root, res);
        return res;
    }
    private void preorder_recursive(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        for (Node child : node.children) {
            preorder_recursive(child, res);
        }
    }


    /**
     * 方法二：迭代
     *
     * 思路：方法一中利用递归来遍历树，实际的递归中隐式调用了栈，在此我们可以直接模拟递归中栈的调用。
     *      在前序遍历中，我们会先遍历节点本身，然后从左向右依次先序遍历该每个以子节点为根的子树。
     *
     * time:  O(m)，其中 m 为 N 叉树的节点。每个节点恰好被访问一次。
     * space: O(m)，其中 m 为 N 叉树的节点。如果 N 叉树的深度为 1 则此时栈的空间为 O(m-1)，
     *              如果 N 叉树的深度为 m−1 则此时栈的空间为 O(1)，平均情况下栈的空间为 O(logm)，因此空间复杂度为 O(m)
     */
    public List<Integer> preorder_iterative(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

}
