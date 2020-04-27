package com.home.leetcode.medium;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * @author Poet
 * @date 2020/4/27
 * @see <a href = "https://leetcode.com/problems/remove-duplicates-from-sorted-list/" />
 */
public class RemoveDuplicatesFromSortedList_II_82 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next!=null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;

            } else {
                prev = prev.next;
            }

            curr = prev.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null) {
            ListNode curr = prev.next;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next != curr) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
        }

        return dummy.next;
    }

} 
