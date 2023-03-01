package com.home.leetcode.medium;

/**
 * 1145. Binary Tree Coloring Game (二叉树着色游戏)
 *
 * Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
 *
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. The first player colors the node with value x red, and the second player colors the node with value y blue.
 *
 * Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 *
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 *
 * You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 *
 * Example 2:
 * Input: root = [1,2,3], n = 3, x = 1
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-coloring-game" />
 * @author Poet
 * @date 2023/2/3
 */
public class LC_1145_BinaryTreeColoringGame {

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

    // 参考答案

    /**
     * 方法一：深度优先搜索
     */
    class Solution {
        TreeNode xNode;

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            find(root, x);
            int leftSize = getSubtreeSize(xNode.left);
            if (leftSize >= (n + 1) / 2) {
                return true;
            }
            int rightSize = getSubtreeSize(xNode.right);
            if (rightSize >= (n + 1) / 2) {
                return true;
            }
            int remain = n - 1 - leftSize - rightSize;
            return remain >= (n + 1) / 2;
        }

        public void find(TreeNode node, int x) {
            if (xNode != null || node == null) {
                return;
            }
            if (node.val == x) {
                xNode = node;
                return;
            }
            find(node.left, x);
            find(node.right, x);
        }

        public int getSubtreeSize(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
        }
    }

}
