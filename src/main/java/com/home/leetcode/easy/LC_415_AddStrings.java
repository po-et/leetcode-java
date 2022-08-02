package com.home.leetcode.easy;

/**
 * 415. Add Strings (字符串相加)
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * @see <a href="https://leetcode.cn/problems/add-strings/" />
 * @author Poet
 * @date 2022/8/2
 */
public class LC_415_AddStrings {

    /**
     * 方法一：模拟
     *
     * 思路：对两个大整数模拟「竖式加法」的过程
     *
     * time:  O(max(len1,len2))
     * space: O(1) 在 Java 解法中使用到了 StringBuffer，故 Java 解法的空间复杂度为 O(n)
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;  // i 指向 num1 的结尾
        int j = num2.length() - 1;  // j 指向 num2 的结尾
        int add = 0;                // 进位

        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + add;
            builder.append(sum % 10);
            add = sum / 10;

            i--;
            j--;
        }

        return builder.reverse().toString();
    }
}
