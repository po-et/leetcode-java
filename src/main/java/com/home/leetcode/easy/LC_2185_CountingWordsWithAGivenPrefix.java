package com.home.leetcode.easy;

/**
 * 2185. Counting Words With a Given Prefix (统计包含给定前缀的字符串)
 *
 * You are given an array of strings words and a string pref.
 *
 * Return the number of strings in words that contain pref as a prefix.
 *
 * A prefix of a string s is any leading contiguous substring of s.
 *
 * Example 1:
 * Input: words = ["pay","attention","practice","attend"], pref = "at"
 * Output: 2
 * Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
 *
 * Example 2:
 * Input: words = ["leetcode","win","loops","success"], pref = "code"
 * Output: 0
 * Explanation: There are no strings that contain "code" as a prefix.
 *
 * @see <a href="https://leetcode.cn/problems/counting-words-with-a-given-prefix/" />
 * @author poet
 * @date 2023/1/8
 */
public class LC_2185_CountingWordsWithAGivenPrefix {

    /**
     * 方法一：模拟
     *
     * time:  O(n×m)，其中 n 是输入 words 的长度，m 是输入 pref 的长度
     * space: O(1)
     */
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }

    public int prefixCount_2(String[] words, String pref) {
        int res = 0;
        int n = pref.length();

        for (String word : words) {
            if (word.length() >= n) {
                int index = 0;
                while (index < n && word.charAt(index) == pref.charAt(index)) {
                    index++;
                }
                if (index == n) {
                    res++;
                }
            }
        }
        return res;
    }
}
