package com.home.offer.jianzhi;

/**
 * 面试题52. 两个链表的第一个公共节点
 *
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author Poet
 * @date 2020/6/14
 */
public class Offer_52_IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 双指针法（特别巧妙！！！）
     * - 时间复杂度：O(M+N)
     * - 空间复杂度：O(1)
     *
     * via: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
     */
    public ListNode getIntersectionNode_Best(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
