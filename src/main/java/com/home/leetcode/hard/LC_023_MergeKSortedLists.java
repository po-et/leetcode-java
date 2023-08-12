package com.home.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists（合并 K 个升序链表）
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @see <a href="https://leetcode.cn/problems/merge-k-sorted-lists/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_023_MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 方法：优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (l1, l2) -> l1.val - l2.val);

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }

            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }

}
