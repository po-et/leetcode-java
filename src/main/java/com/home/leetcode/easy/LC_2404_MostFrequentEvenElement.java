package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. Most Frequent Even Element
 *
 * Given an integer array nums, return the most frequent even element.
 *
 * If there is a tie, return the smallest one. If there is no such element, return -1.
 *
 * Example 1:
 * Input: nums = [0,1,2,2,4,4,1]
 * Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 *
 * Example 2:
 * Input: nums = [4,4,4,9,2,4]
 * Output: 4
 * Explanation: 4 is the even element appears the most.
 *
 * Example 3:
 * Input: nums = [29,47,21,41,13,37,25,7]
 * Output: -1
 * Explanation: There is no even element.
 *
 * @see <a href="https://leetcode.cn/problems/most-frequent-even-element/" />
 * @author Poet
 * @date 2023/4/13
 */
public class LC_2404_MostFrequentEvenElement {

    /**
     * 方法一：哈希表计数
     *
     * time:  O(N)
     * space: O(N)
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        if (map.isEmpty()) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((entry.getValue() > maxCount)
                    || (entry.getValue() == maxCount && entry.getKey() < res)) {
                res = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return res;
    }
}
