package com.home.leetcode.medium;

/**
 * 416. Partition Equal Subset Sum (分割等和子集)
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * @see <a href="https://leetcode.cn/problems/partition-equal-subset-sum/" />
 * @author Poet
 * @date 2022/6/21
 */
public class LC_416_PartitionEqualSubsetSum {

    /* 本题是经典的「NP 完全问题」 */

    /**
     * 这道题可以换一种表述：给定一个只包含正整数的非空数组 nums[0]，判断是否可以从数组中选出一些数字，使得这些数字的和等于整个数组的元素和的一半。
     * 因此这个问题可以转换成「0-1 背包问题」
     *
     * 这道题与传统的「0-1 背包问题」的区别在于，传统的「0−1 背包问题」要求选取的物品的重量之和不能超过背包的总容量，这道题则要求选取的数字的和恰好等于整个数组的元素和的一半。
     */


    /**
     * 方法一：动态规划
     *
     * 状态定义：
     *   二维数组dp，包含 n 行 target+1 列，其中 dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
     *   是否存在一种选取方案使得被选取的正整数的和等于 j。
     *
     * 状态转移方程：
     *      dp[i][j] = dp[i−1][j] | dp[i−1][j−nums[i]],    j ≥ nums[i]
     *                 dp[i−1][j]                     ,    j < nums[i]
     *
     *
     * 官方题解：https://leetcode.cn/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
     *
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

}
