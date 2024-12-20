package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 *
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 示例 1：
 * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 *
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 *
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *
 * 注意：
 * 本题与主站 538 题相同： https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 本题与主站 1038 题相同：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 * @see <a href="https://leetcode.cn/problems/w6cpku/" />
 * @author Poet
 * @date 2023/3/30
 */
public class Offer_II_054_BinarySearchTreeToGreaterSumTree {

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
     * 方法一：反序中序遍历
     */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }

}
