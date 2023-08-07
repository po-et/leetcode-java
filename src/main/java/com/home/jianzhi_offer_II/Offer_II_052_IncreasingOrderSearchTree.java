package com.home.jianzhi_offer_II;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 *
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-tree/
 *
 * @see <a href="https://leetcode.cn/problems/NYBBNL/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhi97xo3" />
 * @author Poet
 * @date 2023/3/29
 */
public class Offer_II_052_IncreasingOrderSearchTree {

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
     * 方法一：中序遍历之后生成新的树
     *
     * time:  O(N)
     * space: O(N)
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        inOrder(root, inOrderList);

        TreeNode dummyHead = new TreeNode(-1);
        TreeNode cur = dummyHead;
        for (Integer num : inOrderList) {
            cur.right = new TreeNode(num);
            cur = cur.right;
        }
        return dummyHead.right;
    }

    private void inOrder(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }


    /**
     * 方法二：在中序遍历的过程中改变节点指向
     *
     * time:  O(N)
     * space: O(N)
     */
    private TreeNode curNode;

    public TreeNode increasingBST_2(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);
        curNode = dummyHead;
        inOrder_2(root);
        return dummyHead.right;
    }

    private void inOrder_2(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder_2(node.left);

        // 在中序遍历的过程中修改节点指向
        curNode.right = node;
        node.left = null;
        curNode = node;

        inOrder_2(node.right);
    }


}
