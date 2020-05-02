package com.home.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * @see <a href = "https://leetcode.com/problems/reorder-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class ReorderList_143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 使用双指针得到中间结点，倒转链表，拼接
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        slow = reverse(slow);

        while (head.next != null) {
            ListNode headNext = head.next;

            ListNode slowNext = slow.next;
            slow.next = head.next;
            head.next = slow;
            slow = slowNext;

            head = headNext;
        }

        if (slow != null) {
            head.next = slow;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 方法二
     * 使用双指针来得到中间结点，然后使用栈和队列来做
     */
    public void reorderList2(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            queue.add(head);
            head = head.next;
        }
        while (head2 != null) {
            stack.push(head2);
            head2 = head2.next;
        }

        while (!queue.isEmpty() && !stack.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            curr.next = stack.pop();
            curr = curr.next;
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
        }
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        curr.next = null;
        head = dummy.next;
    }
}
