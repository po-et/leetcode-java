package com.home.leetcode.easy;

/**
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
 * @see <a href = "https://leetcode.com/problems/palindrome-linked-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class PalindromeLinkedList_234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

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
