package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 029. 排序的循环链表
 *
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * 示例 1：
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 * 示例 2：
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 *
 * 示例 3：
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 *
 * @see <a href="https://leetcode.cn/problems/4ueAj6/" />
 * @author Poet
 * @date 2022/6/18
 */
public class Offer_II_InsertIntoASortedCirculalLinkedList {

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }


    /**
     * 方法一：一次遍历
     *
     * time:  O(n) 其中 n 是链表的节点数。需要遍历链表一次寻找插入节点的位置，插入节点的时间是 O(1)
     * space: O(1)
     */
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);

        // 如果循环链表为空
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // 如果循环链表的头节点的 next 指针指向自身
        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }

        // 如果循环链表中的节点数大于 1
        Node curr = head;
        Node next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }

        curr.next = newNode;
        newNode.next = next;
        return head;
    }
}
