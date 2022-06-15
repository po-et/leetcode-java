package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists （判断两个链表是否相交）
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists" />
 * @author Poet
 * @date 2022/6/12
 */
public class LC_160_IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：哈希表
     *
     * time:  O(m+n) 其中 m 和 n 是分别是链表 headA 和 headB 的长度
     * space: O(m)
     */
    public ListNode getIntersectionNode_hashTable(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        Set<ListNode> seenSet = new HashSet<>();
        while (curA != null) {
            seenSet.add(curA);
            curA = curA.next;
        }

        while (curB != null) {
            if (seenSet.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    /**
     * 方法二：双指针（思路很有趣！）
     *
     * 使用双指针的方法，可以将空间复杂度降至 O(1)
     *
     * time:  O(m+n) 其中 m 和 n 是分别是链表 headA 和 headB 的长度
     * space: O(1)
     */
    public ListNode getIntersectionNode_two_pointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
