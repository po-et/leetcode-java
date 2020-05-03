package com.home.leetcode.medium;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * @see <a href = "https://leetcode.com/problems/top-k-frequent-elements/" />
 * @author Poet
 * @date 2020/5/3
 */
public class TopKFrequentElements_347 {

    static class Freq {
        int val;
        int count;
        public Freq(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    /**
     * 优先队列
     */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length == 0 || k<=0)
            throw new IllegalArgumentException("param is not valid.");

        int[] ret = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);

        freqMap.forEach((num, count)->{
            if (queue.size() < k) {
                queue.offer(new Freq(num, freqMap.get(num)));
                return;
            }

            Freq peek = queue.peek();
            if (peek.count < freqMap.get(num)) {
                queue.poll();
                queue.offer(new Freq(num, freqMap.get(num)));
            }
        });

        int index = 0 ;
        while (!queue.isEmpty()) {
            ret[index++] = queue.poll().val;
        }
        return ret;
    }


    /**
     * 桶排序的思路（有趣！）
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if(nums==null || nums.length == 0 || k <= 0)
            throw new IllegalArgumentException("param is not valid.");

        //step1—用哈希表统计数组中各元素出现的频次，表中“键”为元素数值，“值”为对应元素出现的频次
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //step2—桶排序
        List<Integer>[] bucket = new List[nums.length + 1]; // 定义足够数量的桶

        for (Integer key : freqMap.keySet()) {
            int count = freqMap.get(key);
            //把出现频次相同的元素“扔”到序号等于频次的桶中
            if(bucket[count] == null)
                bucket[count] = new ArrayList<>();
            bucket[count].add(key);
        }

        //step3—“逆序”取数据
        List<Integer> retList = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null && retList.size() < k) {
                retList.addAll(bucket[i]);
            }
        }

        // 拼装返回数据
        int[] ret = new int[k];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }
}
