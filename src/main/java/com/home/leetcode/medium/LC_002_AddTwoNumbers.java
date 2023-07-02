package com.home.leetcode.medium;

/**
 * 2. Add Two Numbers（链表中两数相加）
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/" />
 * @author Poet
 * @date 2020/4/28
 */
public class LC_002_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    // 更好理解
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        int tenth = 0;
        int digit = 0;

        while (true) {
            digit = (l1.val + l2.val + tenth) % 10;
            tenth = (l1.val + l2.val + tenth) / 10;

            cur.next = new ListNode(digit);

            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;

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
            cur.next = new ListNode(tenth);
        }

        return dummyHead.next;
    }

}