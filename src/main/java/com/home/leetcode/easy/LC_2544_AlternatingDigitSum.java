package com.home.leetcode.easy;

/**
 * 2544. Alternating Digit Sum (交替数字和)
 *
 * You are given a positive integer n. Each digit of n has a sign according to the following rules:
 *  - The most significant digit is assigned a positive sign.
 *  - Each other digit has an opposite sign to its adjacent digits.
 *
 * Return the sum of all digits with their corresponding sign.
 *
 * Example 1:
 * Input: n = 521
 * Output: 4
 * Explanation: (+5) + (-2) + (+1) = 4.
 *
 * Example 2:
 * Input: n = 111
 * Output: 1
 * Explanation: (+1) + (-1) + (+1) = 1.
 *
 * Example 3:
 * Input: n = 886996
 * Output: 0
 * Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
 *
 * @see <a href="https://leetcode.cn/problems/alternating-digit-sum/" />
 * @author Poet
 * @date 2023/7/12
 */
public class LC_2544_AlternatingDigitSum {

    /**
     * 方法：数学（很简单，遍历一遍）
     */
    public int alternateDigitSum(int n) {
        int res = 0;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                res += Integer.valueOf(str.charAt(i) - '0');
            } else {
                res -= Integer.valueOf(str.charAt(i) - '0');
            }
        }
        return res;
    }

    // 官方题解：另一种写法
    public int alternateDigitSum_2(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * res;
    }

}
