package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 050. 向下的路径节点之和
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 *
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @see <a href="https://leetcode.cn/problems/6eUYwP/" />
 * @author Poet
 * @date 2022/11/24
 */
public class Offer_II_050_PathSum {
    
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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    private int findPath(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == targetSum) {
            res += 1;
        }

        res += findPath(root.left, (targetSum - root.val) % 1000000007);
        res += findPath(root.right, (targetSum - root.val) % 1000000007);
        return res;
    }

}
