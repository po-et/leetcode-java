package com.home.leetcode.hard;

import java.util.Arrays;
import java.util.Random;

/**
 * 1206. Design Skiplist （设计跳表）
 *
 * Design a Skiplist without using any built-in libraries.
 *
 * A skiplist is a data structure that takes O(log(n)) time to add, erase and search. Comparing with treap and red-black tree which has the same function and performance, the code length of Skiplist can be comparatively short and the idea behind Skiplists is just simple linked lists.
 *
 * For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it. The Skiplist works this way:
 *
 *
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 *
 * You can see there are many layers in the Skiplist. Each layer is a sorted linked list. With the help of the top layers, add, erase and search can be faster than O(n). It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).
 *
 * See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list
 *
 * Implement the Skiplist class:
 *
 * Skiplist() Initializes the object of the skiplist.
 * bool search(int target) Returns true if the integer target exists in the Skiplist or false otherwise.
 * void add(int num) Inserts the value num into the SkipList.
 * bool erase(int num) Removes the value num from the Skiplist and returns true. If num does not exist in the Skiplist, do nothing and return false. If there exist multiple num values, removing any one of them is fine.
 * Note that duplicates may exist in the Skiplist, your code needs to handle this situation.
 *
 *
 * Example 1:
 * Input
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * Output
 * [null, null, null, null, false, null, true, false, true, false]
 *
 * Explanation
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0); // return False
 * skiplist.add(4);
 * skiplist.search(1); // return True
 * skiplist.erase(0);  // return False, 0 is not in skiplist.
 * skiplist.erase(1);  // return True
 * skiplist.search(1); // return False, 1 has already been erased.
 *
 * @see <a href="https://leetcode.cn/problems/design-skiplist/" />
 * @author Poet
 * @date 2022/7/26
 */
public class LC_1206_DesignSkiplist {

    /**
     * 方法一：直接构造
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/design-skiplist/solution/she-ji-tiao-biao-by-leetcode-solution-e8yh/
     *
     * time:  O(logn)
     * space: O(n)
     */
    class Skiplist {
        static final int MAX_LEVEL = 32;
        static final double P_FACTOR = 0.25;
        private SkiplistNode head;
        private int level;
        private Random random;

        public Skiplist() {
            this.head = new SkiplistNode(-1, MAX_LEVEL);
            this.level = 0;
            this.random = new Random();
        }

        public boolean search(int target) {
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 target 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < target) {
                    curr = curr.forward[i];
                }
            }
            curr = curr.forward[0];
            /* 检测当前元素的值是否等于 target */
            if (curr != null && curr.val == target) {
                return true;
            }
            return false;
        }

        public void add(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 num 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            int lv = randomLevel();
            level = Math.max(level, lv);
            SkiplistNode newNode = new SkiplistNode(num, lv);
            for (int i = 0; i < lv; i++) {
                /* 对第 i 层的状态进行更新，将当前元素的 forward 指向新的节点 */
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }

        public boolean erase(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 num 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            curr = curr.forward[0];
            /* 如果值不存在则返回 false */
            if (curr == null || curr.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                /* 对第 i 层的状态进行更新，将 forward 指向被删除节点的下一跳 */
                update[i].forward[i] = curr.forward[i];
            }
            /* 更新当前的 level */
            while (level > 1 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }

        private int randomLevel() {
            int lv = 1;
            /* 随机生成 lv */
            while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }
    }

    class SkiplistNode {
        int val;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            this.forward = new SkiplistNode[maxLevel];
        }
    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
}
