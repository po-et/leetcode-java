package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 024. 反转链表
 *
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 【进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？】
 *
 * 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @see <a href="https://leetcode.cn/problems/UHnkqh" />
 * @author Poet
 * @date 2023/3/19
 */
public class Offer_II_024_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
