package com.home.offer.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题25. 合并两个排序的链表
 *
 * 定输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @see <a href="https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof" />
 * @author Poet
 * @date 2020/5/29
 */
public class Offer_25_MergeTwoSortedNodes {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 方法一：递归
     *
     * time:  O(n+m) 其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），至多只会递归调用每个节点一次。
     * space: O(n+m) 递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 方法二：迭代
     *
     * time:  O(n+m) 其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。
     * space: O(1)
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }


    /**
     * 方法三：优先队列
     */
    public ListNode mergeTwoLists_3_PriorityQueue(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        queue.offer(l1);
        queue.offer(l2);

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }

            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }


}
