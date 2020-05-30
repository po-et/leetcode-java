package com.home.leetcode.jianzhi_offer;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_33_BST_VerifyPostorder {

    /*
     * 解题思路：
     *
     * 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
     * 二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。
     */

    /**
     * 方法一：递归分治
     *  1、划分左右子树
     *  2、判断是否为二叉搜索树
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     */
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null)
            return false;
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j)
            return true;

        int p = i;
        while(postorder[p] < postorder[j]) p++;  // 找到左子树
        int m = p;
        while(postorder[p] > postorder[j]) p++;  // 找到右子树

        // 说明当前数组 不是二叉搜索树的后序
        if(p != j) return false;

        // 所有子树都需正确才可判定正确，因此使用 与逻辑符 && 连接
        return recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
