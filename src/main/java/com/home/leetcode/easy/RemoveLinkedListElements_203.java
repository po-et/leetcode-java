package com.home.leetcode.easy;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/" />
 * @author Poet
 * @date 2020/4/27
 */
public class RemoveLinkedListElements_203 {

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


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode (0);
        dummy.next= head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if(curr.next.val == val ){
//                ListNode delNode = curr.next;
//                curr.next = delNode.next;
//                delNode.next = null;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }


}
