package com.home.jianzhi_offer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @see <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/" />
 * @author Poet
 * @date 2022/6/19
 */
public class Offer_36_BST_TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 本文解法基于性质：二叉搜索树的中序遍历为 递增序列
     *
     * 官方题解：https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
     *
     * time:  O(n)
     * space: O(1)
     */
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 中序遍历
        dfs(root);
        // 循环链表
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        dfs(cur.left);

        if (pre == null) {  // 当 pre 为空时：代表正在访问链表头节点，记为 head
            head = cur;
        } else {            // 当 pre 不为空时：修改双向节点引用，即 pre.right = cur ，cur.left = pre
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }

}
