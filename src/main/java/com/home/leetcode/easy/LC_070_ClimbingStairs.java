package com.home.leetcode.easy;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/" />
 * @author Poet
 * @date 2020/5/9
 */
public class LC_070_ClimbingStairs {

    private int[] memo;

    /**
     * 记忆化搜索
     */
    public int climbStairs(int n) {
        // memo[n] 表示爬n级台阶的方法数
        memo = new int[n + 1];
        return calcWays(n);
    }

    /**
     * 记忆化搜索
     */
    private int calcWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }
        return memo[n];
    }

    /**
     * 动态规划
     */
    public int climbStairs_DP(int n) {
        memo = new int[n + 1];

        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

}
