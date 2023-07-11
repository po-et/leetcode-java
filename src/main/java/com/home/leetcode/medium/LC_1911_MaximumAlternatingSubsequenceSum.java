package com.home.leetcode.medium;

/**
 * 1911. Maximum Alternating Subsequence Sum （最大子序列交替和）
 *
 * The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.
 *
 * For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
 * Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).
 *
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 *
 * Example 1:
 * Input: nums = [4,2,5,3]
 * Output: 7
 * Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
 *
 * Example 2:
 * Input: nums = [5,6,7,8]
 * Output: 8
 * Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
 *
 * Example 3:
 * Input: nums = [6,2,1,2,4,5]
 * Output: 10
 * Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-alternating-subsequence-sum/" />
 * @author Poet
 * @date 2023/7/11
 */
public class LC_1911_MaximumAlternatingSubsequenceSum {

    // 类似题目：122. 买卖股票的最佳时机 II

    /**
     * 方法：动态规划
     */
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] f = new long[n + 1];     // f[i] 表示从前 i 个元素中选出的子序列，且最后一个元素为奇数下标时的最大交替和
        long[] g = new long[n + 1];     // g[i] 表示从前 i 个元素中选出的子序列，且最后一个元素为偶数下标时的最大交替和

        for (int i = 1; i <= n; ++i) {
            f[i] = Math.max(g[i - 1] - nums[i - 1], f[i - 1]);
            g[i] = Math.max(f[i - 1] + nums[i - 1], g[i - 1]);
        }
        return Math.max(f[n], g[n]);
    }

}
