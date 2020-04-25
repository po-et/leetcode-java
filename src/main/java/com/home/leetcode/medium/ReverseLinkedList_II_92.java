package com.home.leetcode.medium;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author Poet
 * @date 2020/4/23
 * @see <a href = "https://leetcode.com/problems/reverse-linked-list-ii/" />
 */
public class ReverseLinkedList_II_92 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode start = dummyHead;
        for (int i = 0; i < m-1; i++) {
            start = start.next;
        }

        ListNode node1 = start.next;
        ListNode node2 = start.next.next;
        for (int i = m; i < n ; i++) {
            node1.next = node2.next;
            node2.next = start.next;
            start.next = node2;
            node2 = node1.next;
        }

        return dummyHead.next;
    }

}
