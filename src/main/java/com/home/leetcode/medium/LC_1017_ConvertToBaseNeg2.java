package com.home.leetcode.medium;

/**
 * 1017. Convert to Base -2 (负二进制转换)
 *
 * Given an integer n, return a binary string representing its representation in base -2.
 *
 * Note that the returned string should not have leading zeros unless the string is "0".
 *
 * Example 1:
 * Input: n = 2
 * Output: "110"
 * Explantion: (-2)2 + (-2)1 = 2
 *
 * Example 2:
 * Input: n = 3
 * Output: "111"
 * Explantion: (-2)2 + (-2)1 + (-2)0 = 3
 *
 * Example 3:
 * Input: n = 4
 * Output: "100"
 * Explantion: (-2)2 = 4
 *
 * @see <a href="https://leetcode.cn/problems/convert-to-base-2/" />
 * @author Poet
 * @date 2023/4/6
 */
public class LC_1017_ConvertToBaseNeg2 {

    // 参考答案

    /**
     * 方法一：模拟进位
     */
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return res.reverse().toString();
    }

}
