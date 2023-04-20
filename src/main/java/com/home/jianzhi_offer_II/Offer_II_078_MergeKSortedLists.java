package com.home.jianzhi_offer_II;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 078. 合并排序链表
 *
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @see <a href="https://leetcode.cn/problems/vvXgSW/" />
 * @author Poet
 * @date 2023/4/15
 */
public class Offer_II_078_MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 方法一：顺序合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode node : lists) {
            res = mergeTwoLists(res, node);
        }
        return res;
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode a = node1, b = node2;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a == null ? b : a);
        return dummyHead.next;
    }

    /**
     * 方法三：使用优先队列合并
     */
    public ListNode mergeKLists_PQ(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummyHead.next;
    }
}
