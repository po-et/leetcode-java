package com.home.leetcode.medium;

/**
 * 279. Perfect Squares
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
 * with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * @see <a href="https://leetcode.cn/problems/perfect-squares/" />
 * @author Poet
 * @date 2022/5/23
 */
public class LC_279_PerfectSquares {

    /**
     * 动态规划
     * @see <a href="https://leetcode.cn/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/"/>
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }

        return dp[n];
    }

}
