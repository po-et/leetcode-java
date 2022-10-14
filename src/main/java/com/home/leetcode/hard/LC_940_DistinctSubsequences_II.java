package com.home.leetcode.hard;

import java.util.Arrays;

/**
 * 940. Distinct Subsequences II (不同的子序列 II)
 *
 * Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 *
 * Example 2:
 * Input: s = "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
 *
 * Example 3:
 * Input: s = "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 * @see <a href="https://leetcode.cn/problems/distinct-subsequences-ii/" />
 * @author Poet
 * @date 2022/10/14
 */
public class LC_940_DistinctSubsequences_II {

    /**
     * 方法一：动态规划
     *
     * 思路很难想到，建议多看几遍！
     * solution: https://leetcode.cn/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode-solu-k2h5/
     */
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1) {
                res = (res + f[last[i]]) % MOD;
            }
        }
        return res;
    }
}
