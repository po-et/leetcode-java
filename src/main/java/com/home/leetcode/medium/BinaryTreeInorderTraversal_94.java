package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-inorder-traversal/" />
 * @author Poet
 * @date 2020/5/3
 */
public class BinaryTreeInorderTraversal_94 {

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
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversalRecursive(root, ret);
        return ret;
    }

    private void traversalRecursive(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }

        traversalRecursive(node.left, ret);
        ret.add(node.val);
        traversalRecursive(node.right, ret);
    }




    /**
     * 非递归（通过stack模拟系统栈）
     *
     * @comment liuyubo提供的方法，可以应用在前、中、后序遍历所有的非递归实现上 （推荐！）
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command command = stack.pop();

            if (command.s.equals("print")) {
                ret.add(command.node.val);

            } else { // command.s.equals("go")
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }

                stack.push(new Command("print", command.node));

                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return ret;
    }

    static class Command {
        String s;
        TreeNode node;
        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
}
