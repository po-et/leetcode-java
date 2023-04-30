package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 002. 二进制加法
 *
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *  - 每个字符串仅由字符 '0' 或 '1' 组成。
 *  - 1 <= a.length, b.length <= 10^4
 *  - 字符串如果不是 "0" ，就都不含前导零。
 *
 * 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
 *
 * @see <a href="https://leetcode.cn/problems/JFETK5/" />
 * @author Poet
 * @date 2023/3/12
 */
public class Offer_II_002_AddBinary {

    /**
     * 考虑一个最朴素的方法：先将 a 和  b 转化成十进制数，求和后再转化为二进制数。利用 Python 和 Java 自带的高精度运算，我们可以很简单地写出这个程序
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    /**
     * 方法一：模拟
     *
     * time:  O(n)
     * space: O(1)
     */
    public String addBinary_1(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            // 取模
            builder.append((char) (carry % 2 + '0'));
            // 取余
            carry /= 2;
        }

        if (carry > 0) {
            builder.append('1');
        }

        return builder.reverse().toString();
    }
}
