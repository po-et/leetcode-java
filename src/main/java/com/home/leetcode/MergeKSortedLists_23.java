package com.home.leetcode;

import com.home.leetcode.utils.ListNode;

import java.util.PriorityQueue;

/**
 *
 * 两种方法：1.分治法； 2.PriorityQueue
 *
 * Created by Poet on 2019-01-11.
 */
public class MergeKSortedLists_23 {

    /**
     * 方法一： 分治法
     * time: O(nlogk) where k is the number of linked lists
     * space: O(n)
     */
    public ListNode mergeKlists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi-lo)/2 + lo;   //所有的mid取值都该这么写，防止hi+lo越界！！！
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * 方法二： PriorityQueue (更推荐)
     * time: O(nlogk) where k is the number of linked lists
     * space: O(n)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length, (a,b) -> a.val-b.val); //重写compare方法
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }

}
