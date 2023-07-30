package com.home.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II (环形链表 II)
 *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 *
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle-ii/" />
 * @author Poet
 * @date 2022/7/23
 */
public class LC_142_LinkedListCycle_II {

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
     *
     * time:  O(n)
     * space: O(n)
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (visited.contains(cur)) {
                return cur;
            }
            visited.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /**
     * 方法二：双指针法
     *
     * time:  O(n)
     * space: O(1)
     */
    public ListNode detectCycle_2_two_pointer(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }

}
