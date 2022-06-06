package com.home.offer.jianzhi;

/**
 * 面试题06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @see <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof" />
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_06_ReversePrint {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        // 计算链表长度
        int size = 0;

        // reverse
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

            size++;
        }

        // print
        int[] ret = new int[size];
        int index = 0;
        while (pre != null) {
            ret[index++] = pre.val;
            pre = pre.next;
        }
        return ret;
    }


//
//    public ListNode reverseNode(ListNode head){
//        ListNode pre = null;
//        ListNode cur = head;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        return pre;
//    }


}
