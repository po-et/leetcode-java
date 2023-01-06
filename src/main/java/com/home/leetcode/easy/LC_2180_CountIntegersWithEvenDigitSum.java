package com.home.leetcode.easy;

/**
 * 2180. Count Integers With Even Digit Sum (统计各位数字之和为偶数的整数个数)
 *
 * Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
 *
 * The digit sum of a positive integer is the sum of all its digits.
 *
 * Example 1:
 * Input: num = 4
 * Output: 2
 * Explanation:
 * The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
 *
 * Example 2:
 * Input: num = 30
 * Output: 14
 * Explanation:
 * The 14 integers less than or equal to 30 whose digit sums are even are
 * 2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
 *
 * @see <a href="https://leetcode.cn/problems/count-integers-with-even-digit-sum/" />
 * @author Poet
 * @date 2023/1/6
 */
public class LC_2180_CountIntegersWithEvenDigitSum {

    /**
     * 方法一：暴力枚举
     */
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (isEvenSum(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isEvenSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
