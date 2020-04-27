package com.home.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @see <a href = "https://leetcode.com/problems/merge-two-sorted-lists/" />
 * @author Poet
 * @date 2020/4/27
 */
public class MergeTwoSortedLists_21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode node1 = l1;
        ListNode node2 = l2;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        if (node1 != null) {
            curr.next = node1;
        }

        if (node2 != null) {
            curr.next = node2;
        }

        return dummy.next;
    }


}
