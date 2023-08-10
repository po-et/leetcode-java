package com.home.jianzhi_offer_II;

import java.util.PriorityQueue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * 注意：本题与主站 703 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * @see <a href="https://leetcode.cn/problems/jBjn9C/" />
 * @author Poet
 * @date 2023/4/1
 */
public class Offer_II_059_KthLargestElementInAStream {

    /**
     * 方法一：优先队列
     */
    class KthLargest {

        PriorityQueue<Integer> pq;
        int capacity;

        public KthLargest(int k, int[] nums) {
            // 最小堆
            pq = new PriorityQueue<>(k);
            capacity = k;
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (i < k) {
                    pq.offer(nums[i]);
                } else {
                    int peek = pq.peek();
                    if (peek < nums[i]) {
                        pq.poll();
                        pq.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (pq.size() < capacity) {
                pq.offer(val);
                return pq.peek();
            }
            if (pq.size() == capacity && pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }


    /**
     * 优先队列（官方题解，更简洁）
     */
    class KthLargest_official {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest_official(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();

            for (int x : nums) {
                // 调用内部add方法
                add(x);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
