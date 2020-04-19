package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @see <a href = "https://leetcode.com/problems/two-sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class TwoSum_1 {

    /**
     * time: O(n)
     * space: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(record.containsKey(complement)){
                return new int[]{i, record.get(complement)};
            }
            record.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution!");
    }

}
