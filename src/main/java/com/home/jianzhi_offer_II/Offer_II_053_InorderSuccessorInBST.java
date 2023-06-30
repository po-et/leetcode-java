package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 *
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 *
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 * 示例 1：
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 *
 * 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/
 *
 * @see <a href="https://leetcode.cn/problems/P5rCT8/" />
 * @author Poet
 * @date 2023/3/30
 */
public class Offer_II_053_InorderSuccessorInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法一：中序遍历
     */

    /**
     * 方法二：利用二叉搜索树的性质
     *
     * time:  O(N)
     * space: O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }

        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

}
