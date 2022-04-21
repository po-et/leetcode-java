package com.home.leetcode;


import com.home.leetcode.utils.ListNode;

/**
 * 合并两个有序的链表
 *
 * 两种方法： 迭代 + 递归
 *
 * Created by Poet on 2019-01-11.
 */
public class MergeTwoSortedLists_21 {

    /**
     * 迭代
     * time: O(n)
     * space: O(1)
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }


    /**
     * 递归
     * time: O(n)
     * space: O(n)
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
