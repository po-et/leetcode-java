package com.home.leetcode.easy;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * @see <a href = "https://leetcode.cn/problems/remove-duplicates-from-sorted-list/" />
 * @author Poet
 * @date 2020/4/23
 */
public class LC_083_RemoveDuplicatesFromSortedList {

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
                next.next = null;   // delete node
            }

            cur = cur.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


//    public static void main(String[] args) {
//        com.home.leetcode.utils.ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 7, 8}, 10);
//        ListNodeUtil.print(deleteDuplicates(listNode));
//        ListNodeUtil.print(listNode);
//    }
}
