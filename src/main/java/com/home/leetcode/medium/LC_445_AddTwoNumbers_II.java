package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 445. Add Two Numbers II （两数相加 II）
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example 1:
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 *
 * Example 2:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 *
 * Example 3:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * @see <a href="https://leetcode.cn/problems/add-two-numbers-ii/" />
 * @author Poet
 * @date 2020/4/29
 */
public class LC_445_AddTwoNumbers_II {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 方法一：栈 （官方题解，语义最清晰）
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = res;
            res = curnode;
        }
        return res;
    }

    /**
     * 方法一：栈
     *
     * @see <a href='https://blog.csdn.net/mine_song/article/details/70548158'/>
     */
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode curr = new ListNode(0);
        int sum = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            // head.val存储进制位，head.val可能为0
            ListNode head = new ListNode(sum / 10);
            head.next = curr;
            // curNode存储结果
            curr.val = sum % 10;
            // curNode往前移动，指向head
            curr = head;
            // 此时sum存储的是进制位, 下次计算需要用到
            sum /= 10;
        }

        // 前导0的情况, curNode为head的引用，可能为0
        return curr.val == 0 ? curr.next : curr;
    }


    /**
     * 方法二 （更好理解！）
     * 使用类似 {@link LC_002_AddTwoNumbers} 的方法
     */
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode curr = new ListNode(0);
        int tenth = 0;
        int digit = 0;

        while (true) {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }

            // 补0
            int val1 = 0, val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }

            digit = (val1 + val2 + tenth) % 10;
            tenth = (val1 + val2 + tenth) / 10;

            ListNode head = new ListNode(tenth);
            head.next = curr;
            curr.val = digit;
            curr = head;
        }

        return tenth == 0 ? curr.next : curr;
    }

    /**
     * 方法：反转链表+两数相加
     */

}
