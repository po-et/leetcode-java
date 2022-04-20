package com.home.offer.jianzhi;

/**
 * 面试题10- I. 斐波那契数列
 *
 * @author Poet
 * @date 2020/5/26
 */
public class Offer_10_1_Fibonacci {

    // 0 1 1 2 3 5
    public static int fib(int n) {
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fib(4));
    }

}
