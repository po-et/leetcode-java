package com.home.leetcode;

import com.home.leetcode.utils.ListNode;
import com.home.leetcode.utils.ListNodeUtil;

/**
 * Remove duplicates from sorted list
 *
 * for example:
 *  Given 1->1->2->3->3, return 1->2->3.
 *
 * Created by Poet on 2019-01-13.
 */
public class RemoveDuplicatesFromSortedList_83 {

    /**
     * time: O(n)
     * space: O(1)
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
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

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNodeUtil.add(node, 2);
        ListNodeUtil.add(node, 3);
        ListNodeUtil.add(node, 3);
        ListNodeUtil.add(node, 4);
        ListNodeUtil.add(node, 5);
        ListNodeUtil.add(node, 5);
        ListNodeUtil.add(node, 6);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.add(node, 7);
//        ListNodeUtil.add(node, 8);
        ListNodeUtil.print(node);

        ListNodeUtil.print(deleteDuplicates(node));
        ListNodeUtil.print(node);
    }
}
