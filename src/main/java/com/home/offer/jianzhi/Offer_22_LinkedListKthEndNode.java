package com.home.offer.jianzhi;

/**
 * 面试题22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * @author Poet
 * @date 2020/5/29
 */
public class Offer_22_LinkedListKthEndNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // get listNode length
        int length = 0;
        while (slow != null) {
            length ++;
            slow = slow.next;
        }

        // 考虑K大于链表长度的情形
        k = k > length ? k % length : k;
        slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
