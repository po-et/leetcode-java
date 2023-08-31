package com.home.jianzhi_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * @see <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/" />
 * @author Poet
 * @date 2022/6/19
 */
public class Offer_54_BST_KthLargest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法一：中序遍历 + 列表记录（取第size-k个）
     */
    List<Integer> bstList = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return bstList.get(bstList.size() - k);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        bstList.add(root.val);
        dfs(root.right);
    }


    /**
     * 方法二：中序遍历 + 提前返回
     *
     * 官方题解：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     *
     * time:  O(n) 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N ，占用 O(N) 时间。
     * space: O(n) 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。
     */
    int res, k;

    public int kthLargest_2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs_2(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

}
