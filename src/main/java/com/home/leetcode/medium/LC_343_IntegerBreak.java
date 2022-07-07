package com.home.leetcode.medium;

/**
 * 343. Integer Break
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * @see <a href="https://leetcode.cn/problems/integer-break/" />
 * @author Poet
 * @date 2020/5/11
 */
public class LC_343_IntegerBreak {

    /**
     * 【解题方法总结】
     * 首先，考虑递归结构，画出递归形式化的图解
     *
     * 其次，优先使用自顶向下的方法解题（记忆化搜索）
     * 最后，再考虑使用自底向上的方法，转成（动态规划）
     */


    /**
     * 方法一：记忆化搜索
     */
    private int[] memo;

    public int integerBreak(int n) {
        assert n >= 2;
        // memo[i]表示将i分割，得到的最大乘积
        memo = new int[n + 1];

        return breakInteger(n);
    }

    // 将n进行分割（至少分割成两部分），可以获得的最大乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            // 函数定义为至少分割成两部分，所以（n-i）一定会继续分割，所以需要将 i*(n-i) 作为一个选项单独加进来判断
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }


    /**
     * 方法二：动态规划
     */
    public int integerBreak_DP(int n) {
        assert n >= 2;

        // memo[i]表示将数字i分割（至少分割成两部分）后，得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // 分割为 j + (i-j)，或者继续将 (i-j) 继续分割
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }

        return memo[n];
    }

    private int max3(int i1, int i2, int i3) {
        return Math.max(i1, Math.max(i2, i3));
    }

}
