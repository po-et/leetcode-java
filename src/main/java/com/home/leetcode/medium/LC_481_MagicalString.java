package com.home.leetcode.medium;

/**
 * 481. Magical String （神奇字符串）
 *
 * A magical string s consists of only '1' and '2' and obeys the following rules:
 *
 * The string s is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string s itself.
 * The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". You can see that the occurrence sequence is s itself.
 *
 * Given an integer n, return the number of 1's in the first n number in the magical string s.
 *
 *
 * Example 1:
 * Input: n = 6
 * Output: 3
 * Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/magical-string/" />
 * @author Poet
 * @date 2022/10/31
 */
public class LC_481_MagicalString {

    // 直接参考答案

    /**
     * 方法一：双指针
     */
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++res;
                }
                ++j;
                --size;
            }
            ++i;
        }
        return res;
    }

}
