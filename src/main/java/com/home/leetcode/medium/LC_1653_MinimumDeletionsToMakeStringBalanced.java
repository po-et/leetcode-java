package com.home.leetcode.medium;

/**
 * 1653. Minimum Deletions to Make String Balanced (使字符串平衡的最少删除次数)
 *
 * You are given a string s consisting only of characters 'a' and 'b'.
 *
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 *
 * Return the minimum number of deletions needed to make s balanced.
 *
 * Example 1:
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 *
 * Example 2:
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/" />
 * @author Poet
 * @date 2023/3/6
 */
public class LC_1653_MinimumDeletionsToMakeStringBalanced {

    /**
     * 方法一：枚举
     */
    public int minimumDeletions(String s) {
        int leftB = 0;
        int rightA = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }

        int res = rightA;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                rightA--;
            } else {    // ch == 'b'
                leftB++;
            }
            res = Math.min(res, leftB + rightA);
        }

        return res;
    }
}
