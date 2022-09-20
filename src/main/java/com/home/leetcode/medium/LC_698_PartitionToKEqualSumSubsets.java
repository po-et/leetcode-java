package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 698. Partition to K Equal Sum Subsets (划分为k个相等的子集)
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 * Example 2:
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 * Constraints:
 *      - 1 <= k <= nums.length <= 16
 *      - 1 <= nums[i] <= 104
 *      - The frequency of each element is in the range [1, 4].
 *
 * @see <a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/" />
 * @author Poet
 * @date 2022/9/20
 */
public class LC_698_PartitionToKEqualSumSubsets {

    /**
     * 经典回溯法
     *
     * solution: https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-lfool-d9o7/
     */



    // 难理解
    /**
     * 方法一：状态压缩 + 记忆化搜索
     */
    int[] nums;
    int per, n;
    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + p > per) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                    return true;
                }
            }
        }
        return false;
    }

}
