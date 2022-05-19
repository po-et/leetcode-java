package com.home.leetcode.medium;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @see <a href="https://leetcode.cn/problems/partition-list/" />
 * @author Poet
 * @date 2020/4/28
 */
public class LC_086_PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {    // head.val >= x
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }

        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
