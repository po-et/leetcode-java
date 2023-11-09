package com.home.leetcode.easy;

/**
 * 2609. Find the Longest Balanced Substring of a Binary String (最长平衡子字符串)
 *
 * You are given a binary string s consisting only of zeroes and ones.
 *
 * A substring of s is considered balanced if all zeroes are before ones and the number of zeroes is equal to the number of ones inside the substring. Notice that the empty substring is considered a balanced substring.
 *
 * Return the length of the longest balanced substring of s.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "01000111"
 * Output: 6
 * Explanation: The longest balanced substring is "000111", which has length 6.
 *
 * Example 2:
 * Input: s = "00111"
 * Output: 4
 * Explanation: The longest balanced substring is "0011", which has length 4.
 *
 * Example 3:
 * Input: s = "111"
 * Output: 0
 * Explanation: There is no balanced substring except the empty substring, so the answer is 0.
 *
 * @see <a href="https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/" />
 * @author Poet
 * @date 2023/11/8
 */
public class LC_2609_FindTheLongestBalancedSubstringOfABinaryString {

    /**
     * 方法：计数
     */
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int[] count = new int[2];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count[1]++;
                res = Math.max(res, 2 * Math.min(count[0], count[1]));
            } else if (i == 0 || s.charAt(i - 1) == '1') {
                count[0] = 1;
                count[1] = 0;
            } else {
                count[0]++;
            }
        }
        return res;
    }

}
