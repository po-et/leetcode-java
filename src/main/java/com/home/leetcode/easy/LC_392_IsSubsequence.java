package com.home.leetcode.easy;

/**
 * 392. Is Subsequence （判断子序列）
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/is-subsequence/" />
 * @author poet
 * @date 2022/7/19
 */
public class LC_392_IsSubsequence {

    /**
     * 方法一：双指针（贪心思想）
     *
     * time:  O(n+m)，其中 n 为 s 的长度，m 为 t 的长度。每次无论是匹配成功还是失败，都有至少一个指针发生右移，两指针能够位移的总距离为 n+m
     * space: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int index = 0;
        for (char ch : t.toCharArray()) {
            if (s.charAt(index) == ch) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }

    // 方法一的官方写法
    public boolean isSubsequence_official_ans(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 方法二：动态规划
     */

}