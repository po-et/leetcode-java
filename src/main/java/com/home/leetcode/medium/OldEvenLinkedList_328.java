package com.home.leetcode.medium;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * @see <a href="https://leetcode.com/problems/odd-even-linked-list/" />
 * @author Poet
 * @date 2020/4/28
 */
public class OldEvenLinkedList_328 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        while (even != null && even.next != null) {

            ListNode nextOdd = odd.next;
            odd.next = even.next;
            even.next = even.next.next;
            odd.next.next = nextOdd;

            odd = odd.next;
            even = even.next;
        }

        return head;
    }
}
