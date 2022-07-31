package com.home.leetcode.medium;

import java.util.*;

/**
 * 692. Top K Frequent Words (前K个高频单词)
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 *
 * @see <a href="https://leetcode.cn/problems/top-k-frequent-words/" />
 * @author Poet
 * @date 2022/7/31
 */
public class LC_692_TopKFrequentWords {

    /**
     * 方法一：哈希表 + 排序
     * 思路：预处理出每一个单词出现的频率，然后依据每个单词出现的频率降序排序，最后返回前 k 个字符串
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getKey());
        }

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return Objects.equals(map.get(word1), map.get(word2))
                        ? word1.compareTo(word2)
                        : map.get(word2) - map.get(word1);
            }
        });

        return res.subList(0, k);
    }

    /**
     * 方法二：优先队列
     */
    public List<String> topKFrequent_PriorityQueue(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return Objects.equals(entry1.getValue(), entry2.getValue())
                        ? entry2.getKey().compareTo(entry1.getKey())
                        : entry1.getValue() - entry2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }

        Collections.reverse(res);
        return res;
    }
}
