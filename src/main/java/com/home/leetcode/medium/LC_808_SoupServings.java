package com.home.leetcode.medium;

/**
 * 808. Soup Servings
 *
 * There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds of operations:
 *
 *  1. Serve 100 ml of soup A and 0 ml of soup B,
 *  2. Serve 75 ml of soup A and 25 ml of soup B,
 *  3. Serve 50 ml of soup A and 50 ml of soup B, and
 *  4. Serve 25 ml of soup A and 75 ml of soup B.
 *
 * When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.
 *
 * Note that we do not have an operation where all 100 ml's of soup B are used first.
 *
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time. Answers within 10-5 of the actual answer will be accepted.
 *
 * Example 1:
 * Input: n = 50
 * Output: 0.62500
 * Explanation: If we choose the first two operations, A will become empty first.
 *      For the third operation, A and B will become empty at the same time.
 *      For the fourth operation, B will become empty first.
 *      So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 *
 * Example 2:
 * Input: n = 100
 * Output: 0.71875
 *
 * @see <a href="https://leetcode.cn/problems/soup-servings/" />
 * @author Poet
 * @date 2022/11/21
 */
public class LC_808_SoupServings {

    /* --- 这道题来自：Weekly Contest 78 --- */

    // 参考答案
    /**
     * 方法一：动态规划
     */
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }
        return dp[n][n];
    }
}
