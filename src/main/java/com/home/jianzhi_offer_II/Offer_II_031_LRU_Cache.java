package com.home.jianzhi_offer_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 031. 最近最少使用缓存
 *
 * 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/
 *
 * @see <a href="https://leetcode.cn/problems/OrIXps" />
 * @author Poet
 * @date 2023/3/21
 */
public class Offer_II_031_LRU_Cache {

    /**
     * 方法一：哈希表 + 双向链表
     */
    class LRUCache {
        private class Node {
            int key, value;
            Node pre, next;
            public Node() {}
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> map;
        int size;
        int capacity;
        Node head, tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;

            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNode(newNode);
                size++;

                if (size > capacity) {
                    Node pop = popTail();
                    map.remove(pop.key);
                    size--;
                }
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        private void addNode(Node node) {
            node.next = head.next;
            node.pre = head;

            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private Node popTail() {
            Node last = tail.pre;
            removeNode(last);
            return last;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 *
 *      LRUCache obj = new LRUCache(capacity);
 *      int param_1 = obj.get(key);
 *      obj.put(key,value);
 */
}
