package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 *
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 *
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 *
 * 示例 1：
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 *
 * 示例 2：
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *
 * 注意：本题与主站 919 题相同： https://leetcode-cn.com/problems/complete-binary-tree-inserter/
 *
 * @see <a href="https://leetcode.cn/problems/NaqhDT/" />
 * @author Poet
 * @date 2023/3/26
 */
public class Offer_II_043_CompleteBinaryTreeInserter {

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
     * 方法一：队列
     */
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.queue = new ArrayDeque<>();

            Queue<TreeNode> tmpQueue = new ArrayDeque<>();
            tmpQueue.offer(root);
            while (!tmpQueue.isEmpty()) {
                TreeNode node = tmpQueue.poll();
                if (node.left != null) {
                    tmpQueue.offer(node.left);
                }
                if (node.right != null) {
                    tmpQueue.offer(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    queue.offer(node);
                }
            }
        }

        public int insert(int v) {
            TreeNode child = new TreeNode(v);
            TreeNode node = queue.peek();
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                queue.poll();
            }

            queue.offer(child);
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */

}
