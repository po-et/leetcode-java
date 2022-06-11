package com.home.offer.jianzhi;

/**
 * 面试题26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *     3
 *    / \
 *   4  5
 *  / \
 * 1  2
 *
 * 给定的树 B：
 *
 *   4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * @see <a href="https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof" />
 * @author Poet
 * @date 2020/5/29
 */
public class Offer_26_JudgeIsSubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 树的子结构（先序遍历）
     *
     * time:  O(MN) 其中 M,N 分别为树A和树B的节点数量；先序遍历树 A 占用 O(M)，每次调用 recur(A, B) 判断占用 O(N)
     * space: O(M) 当树 A 和树 B 都退化为链表时，递归调用深度最大。
     */
    // 遍历树A
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断树A包含树B
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}

