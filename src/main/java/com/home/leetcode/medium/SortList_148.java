package com.home.leetcode.medium;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * @see <a href="https://leetcode.com/problems/sort-list/" />
 * @author Poet
 * @date 2020/5/2
 */
public class SortList_148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 题目对时间复杂度有要求，在链表中选择不需要数组随机访问的归并排序
     * time: O(nlogn)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        //注意，这里不能写成while (fast.next != null && fast.next.next != null)，因为，在只有两个node的情况下fast和slow指针还是需要向下走，否则无法分解成一个node.
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //note: 这里需要一个pre指针来保存slow的上一个node，因为需要把上一个node的next设为null
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //merge的时候，参数是两个sort好的linkedList的head，需要使用sortList的返回值。
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }

}
