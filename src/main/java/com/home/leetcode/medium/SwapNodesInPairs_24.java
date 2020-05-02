package com.home.leetcode.medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/" />
 * @author Poet
 * @date 2020/5/1
 */
public class SwapNodesInPairs_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            // swap
            node1.next = node2.next;
            node2.next = prev.next;
            prev.next = node2;
            // move
            prev = node1;
        }

        return dummy.next;
    }



}
