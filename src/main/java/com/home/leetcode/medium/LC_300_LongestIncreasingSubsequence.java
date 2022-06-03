package com.home.leetcode.medium;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/longest-increasing-subsequence/" />
 * @author poet
 * @date 2022/6/3
 */
public class LC_300_LongestIncreasingSubsequence {

    /**
     * 状态的定义：
     *     LIS(i)表示以第i个数字为结尾的最长上升子序列的长度
     *
     *     即，LIS(i)表示[0...i]的范围内，选择数字nums[i]可以获得的最长上升子序列的长度
     *
     * 状态转移方程：
     *     LIS(i) = max (1 + LIS(j) if nums[i] > nums[j] )     (j < i)
     */


    /**
     * 动态规划
     * time: O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // memo[i]表示以nums[i]为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];

        // 先解决小问题
        memo[0] = 1;

        // 再递推到大问题
        for (int i = 1; i < nums.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}
