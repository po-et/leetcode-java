package com.home.leetcode.medium;

/**
 * 1669. Merge In Between Linked Lists (合并两个链表)
 *
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 * The blue edges and nodes in the following figure indicate the result:
 *
 *
 * Build the result list and return its head.
 *
 * Example 1:
 * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * Output: [0,1,2,1000000,1000001,1000002,5]
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
 *
 * Example 2:
 * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 * Explanation: The blue edges and nodes in the above figure indicate the result.
 *
 * @see <a href="https://leetcode.cn/problems/merge-in-between-linked-lists/" />
 * @author Poet
 * @date 2023/1/30
 */
public class LC_1669_MergeInBetweenLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * 方法一：模拟 （官方题解，更简洁！）
     *
     * time:  O(n+m)
     * space: O(1)
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }

        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;
        return list1;
    }


    /**
     * 模拟（自己ac）
     */
    public ListNode mergeInBetween_self(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = list1;

        for (int i = 0; i < a - 1; i++) {
            list1 = list1.next;
        }
        ListNode tmpNode = list1.next;
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }

        for (int i = 0; i < b - a; i++) {
            tmpNode = tmpNode.next;
        }
        list2.next = tmpNode.next;
        tmpNode.next = null;

        return dummyHead.next;
    }

}
