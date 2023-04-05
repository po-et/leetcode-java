package com.home.leetcode.easy;

/**
 * 2427. Number of Common Factors (公因子的数目)
 *
 * Given two positive integers a and b, return the number of common factors of a and b.
 *
 * An integer x is a common factor of a and b if x divides both a and b.
 *
 * Example 1:
 * Input: a = 12, b = 6
 * Output: 4
 * Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
 *
 * Example 2:
 * Input: a = 25, b = 30
 * Output: 2
 * Explanation: The common factors of 25 and 30 are 1, 5.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-common-factors/" />
 * @author Poet
 * @date 2023/4/5
 */
public class LC_2427_NumberOfCommonFactors {

    /**
     * 方法一：枚举到较小值
     *
     * time:  O(N)
     * space: O(1)
     */
    public int commonFactors(int a, int b) {
        int res = 0;
        int min = Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                res++;
            }
        }
        return res;
    }
}
