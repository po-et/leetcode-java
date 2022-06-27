package com.home.jianzhi_offer;

/**
 * 面试题07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
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
                root.left = reConstructBinaryTree(preorder, startPre + 1, startPre + i - startIn,
                        inorder, startIn, i - 1);
                root.right = reConstructBinaryTree(preorder, startPre + 1 + i - startIn, endPre,
                        inorder, i + 1, endIn);
            }
        }

        return root;
    }


}
