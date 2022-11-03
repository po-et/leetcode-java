package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 1668. Maximum Repeating Substring (最大重复子字符串)
 *
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
 * The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
 * If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 *
 * Example 1:
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 *
 * Example 2:
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 *
 * Example 3:
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 *
 * @see <a href="https://leetcode.cn/problems/maximum-repeating-substring/" />
 * @author Poet
 * @date 2022/11/3
 */
public class LC_1668_MaximumRepeatingSubstring {

    // 参考答案

    /**
     * 方法一：简单枚举 + 动态规划
     */
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
