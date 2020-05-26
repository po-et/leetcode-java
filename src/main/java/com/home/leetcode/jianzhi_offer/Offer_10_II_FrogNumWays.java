package com.home.leetcode.jianzhi_offer;

/**
 * 面试题10- II. 青蛙跳台阶问题
 *
 * @author Poet
 * @date 2020/5/26
 */
public class Offer_10_II_FrogNumWays {

    public static int numWays(int n) {
        if (n <= 0) return 1;

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3));
        System.out.println(numWays(4));
    }

}
