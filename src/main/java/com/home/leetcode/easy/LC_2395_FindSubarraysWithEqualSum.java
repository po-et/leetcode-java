package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2395. Find Subarrays With Equal Sum
 * Given a 0-indexed integer array nums, determine whether there exist two subarrays of length 2 with equal sum. Note that the two subarrays must begin at different indices.
 *
 * Return true if these subarrays exist, and false otherwise.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [4,2,4]
 * Output: true
 * Explanation: The subarrays with elements [4,2] and [2,4] have the same sum of 6.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5]
 * Output: false
 * Explanation: No two subarrays of size 2 have the same sum.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: true
 * Explanation: The subarrays [nums[0],nums[1]] and [nums[1],nums[2]] have the same sum of 0.
 * Note that even though the subarrays have the same content, the two subarrays are considered different because they are in different positions in the original array.
 *
 * @see <a href="https://leetcode.cn/problems/find-subarrays-with-equal-sum/" />
 * @author Poet
 * @date 2023/3/26
 */
public class LC_2395_FindSubarraysWithEqualSum {

    /**
     * 方法一：哈希表
     *
     * time:  O(n)
     * space: O(n)
     */
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (sumSet.contains(sum)) {
                return true;
            }
            sumSet.add(sum);
        }
        return false;
    }
}
