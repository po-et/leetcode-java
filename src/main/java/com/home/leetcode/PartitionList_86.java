package com.home.leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @see <a href="https://leetcode.com/problems/partition-list/" />
 * @author Poet
 * @date 2020/4/27
 */
public class PartitionList_86 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode headNode = head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;

        while (headNode != null) {
            if (headNode.val < x) {
                curr1.next = headNode;
                curr1 = curr1.next;
            } else {
                curr2.next = headNode;
                curr2 = curr2.next;
            }
            headNode = headNode.next;
        }

        curr2.next = null;
        curr1.next = dummy2.next;

        return dummy1.next;
    }
}
