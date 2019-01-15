package com.home.leetcode.utils;

/**
 * Created by Poet on 2019-01-11.
 */
public class ListNodeUtil {

    public static void print(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static void add(ListNode node, int n) {
        ListNode last = new ListNode(n);
        while (node.next != null) {
            node = node.next;
        }
        node.next = last;
    }

}
