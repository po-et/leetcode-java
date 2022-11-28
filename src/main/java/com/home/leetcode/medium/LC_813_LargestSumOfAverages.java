package com.home.leetcode.medium;

/**
 * 813. Largest Sum of Averages （最大平均值和的分组）
 *
 * You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays.
 * The score of a partition is the sum of the averages of each subarray.
 *
 * Note that the partition must use every integer in nums, and that the score is not necessarily an integer.
 *
 * Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.
 *
 * Example 1:
 * Input: nums = [9,1,2,3,9], k = 3
 * Output: 20.00000
 * Explanation:
 * The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5,6,7], k = 4
 * Output: 20.50000
 *
 * @see <a href="https://leetcode.cn/problems/largest-sum-of-averages/" />
 * @author Poet
 * @date 2022/11/28
 */
public class LC_813_LargestSumOfAverages {

    /* --- 这道题来自：Weekly Contest 79 --- */

    // 参考答案

    /**
     * 方法一：动态规划
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        // nums数据的前缀和
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
