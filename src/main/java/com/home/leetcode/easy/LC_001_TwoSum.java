package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @see <a href = "https://leetcode.com/problems/two-sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class LC_001_TwoSum {

    /**
     * 方法二：哈希表
     * time: O(n)
     * space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution!");
    }

    /**
     * 方法一：暴力枚举
     * time: O(n^2)
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("not exist solution.");
    }

}
