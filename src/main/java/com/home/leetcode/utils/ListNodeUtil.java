package com.home.leetcode.utils;

/**
 * Created by Poet on 2019-01-11.
 */
public class ListNodeUtil {

    public static ListNode createListNode(int[] arr, int n) {
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);

        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    public static void print(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static void add(ListNode node, int val) {
        ListNode last = new ListNode(val);
        while (node.next != null) {
            node = node.next;
        }
        node.next = last;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        print(head);    // output: 1->2->3->4->5->6->7

        ListNode reverseNode = reverse(head);
        print(reverseNode); // output: 7->6->5->4->3->2->1
    }

}
