package com.home.leetcode.easy;

/**
 * 1800. Maximum Ascending Subarray Sum (最大升序子数组和)
 *
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
 *
 * A subarray is defined as a contiguous sequence of numbers in an array.
 *
 * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1.
 *
 * Note that a subarray of size 1 is ascending.
 *
 * Example 1:
 * Input: nums = [10,20,30,5,10,50]
 * Output: 65
 * Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
 *
 * Example 2:
 * Input: nums = [10,20,30,40,50]
 * Output: 150
 * Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
 *
 * Example 3:
 * Input: nums = [12,17,15,13,10,11,12]
 * Output: 33
 * Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-ascending-subarray-sum/" />
 * @author Poet
 * @date 2022/10/7
 */
public class LC_1800_MaximumAscendingSubarraySum {

    // 遍历一遍，自己完成
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i];
                res = Math.max(res, curSum);
            } else {
                curSum = nums[i];
            }
        }
        return res;
    }

    /**
     * 方法一：动态规划
     */
    public int maxAscendingSum_DP(int[] nums) {
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int curSum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                curSum += nums[l++];
            }
            res = Math.max(res, curSum);
        }
        return res;
    }

}
