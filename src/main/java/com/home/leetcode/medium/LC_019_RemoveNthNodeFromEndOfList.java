package com.home.leetcode.medium;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * @see <a href= "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class LC_019_RemoveNthNodeFromEndOfList {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        for (int i = 0; i < n + 1; i++) {
//            assert q != null;
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }

        // remove
        p.next = p.next.next;

        return dummy.next;
    }

}
