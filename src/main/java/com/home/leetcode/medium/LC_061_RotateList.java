package com.home.leetcode.medium;

/**
 * 61. Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 *
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * @see <a href = "https://leetcode.cn/problems/rotate-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class LC_061_RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    /**
     * 方法一：双指针（传统笨方法）
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        curr = head2;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return head2;
    }

    /**
     * 方法二：(tricky 推荐！)
     *
     * 不用快慢指针，一个指针就够了，原理是先遍历整个链表获得链表长度n，然后此时把链表头和尾链接起来，
     * 在往后走n - k % n个节点就到达新链表的头结点前一个点，这时断开链表即可
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        int n = 1;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        curr.next = head;

        int m = n - k % n;
        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }

        ListNode retNode = curr.next;
        curr.next = null;

        return retNode;
    }

}