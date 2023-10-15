package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 * @see <a href="https://leetcode.cn/problems/single-number-ii/?envType=daily-question&envId=2023-10-15" />
 * @author Poet
 * @date 2023/10/15
 */
public class LC_137_SingleNumber_II {

    /**
     * 方法一：哈希表
     *
     * time:  O(N)
     * space: O(N)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
