package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Poet
 * @date 2022/6/11
 */
public class LC_141_LinkedListCycle {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：哈希表
     * 遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过。
     *
     * time:  O(n)
     * space: O(n)
     */
    public boolean hasCycle_hashtable(ListNode head) {
        Set<ListNode> seenSet = new HashSet<>();
        while (head != null) {
            if (!seenSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：快慢指针
     *
     * 本方法需要对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解
     *
     * time:  O(n)
     * space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
