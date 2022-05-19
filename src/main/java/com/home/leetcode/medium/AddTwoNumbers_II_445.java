package com.home.leetcode.medium;


import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/" />
 * @author Poet
 * @date 2020/4/29
 */
public class AddTwoNumbers_II_445 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 方法一
     * @see <a href='https://blog.csdn.net/mine_song/article/details/70548158'/>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
            ListNode head = new ListNode(sum/10);
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
     * 方法二
     * 使用类似 {@link LC_002_AddTwoNumbers} 的方法
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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

            digit = (val1 + val2 + tenth)%10;
            tenth = (val1 + val2 + tenth)/10;

            ListNode head = new ListNode(tenth);
            head.next = curr;
            curr.val = digit;
            curr = head;
        }

        return tenth == 0 ? curr.next : curr;
    }
}
