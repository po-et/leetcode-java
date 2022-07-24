package com.home.leetcode.easy;

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 * Input:  1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/" />
 * @author Poet
 * @date 2020/4/23
 */
public class LC_206_ReverseLinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 方法一：迭代
     *
     * time:  O(n) 其中 n 是链表的长度。需要遍历链表一次。
     * space: O(1)
     */
    public ListNode reverseList(ListNode head) {
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

    /**
     * 方法二：递归 (递归版本稍微复杂一些，其关键在于反向工作)
     *
     * time:  O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * space: O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
