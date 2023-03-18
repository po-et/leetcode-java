package com.home.leetcode.medium;

/**
 * 647. Palindromic Substrings (回文子字符串的个数)
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * @see <a href="" />
 * @author Poet
 * @date 2023/3/18
 */
public class LC_647_PalindromicSubstrings {

    /**
     * 方法一：中心拓展
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}
