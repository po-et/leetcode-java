package com.home.leetcode.easy;

/**
 * 1684. Count the Number of Consistent Strings （统计一致字符串的数目）
 *
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 *
 * Example 1:
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 *
 * Example 2:
 * Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * Output: 7
 * Explanation: All strings are consistent.
 *
 * Example 3:
 * Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * Output: 4
 * Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 *
 * @see <a href="https://leetcode.cn/problems/count-the-number-of-consistent-strings/" />
 * @author Poet
 * @date 2022/11/8
 */
public class LC_1684_CountTheNumberOfConsistentStrings {

    /* --- 这道题来自：第 41 场双周赛。 可以用位运算 --- */

    /**
     * 方法一：遍历
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                    flag = false;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}
