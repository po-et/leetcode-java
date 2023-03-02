package com.home.interview;

/**
 * 面试题 05.02. Binary Number to String LCCI (二进制数转字符串)
 *
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
 *
 * Example1:
 *  Input: 0.625
 *  Output: "0.101"
 *
 * Example2:
 *  Input: 0.1
 *  Output: "ERROR"
 *  Note: 0.1 cannot be represented accurately in binary.
 *
 * Note:
 *  This two charaters "0." should be counted into 32 characters.
 *  The number of decimal places for num is at most 6 digits
 *
 * @see <a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/" />
 * @author Poet
 * @date 2023/3/2
 */
public class LCCI_05_02_BinaryNumberToString {

    /**
     * 方法一：转换二进制数
     *
     * 数学推导：在二进制表示中，将一个数乘以 2 的效果是将小数点向右移动一位
     *
     * time:  O(C) 其中 C 是结果字符串的最大长度 C=32。最多计算 32 位，每一位的计算时间是 O(1)
     * space: O(C)
     */
    public String printBin(double num) {
        StringBuilder builder = new StringBuilder();
        builder.append("0.");

        while (builder.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            builder.append(digit);
            num -= digit;
        }

        return builder.length() <= 32 ? builder.toString() : "ERROR";
    }

}
