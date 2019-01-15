package com.home.leetcode;

import com.home.leetcode.utils.ListNode;
import com.home.leetcode.utils.ListNodeUtil;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Created by Poet on 2019-01-12.
 */
public class SwapNodesinPairs_24 {

    /**
     * time: O(n)
     * space: O(1)
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;

        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }


//    public static ListNode swapPairs2(ListNode head) {
//        ListNode l1 = head;
//        ListNode l2 = head.next;
//
//        while (l2 != null && l2.next != null) {
//            ListNode next = l2.next.next;
//            int tmp = l2.val;
//            l1.next = l2.next;
//            ListNode tmpNode = new ListNode(tmp);
//            tmpNode.next = l1;
//            l1 = l2;
//            l2 = l2.next;
//        }
//        return head;
//    }

    /**
     * 递归
     * @From: http://wiki.jikexueyuan.com/project/leetcode-book/23.html
     */
    public static ListNode swapPairs3(ListNode head) {
        if(head == null) return null;
        if(head.next ==null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs3(tmp.next);
        tmp.next = head;
        return tmp;
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

        ListNode result = swapPairs3(node);
        ListNodeUtil.print(result);
    }
}
