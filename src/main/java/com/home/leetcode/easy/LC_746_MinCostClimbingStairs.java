package com.home.leetcode.easy;

/**
 * 746. Min Cost Climbing Stairs (使用最小花费爬楼梯)
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 *
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 * @see <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/" />
 * @author Poet
 * @date 2022/7/29
 */
public class LC_746_MinCostClimbingStairs {

    /**
     * 方法一：动态规划
     *
     * 状态定义：
     *      dp[i] 表示达到下标 i 的最小花费
     * 状态转移方程：
     *      dp[i] = min(dp[i−1] + cost[i−1], dp[i−2] + cost[i−2])
     * 初始化条件：
     *      dp[0] = dp[1] = 0
     *
     * time:  O(n)
     * space: O(n)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 当 i≥2 时，dp[i] 只和 dp[i−1] 与 dp[i−2] 有关，因此可以使用滚动数组的思想，将空间复杂度优化到 O(1)
     *
     * time:  O(n)
     * space: O(1) 使用滚动数组的思想，只需要使用有限的额外空间。
     */
    public int minCostClimbingStairs_space_o1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;

        for (int i = 2; i <= n; i++) {
            int next = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
