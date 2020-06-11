package com.home.leetcode.hard;

import com.home.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * [leetcode] 25. Reverse Nodes in k-Group
 * 参考答案：https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
 *
 * Given this linked list: 1->2->3->4->5
 *     For k = 2, you should return: 2->1->4->3->5
 *     For k = 3, you should return: 3->2->1->4->5
 *
 * Created by Poet on 2019-01-06.
 */
public class ReverseNodesKGroup_25 {

    /**
     * time: O(n)
     * space: O(n)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }



    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;

        int count = 0;
        while (end != null) {
            count++;
            // group
            if (count % k == 0) {
                // reverse linked list (start, end]
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    /**
     * reverse linked list from range (start, end), return last node.
     * for example:
     * 0->1->2->3->4->5->6->7->8
     * |           |
     * start       end
     *
     * After call start = reverse(start, end)
     *
     * 0->3->2->1->4->5->6->7->8
     *          |  |
     *       start end
     *       first
     *
     */
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode prev = start;
        ListNode first = curr;
        while (curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }


    /**
     * @see <a href = "https://www.bilibili.com/video/BV17x411m7qE?from=search&seid=9636965338124954411" />
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        if(head==null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverse3(prev, k);
        }
        return dummy.next;
    }

    private ListNode reverse3(ListNode prev, int k) {
        ListNode last = prev;
        for (int i = 0; i < k+1; i++) {
            last = last.next;
            if(i!=k && last == null){
                return null;
            }
        }

        ListNode node1 = prev.next;
        ListNode node2 = prev.next.next;
        while (node2 != last) {
            node1.next = node2.next;
            node2.next = prev.next;
            prev.next = node2;
            node2 = node1.next;
        }
        return node1;
    }


    /**
     * Stack （最好理解！）
     * added on 2020-04-25
     */
    public static ListNode reverseKGroup4(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode next = dummy.next;
        Stack<ListNode> stack = new Stack<>();

        while (next != null) {
            for (int i = 0; i < k && next!=null; i++) {
                stack.push(next);
                next = next.next;
            }
            if (stack.size() != k) {
                return dummy.next;
            }
            while (!stack.isEmpty()) {
                curr.next = stack.pop();
                curr = curr.next;
            }
            curr.next = next;
        }

        return dummy.next;
    }
}
