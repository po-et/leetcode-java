package com.home.leetcode.easy;

/**
 * 237. Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class LC_237_DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }

        ListNode delNode = node.next;
        node.val = node.next.val;
        node.next = node.next.next;

        // remove node
        delNode.next= null;
    }

    /**
     * all valid node
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
