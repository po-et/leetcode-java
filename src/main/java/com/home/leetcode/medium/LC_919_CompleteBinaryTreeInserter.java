package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 919. Complete Binary Tree Inserter (完全二叉树插入器)
 *
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 *
 * Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.
 *
 * Implement the CBTInserter class:
 *      CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
 *      int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
 *      TreeNode get_root() Returns the root node of the tree.
 *
 * Example 1:
 * Input
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * Output
 * [null, 1, 2, [1, 2, 3, 4]]
 *
 * Explanation
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // return 1
 * cBTInserter.insert(4);  // return 2
 * cBTInserter.get_root(); // return [1, 2, 3, 4]
 *
 * @see <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/" />
 * @author Poet
 * @date 2022/7/25
 */
public class LC_919_CompleteBinaryTreeInserter {

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
     * 方法一：队列
     *
     * 思路：对于一棵完全二叉树而言，其除了最后一层之外都是完全填充的，并且最后一层的节点全部在最左侧。那么，只有倒数第二层（如果存在）
     *      最右侧的若干个节点，以及最后一层的全部节点可以再添加子节点，其余的节点都已经拥有两个子节点。
     *      因此，我们可以使用一个队列存储上述提到的这些可以添加子节点的节点。
     *
     */
    class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.queue = new ArrayDeque<>();
            this.root = root;

            Queue<TreeNode> levelQueue = new ArrayDeque<>();
            levelQueue.offer(root);

            while (!levelQueue.isEmpty()) {
                TreeNode node = levelQueue.poll();
                if (node.left != null) {
                    levelQueue.offer(node.left);
                }
                if (node.right != null) {
                    levelQueue.offer(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    queue.offer(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = queue.peek();
            TreeNode newNode = new TreeNode(val);
            queue.offer(newNode);

            if (node.left == null) {
                node.left = newNode;
            } else {
                node.right = newNode;
                queue.poll();
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
}
