package com.home.leetcode.medium;

/**
 * 328. Odd Even Linked List (奇偶链表)
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input:  1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * @see <a href="https://leetcode.cn/problems/odd-even-linked-list/" />
 * @author Poet
 * @date 2020/4/28
 */
public class LC_328_OldEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;
        int index = 1;

        while (head != null) {
            if (isOdd(index)) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            index++;
            head = head.next;
        }

        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
    }

    public ListNode oddEvenList_2(ListNode head) {
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

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }

}
