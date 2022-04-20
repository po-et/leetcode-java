package com.home.offer.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - I. 从上到下打印二叉树 （层序遍历 / BFS）
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_32_I_BinaryTreeLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];

        List<Integer> retList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            retList.add(head.val);
            if (head.left != null) queue.offer(head.left);
            if (head.right != null) queue.offer(head.right);
        }

        // convert List to Array
        int[] arr = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            arr[i] = retList.get(i);
        }
        return arr;
    }
}
