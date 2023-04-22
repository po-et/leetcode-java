package com.home.leetcode.medium;

/**
 * 1027. Longest Arithmetic Subsequence (最长等差数列)
 *
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Note that:
 *  - A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *  - A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 *
 * Example 1:
 * Input: nums = [3,6,9,12]
 * Output: 4
 * Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
 *
 * Example 2:
 * Input: nums = [9,4,7,2,10]
 * Output: 3
 * Explanation:  The longest arithmetic subsequence is [4,7,10].
 *
 * Example 3:
 * Input: nums = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:  The longest arithmetic subsequence is [20,15,10,5].
 *
 * @see <a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/" />
 * @author Poet
 * @date 2023/4/22
 */
public class LC_1027_LongestArithmeticSubsequence {

    /**
     * DP
     *
     * 状态定义：
     * dp[i][d]: 表示以数组下标 i 处的元素结尾、公差为 d 的等差数列的最大长度。
     *
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int maxLen = 0;     //保存结果
        for (int k = 1; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int d = nums[k] - nums[j] + 500;//统一加偏移量，使下标非负
                dp[k][d] = dp[j][d] + 1; //根据 d 去填充dp[k][d]
                maxLen = Math.max(maxLen, dp[k][d]);//维护最大值
            }
        }
        return maxLen + 1;
    }

}
