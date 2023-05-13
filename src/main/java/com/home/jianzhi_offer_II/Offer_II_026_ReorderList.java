package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 026. 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *      L0 → L1 → … → Ln-1 → Ln
 *
 * 请将其重新排列后变为：
 *      L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 *
 * 示例 2:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 *
 * 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/
 *
 * @see <a href="https://leetcode.cn/problems/LGjMqU" />
 * @author Poet
 * @date 2023/3/19
 */
public class Offer_II_026_ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 方法一：线性表
     *
     * 将链表，转换成线性的数组，时间复杂度降为O(1)
     */

    /**
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 1、找到原链表的中点（参考「876. 链表的中间结点」）
        ListNode mid = findMidNode(head);

        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        // 2、将原链表的右半端反转（参考「206. 反转链表」）
        l2 = reverse(l2);

        // 3、将原链表的两端合并。
        merge(l1, l2);
    }

    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
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

    private void merge(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
