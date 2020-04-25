package com.home.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * @author Poet
 * @date 2020/4/23
 * @see <a href = "hhttps://leetcode.com/problems/remove-duplicates-from-sorted-list/" />
 */
public class RemoveDuplicatesFromSortedList_83 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                ListNode next = cur.next;
                cur.next = cur.next.next;
                next = null;
            }
            cur = cur.next;
        }
        return head;
    }

}
