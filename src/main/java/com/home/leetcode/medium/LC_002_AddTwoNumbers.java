package com.home.leetcode.medium;

/**
 * 2. Add Two Numbers （链表中两数相加）
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/" />
 * @author Poet
 * @date 2020/4/28
 */
public class LC_002_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int tenth = 0;
        int digit = 0;

        while (true) {
            digit = (l1.val + l2.val + tenth) % 10;
            tenth = (l1.val + l2.val + tenth) / 10;

            curr.next = new ListNode(digit);

            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;

            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
        }

        // 处理最后一位 >=10 的情况
        if (tenth != 0) {
            curr.next = new ListNode(tenth);
        }

        return dummy.next;
    }


}
