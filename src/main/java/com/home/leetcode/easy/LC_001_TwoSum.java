package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum （两数之和）
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @see <a href="https://leetcode.cn/problems/two-sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class LC_001_TwoSum {

    /**
     * 方法一：哈希表
     *
     * time:  O(n)
     * space: O(n) 其中 N 是数组中的元素数量。主要为哈希表的开销。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            // 只需要检查查找表里已有的元素
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution!");
    }

    /**
     * 方法二：暴力枚举
     *
     * time: O(n^2)
     */
    public int[] twoSum_2(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("not exist solution.");
    }

}
