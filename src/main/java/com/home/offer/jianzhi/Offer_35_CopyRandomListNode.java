package com.home.offer.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * @see <a href="https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/" />
 * @author poet
 * @date 2022/6/6
 */
public class Offer_35_CopyRandomListNode {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 方法一：回溯 + 哈希表
     *
     * time:  O(n) 其中 n 是链表的长度。对于每个节点，我们至多访问其「后继节点」和「随机指针指向的节点」各一次，均摊每个点至多被访问两次。
     * space: O(n) 其中 n 是链表的长度。为哈希表的空间开销
     */
    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);

            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }

        return cachedNode.get(head);
    }
}
