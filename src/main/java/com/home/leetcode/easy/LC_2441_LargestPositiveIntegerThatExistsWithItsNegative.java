package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative (与对应负数同时存在的最大正整数)
 *
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
 *
 * Return the positive integer k. If there is no such integer, return -1.
 *
 * Example 1:
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.
 *
 * Example 2:
 * Input: nums = [-1,10,6,7,-7,1]
 * Output: 7
 * Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
 *
 * Example 3:
 * Input: nums = [-10,8,6,7,-2,-3]
 * Output: -1
 * Explanation: There is no a single valid k, we return -1.
 *
 * @see <a href="https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/" />
 * @author Poet
 * @date 2023/5/13
 */
public class LC_2441_LargestPositiveIntegerThatExistsWithItsNegative {

    /**
     * 方法二：哈希表
     *
     * time:  O(N)
     * space: O(N)
     */
    public int findMaxK(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.contains(num) && set.contains(num * -1) && Math.abs(num) > res) {
                res = Math.abs(num);
            }
        }
        return res == 0 ? -1 : res;
    }
}
