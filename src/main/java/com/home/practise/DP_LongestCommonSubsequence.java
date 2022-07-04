package com.home.practise;

/**
 * Longest Common Subsequence 最长公共子序列
 *
 * @author poet
 * @date 2022/6/3
 */
public class DP_LongestCommonSubsequence {

    /**
     * 状态的定义：
     *     LCS(m, n) 表示 S1[0...m] 和 S2[0...n] 的最长公共子序列的长度
     *
     * 状态的转移：
     *     S1[m] == S2[n]:
     *         LCS(m, n) = 1 + LCS(m-1, n-1)
     *     S1[m] != S2[n]
     *         LCS(m, n) = max( LCS(m-1, n), LCS(m, n-1) )
     *
     */


    public int lengthOfLIS(int[] s1, int[] s2) {
        return 0;
    }

    public int lengthOfLIS_DP(int[] s1, int[] s2) {
        return 0;
    }

}
