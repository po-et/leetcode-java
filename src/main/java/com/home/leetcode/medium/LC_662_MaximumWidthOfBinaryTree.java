package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree (二叉树最大宽度)
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 *
 * Example 2:
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 *
 * Example 3:
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width exists in the second level with length 2 (3,2).
 *
 * @see <a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/" />
 * @author Poet
 * @date 2022/8/27
 */
public class LC_662_MaximumWidthOfBinaryTree {

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

    private class PairNode {
        TreeNode node;
        Integer index;
        public PairNode(TreeNode node, Integer index) {
            this.node = node;
            this.index = index;
        }
    }

    /**
     * 方法一：广度优先搜索
     *
     * time:  O(n) 其中 n 是二叉树的节点个数，需要遍历所有节点
     * space: O(n) 广度优先搜索的空间复杂度最多为 O(n)
     */
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Queue<PairNode> queue = new LinkedList<>();
        queue.offer(new PairNode(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();
            PairNode first = queue.peek();
            PairNode last = null;
            for (int i = 0; i < size; i++) {
                PairNode pair = queue.poll();
                if (pair.node.left != null) {
                    queue.offer(new PairNode(pair.node.left, 2 * pair.index));
                }
                if (pair.node.right != null) {
                    queue.offer(new PairNode(pair.node.right, 2 * pair.index + 1));
                }
                last = pair;
            }

            int width = last.index - first.index + 1;
            res = Math.max(width, res);
        }

        return res;
    }


    /**
     * 方法二：深度优先搜索
     */
    Map<Integer, Integer> levelMin = new HashMap<>();

    public int widthOfBinaryTree_DFS(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }

        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        int width = Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1));
        return Math.max(index - levelMin.get(depth) + 1, width);
    }

}
