package com.home.leetcode.easy;

/**
 * 1796. Second Largest Digit in a String (字符串中第二大的数字)
 *
 * Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
 *
 * An alphanumeric string is a string consisting of lowercase English letters and digits.
 *
 * Example 1:
 * Input: s = "dfa12321afd"
 * Output: 2
 * Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
 *
 * Example 2:
 * Input: s = "abc1111"
 * Output: -1
 * Explanation: The digits that appear in s are [1]. There is no second largest digit.
 *
 * @see <a href="https://leetcode.cn/problems/second-largest-digit-in-a-string/" />
 * @author Poet
 * @date 2022/12/3
 */
public class LC_1796_SecondLargestDigitInAString {

    /* --- 这道题来自：第 48 场双周赛 --- */

    /**
     * 方法一：直接遍历
     * time:  O(n)
     * space: O(1)
     */
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 令 num 表示 s[i] 对应的十进制数字
                int num = ch - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

}
