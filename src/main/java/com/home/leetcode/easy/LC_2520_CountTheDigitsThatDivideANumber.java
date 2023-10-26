package com.home.leetcode.easy;

/**
 * 2520. Count the Digits That Divide a Number (统计能整除数字的位数)
 *
 * Given an integer num, return the number of digits in num that divide num.
 *
 * An integer val divides nums if nums % val == 0.
 *
 * Example 1:
 * Input: num = 7
 * Output: 1
 * Explanation: 7 divides itself, hence the answer is 1.
 *
 * Example 2:
 * Input: num = 121
 * Output: 2
 * Explanation: 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
 *
 * Example 3:
 * Input: num = 1248
 * Output: 4
 * Explanation: 1248 is divisible by all of its digits, hence the answer is 4.
 *
 * @see <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/" />
 * @author Poet
 * @date 2023/10/26
 */
public class LC_2520_CountTheDigitsThatDivideANumber {

    /**
     * 方法：模拟
     */
    public int countDigits(int num) {
        int res = 0;
        int digit = num;
        while (digit > 0) {
            if (num % (digit % 10) == 0) {
                res++;
            }
            digit = digit / 10;
        }
        return res;
    }
}
