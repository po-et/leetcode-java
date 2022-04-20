package com.home.offer.jianzhi;

/**
 * 面试题27. 二叉树的镜像 （翻转二叉树）
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *  
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * @author Poet
 * @date 2020/5/29
 */
public class Offer_27_RevertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode leftChild = mirrorTree(root.left);
        TreeNode rightChild = mirrorTree(root.right);

        // swap left & right
        root.left = rightChild;
        root.right = leftChild;

        return root;
    }

}

