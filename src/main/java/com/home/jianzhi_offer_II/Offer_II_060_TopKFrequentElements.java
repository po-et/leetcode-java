package com.home.jianzhi_offer_II;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 *
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @see <a href="https://leetcode.cn/problems/g5c51o/" />
 * @author Poet
 * @date 2023/4/1
 */
public class Offer_II_060_TopKFrequentElements {

    /**
     * 方法一：堆
     *
     * time:  O(NlogK)
     * space: O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.freq - o2.freq;
            }
        });

        // 填充PriorityQueue
        freqMap.forEach((key, val) -> {
            if (queue.size() < k) {
                queue.offer(new Node(key, val));
            } else {
                Node peek = queue.peek();
                if (peek.freq < val) {
                    queue.poll();
                    queue.offer(new Node(key, val));
                }
            }
        });

        // 输出结果
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index] = queue.poll().num;
            index++;
        }
        return res;
    }

    class Node {
        int num;
        int freq;
        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    /**
     * 方法二：基于快速排序
     */

}
