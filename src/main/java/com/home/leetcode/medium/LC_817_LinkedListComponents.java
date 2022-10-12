package com.home.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components (链表组件)
 *
 * You are given the head of a linked list containing unique integer values and an integer array nums that is a subset of the linked list values.
 *
 * Return the number of connected components in nums where two values are connected if they appear consecutively in the linked list.
 *
 * Example 1:
 * Input: head = [0,1,2,3], nums = [0,1,3]
 * Output: 2
 * Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 *
 * Example 2:
 * Input: head = [0,1,2,3,4], nums = [0,3,1,4]
 * Output: 2
 * Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 *
 * // 备注：题是简单级，题目理解是困难级。其实就是问：值存在于数组中的节点，是连续的几段
 *
 * @see <a href="https://leetcode.cn/problems/linked-list-components/" />
 * @author Poet
 * @date 2022/10/12
 */
public class LC_817_LinkedListComponents {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 方法一：计算组件的起始位置
     *
     * time:  O(n) 需要遍历一遍链表
     * space: O(m) 其中 m 是数组 nums 的长度，需要一个哈希集合来存储 nums 的元素
     */
    public int numComponents(ListNode head, int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        boolean inSet = true;
        while (head != null) {
            if (set.contains(head.val)) {
                if (inSet) {
                    res++;
                    inSet = false;
                }
            } else {
                inSet = true;
            }
            head = head.next;
        }

        return res;
    }


}
