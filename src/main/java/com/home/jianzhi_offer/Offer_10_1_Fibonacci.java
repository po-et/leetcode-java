package com.home.jianzhi_offer;

/**
 * 面试题10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * @see <a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof" />
 * @author Poet
 * @date 2020/5/26
 */
public class Offer_10_1_Fibonacci {

    /**
     * 方法一：动态规划
     *
     * 递推关系： F(n)=F(n-1)+F(n-2)
     * 由于斐波那契数存在递推关系，因此可以使用动态规划求解。动态规划的状态转移方程即为上述递推关系，边界条件为 F(0) 和 F(1)
     *
     * time:  O(n)
     * space: O(1)
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }

    /**
     * 方法一的空间优化版
     *
     * 由于 F(n) 只和 F(n-1) 与 F(n-2) 有关，因此可以使用「滚动数组思想」把空间复杂度优化成 O(1)
     */
    public int fib_space_o1(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }


    public static void main(String[] args) {
        Offer_10_1_Fibonacci solution = new Offer_10_1_Fibonacci();
        System.out.println(solution.fib(100));
        System.out.println(solution.fib(1000));
        System.out.println(solution.fib(10000));
    }

}
