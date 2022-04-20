package com.home.offer.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - II. 从上到下打印二叉树
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_32_II_BinaryTreeLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            ret.add(levelList);

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return ret;
    }
}
