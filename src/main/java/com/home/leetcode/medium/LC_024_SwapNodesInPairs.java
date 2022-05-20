package com.home.leetcode.medium;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @see <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/" />
 * @author Poet
 * @date 2020/5/1
 */
public class LC_024_SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 使用四个指针（更好理解）
     *
     * prev —> node1 -> node2 -> next
     * prev -> node2 -> node1 -> next
     *                    /\
     *                  prev移动
     * time: O(n)
     * space: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            // 重点确定每个节点的含义
            ListNode node1 = prev.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            // 开始交换
            node2.next = node1;
            node1.next = next;
            prev.next = node2;

            // 移动prev
            prev = node1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {

            // 省略方法一的next节点
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;

            // swap
            node1.next = node2.next;
            node2.next = prev.next;
            prev.next = node2;

            // move
            prev = node1;
        }
        return dummy.next;
    }

    /**
     * 递归
     * time: O(n)
     * space: O(n)
     *
     * @see <a href="https://wiki.jikexueyuan.com/project/leetcode-book/23.html" />
     */
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
