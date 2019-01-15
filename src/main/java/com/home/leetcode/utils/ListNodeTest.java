package com.home.leetcode.utils;

/**
 * Created by Poet on 2019-01-12.
 */
public class ListNodeTest {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNodeUtil.add(node, 2);
        ListNodeUtil.add(node, 3);
        ListNodeUtil.add(node, 4);
        ListNodeUtil.add(node, 5);
        ListNodeUtil.add(node, 6);
        ListNodeUtil.add(node, 7);
        ListNodeUtil.print(node);
    }
}
