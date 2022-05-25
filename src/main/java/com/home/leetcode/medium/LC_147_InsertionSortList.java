package com.home.leetcode.medium;

/**
 * 147. Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @see <a href="https://leetcode.cn/problems/insertion-sort-list/" />
 * @author Poet
 * @date 2020/5/1
 */
public class LC_147_InsertionSortList {

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

    /**
     * 对原链表排序
     * time: O(n^2)
     * space: O(1)
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int index = 0;

        while (curr.next != null) {
            ListNode prev = dummy;

            int i;
            for (i = 0; i < index && prev.next.val < curr.next.val; i++) {
                // move, find index
                prev = prev.next;
            }

            if (i != index) {
                ListNode currNext = curr.next;
                ListNode prevNext = prev.next;

                // remove
                curr.next = currNext.next;

                // add
                prev.next = currNext;
                currNext.next = prevNext;
            } else {
                // move
                curr = curr.next;
            }
            index++;
        }
        return dummy.next;
    }


    /**
     * 可以构建一个临时的链表，然后将待排序的链表的每一个节点插入到临时链表中
     * time: O(n^2)
     * space: O(n)
     */
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                // move
                prev = prev.next;
            }
            // add
            ListNode currNext = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = currNext;
        }
        return dummy.next;
    }








    public ListNode insertionSortListTemp(ListNode head) {

        return null;
    }

}
