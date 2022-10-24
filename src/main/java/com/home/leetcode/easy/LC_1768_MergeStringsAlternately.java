package com.home.leetcode.easy;

/**
 * 1768. Merge Strings Alternately
 *
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Example 3:
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 * @see <a href="https://leetcode.cn/problems/merge-strings-alternately/" />
 * @author Poet
 * @date 2022/10/23
 */
public class LC_1768_MergeStringsAlternately {

    /**
     * 方法一：双指针
     *
     * time:  O(m+n)
     * space: O(m+n)
     */
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder builder = new StringBuilder();

        while (index1 < n1 && index2 < n2) {
            builder.append(word1.charAt(index1++));
            builder.append(word2.charAt(index2++));
        }
        if (index1 < n1) {
            builder.append(word1.substring(index1));
        }
        if (index2 < n2) {
            builder.append(word2.substring(index2));
        }

        return builder.toString();
    }

    /**
     * 双指针 另一个写法
     */
    public String mergeAlternately_1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder res = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                res.append(word1.charAt(i));
                ++i;
            }
            if (j < n) {
                res.append(word2.charAt(j));
                ++j;
            }
        }
        return res.toString();
    }
}
