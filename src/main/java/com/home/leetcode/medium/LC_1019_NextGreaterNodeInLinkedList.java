package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1019. Next Greater Node In Linked List (链表中的下一个更大节点)
 *
 * You are given the head of a linked list with n nodes.
 *
 * For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
 *
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
 *
 * Example 1:
 * Input: head = [2,1,5]
 * Output: [5,5,0]
 *
 * Example 2:
 * Input: head = [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 *
 * @see <a href="" />
 * @author Poet
 * @date 2023/4/10
 */
public class LC_1019_NextGreaterNodeInLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> ans = new ArrayList<>();
            Deque<int[]> stack = new ArrayDeque<>();

            ListNode cur = head;
            int idx = -1;
            while (cur != null) {
                ++idx;
                ans.add(0);
                while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                    ans.set(stack.pop()[1], cur.val);
                }
                stack.push(new int[]{cur.val, idx});
                cur = cur.next;
            }

            int size = ans.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }
}
