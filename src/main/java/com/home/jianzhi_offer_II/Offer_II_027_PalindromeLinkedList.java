package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 027. 回文链表
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: false
 *
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @see <a href="https://leetcode.cn/problems/aMhZSa" />
 * @author Poet
 * @date 2023/3/20
 */
public class Offer_II_027_PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* 方法一：将值复制到数组中后用双指针法 */

    /**
     * 方法三：快慢指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMidNode(head);

        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        l2 = reverse(l2);

        return isEqual(l1, l2);
    }

    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return pre;
    }

    // 递归写法
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

}
