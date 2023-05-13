package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 *
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 *
 * 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * @see <a href="https://leetcode.cn/problems/lMSNwu" />
 * @author Poet
 * @date 2023/3/19
 */
public class Offer_II_025_AddTwoNumbers_ii {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 方法一：先翻转链表，再加和，最后再翻转
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while (carry > 0 || l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            if (sum > 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 方法二：栈
     *
     * time:  O(max(m,n))
     * space: O(m+n)
     */
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode cur = new ListNode(sum);
            cur.next = pre;
            pre = cur;
        }

        return pre;
    }

}
