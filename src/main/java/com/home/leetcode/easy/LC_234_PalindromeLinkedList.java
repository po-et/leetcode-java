package com.home.leetcode.easy;

/**
 * 234. Palindrome Linked List （回文链表）
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @see <a href="https://leetcode.cn/problems/palindrome-linked-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class LC_234_PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 快慢指针
     *
     * time:  O(n) 其中 n 指的是链表的大小
     * space: O(1) 我们只会修改原本链表中节点的指向，而在堆栈上的堆栈帧不超过 O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        slow = reverse(slow);

        while (head != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * LeetCode提交后：Wrong Answer!!!
     * > 直接改变了原链表
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode origin = head;
        ListNode rev = reverse(head);
        while (origin != null) {
            if (origin.val != rev.val) {
                return false;
            }
            origin = origin.next;
            rev = rev.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
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

}
