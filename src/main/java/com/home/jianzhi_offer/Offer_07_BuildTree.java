package com.home.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @see <a href="https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/" />
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_07_BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法一：递归
     */
    class Solution {
        private Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }
    }






    /**
     * Solution: https://blog.csdn.net/ouyangyanlan/article/details/73163509
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    // 构建二叉树
    // 范围 preorder[startPre..endPre] + inorder[startIn..endIn]
    private TreeNode reConstructBinaryTree(int[] preorder, int startPre, int endPre,
                                           int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == root.val) {
                root.left = reConstructBinaryTree(preorder, startPre + 1, startPre + i - startIn, inorder, startIn, i - 1);
                root.right = reConstructBinaryTree(preorder, startPre + 1 + i - startIn, endPre, inorder, i + 1, endIn);
            }
        }

        return root;
    }

}
