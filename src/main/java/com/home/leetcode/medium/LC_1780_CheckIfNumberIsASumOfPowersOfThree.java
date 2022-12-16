package com.home.leetcode.medium;

/**
 * 1780. Check if Number is a Sum of Powers of Three (判断一个数字是否可以表示成三的幂的和)
 *
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 *
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 *
 * Example 1:
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 3^1 + 3^2
 *
 * Example 2:
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 3^0 + 3^2 + 3^4
 *
 * Example 3:
 * Input: n = 21
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/" />
 * @author Poet
 * @date 2022/12/9
 */
public class LC_1780_CheckIfNumberIsASumOfPowersOfThree {

    /**
     * 方法一：进制转换
     *
     * 思路与算法：我们可以将 n 转换成 3 进制。如果 n 的 3 进制表示中每一位均不为 2，那么答案为 True，否则为 False。
     *
     * time:  O(logn) 即为进制转换需要的时间
     * space: O(1)
     */
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}