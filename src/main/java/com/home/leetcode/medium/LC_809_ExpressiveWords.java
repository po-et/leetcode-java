package com.home.leetcode.medium;

/**
 * 809. Expressive Words (情感丰富的文字)
 *
 * Sometimes people repeat letters to represent extra feeling. For example:
 *
 * "hello" -> "heeellooo"
 * "hi" -> "hiiii"
 * In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
 *
 * You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
 *
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
 * Return the number of query strings that are stretchy.
 *
 * Example 1:
 * Input: s = "heeellooo", words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 *  We can extend "e" and "o" in the word "hello" to get "heeellooo".
 *  We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 *
 * Example 2:
 * Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/expressive-words/" />
 * @author Poet
 * @date 2022/11/25
 */
public class LC_809_ExpressiveWords {

    /**
     * 方法一：双指针
     */
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (expand(s, word)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                ++cnti;
                ++i;
            }
            int cntj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                ++cntj;
                ++j;
            }
            if (cnti < cntj) {
                return false;
            }
            if (cnti != cntj && cnti < 3) {
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }

}
