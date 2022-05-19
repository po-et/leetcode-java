package com.home.leetcode.easy;

/**
 * 203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @see <a href="https://leetcode.cn/problems/remove-linked-list-elements/" />
 * @author Poet
 * @date 2020/4/27
 */
public class LC_203_RemoveLinkedListElements {

  // Definition for singly-linked list.
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
     * 迭代
     * time: O(n)
     * space: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;

        while (curr.next != null) {
            if (curr.next.val == val) {
//                ListNode delNode = curr.next;
//                curr.next = delNode.next;
//                delNode.next = null;  // 标记为可删除node
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * time: O(n) 其中 n 是链表的长度。递归过程中需要遍历链表一次。
     * space: O(n) 其中 n 是链表的长度。空间复杂度主要取决于递归调用栈，最多不会超过 n 层。
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


}
