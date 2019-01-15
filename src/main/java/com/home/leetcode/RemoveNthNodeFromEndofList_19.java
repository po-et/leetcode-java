package com.home.leetcode;


import com.home.leetcode.utils.ListNode;
import com.home.leetcode.utils.ListNodeUtil;

/**
 * 删除单链表倒数第N个值
 *
 * Created by Poet on 2019-01-11.
 */
public class RemoveNthNodeFromEndofList_19 {

    /**
     * time: O(n)
     * space: O(1)
     */
    public static ListNode RemoveNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode RemoveNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNodeUtil.add(node, 2);
        ListNodeUtil.add(node, 3);
        ListNodeUtil.add(node, 4);
        ListNodeUtil.add(node, 5);
        ListNodeUtil.add(node, 6);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.print(node);

        ListNode result = RemoveNthFromEnd(node,5);
        ListNodeUtil.print(result);

//        ListNode result2 = RemoveNthFromEnd2(node,5);
//        ListNodeUtil.print(result2);

        /**
         * output:
         * 1->2->3->4->5->6->7
         * 1->2->4->5->6->7
         */
    }



}
