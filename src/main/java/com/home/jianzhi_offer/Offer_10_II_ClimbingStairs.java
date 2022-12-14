package com.home.jianzhi_offer;

/**
 * 面试题10- II. 青蛙跳台阶问题
 *
 * @author Poet
 * @date 2020/5/26
 */
public class Offer_10_II_ClimbingStairs {

    /**
     * 方法一：动态规划
     *
     * f(n) = f(n-1) + f(n-2)，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 n 项的值
     *
     * time:  O(n)
     * space: O(n)
     */
    public static int numWays(int n) {
        if (n <= 0) {
            return 1;
        }

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1_000_000_007;  // 循环求余法
        }
        return memo[n];
    }

    /**
     * 方法一的空间优化版
     * space: O(1)
     */
    public int numWays_space_o1(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(numWays(3));
        System.out.println(numWays(10));
        System.out.println(numWays(100));
        System.out.println(numWays(10_000));
    }

}
