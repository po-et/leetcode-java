package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 173. Binary Search Tree Iterator (二叉搜索树迭代器)
 *
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 *
 *
 * Example 1:
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 *
 *
 * @see <a href="https://leetcode.cn/problems/binary-search-tree-iterator/" />
 * @author Poet
 * @date 2022/8/12
 */
public class LC_173_BinarySearchTreeIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 方法一：递归 扁平化 (获取中序遍历的全部结果并保存在数组中)
     *
     * time:  O(n) 初始化需要 O(n) 的时间，其中 n 为树中节点的数量，随后每次调用只需要 O(1) 的时间
     * space: O(n) 需要保存中序遍历的全部结果
     */
    class BSTIterator {
        private int index;
        private List<Integer> arr;

        public BSTIterator(TreeNode root) {
            index = 0;
            arr = new ArrayList<>();
            inOrderTraversal(root);
        }

        public int next() {
            return arr.get(index++);
        }

        public boolean hasNext() {
            return index < arr.size();
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return ;
            }

            inOrderTraversal(root.left);
            arr.add(root.val);
            inOrderTraversal(root.right);
        }
    }


    /**
     * 方法二：迭代
     *
     * 思路：除了递归的方法外，还可以利用栈这一数据结构，通过迭代的方式对二叉树做中序遍历。这样无需预先计算出中序遍历的全部结果，只需要实时维护当前栈的情况即可。
     *
     * time:  O(1)
     * space: O(n)
     */
    class BSTIterator_iterator {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator_iterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }


    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
