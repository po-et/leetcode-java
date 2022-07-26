package com.home.leetcode.easy;

/**
 * 509. Fibonacci Number
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * @see <a href="https://leetcode.cn/problems/fibonacci-number/" />
 * @author Poet
 * @date 2022/5/29
 */
public class LC_509_FibonacciNumber {

    private int[] memo;

    /**
     * 递归：【记忆化搜索】{自上向下的解决问题} (人的思维更好理解)
     *
     * time: O(n)
     */
    public int fib(int n) {
        memo = new int[n + 1];
        return fibRecursive(n);
    }

    private int fibRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = fibRecursive(n - 1) + fibRecursive(n - 2);
        }
        return memo[n];
    }


    /**
     * 【动态规划】{自下向上的解决问题}
     *
     * time: O(n)
     */
    public int fib_DP(int n){
        if (n == 0) {
            return 0;
        }

        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

}
